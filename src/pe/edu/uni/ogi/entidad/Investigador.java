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
		name = "investigador.listar",
		procedureName = "PKG_INVESTIGADOR.SP_BUSCAR_X_CRITERIOS",
		resultClasses = Investigador.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "investigador.insertar",
		procedureName = "PKG_INVESTIGADOR.SP_INSERTAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_INVESTIGADOR", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DNI", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_TELEFONO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EMAIL", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_COD_UNI", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "investigador.actualizar",
		procedureName = "PKG_INVESTIGADOR.SP_ACTUALIZAR",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_INVESTIGADOR", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DNI", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_TELEFONO", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EMAIL", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_COD_UNI", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "investigador.buscarXId",
		procedureName = "PKG_INVESTIGADOR.SP_BUSCAR_X_ID",
		resultClasses = Investigador.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_COD_UNI", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name="investigador.eliminar", 
		procedureName="PKG_INVESTIGADOR.SP_ELIMINAR",
		parameters={
			@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_INVESTIGADOR", type=Integer.class )
		}					
	)
})

@Entity(name = "INVESTIGADOR")
public class Investigador extends Entidad {

	private int id;
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	private String cod_uni;
	
	public Investigador() {
	}

	@Id
	@Column(name = "ID_INVESTIGADOR")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "DNI")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "TELEFONO")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "COD_UNI")
	public String getCod_uni() {
		return cod_uni;
	}

	public void setCod_uni(String cod_uni) {
		this.cod_uni = cod_uni;
	}
	
	
}
