package pe.edu.uni.ogi.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		name = "usuario.listar",
		procedureName = "PKG_USUARIO.SP_BUSCAR_X_CRITERIOS",
		resultClasses = Usuario.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "usuario.insertar",
		procedureName = "PKG_USUARIO.SP_INSERTAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CLAVE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "usuario.actualizar",
		procedureName = "PKG_USUARIO.SP_ACTUALIZAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CLAVE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "usuario.buscarXId",
		procedureName = "PKG_USUARIO.SP_BUSCAR_X_ID",
		resultClasses = Usuario.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID", type = Integer.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "usuario.validarAcceso", 
		procedureName = "PKG_USUARIO.SP_VALIDAR_ACCESO", 
		resultClasses = Usuario.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USUARIO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CLAVE", type = String.class) 
		}
	),
	@NamedStoredProcedureQuery(
		name="usuario.eliminar", 
		procedureName="PKG_USUARIO.SP_ELIMINAR",
		parameters={
			@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID", type=Integer.class )
		}					
	)
})

@Entity(name = "USUARIO")
public class Usuario extends Entidad {
	private int id;
	private String usuario;
	private String clave;
	private String nombre;

	public Usuario() {
		super();
	}

	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USUARIO")
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "CLAVE")
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
