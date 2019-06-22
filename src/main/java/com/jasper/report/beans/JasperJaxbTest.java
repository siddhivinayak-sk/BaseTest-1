package com.jasper.report.beans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;

public class JasperJaxbTest {

	
	
	
	public static void main(String...args) throws Exception {
		String source = "c:\\templates\\r21.jrxml";
		String target = "c:\\templates\\r21-gen.jrxml";
		byte bytes[] = Files.readAllBytes(Paths.get(source));
		
		JAXBContext context = JAXBContext.newInstance(JasperReport.class);
		
		String detail = new String(bytes);;
		if(null != detail && !"".equals(detail)) {
			detail = detail.replaceAll("<jasperReport(.*?)>", "<jasperReport>");
			detail = detail.replace("<jr:", "<");
			detail = detail.replace("<jr:", "<");
			detail = detail.replace("</jr:", "</");
			detail = detail.replaceAll("<table (.*?)>", "<table>");
			System.out.println(detail);
			Unmarshaller um = context.createUnmarshaller();
			InputStream is = new ByteArrayInputStream(detail.getBytes());
			JasperReport report = (JasperReport)um.unmarshal(is);

			Gson gson = new Gson();
			//System.out.println(gson.toJson(report));

			byte ibytes[] = Files.readAllBytes(Paths.get(source));
			String idata = new String(bytes);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			m.marshal(report, sw);
			String minput = sw.toString();
			minput = getDetails(minput);
			if(null != minput && !"".equals(minput)) {
				minput = minput.replace("&gt;", "<");
				minput = minput.replace("&lt;", ">");
				minput = minput.replace("<table>", "<jr:table xmlns:jr=\"http://jasperreports.sourceforge.net/jasperreports/components\" xsi:schemaLocation=\"http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd\">");
				minput = minput.replace("<column", "<jr:column");
				minput = minput.replace("</column", "</jr:column");
				idata = idata.replaceAll("<detail>(.*?)</detail>", minput);
			}
			Files.write(Paths.get(target), idata.getBytes(), StandardOpenOption.CREATE);
			
		}
		
		
		
		
	}
	
	
	static private String getDetails(String data) {
		Matcher m = Pattern.compile("<detail>(.*?)</detail>", Pattern.DOTALL).matcher(data);
		return (m.find())?m.group():"";
	}
	
}
