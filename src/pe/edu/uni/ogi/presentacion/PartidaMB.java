package pe.edu.uni.ogi.presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Partida;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.PartidaServicio;



@Controller("partidaMB")
@SessionScoped
public class PartidaMB extends GenericoMB {

	private Partida partida;
	private List<Partida> lstPartida;

	@Autowired
	private PartidaServicio partidaServicio;

	
	public PartidaMB() {
	}

	@PostConstruct
	public void init() {
		this.setPartida(new Partida());
		this.setLstPartida(new ArrayList<Partida>());
	}

	public void limpiar() {
		this.init();
		this.listar();
	}
	
	public String cancelar() {
		this.limpiar();
		return "partida_listado";
	}
	
	public String listar() {
		try {
			lstPartida = this.getPartidaServicio().listar(partida);
/*
			for (Partida partida : lstPartida) {
				System.out.println(partida);
			}
*/
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		return "partida_listado";
	}

	public String nuevo() {
		init();
		return "partida_registro";
	}
	
	public String modificar(Partida partida) {
		try {
			Partida oPartida = this.getPartidaServicio().buscarXId(partida);
			this.setPartida(oPartida);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "partida_registro";
	}
	
	public void grabar() {
		boolean sw = false;

		if (!this.validar()) {
			return;
		}

		try {
			if (this.getPartida().getId() > 0) {
				sw = this.getPartidaServicio().actualizar(this.getPartida());
			} else {
				sw = this.getPartidaServicio().insertar(this.getPartida());
//				System.out.println("MB" + this.getPartida().getId());
			}
			if (sw) {
				this.init();
				super.msgInfo("Exito al grabar partida");
			} else {
				this.init();
				super.msgAlert("Error al grabar partida");
			}
		} catch (ServicioException e) {
			this.init();
			super.msgError("Error al grabar partida" + e.getMessage());

		}
	}
	
	public boolean validar() {
		if (this.getPartida().getEspecifica().trim().length() <= 0) {
			super.msgInfo("La específica es un valor requerido");
			return false;
		}
		if (this.getPartida().getNombre().trim().length() <= 0) {
			super.msgInfo("El nombre es un valor requerido");
			return false;
		}
		if (this.getPartida().getDetalle().trim().length() <= 0) {
			super.msgInfo("El detalle es un valor requerido");
			return false;
		}
		return true;
	}
	
	public String eliminar(Partida partida) {
		try {
			this.getPartidaServicio().eliminar(partida);
			this.listar();
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		
		return "partida_listado";
	}
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Partida> getLstPartida() {
		return lstPartida;
	}

	public void setLstPartida(List<Partida> lstPartida) {
		this.lstPartida = lstPartida;
	}

	public PartidaServicio getPartidaServicio() {
		return partidaServicio;
	}

	public void setPartidaServicio(PartidaServicio partidaServicio) {
		this.partidaServicio = partidaServicio;
	}
}
