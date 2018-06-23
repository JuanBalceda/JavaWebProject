package pe.edu.uni.ogi.presentacion;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Usuario;
import pe.edu.uni.ogi.servicio.interfaces.UsuarioServicio;
import pe.edu.uni.ogi.utilitario.Encrypt;

@Controller("loginMB")
@SessionScoped
public class LoginMB extends GenericoMB {

	private Usuario usuario;
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	public LoginMB() {
	}

	@PostConstruct
	public void init() {
		this.setUsuario(new Usuario());
	}

	public String validarAcceso() {
		String pagina = "index";
		try {
			// Encriptacion
			Encrypt.init(super.getStringJSF("Encrypt.key"));
			String claveEncriptada = Encrypt.encrypt(usuario.getClave());
			usuario.setClave(claveEncriptada);

			Usuario oUsuario = this.getUsuarioServicio().validarUsuario(usuario);
			if (oUsuario != null) {

				HttpSession session = super.getRequest().getSession();
				session.setAttribute("usuario", oUsuario);
				session.setAttribute("id", session.getId());
			
				pagina = "panel";
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return pagina;

	}

	public String cerrarSesion() {

		HttpSession session = super.getRequest().getSession();
		session.removeAttribute("id");
		session.removeAttribute("usuario");
		session.invalidate();

		String url = super.getRequest().getContextPath() + "/faces/index.xhtml";
		try {
			super.getResponse().sendRedirect(url);

		} catch (IOException e) {
//			e.printStackTrace();
		}
		return "";
	}

	// Getters and Setters

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioServicio getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

}
