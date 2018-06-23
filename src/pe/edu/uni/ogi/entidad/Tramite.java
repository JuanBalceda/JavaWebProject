package pe.edu.uni.ogi.entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
		name = "tramite.insert",
		procedureName = "PKG_TRAMITE.SP_INSERTAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "P_ID_EI", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_INV", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PROY", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_INICIO", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_FIN", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CERTIFICADO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_SIAF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_RENDICION", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF_RENDICION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE_RENDICION", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE_DEVOLUCION", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_RESPONSABLE_RENDICION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF_DEVOLUCION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_TIPO_TRAMITE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ESTADO_TRAMITE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_OCEF", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "tramite.findByLikeObjectVO", 
		procedureName = "PKG_TRAMITE.SP_BUSCAR_X_CRITERIOS", 
		resultClasses = TramiteVO.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_C_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CODIGO_OCPLA", type = String.class)
		}
	),
	@NamedStoredProcedureQuery(
		name = "tramite.buscarXId",
		procedureName = "PKG_TRAMITE.SP_BUSCAR_X_ID",
		resultClasses = Tramite.class,
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_EI", type = Integer.class)
		}
	),
	@NamedStoredProcedureQuery(
		name="tramite.eliminar", 
		procedureName="PKG_TRAMITE.SP_ELIMINAR",
		parameters={
			@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_ID_EI", type=Integer.class )
		}	
	),
	@NamedStoredProcedureQuery(
		name = "tramite.actualizar",
		procedureName = "PKG_TRAMITE.SP_ACTUALIZAR",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_EI", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_INV", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_PROY", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_INICIO", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_FIN", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_CERTIFICADO", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_SIAF", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_FECHA_RENDICION", type = Date.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF_RENDICION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE_RENDICION", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_IMPORTE_DEVOLUCION", type = Double.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_RESPONSABLE_RENDICION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_EXP_OCEF_DEVOLUCION", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_TIPO_TRAMITE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ESTADO_TRAMITE", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_ID_OCEF", type = String.class)

		}
	),
	@NamedStoredProcedureQuery(
			name = "tramite.listar",
			procedureName = "PKG_TRAMITE.SP_BUSCAR",
			resultClasses = Tramite.class,
			parameters = {
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CURSOR", type = void.class),
			}
		)
})


@Entity(name = "ENCARGO_INTERNO")
public class Tramite extends Entidad {
	
	private int id;
	private Date fecha_inicio;
    private Date fecha_fin;
	private String certificado;
	private String exp_ocef;
	private String exp_siaf;
	private double importe;
	private Proyecto proyecto;
	private Investigador investigador;
	private List<Detalle> lstDetalle;
    private Date fecha_rendicion;
	private String exp_ocef_rendicion;
	private double importe_rendicion;
	private double importe_devolucion;
	private String responsable_rendicion;
	private String exp_ocef_devolucion;
	
	private String tipo_tramite;
	private String estado_tramite;
	private String id_ocef;
	
	
	public Tramite() {
		this.setProyecto(new Proyecto());
		this.setInvestigador(new Investigador());
		this.setLstDetalle(new ArrayList<Detalle>());
	}
	
	@Id
	@Column(name = "ID_EI")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_INICIO")
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_FIN")
	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	@Column(name = "CERTIFICADO")
	public String getCertificado() {
		return certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	@Column(name = "EXP_OCEF")
	public String getExp_ocef() {
		return exp_ocef;
	}

	public void setExp_ocef(String exp_ocef) {
		this.exp_ocef = exp_ocef;
	}

	@Column(name = "EXP_SIAF")
	public String getExp_siaf() {
		return exp_siaf;
	}

	public void setExp_siaf(String exp_siaf) {
		this.exp_siaf = exp_siaf;
	}

	@Column(name = "IMPORTE_TOTAL")
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PROY")
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@ManyToOne
	@JoinColumn(name = "ID_INV")
	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	@OneToMany(mappedBy = "tramite")
	public List<Detalle> getLstDetalle() {
		return lstDetalle;
	}

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_RENDICION")
	public Date getFecha_rendicion() {
		return fecha_rendicion;
	}

	public void setFecha_rendicion(Date fecha_rendicion) {
		this.fecha_rendicion = fecha_rendicion;
	}

	@Column(name = "EXP_OCEF_RENDICION")
	public String getExp_ocef_rendicion() {
		return exp_ocef_rendicion;
	}

	public void setExp_ocef_rendicion(String exp_ocef_rendicion) {
		this.exp_ocef_rendicion = exp_ocef_rendicion;
	}

	@Column(name = "IMPORTE_RENDICION")
	public double getImporte_rendicion() {
		return importe_rendicion;
	}

	public void setImporte_rendicion(double importe_rendicion) {
		this.importe_rendicion = importe_rendicion;
	}

	@Column(name = "IMPORTE_DEVOLUCION")
	public double getImporte_devolucion() {
		return importe_devolucion;
	}

	public void setImporte_devolucion(double importe_devolucion) {
		this.importe_devolucion = importe_devolucion;
	}

	@Column(name = "RESPONSABLE_RENDICION")
	public String getResponsable_rendicion() {
		return responsable_rendicion;
	}

	public void setResponsable_rendicion(String responsable_rendicion) {
		this.responsable_rendicion = responsable_rendicion;
	}

	public void setLstDetalle(List<Detalle> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}
	
	@Column(name = "EXP_OCEF_DEVOLUCION")
	public String getExp_ocef_devolucion() {
		return exp_ocef_devolucion;
	}

	public void setExp_ocef_devolucion(String exp_ocef_devolucion) {
		this.exp_ocef_devolucion = exp_ocef_devolucion;
	}

	public void addDetalle(Detalle detalle) {
		getLstDetalle().add(detalle);
		detalle.setTramite(this);

		//return detalle;
	}

	public void removeDetalle(Detalle detalle) {
		getLstDetalle().remove(detalle);
		detalle.setTramite(null);
		//return detalle;
	}

	public void ejecutarCalculos() {
		Double tmpImporte = 0.0;
		for (Detalle detalle : lstDetalle) {
			tmpImporte += detalle.getImporte();
		}
		this.setImporte(tmpImporte);
	}

	public void calcularDevolucion() {
		double devolucion = this.getImporte() - this.getImporte_rendicion();
		this.setImporte_devolucion(devolucion);
	}
	
	@Column(name="TIPO_TRAMITE")
	public String getTipo_tramite() {
		return tipo_tramite;
	}

	public void setTipo_tramite(String tipo_tramite) {
		this.tipo_tramite = tipo_tramite;
	}

	@Column(name="ESTADO_TRAMITE")
	public String getEstado_tramite() {
		return estado_tramite;
	}

	public void setEstado_tramite(String estado_tramite) {
		this.estado_tramite = estado_tramite;
	}
	
	@Column(name="ID_OCEF")
	public String getId_ocef() {
		return id_ocef;
	}

	public void setId_ocef(String id_ocef) {
		this.id_ocef = id_ocef;
	}
	
	
}
