package pe.edu.uni.ogi.persistencia.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.ogi.entidad.Detalle;
import pe.edu.uni.ogi.entidad.Tramite;
import pe.edu.uni.ogi.entidad.TramiteVO;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.PartidaPersistencia;
import pe.edu.uni.ogi.persistencia.interfaces.TramitePersistencia;

@Transactional
@Repository("tramitePersistencia")
public class TramitePresistenciaImpl implements TramitePersistencia {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PartidaPersistencia partidaPersistencia;

	public TramitePresistenciaImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tramite> listarTodo() throws PersistenciaException {
		List<Tramite> lstTramite = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.listar");

			if (spq.execute()) {
				lstTramite = (List<Tramite>) spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstTramite;
	}

	@Override
	public Tramite buscarXId(Tramite t) throws PersistenciaException {
		List<Tramite> lstTramite = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.buscarXId");

			spq.setParameter("P_ID_EI", t.getId());

			if (spq.execute()) {
				lstTramite = (List<Tramite>) spq.getOutputParameterValue("P_CURSOR");
				if (lstTramite != null && lstTramite.size() > 0) {
					return lstTramite.get(0);
				}
			}
			em.close();
			return new Tramite();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(Tramite t) throws PersistenciaException {
		boolean sw = false;
		try {
			sw = this.insertCabecera(t);

			if (sw) {

				System.out.println("Exito de iserción de cabecera " + t.getId());

				for (Detalle detalle : t.getLstDetalle()) {
					detalle.setTramite(t);
					sw = this.insertDetalle(detalle);
					if (sw) {
						System.out.println("Exito de iserción de detalle " + detalle.getId());
					} else {
						sw = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(Tramite t) throws PersistenciaException {
		boolean sw = false;
		try {
			sw = this.actualizarCabecera(t);

			if (sw) {

				System.out.println("Exito al actualizar cabecera " + t.getId());

				for (Detalle detalle : t.getLstDetalle()) {
					detalle.setTramite(t);
					if (detalle.getId() != 0) {
						sw = this.actualizarDetalle(detalle);
					} else {
						sw = this.insertDetalle(detalle);
					}

					if (sw) {
						System.out.println("Exito al actualizar detalle " + detalle.getId());
					} else {
						sw = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(Tramite t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.eliminar");

			spq.setParameter("P_ID_EI", t.getId());

			spq.execute();
			em.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	public boolean actualizarCabecera(Tramite tramite) throws PersistenciaException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.actualizar");

			spq.setParameter("P_ID_EI", tramite.getId());
			spq.setParameter("P_ID_INV", tramite.getInvestigador().getId());
			spq.setParameter("P_ID_PROY", tramite.getProyecto().getId());
			spq.setParameter("P_FECHA_INICIO", tramite.getFecha_inicio());
			spq.setParameter("P_FECHA_FIN", tramite.getFecha_fin());
			spq.setParameter("P_CERTIFICADO", tramite.getCertificado());
			spq.setParameter("P_EXP_OCEF", tramite.getExp_ocef());
			spq.setParameter("P_EXP_SIAF", tramite.getExp_siaf());
			spq.setParameter("P_IMPORTE", tramite.getImporte());
			spq.setParameter("P_FECHA_RENDICION", tramite.getFecha_rendicion());
			spq.setParameter("P_EXP_OCEF_RENDICION", tramite.getExp_ocef_rendicion());
			spq.setParameter("P_IMPORTE_RENDICION", tramite.getImporte_rendicion());
			spq.setParameter("P_IMPORTE_DEVOLUCION", tramite.getImporte_devolucion());
			spq.setParameter("P_RESPONSABLE_RENDICION", tramite.getResponsable_rendicion());
			spq.setParameter("P_EXP_OCEF_DEVOLUCION", tramite.getExp_ocef_devolucion());
			spq.setParameter("P_TIPO_TRAMITE", tramite.getTipo_tramite());
			spq.setParameter("P_ESTADO_TRAMITE", tramite.getEstado_tramite());
			spq.setParameter("P_ID_OCEF", tramite.getId_ocef());
	
			spq.execute();
			em.close();
			sw = true;
		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new PersistenciaException(e);
		}
		return sw;
	}

	public boolean actualizarDetalle(Detalle detalle) throws PersistenciaException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("detalle.actualizar");
			spq.setParameter("P_ID_EI_DETALLE", detalle.getId());
			spq.setParameter("P_ID_EI", detalle.getTramite().getId());
			spq.setParameter("P_ID_PARTIDA", detalle.getPartida().getId());
			spq.setParameter("P_IMPORTE", detalle.getImporte());

			spq.execute();
			em.close();
			sw = true;

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean insertCabecera(Tramite tramite) throws PersistenciaException {
		Object idTramite = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.insert");

			spq.setParameter("P_ID_INV", tramite.getInvestigador().getId());
			spq.setParameter("P_ID_PROY", tramite.getProyecto().getId());
			spq.setParameter("P_FECHA_INICIO", tramite.getFecha_inicio());
			spq.setParameter("P_FECHA_FIN", tramite.getFecha_fin());
			spq.setParameter("P_CERTIFICADO", tramite.getCertificado());
			spq.setParameter("P_EXP_OCEF", tramite.getExp_ocef());
			spq.setParameter("P_EXP_SIAF", tramite.getExp_siaf());
			spq.setParameter("P_IMPORTE", tramite.getImporte());
			spq.setParameter("P_FECHA_RENDICION", tramite.getFecha_rendicion());
			spq.setParameter("P_EXP_OCEF_RENDICION", tramite.getExp_ocef_rendicion());
			spq.setParameter("P_IMPORTE_RENDICION", tramite.getImporte_rendicion());
			spq.setParameter("P_IMPORTE_DEVOLUCION", tramite.getImporte_devolucion());
			spq.setParameter("P_RESPONSABLE_RENDICION", tramite.getResponsable_rendicion());
			spq.setParameter("P_EXP_OCEF_DEVOLUCION", tramite.getExp_ocef_devolucion());
			spq.setParameter("P_TIPO_TRAMITE", tramite.getTipo_tramite());
			spq.setParameter("P_ESTADO_TRAMITE", tramite.getEstado_tramite());
			spq.setParameter("P_ID_OCEF", tramite.getId_ocef());

			spq.execute();
			idTramite = spq.getOutputParameterValue(1);
			System.err.println("idTramite " + idTramite);
			if (idTramite != null) {
				tramite.setId(Integer.valueOf(idTramite.toString()));
				sw = true;
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean insertDetalle(Detalle detalle) throws PersistenciaException {
		Object idDetalle = null;
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("detalle.insert");

			spq.setParameter("P_ID_EI", detalle.getTramite().getId());
			spq.setParameter("P_ID_PARTIDA", detalle.getPartida().getId());
			spq.setParameter("P_IMPORTE", detalle.getImporte());

			spq.execute();
			idDetalle = spq.getOutputParameterValue(1);
			if (idDetalle != null) {
				detalle.setId(Integer.valueOf(idDetalle.toString()));
				sw = true;
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			sw = false;
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public List<TramiteVO> findByLikeObjectVO(Tramite tramite) throws PersistenciaException {
		List<TramiteVO> lstTramiteVO = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("tramite.findByLikeObjectVO");
			spq.setParameter("P_CODIGO_OCPLA", tramite.getProyecto().getCodigo_ocpla());

			if (spq.execute()) {
				lstTramiteVO = (List<TramiteVO>) spq.getOutputParameterValue("P_C_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstTramiteVO;
	}

	// Getters and Setters

	public PartidaPersistencia getPartidaPersistencia() {
		return partidaPersistencia;
	}

	public void setPartidaPersistencia(PartidaPersistencia partidaPersistencia) {
		this.partidaPersistencia = partidaPersistencia;
	}


	@Override
	public List<Tramite> listar(Tramite t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
