package pe.edu.uni.ogi.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.ogi.entidad.Partida;
import pe.edu.uni.ogi.entidad.Proyecto;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.ProyectoPersistencia;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.ProyectoServicio;

@Service("proyectoServicio")
public class ProyectoServicioImpl implements ProyectoServicio {

	@Autowired
	private ProyectoPersistencia proyectoPersistencia;
	
	public ProyectoServicioImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public ProyectoPersistencia getProyectoPersistencia() {
		return proyectoPersistencia;
	}

	public void setProyectoPersistencia(ProyectoPersistencia proyectoPersistencia) {
		this.proyectoPersistencia = proyectoPersistencia;
	}

	@Override
	public List<Proyecto> listar(Proyecto t) throws ServicioException {
		List<Proyecto> lstProyecto= new ArrayList<Proyecto>();
		try {
			lstProyecto= this.getProyectoPersistencia().listar(t);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new ServicioException(e);
		}
		
		return lstProyecto;
	}

	@Override
	public Proyecto buscarXId(Proyecto t) throws ServicioException {
		try {
			return this.getProyectoPersistencia().buscarXId(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean insertar(Proyecto t) throws ServicioException {
		try {
			return this.getProyectoPersistencia().insertar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean actualizar(Proyecto t) throws ServicioException {
		try {
			return this.getProyectoPersistencia().actualizar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean eliminar(Proyecto t) throws ServicioException {
		boolean sw;
		try {
			sw= this.getProyectoPersistencia().eliminar(t);
		} catch (PersistenciaException e) {
			sw=false;
			throw new ServicioException(e);
		}
		return sw;
	}

}
