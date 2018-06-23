package pe.edu.uni.ogi.servicio.interfaces;

import java.util.List;

import pe.edu.uni.ogi.servicio.excepciones.ServicioException;

public interface Servicio<T> {
	public List<T> listar(T t) throws ServicioException;

	public T buscarXId(T t) throws ServicioException;

	public boolean insertar(T t) throws ServicioException;

	public boolean actualizar(T t) throws ServicioException;
	
	public boolean eliminar(T t) throws ServicioException;

}
