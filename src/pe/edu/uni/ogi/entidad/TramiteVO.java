package pe.edu.uni.ogi.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "VIEW_EI")
public class TramiteVO {

	private int id;
	private String nombre_inv;
	private String codigo_ocpla;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String exp_ocef;
	private double importe_total;
	
    private Date fecha_rendicion;
	private String exp_ocef_rendicion;
	private double importe_rendicion;
	private double importe_devolucion;
	private String responsable_rendicion;
	
	private String tipo_tramite;
	private String estado_tramite;
	
	
	public TramiteVO() {
	}

	@Id
	@Column(name="ID_EI")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="NOMBRE")
	public String getNombre_inv() {
		return nombre_inv;
	}

	public void setNombre_inv(String nombre_inv) {
		this.nombre_inv = nombre_inv;
	}

	@Column(name="CODIGO_OCPLA")
	public String getCodigo_ocpla() {
		return codigo_ocpla;
	}

	public void setCodigo_ocpla(String codigo_ocpla) {
		this.codigo_ocpla = codigo_ocpla;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INICIO")
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_FIN")
	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	@Column(name="IMPORTE_TOTAL")
	public double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}
	
	@Column(name="EXP_OCEF")
	public String getExp_ocef() {
		return exp_ocef;
	}

	public void setExp_ocef(String exp_ocef) {
		this.exp_ocef = exp_ocef;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_RENDICION")
	public Date getFecha_rendicion() {
		return fecha_rendicion;
	}

	public void setFecha_rendicion(Date fecha_rendicion) {
		this.fecha_rendicion = fecha_rendicion;
	}

	@Column(name="EXP_OCEF_RENDICION")
	public String getExp_ocef_rendicion() {
		return exp_ocef_rendicion;
	}

	public void setExp_ocef_rendicion(String exp_ocef_rendicion) {
		this.exp_ocef_rendicion = exp_ocef_rendicion;
	}

	@Column(name="IMPORTE_RENDICION")
	public double getImporte_rendicion() {
		return importe_rendicion;
	}

	public void setImporte_rendicion(double importe_rendicion) {
		this.importe_rendicion = importe_rendicion;
	}

	@Column(name="IMPORTE_DEVOLUCION")
	public double getImporte_devolucion() {
		return importe_devolucion;
	}

	public void setImporte_devolucion(double importe_devolucion) {
		this.importe_devolucion = importe_devolucion;
	}

	@Column(name="RESPONSABLE_RENDICION")
	public String getResponsable_rendicion() {
		return responsable_rendicion;
	}

	public void setResponsable_rendicion(String responsable_rendicion) {
		this.responsable_rendicion = responsable_rendicion;
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

	
	
}
