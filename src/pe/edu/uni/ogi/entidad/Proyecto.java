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
		name = "proyecto.listar",
		procedureName = "PKG_PROYECTO.SP_BUSCAR_X_CRITERIOS",
		resultClasses = Proyecto.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCPLA", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "proyecto.insertar",
		procedureName = "PKG_PROYECTO.SP_INSERTAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_PROYECTO", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCPLA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCEF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "proyecto.actualizar",
		procedureName = "PKG_PROYECTO.SP_ACTUALIZAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PROYECTO", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCPLA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCEF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "proyecto.buscarXId",
		procedureName = "PKG_PROYECTO.SP_BUSCAR_X_ID",
		resultClasses = Proyecto.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PROYECTO", type = Integer.class)
		}
	),
	@NamedStoredProcedureQuery(
		name="proyecto.eliminar", 
		procedureName="PKG_PROYECTO.SP_ELIMINAR",
		parameters={
			@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_PROYECTO", type=Integer.class )
		}					
	)
})

@Entity(name = "PROYECTO")
public class Proyecto extends Entidad {

	private int id;
	private String codigo_ocpla;
	private String codigo_ocef;
	private String nombre;
	
	public Proyecto() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID_PROYECTO")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CODIGO_OCPLA")
	public String getCodigo_ocpla() {
		return codigo_ocpla;
	}

	public void setCodigo_ocpla(String codigo_ocpla) {
		this.codigo_ocpla = codigo_ocpla;
	}

	@Column(name = "CODIGO_OCEF")
	public String getCodigo_ocef() {
		return codigo_ocef;
	}

	public void setCodigo_ocef(String codigo_ocef) {
		this.codigo_ocef = codigo_ocef;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
