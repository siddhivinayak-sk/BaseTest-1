package basetest.jasperreport;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;

public class JasperTest {

	
	@SuppressWarnings("deprecation")
	public static void main(String...args) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "user", "app");
		//Statement st = con.createStatement();
		//ResultSet rs = st.executeQuery("select * from app.student");
		//while(rs.next()) {
			//System.out.println(rs.getString("name"));
		//}
		
		
		
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tid", "T100001");
		String sourceJasperXml = "C:\\Users\\kumar-sand\\OneDrive - HCL Technologies Ltd\\Code\\NB\\jrprj01\\reports\\r2.jrxml";
		String sourceJasper = "C:\\Users\\kumar-sand\\OneDrive - HCL Technologies Ltd\\Code\\NB\\jrprj01\\reports\\r2.jasper";
		String outputFile = "C:\\Users\\kumar-sand\\OneDrive - HCL Technologies Ltd\\Code\\NB\\jrprj01\\r2.pdf";
		String outputXlsxFile = "C:\\Users\\kumar-sand\\OneDrive - HCL Technologies Ltd\\Code\\NB\\jrprj01\\reports\\r2.xlsx";


		JasperCompileManager.compileReportToFile(sourceJasperXml, sourceJasper);
		
		JasperPrint jp = JasperFillManager.fillReport(sourceJasper, param, con);
		
		
		//To export into PDF file
		//JasperExportManager.exportReportToPdfFile(jp, outputFile);
		
		//To view in JFrame
		//JasperViewer.viewReport(jp);

		//Export PDF
//		JRPdfExporter jpdfExp = new JRPdfExporter();
//		jpdfExp.setExporterInput(new SimpleExporterInput(jp));
//		jpdfExp.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
//		SimplePdfExporterConfiguration pdfConfig = new SimplePdfExporterConfiguration();
//		pdfConfig.setCreatingBatchModeBookmarks(true);
//		jpdfExp.setConfiguration(pdfConfig);
//		jpdfExp.exportReport();
		

		//Export XLSX
//		JRXlsxExporter jxlsxExp = new JRXlsxExporter();
//		SimpleXlsxReportConfiguration xlsxConfig = new SimpleXlsxReportConfiguration();
//		jxlsxExp.setExporterInput(new SimpleExporterInput(jp));
//		jxlsxExp.setExporterOutput(new SimpleOutputStreamExporterOutput(outputXlsxFile));
//		jxlsxExp.setConfiguration(xlsxConfig);
//		jxlsxExp.exportReport();
		

		//Print Directly using JasperPrintManager
		//JasperPrintManager.printReport(jp, false);
		
		
		
		
	    PrinterJob printerJob = PrinterJob.getPrinterJob();
	    PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
	    printerJob.defaultPage(pageFormat);

	    int selectedService = 0;
	    AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName("Microsoft Print to PDF", null));
	    PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);
	    try {
	        printerJob.setPrintService(printService[selectedService]);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    JRPrintServiceExporter exporter;
	    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
	    printRequestAttributeSet.add(MediaSizeName.ISO_A4);
	    printRequestAttributeSet.add(new Copies(1));

	    SimplePrintServiceExporterConfiguration prnExpCfg = new SimplePrintServiceExporterConfiguration();
	    exporter = new JRPrintServiceExporter();
	    exporter.setExporterInput(new SimpleExporterInput(jp));
	    prnExpCfg.setPrintService(printService[selectedService]);
	    prnExpCfg.setPrintServiceAttributeSet(printService[selectedService].getAttributes());
	    prnExpCfg.setPrintRequestAttributeSet(printRequestAttributeSet);
	    prnExpCfg.setDisplayPrintDialog(Boolean.FALSE);
	    prnExpCfg.setDisplayPageDialog(Boolean.FALSE);
	    
	    
	    //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
	    //exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
	    //exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
	    //exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
	    //exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
	    //exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

	    exporter.setConfiguration(prnExpCfg);
	    exporter.exportReport();
		
		
		
		
		
		
	}
}
