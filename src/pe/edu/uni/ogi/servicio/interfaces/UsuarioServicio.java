package pe.edu.uni.ogi.servicio.interfaces;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;

public interface UsuarioServicio extends Servicio<Usuario> {
	public Usuario validarUsuario(Usuario usuario) throws ServicioException;

}
