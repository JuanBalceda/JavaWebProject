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
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.PartidaPersistencia;

@Transactional
@Repository("partidaPersistencia")
public class PartidaPersistenciaImpl implements PartidaPersistencia {
	@PersistenceContext
	private EntityManager em;

	public PartidaPersistenciaImpl() {
	}

	@Override
	public List<Partida> listar(Partida t) throws PersistenciaException {
		List<Partida> lstPartida = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("partida.listar");

			spq.setParameter("P_NOMBRE", t.getNombre());

			if (spq.execute()) {
				lstPartida = (List<Partida>) spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstPartida;
	}

	@Override
	public Partida buscarXId(Partida t) throws PersistenciaException {
		List<Partida> lstPartida = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("partida.buscarXId");

			spq.setParameter("P_ID_PARTIDA", t.getId());

			if (spq.execute()) {
				lstPartida = (List<Partida>) spq.getOutputParameterValue("P_CURSOR");
				if (lstPartida != null && lstPartida.size() > 0) {
					return lstPartida.get(0);
				}

			}
			em.close();
			return new Partida();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(Partida t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("partida.insertar");

			spq.setParameter("P_ID_PARTIDA", t.getId());
			spq.setParameter("P_ESPECIFICA", t.getEspecifica());
			spq.setParameter("P_DETALLE", t.getDetalle().toUpperCase());
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
	public boolean actualizar(Partida t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("partida.actualizar");

			spq.setParameter("P_ID_PARTIDA", t.getId());
			spq.setParameter("P_ESPECIFICA", t.getEspecifica());
			spq.setParameter("P_DETALLE", t.getDetalle().toUpperCase());
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
	public boolean eliminar(Partida t) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("partida.eliminar");

			spq.setParameter("P_ID_PARTIDA", t.getId());

			spq.execute();
			em.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}


}
