package pe.edu.uni.ogi.presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Investigador;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.InvestigadorServicio;

@Controller("investigadorMB")
@SessionScoped
public class InvestigadorMB extends GenericoMB {
	private Investigador investigador;
	private List<Investigador> lstInvestigador;

	@Autowired
	private InvestigadorServicio investigadorServicio;

	public InvestigadorMB() {
	}

	@PostConstruct
	public void init() {
		this.setInvestigador(new Investigador());
		this.setLstInvestigador(new ArrayList<Investigador>());
	}

	public void limpiar() {
		this.init();
		this.listar();
	}

	public String cancelar() {
		this.limpiar();
		return "inv_listado";
	}

	public String listar() {
		try {
			lstInvestigador = this.getInvestigadorServicio().listar(investigador);
/*
			for (Investigador investigador : lstInvestigador) {
				System.out.println(investigador);
			}
*/
			} catch (ServicioException e) {
//			e.printStackTrace();
		}
		return "inv_listado";
	}

	public String nuevo() {
		init();
		return "inv_registro";
	}

	public String modificar(Investigador investigador) {
		try {
			Investigador oInvestigador = this.getInvestigadorServicio().buscarXId(investigador);
			this.setInvestigador(oInvestigador);

		} catch (Exception e) {
//			e.printStackTrace();
		}

		return "inv_registro";
	}
	
	public void grabar() {
		boolean sw = false;

		if (!this.validar()) {
			return;
		}

		try {
			if (this.getInvestigador().getId() > 0) {
				sw = this.getInvestigadorServicio().actualizar(this.getInvestigador());
			} else {
				sw = this.getInvestigadorServicio().insertar(this.getInvestigador());
//				System.out.println("MB" + this.getInvestigador().getId());
			}

			if (sw) {
				this.init();
				super.msgInfo("Exito al grabar investigador");
				
				
			} else {
				this.init();
				super.msgAlert("Error al grabar investigador");
			}
		} catch (ServicioException e) {
			this.init();
			super.msgError("Error al grabar investigador" + e.getMessage());

		}
	}

	public boolean validar() {
		if (this.getInvestigador().getDni().trim().length() <= 0) {
			super.msgInfo("El DNI es un valor requerido");
			return false;
		}
		if (this.getInvestigador().getNombre().trim().length() <= 0) {
			super.msgInfo("El nombre es un valor requerido");
			return false;
		}
		if (this.getInvestigador().getTelefono().trim().length() <= 0) {
			super.msgInfo("El telefono es un valor requerido");
			return false;
		}
		if (this.getInvestigador().getEmail().trim().length() <= 0) {
			super.msgInfo("El email es un valor requerido");
			return false;
		}
		if (this.getInvestigador().getCod_uni().trim().length() <= 0) {
			super.msgInfo("El código uni es un valor requerido");
			return false;
		}
		return true;
	}
	
	public String eliminar(Investigador investigador) {
		try {
			this.getInvestigadorServicio().eliminar(investigador);
			this.listar();
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		return "inv_listado";
	}

	// Getters and Setters

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public List<Investigador> getLstInvestigador() {
		return lstInvestigador;
	}

	public void setLstInvestigador(List<Investigador> lstInvestigador) {
		this.lstInvestigador = lstInvestigador;
	}

	public InvestigadorServicio getInvestigadorServicio() {
		return investigadorServicio;
	}

	public void setInvestigadorServicio(InvestigadorServicio investigadorServicio) {
		this.investigadorServicio = investigadorServicio;
	}
	
}
