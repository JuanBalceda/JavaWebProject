package pe.edu.uni.ogi.servicio.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.ogi.entidad.Investigador;
import pe.edu.uni.ogi.persistencia.excepciones.PersistenciaException;
import pe.edu.uni.ogi.persistencia.interfaces.InvestigadorPersistencia;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.InvestigadorServicio;

@Service("investigadorServicio")
public class InvestigadorServicioImpl implements InvestigadorServicio {
	
	@Autowired
	private InvestigadorPersistencia investigadorPersistencia;
	
	public InvestigadorServicioImpl() {
		// TODO Auto-generated constructor stub
	}

	public InvestigadorPersistencia getInvestigadorPersistencia() {
		return investigadorPersistencia;
	}

	public void setInvestigadorPersistencia(InvestigadorPersistencia investigadorPersistencia) {
		this.investigadorPersistencia = investigadorPersistencia;
	}

	@Override
	public List<Investigador> listar(Investigador t) throws ServicioException {
		List<Investigador> lstInvestigador= new ArrayList<Investigador>();
		try {
			lstInvestigador= this.getInvestigadorPersistencia().listar(t);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new ServicioException(e);
		}
		
		return lstInvestigador;
	}

	@Override
	public Investigador buscarXId(Investigador t) throws ServicioException {
		try {
			return this.getInvestigadorPersistencia().buscarXId(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean insertar(Investigador t) throws ServicioException {
		try {
			return this.getInvestigadorPersistencia().insertar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean actualizar(Investigador t) throws ServicioException {
		try {
			return this.getInvestigadorPersistencia().actualizar(t);
		} catch (PersistenciaException e) {
			throw new ServicioException(e);
			
		}
	}

	@Override
	public boolean eliminar(Investigador t) throws ServicioException {
		boolean sw;
		try {
			sw= this.getInvestigadorPersistencia().eliminar(t);
		} catch (PersistenciaException e) {
			sw=false;
			throw new ServicioException(e);
		}
		return sw;
	}
}
