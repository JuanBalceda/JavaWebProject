package pe.edu.uni.ogi.presentacion;

import java.io.IOException;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;


public abstract class GenericoMB{

	public GenericoMB() {

	}

	protected void msgInfo(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Aviso", msg));
	}

	protected void msgInfo(String titulo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				titulo, msg));
	}

	protected void msgAlert(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Alerta", msg));
	}

	protected void msgError(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Error", msg));
	}

	protected String getStringJSF(String key) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try {
			properties.load(cl.getResourceAsStream("config.properties"));
			return properties.getProperty(key);
		} catch (IOException e) {
//			e.printStackTrace();
		}

		return "";
	}

	protected HttpServletRequest getRequest() {
		FacesContext fctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = fctx.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
		return request;
	}
	
	protected HttpServletResponse getResponse() {
		FacesContext fctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = fctx.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
		return response;
	}
		
	/*
	 * Formato de Exportación de Excel
	 */
	
	protected void setStyleFormat(HSSFWorkbook workbook, Cell cell) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        //font.setColor(IndexedColors.BLACK.getIndex());
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setItalic(false);

        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());

//		newCellStyle.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
//		newCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        newCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        newCellStyle.setBorderTop((short) 1); // single line border
        newCellStyle.setBorderBottom((short) 1); // single line border
        newCellStyle.setBorderRight((short) 1);
        newCellStyle.setBorderLeft((short) 1);
        newCellStyle.setFont(font);

        cell.setCellStyle(newCellStyle);
    }

    protected void setStyleLisCabecera(HSSFWorkbook workbook, Cell cell) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        //font.setColor(IndexedColors.WHITE.getIndex());
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setItalic(false);

        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(cell.getCellStyle());

        //newCellStyle.setFillForegroundColor(HSSFColor.BLUE.index);
        //newCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        newCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        newCellStyle.setBorderTop((short) 1); // single line border
        newCellStyle.setBorderBottom((short) 1); // single line border
        newCellStyle.setBorderRight((short) 1);
        newCellStyle.setBorderLeft((short) 1);
        newCellStyle.setFont(font);

        cell.setCellStyle(newCellStyle);
    }


	
}
