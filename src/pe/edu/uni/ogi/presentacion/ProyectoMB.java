package pe.edu.uni.ogi.presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Proyecto;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.ProyectoServicio;


@Controller("proyectoMB")
@SessionScoped
public class ProyectoMB extends GenericoMB {

	private Proyecto proyecto;
	private List<Proyecto> lstProyecto;

	@Autowired
	private ProyectoServicio proyectoServicio;
	
	public ProyectoMB() {
	}

	@PostConstruct
	public void init() {
		this.setProyecto(new Proyecto());
		this.setLstProyecto(new ArrayList<Proyecto>());
	}

	public void limpiar() {
		this.init();
		this.listar();
	}
	
	public String cancelar() {
		this.limpiar();
		return "proy_listado";
	}
	
	public String listar() {
		try {
			lstProyecto = this.getProyectoServicio().listar(proyecto);
			for (Proyecto proyecto : lstProyecto) {
				System.out.println(proyecto);
			}
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		return "proy_listado";
	}
	
	public String nuevo() {
		init();
		return "proy_registro";
	}
	
	public String modificar(Proyecto proyecto) {
		try {
			Proyecto oProyecto = this.getProyectoServicio().buscarXId(proyecto);
			this.setProyecto(oProyecto);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "proy_registro";
	}
	
	public void grabar() {
		boolean sw = false;

		if (!this.validar()) {
			return;
		}

		try {
			if (this.getProyecto().getId() > 0) {
				sw = this.getProyectoServicio().actualizar(this.getProyecto());
			} else {
				sw = this.getProyectoServicio().insertar(this.getProyecto());
//				System.out.println("MB" + this.getProyecto().getId());
			}
			if (sw) {
				this.init();
				super.msgInfo("Exito al grabar proyecto");
			} else {
				this.init();
				super.msgAlert("Error al grabar proyecto");
			}
		} catch (ServicioException e) {
			this.init();
			super.msgError("Error al grabar proyecto" + e.getMessage());

		}
	}
	
	public boolean validar() {
		if (this.getProyecto().getCodigo_ocpla().trim().length() <= 0) {
			super.msgInfo("La código OCPLA es un valor requerido");
			return false;
		}
		if (this.getProyecto().getCodigo_ocef().trim().length() <= 0) {
			super.msgInfo("El código OCEF es un valor requerido");
			return false;
		}
		if (this.getProyecto().getNombre().trim().length() <= 0) {
			super.msgInfo("El nombre es un valor requerido");
			return false;
		}
		return true;
	}
	
	public String eliminar(Proyecto proyecto) {
		try {
			this.getProyectoServicio().eliminar(proyecto);
			this.listar();
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		
		return "proy_listado";
	}
	
	//Getters and Setters

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<Proyecto> getLstProyecto() {
		return lstProyecto;
	}

	public void setLstProyecto(List<Proyecto> lstProyecto) {
		this.lstProyecto = lstProyecto;
	}

	public ProyectoServicio getProyectoServicio() {
		return proyectoServicio;
	}

	public void setProyectoServicio(ProyectoServicio proyectoServicio) {
		this.proyectoServicio = proyectoServicio;
	}

	
}
