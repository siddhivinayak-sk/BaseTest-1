package basetest.jasperreport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class ReportTest {
	
	public static void main(String...args) throws Exception {
		String input = "";
		String output = "";
		
		try(FileInputStream fis = new FileInputStream(input)) {
			byte[] data = new byte[fis.available()];
			fis.read(data);
			data = Base64.getDecoder().decode(data);
			try(FileOutputStream fos = new FileOutputStream(output)) {
				fos.write(data);
			}
		}
	}
	
	
	
	
}
