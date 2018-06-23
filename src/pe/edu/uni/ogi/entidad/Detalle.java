package pe.edu.uni.ogi.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "detalle.insert", procedureName = "PKG_TRAMITE.SP_INSERTAR_DETALLE", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_EI_DETALLE", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_EI", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PARTIDA", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE", type = Double.class) }),
		@NamedStoredProcedureQuery(name = "detalle.actualizar", procedureName = "PKG_TRAMITE.SP_ACTUALIZAR_DETALLE", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_EI_DETALLE", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_EI", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PARTIDA", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE", type = Double.class) }) })

@Entity(name = "EI_DETALLE")
public class Detalle extends Entidad {

	private int id;
	private double importe;
	private Tramite tramite;
	private Partida partida;

	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID_EI_DETALLE")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "IMPORTE")
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@ManyToOne
	@JoinColumn(name = "ID_EI")
	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PARTIDA")
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public void ejecutarCalculos() {
		this.setImporte(this.getImporte());
	}

}
