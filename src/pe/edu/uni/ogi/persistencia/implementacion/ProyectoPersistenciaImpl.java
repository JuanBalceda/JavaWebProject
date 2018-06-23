package pe.edu.uni.ogi.persistencia.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.ogi.entidad.Partida;
import pe.edu.uni.ogi.entidad.Proyecto;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.ProyectoPersistencia;


@Transactional
@Repository("proyectoPersistencia")
public class ProyectoPersistenciaImpl implements ProyectoPersistencia {

	@PersistenceContext
	private EntityManager em;

	public ProyectoPersistenciaImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Proyecto> listar(Proyecto t) throws PersistenciaException {
		List<Proyecto> lstProyecto = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proyecto.listar");

			spq.setParameter("P_CODIGO_OCPLA", t.getCodigo_ocpla());

			if (spq.execute()) {
				lstProyecto = (List<Proyecto>) spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstProyecto;
	}

	@Override
	public Proyecto buscarXId(Proyecto t) throws PersistenciaException {
		List<Proyecto> lstProyecto = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proyecto.buscarXId");

			spq.setParameter("P_ID_PROYECTO", t.getId());

			if (spq.execute()) {
				lstProyecto = (List<Proyecto>) spq.getOutputParameterValue("P_CURSOR");
				if (lstProyecto != null && lstProyecto.size() > 0) {
					return lstProyecto.get(0);
				}

			}
			em.close();
			return new Proyecto();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(Proyecto t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proyecto.insertar");

			spq.setParameter("P_ID_PROYECTO", t.getId());
			spq.setParameter("P_CODIGO_OCPLA", t.getCodigo_ocpla());
			spq.setParameter("P_CODIGO_OCEF", t.getCodigo_ocef());
			spq.setParameter("P_NOMBRE", t.getNombre().toUpperCase());
			
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
	public boolean actualizar(Proyecto t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proyecto.actualizar");

			spq.setParameter("P_ID_PROYECTO", t.getId());
			spq.setParameter("P_CODIGO_OCPLA", t.getCodigo_ocpla());
			spq.setParameter("P_CODIGO_OCEF", t.getCodigo_ocef());
			spq.setParameter("P_NOMBRE", t.getNombre().toUpperCase());

			spq.execute();

			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean eliminar(Proyecto t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("proyecto.eliminar");

			spq.setParameter("P_ID_PROYECTO", t.getId());

			spq.execute();
			em.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

}
