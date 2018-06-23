package pe.edu.uni.ogi.persistencia.interfaces;

import java.util.List;

import pe.edu.uni.ogi.entidad.Detalle;
import pe.edu.uni.ogi.entidad.Tramite;
import pe.edu.uni.ogi.entidad.TramiteVO;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;

public interface TramitePersistencia extends Persistencia<Tramite> {

	public boolean insertCabecera(Tramite tramite) throws PersistenciaException;

	public boolean insertDetalle(Detalle detalle) throws PersistenciaException;

	public List<TramiteVO> findByLikeObjectVO(Tramite tramite) throws PersistenciaException;
	
	public List<Tramite> listarTodo() throws PersistenciaException;
	
}
