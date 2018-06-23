package pe.edu.uni.ogi.persistencia.interfaces;

import java.util.List;

import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;

public interface Persistencia<T> {
	public List<T> listar(T t) throws PersistenciaException;

	public T buscarXId(T t) throws PersistenciaException;

	public boolean insertar(T t) throws PersistenciaException;

	public boolean actualizar(T t) throws PersistenciaException;
	
	public boolean eliminar(T t) throws PersistenciaException;

}
