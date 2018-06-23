package pe.edu.uni.ogi.presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.UsuarioServicio;
import pe.edu.uni.ogi.utilitario.Encrypt;

@Controller("usuarioMB")
@SessionScoped
public class UsuarioMB extends GenericoMB {
	private Usuario usuario;
	private List<Usuario> lstUsuario;

	@Autowired
	private UsuarioServicio usuarioServicio;

	public UsuarioMB() {
	}

	@PostConstruct
	public void init() {
		this.setUsuario(new Usuario());
		this.setLstUsuario(new ArrayList<Usuario>());
	}

	public void limpiar() {
		this.init();
		this.listar();
	}

	public String cancelar() {
		this.limpiar();
		return "usuario_listado";
	}

	public String listar() {
		try {
			lstUsuario = this.getUsuarioServicio().listar(usuario);
			for (Usuario usuario : lstUsuario) {
				System.out.println(usuario);
			}
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		return "usuario_listado";
	}

	public String nuevo() {
		init();
		return "usuario_registro";
	}

	public String modificar(Usuario usuario) {
		try {
			Usuario oUsuario = this.getUsuarioServicio().buscarXId(usuario);
			this.setUsuario(oUsuario);

		} catch (Exception e) {
//			e.printStackTrace();
		}

		return "usuario_registro";
	}

	public void grabar() {
		boolean sw = false;

		if (!this.validar()) {
			return;
		}

		this.encriptar();

		try {
			if (this.getUsuario().getId() > 0) {
				sw = this.getUsuarioServicio().actualizar(this.getUsuario());
			} else {
				sw = this.getUsuarioServicio().insertar(this.getUsuario());
//				System.out.println("MB" + this.getUsuario().getId());
			}

			if (sw) {
				this.init();
				super.msgInfo("Exito al grabar usuario");
				
				
			} else {
				this.init();
				super.msgAlert("Error al grabar usuario");
			}
		} catch (ServicioException e) {
			this.init();
			super.msgError("Error al grabar usuario" + e.getMessage());

		}
	}

	private void encriptar() {
		Encrypt.init(super.getStringJSF("Encrypt.key"));
		String claveEncriptada;
		try {
			claveEncriptada = Encrypt.encrypt(this.getUsuario().getClave());
			this.getUsuario().setClave(claveEncriptada);
		} catch (Exception e) {
//			System.out.println("Error al encriptar");
		}

	}

	public boolean validar() {
		if (this.getUsuario().getUsuario().trim().length() <= 0) {
			super.msgInfo("El usuario es un valor requerido");
			return false;
		}
		if (this.getUsuario().getClave().trim().length() <= 0) {
			super.msgInfo("La clave es un valor requerido");
			return false;
		}
		if (this.getUsuario().getNombre().trim().length() <= 0) {
			super.msgInfo("El nombre es un valor requerido");
			return false;
		}
		return true;
	}
	
	public String eliminar(Usuario usuario) {
		try {
			this.getUsuarioServicio().eliminar(usuario);
			this.listar();
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
		
		return "usuario_listado";
	}
	
	// Getters and Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLstUsuario() {
		return lstUsuario;
	}

	public void setLstUsuario(List<Usuario> lstUsuario) {
		this.lstUsuario = lstUsuario;
	}

	public UsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

}
