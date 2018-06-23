package pe.edu.uni.ogi.persistencia.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.ogi.entidad.Investigador;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.InvestigadorPersistencia;

@Transactional
@Repository("investigadorPersistencia")
public class InvestigadorPersistenciaImpl implements InvestigadorPersistencia {
	@PersistenceContext
	private EntityManager em;

	public InvestigadorPersistenciaImpl() {
	}

	@Override
	public List<Investigador> listar(Investigador t) throws PersistenciaException {
		List<Investigador> lstInvestigador = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("investigador.listar");

			spq.setParameter("P_NOMBRE", t.getNombre());

			if (spq.execute()) {
				lstInvestigador = (List<Investigador>) spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstInvestigador;
	}

	@Override
	public Investigador buscarXId(Investigador t) throws PersistenciaException {
		List<Investigador> lstInvestigador = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("investigador.buscarXId");

			spq.setParameter("P_COD_UNI", t.getCod_uni());

			if (spq.execute()) {
				lstInvestigador = (List<Investigador>) spq.getOutputParameterValue("P_CURSOR");
				if (lstInvestigador != null && lstInvestigador.size() > 0) {
					return lstInvestigador.get(0);
				}

			}
			em.close();
			return new Investigador();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(Investigador t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("investigador.insertar");

			spq.setParameter("P_ID_INVESTIGADOR", t.getId());
			spq.setParameter("P_DNI", t.getDni());
			spq.setParameter("P_NOMBRE", t.getNombre().toUpperCase());
			spq.setParameter("P_TELEFONO", t.getTelefono());
			spq.setParameter("P_EMAIL", t.getEmail());
			spq.setParameter("P_COD_UNI", t.getCod_uni());

			spq.execute();

			Object id = spq.getOutputParameterValue(1);
			if (id != null) {
				t.setId(Integer.valueOf(id.toString()));
			}

			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean actualizar(Investigador t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("investigador.actualizar");

			spq.setParameter("P_ID_INVESTIGADOR", t.getId());
			spq.setParameter("P_DNI", t.getDni());
			spq.setParameter("P_NOMBRE", t.getNombre().toUpperCase());
			spq.setParameter("P_TELEFONO", t.getTelefono());
			spq.setParameter("P_EMAIL", t.getEmail());
			spq.setParameter("P_COD_UNI", t.getCod_uni());

			spq.execute();

			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean eliminar(Investigador t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("investigador.eliminar");

			spq.setParameter("P_ID_INVESTIGADOR", t.getId());

			spq.execute();
			em.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}


}
