package pe.edu.uni.ogi.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.UsuarioPersistencia;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.UsuarioServicio;

@Service("usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	private UsuarioPersistencia usuarioPersistencia;
	
	public UsuarioServicioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Usuario> listar(Usuario usuario) throws ServicioException {
		List<Usuario> lstUsuario= new ArrayList<Usuario>();
		try {
			lstUsuario= this.getUsuarioPersistencia().listar(usuario);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new ServicioException(e);
		}
		
		return lstUsuario;
	}

	@Override
	public Usuario buscarXId(Usuario usuario) throws ServicioException {
		try {
			return this.getUsuarioPersistencia().buscarXId(usuario);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean insertar(Usuario usuario) throws ServicioException {
		try {
			return this.getUsuarioPersistencia().insertar(usuario);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean actualizar(Usuario usuario) throws ServicioException {
		try {
			return this.getUsuarioPersistencia().actualizar(usuario);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public Usuario validarUsuario(Usuario usuario) throws ServicioException {
		try {
			return this.getUsuarioPersistencia().validarUsuario(usuario);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	public UsuarioPersistencia getUsuarioPersistencia() {
		return usuarioPersistencia;
	}

	public void setUsuarioPersistencia(UsuarioPersistencia usuarioPersistencia) {
		this.usuarioPersistencia = usuarioPersistencia;
	}

	@Override
	public boolean eliminar(Usuario usuario) throws ServicioException {
		boolean sw;
		try {
			sw= this.getUsuarioPersistencia().eliminar(usuario);
		} catch (PersistenciaException e) {
			sw=false;
			throw new ServicioException(e);
		}
		return sw;
	}

	
}
