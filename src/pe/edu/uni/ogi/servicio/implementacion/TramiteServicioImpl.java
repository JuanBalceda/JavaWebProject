package pe.edu.uni.ogi.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.ogi.entidad.Detalle;
import pe.edu.uni.ogi.entidad.Proyecto;
import pe.edu.uni.ogi.entidad.Tramite;
import pe.edu.uni.ogi.entidad.TramiteVO;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.TramitePersistencia;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.TramiteServicio;

@Service("tramiteServicio")
public class TramiteServicioImpl implements TramiteServicio {

	@Autowired
	private TramitePersistencia tramitePersistencia; 

	public TramiteServicioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tramite> listarTodo() throws ServicioException {
		List<Tramite> lstTramite= new ArrayList<Tramite>();
		try {
			lstTramite= this.getTramitePersistencia().listarTodo();
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new ServicioException(e);
		}
		
		return lstTramite;
	}

	@Override
	public Tramite buscarXId(Tramite t) throws ServicioException {
		try {
			return this.getTramitePersistencia().buscarXId(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean insertar(Tramite t) throws ServicioException {
		try {
			return this.getTramitePersistencia().insertar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	@Override
	public boolean actualizar(Tramite t) throws ServicioException {
		try {
			return this.getTramitePersistencia().actualizar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean eliminar(Tramite t) throws ServicioException {
		boolean sw;
		try {
			sw= this.getTramitePersistencia().eliminar(t);
		} catch (PersistenciaException e) {
			sw=false;
			throw new ServicioException(e);
		}
		return sw;
	}

	@Override
	public boolean insertCabecera(Tramite tramite) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertDetalle(Detalle detalle) throws ServicioException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TramiteVO> findByLikeObjectVO(Tramite tramite) throws ServicioException {
		try {
			return this.getTramitePersistencia().findByLikeObjectVO(tramite);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
		}
	}

	public TramitePersistencia getTramitePersistencia() {
		return tramitePersistencia;
	}

	public void setTramitePersistencia(TramitePersistencia tramitePersistencia) {
		this.tramitePersistencia = tramitePersistencia;
	}

	@Override
	public List<Tramite> listar(Tramite t) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
