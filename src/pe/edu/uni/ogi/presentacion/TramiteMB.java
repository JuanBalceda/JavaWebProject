package pe.edu.uni.ogi.presentacion;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import pe.edu.uni.ogi.entidad.Detalle;
import pe.edu.uni.ogi.entidad.Investigador;
import pe.edu.uni.ogi.entidad.Partida;
import pe.edu.uni.ogi.entidad.Proyecto;
import pe.edu.uni.ogi.entidad.Tramite;
import pe.edu.uni.ogi.entidad.TramiteVO;
import pe.edu.uni.ogi.mail.AlertMail;
import pe.edu.uni.ogi.servicio.excepciones.ServicioException;
import pe.edu.uni.ogi.servicio.interfaces.InvestigadorServicio;
import pe.edu.uni.ogi.servicio.interfaces.PartidaServicio;
import pe.edu.uni.ogi.servicio.interfaces.ProyectoServicio;
import pe.edu.uni.ogi.servicio.interfaces.TramiteServicio;

@Component
@Controller("tramiteMB")
@SessionScoped
public class TramiteMB extends GenericoMB {

	private Tramite tramite;
	
	private Investigador investigador;

	private Proyecto proyecto;

	private Partida partida;
	
	private Detalle detalle;

	private List<Partida> lstPartida;

	private List<Tramite> lstTramite;

	private List<TramiteVO> lstTramiteVO;
	
	@Autowired
	protected InvestigadorServicio investigadorServicio;

	@Autowired
	protected ProyectoServicio proyectoServicio;

	@Autowired
	protected PartidaServicio partidaServicio;

	@Autowired
	protected TramiteServicio tramiteServicio;

	public TramiteMB() {
	}

	@PostConstruct
	public void init() {
//		System.out.println("Init...");
		this.inicializar();
	}

	public void listar() {
		try {
			lstTramite = this.getTramiteServicio().listar(tramite);
		} catch (ServicioException e) {
//			e.printStackTrace();
		}
	}

	public String nuevo() {
		this.inicializar();
		return "tramite_registro";
	}

	public void limpiar() {
		this.inicializar();
		this.buscar();
	}

