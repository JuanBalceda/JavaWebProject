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
		name = "partida.listar",
		procedureName = "PKG_PARTIDA.SP_BUSCAR_X_CRITERIOS",
		resultClasses = Partida.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "partida.insertar",
		procedureName = "PKG_PARTIDA.SP_INSERTAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_PARTIDA", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ESPECIFICA", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DETALLE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "partida.actualizar",
		procedureName = "PKG_PARTIDA.SP_ACTUALIZAR",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PARTIDA", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ESPECIFICA", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_DETALLE", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_NOMBRE", type = String.class),
		}
	),
	@NamedStoredProcedureQuery(
		name = "partida.buscarXId",
		procedureName = "PKG_PARTIDA.SP_BUSCAR_X_ID",
		resultClasses = Partida.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PARTIDA", type = Integer.class)
		}
	),
	@NamedStoredProcedureQuery(
		name="partida.eliminar", 
		procedureName="PKG_PARTIDA.SP_ELIMINAR",
		parameters={
			@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_PARTIDA", type=Integer.class )
		}					
	)
})

@Entity(name = "PARTIDA")
public class Partida extends Entidad {

	private int id;
	private String especifica;
	private String detalle;
	private String nombre;
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID_PARTIDA")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ESPECIFICA")
	public String getEspecifica() {
		return especifica;
	}

	public void setEspecifica(String especifica) {
		this.especifica = especifica;
	}

	@Column(name = "DETALLE")
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
