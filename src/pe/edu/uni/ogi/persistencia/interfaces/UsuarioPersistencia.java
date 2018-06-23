package pe.edu.uni.ogi.persistencia.interfaces;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;

public interface UsuarioPersistencia extends Persistencia<Usuario> {
	public Usuario validarUsuario(Usuario usuario) throws PersistenciaException;

}