	public String buscar() {
		try {
			this.inicializar();
			this.setLstTramite(this.getTramiteServicio().listarTodo());
			this.setLstTramiteVO(this.getTramiteServicio().findByLikeObjectVO(this.getTramite()));
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "tramite_listado";
	}

	public void buscarInvXCodigo() {
		try {

			Investigador oInvestigador = this.getInvestigadorServicio().buscarXId(this.getInvestigador());
			if (oInvestigador == null) {
				oInvestigador = new Investigador();
				super.msgInfo("No existe Investigador con el Código UNI ingresado");
			}

			this.setInvestigador(oInvestigador);
			// super.msgInfo("Investigador registrado.");
		} catch (Exception e) {
		}
	}

	public void buscarProyXCodigo() {
		try {

			List<Proyecto> lstProyecto = this.getProyectoServicio().listar(this.getProyecto());

			if (lstProyecto != null && lstProyecto.size() > 0) {
				this.setProyecto(lstProyecto.get(0));
			} else {
				lstProyecto = new ArrayList<>();
				this.setProyecto(new Proyecto());
				super.msgInfo("No existe Proyecto con el código ingresado");
			}

		} catch (Exception e) {
		}
	}

	public void buscarPartida() {
		try {

			List<Partida> oLstPartida;

			oLstPartida = this.getPartidaServicio().listar(this.getPartida());
/*
			for (Partida partida : oLstPartida) {
				System.out.println(partida);
			}
*/
			this.setLstPartida(oLstPartida);
		} catch (Exception e) {
		}
	}

	public void actualizarDetalle() {
		for (Detalle detalle : this.getTramite().getLstDetalle()) {
			detalle.ejecutarCalculos(); // Sub Totales
		}
		this.getTramite().ejecutarCalculos(); // Total
	}

	public void agregarPartida(Partida partida) {
		Detalle detalle = new Detalle();
		detalle.setPartida(partida);
		this.getTramite().addDetalle(detalle);
	}

	public void eliminarDetalle(Detalle detalle) {
		this.getTramite().removeDetalle(detalle);
	}

	public void grabar() {

		this.getTramite().setInvestigador(this.getInvestigador());
		this.getTramite().setProyecto(this.getProyecto());

		boolean sw = false;
		if (this.getTramite().getId() > 0) {
			// Actualización
			try {
				if (validar()) {
					sw = this.getTramiteServicio().actualizar(this.getTramite());
				}
				if (sw) {
					super.msgInfo("Trámite actualizado satisfactoriamente");
//					System.err.println("MB " + this.getTramite().getId());
					this.inicializar();
				} else {
					this.inicializar();
					super.msgAlert("Error al actualizar el trámite");
				}
			} catch (Exception e) {
				this.inicializar();
				super.msgInfo("Error al actualizar el trámite");
			}
		} else {
			// Inserción
			try {
				if (validar()) {
					sw = this.getTramiteServicio().insertar(this.getTramite());
				}
				if (sw) {
					super.msgInfo("Tramite creado satisfactoriamente");
//					System.err.println("MB " + this.getTramite().getId());
					this.inicializar();
				} else {
					this.inicializar();
					super.msgAlert("Error al crear el trámite");
				}
			} catch (Exception e) {
				this.inicializar();
				super.msgInfo("Error al crear Trámite");
			}
		}

	}

	public boolean validar() {
		if (this.getInvestigador().getNombre().trim().length() <= 0) {
			super.msgInfo("El investigador es un valor requerido");
			return false;
		}
		if (this.getProyecto().getNombre().trim().length() <= 0) {
			super.msgInfo("El proyecto es un valor requerido");
			return false;
		}
		return true;
	}

	public String cancelar() {
		this.inicializar();
		return "tramite_registro";
	}

	public String eliminar(int tramite) {
		Tramite t = new Tramite();
		t.setId(tramite);
		try {
			this.getTramiteServicio().eliminar(t);
			this.buscar();
		} catch (ServicioException e) {
//			e.printStackTrace();
		}

		return "tramite_listado";
	}

	public void actualizarDevolucion() {
		this.getTramite().calcularDevolucion();
	}

	public String modificar(int tramiteId) {
		try {
			Tramite t = new Tramite();
			t.setId(tramiteId);
			this.inicializar();
			this.setTramite(this.getTramiteServicio().buscarXId(t));
			this.setInvestigador(getTramite().getInvestigador());
			this.setProyecto(getTramite().getProyecto());
			this.setLstTramite(this.getTramiteServicio().listarTodo());
			this.setLstTramiteVO(this.getTramiteServicio().findByLikeObjectVO(this.getTramite()));
			
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "tramite_registro";
	}

	// Getters and Setters

	public Tramite getTramite() {
		return tramite;
	}

	public List<Tramite> getLstTramite() {
		return lstTramite;
	}

	public void setLstTramite(List<Tramite> lstTramite) {
		this.lstTramite = lstTramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<TramiteVO> getLstTramiteVO() {
		return lstTramiteVO;
	}

	public void setLstTramiteVO(List<TramiteVO> lstTramiteVO) {
		this.lstTramiteVO = lstTramiteVO;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public List<Partida> getLstPartida() {
		return lstPartida;
	}

	public void setLstPartida(List<Partida> lstPartida) {
		this.lstPartida = lstPartida;
	}

	public InvestigadorServicio getInvestigadorServicio() {
		return investigadorServicio;
	}

	public void setInvestigadorServicio(InvestigadorServicio investigadorServicio) {
		this.investigadorServicio = investigadorServicio;
	}

	public ProyectoServicio getProyectoServicio() {
		return proyectoServicio;
	}

	public void setProyectoServicio(ProyectoServicio proyectoServicio) {
		this.proyectoServicio = proyectoServicio;
	}

	public PartidaServicio getPartidaServicio() {
		return partidaServicio;
	}

	public void setPartidaServicio(PartidaServicio partidaServicio) {
		this.partidaServicio = partidaServicio;
	}

	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	private void inicializar() {
		this.setTramite(new Tramite());
		this.setDetalle(new Detalle());
		this.setInvestigador(new Investigador());
		this.setProyecto(new Proyecto());
		this.setPartida(new Partida());
		this.setLstPartida(new ArrayList<Partida>());
		this.setLstTramite(new ArrayList<Tramite>());
		this.setLstTramiteVO(new ArrayList<TramiteVO>());
	}

	/*
	 * Exportacion Excel
	 */
	public void exportExcel() {
		this.inicializar();
		HttpServletResponse response = super.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=Listado_Tramites.xls");

		try {
			OutputStream out = response.getOutputStream();
			this.setLstTramite(this.getTramiteServicio().listarTodo());
			HSSFWorkbook workbook = new HSSFWorkbook();
			if (this.getLstTramite() != null) {
				workbook = exportExcelFormato(this.getLstTramite());
			}
			workbook.write(out);
			FacesContext.getCurrentInstance().responseComplete();
			out.flush();
			out.close();
			workbook = null;
			response = null;
			
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	private HSSFWorkbook exportExcelFormato(List<Tramite> lstTramite) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Listado de Tramites");

		int countRow = 0;

		// CABECERA
		Row row = sheet.createRow(countRow);

		Cell cell = row.createCell(0);
		cell.setCellValue("Item");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(1);
		cell.setCellValue("Código OCPLA");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(2);
		cell.setCellValue("Investigador");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(3);
		cell.setCellValue("Feha de inicio");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(4);
		cell.setCellValue("Feha de fin");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(5);
		cell.setCellValue("Exp. OCEF Solicitud");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(6);
		cell.setCellValue("Exp. SIAF");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(7);
		cell.setCellValue("Certificado");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(8);
		cell.setCellValue("Importe solicitud");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(9);
		cell.setCellValue("Exp. OCEF rendición");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(10);
		cell.setCellValue("Fecha rendición");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(11);
		cell.setCellValue("Importe rendición");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(12);
		cell.setCellValue("Exp. OCEF devolución");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(13);
		cell.setCellValue("Importe devolución");
		super.setStyleLisCabecera(workbook, cell);

		cell = row.createCell(14);
		cell.setCellValue("Responsable OCEF");
		super.setStyleLisCabecera(workbook, cell);

		// LISTADO
		int item = 0;

		for (Tramite tramite : lstTramite) {

			countRow++;
			item++;

			row = sheet.createRow(countRow);

			// Item
			cell = row.createCell(0);
			cell.setCellValue(item);
			super.setStyleFormat(workbook, cell);

			// Código OCPLA
			cell = row.createCell(1);
			if (tramite.getProyecto().getCodigo_ocpla() != null) {
				cell.setCellValue(tramite.getProyecto().getCodigo_ocpla());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Investigador
			cell = row.createCell(2);
			if (tramite.getInvestigador().getNombre() != null) {
				cell.setCellValue(tramite.getInvestigador().getNombre());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Fecha de inicio
			cell = row.createCell(3);
			if (tramite.getFecha_inicio() != null) {
				cell.setCellValue(tramite.getFecha_inicio());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Fecha de fin
			cell = row.createCell(4);
			if (tramite.getFecha_fin() != null) {
				cell.setCellValue(tramite.getFecha_fin());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Código OCEF
			cell = row.createCell(5);
			if (tramite.getExp_ocef() != null) {
				cell.setCellValue(tramite.getExp_ocef());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Código OCEF
			cell = row.createCell(6);
			if (tramite.getExp_siaf() != null) {
				cell.setCellValue(tramite.getExp_siaf());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Certificado
			cell = row.createCell(7);
			if (tramite.getCertificado() != null) {
				cell.setCellValue(tramite.getCertificado());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Importe total
			cell = row.createCell(8);
			if (tramite.getImporte() != 0) {
				cell.setCellValue(tramite.getImporte());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Exp. OCEF Rendicion
			cell = row.createCell(9);
			if (tramite.getExp_ocef_rendicion() != null) {
				cell.setCellValue(tramite.getExp_ocef_rendicion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Fecha de rendicion
			cell = row.createCell(10);
			if (tramite.getFecha_rendicion() != null) {
				cell.setCellValue(tramite.getFecha_rendicion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Importe de rendición
			cell = row.createCell(11);
			if (tramite.getImporte_rendicion() != 0) {
				cell.setCellValue(tramite.getImporte_rendicion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Código OCEF devolucion
			cell = row.createCell(12);
			if (tramite.getExp_ocef_devolucion() != null) {
				cell.setCellValue(tramite.getExp_ocef_devolucion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Importe devolucion
			cell = row.createCell(13);
			if (tramite.getImporte_devolucion() != 0) {
				cell.setCellValue(tramite.getImporte_devolucion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

			// Responsable OCEF
			cell = row.createCell(14);
			if (tramite.getResponsable_rendicion() != null) {
				cell.setCellValue(tramite.getResponsable_rendicion());
				super.setStyleFormat(workbook, cell);
			} else {
				cell.setCellValue(" ");
				super.setStyleFormat(workbook, cell);
			}

		}

		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		sheet.autoSizeColumn(10);
		sheet.autoSizeColumn(11);
		sheet.autoSizeColumn(12);
		sheet.autoSizeColumn(13);
		sheet.autoSizeColumn(14);
		// System.out.println("Excel listo");
		return workbook;
	}

	@Async
	@Scheduled(cron = "0 0 0 1/1 * ?") // (cron= "0 0 12 1/1 * ? *") para cada día a las 12
	public void sendMail() {

		buscar();
		List<Tramite> lstTramite = this.getLstTramite();

		// System.out.println(lstTramite.size());

		Date hoy = new Date();

		for (Tramite t : lstTramite) {
			int dias = (int) (t.getFecha_fin().getTime() - hoy.getTime()) / 86_400_000;
			// System.out.println(dias);

			if (dias == 10) {
				AlertMail.enviarConGMail(t.getInvestigador().getEmail(),
						"Estimado investigador," + "\nLe recordamos que nos encontramos a " + dias
								+ " días de la rendición de su trámite." + "\n" + "\nAtentamente,"
								+ "\nOficina de Gestión de la Investigación.");
			} else if (dias == 5) {
				AlertMail.enviarConGMail(t.getInvestigador().getEmail(),
						"Estimado investigador,\n Le recordamos que nos encontramos a 0" + dias
								+ " días de la rendición de su trámite." + "\n" + "\nAtentamente,"
								+ "\nOficina de Gestión de la Investigación.");
			} else if (dias == 0) {
				System.out.println("No hay correos por enviar el día de hoy");
			}
		}
	}

}
