package pe.edu.uni.ogi.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.ogi.entidad.Partida;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.PartidaPersistencia;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.PartidaServicio;

@Service("partidaServicio")
public class PartidaServicioImpl implements PartidaServicio {

	@Autowired
	private PartidaPersistencia partidaPersistencia;
	
	public PartidaServicioImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public PartidaPersistencia getPartidaPersistencia() {
		return partidaPersistencia;
	}

	public void setPartidaPersistencia(PartidaPersistencia partidaPersistencia) {
		this.partidaPersistencia = partidaPersistencia;
	}

	@Override
	public List<Partida> listar(Partida t) throws ServicioException {
		List<Partida> lstPartida= new ArrayList<Partida>();
		try {
			lstPartida= this.getPartidaPersistencia().listar(t);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new ServicioException(e);
		}
		
		return lstPartida;
	}

	@Override
	public Partida buscarXId(Partida t) throws ServicioException {
		try {
			return this.getPartidaPersistencia().buscarXId(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean insertar(Partida t) throws ServicioException {
		try {
			return this.getPartidaPersistencia().insertar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean actualizar(Partida t) throws ServicioException {
		try {
			return this.getPartidaPersistencia().actualizar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean eliminar(Partida t) throws ServicioException {
		boolean sw;
		try {
			sw= this.getPartidaPersistencia().eliminar(t);
		} catch (PersistenciaException e) {
			sw=false;
			throw new ServicioException(e);
		}
		return sw;
	}

}
