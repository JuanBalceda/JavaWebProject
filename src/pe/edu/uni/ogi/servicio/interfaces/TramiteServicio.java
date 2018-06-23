package pe.edu.uni.ogi.servicio.interfaces;

import java.util.List;

import pe.edu.uni.ogi.entidad.Detalle;
import pe.edu.uni.ogi.entidad.Tramite;
import pe.edu.uni.ogi.entidad.TramiteVO;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;

public interface TramiteServicio extends Servicio<Tramite> {
	
	public List<Tramite> listarTodo() throws ServicioException;
	
	public boolean insertCabecera(Tramite tramite) throws ServicioException;
	
	public boolean insertDetalle(Detalle detalle) throws ServicioException;

	public List<TramiteVO> findByLikeObjectVO(Tramite tramite)throws ServicioException;
}
