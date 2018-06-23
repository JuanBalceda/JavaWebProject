package pe.edu.uni.ogi.persistencia.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.UsuarioPersistencia;

@Transactional
@Repository("usuarioPersistencia")
public class UsuarioPersistenciaImpl implements UsuarioPersistencia {
	@PersistenceContext
	private EntityManager em;

	public UsuarioPersistenciaImpl() {
	}

	@Override
	public List<Usuario> listar(Usuario usuario) throws PersistenciaException {
		List<Usuario> lstUsuario = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.listar");

			spq.setParameter("P_NOMBRE", usuario.getNombre());

			if (spq.execute()) {
				lstUsuario = (List<Usuario>) spq.getOutputParameterValue("P_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return lstUsuario;
	}

	@Override
	public Usuario buscarXId(Usuario usuario) throws PersistenciaException {
		List<Usuario> lstUsuario = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.buscarXId");

			spq.setParameter("P_ID", usuario.getId());

			if (spq.execute()) {
				lstUsuario = (List<Usuario>) spq.getOutputParameterValue("P_CURSOR");
				if (lstUsuario != null && lstUsuario.size() > 0) {
					return lstUsuario.get(0);
				}

			}
			em.close();
			return new Usuario();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(Usuario usuario) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.insertar");

			spq.setParameter("P_USUARIO", usuario.getUsuario().toLowerCase());
			spq.setParameter("P_CLAVE", usuario.getClave());
			spq.setParameter("P_NOMBRE", usuario.getNombre().toUpperCase());

			spq.execute();

			Object id = spq.getOutputParameterValue(1);
			if (id != null) {
				usuario.setId(Integer.valueOf(id.toString()));
			}

			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean actualizar(Usuario usuario) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.actualizar");

			spq.setParameter("P_ID", usuario.getId());
			spq.setParameter("P_USUARIO", usuario.getUsuario().toLowerCase());
			spq.setParameter("P_CLAVE", usuario.getClave());
			spq.setParameter("P_NOMBRE", usuario.getNombre().toUpperCase());

			spq.execute();

			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public Usuario validarUsuario(Usuario usuario) throws PersistenciaException {
		List<Usuario> lstUsuario = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.validarAcceso");

			spq.setParameter("P_USUARIO", usuario.getUsuario());
			spq.setParameter("P_CLAVE", usuario.getClave());

			if (spq.execute()) {
				lstUsuario = (List<Usuario>) spq.getOutputParameterValue("P_CURSOR");
				if (lstUsuario != null && lstUsuario.size() > 0) {
					return lstUsuario.get(0);
				}

			}
			em.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean eliminar(Usuario usuario) throws PersistenciaException {
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.eliminar");

			spq.setParameter("P_ID", usuario.getId());

			spq.execute();
			em.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
	}

}
