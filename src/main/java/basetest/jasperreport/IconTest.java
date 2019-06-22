package basetest.jasperreport;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IconTest {
	public static void main(String...args) throws Exception {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "user", "app");

		
		JFrame jf1 = new JFrame("Test");
		jf1.setVisible(true);
		jf1.setSize(400, 400);
		JButton jb = new JButton("");
		jb.setVisible(true);
		jb.setSize(200, 300);
		jf1.add(jb);
		PreparedStatement ps2 = con.prepareStatement("select A_SIGN_IC1 from app.SPF_DETAILS where TID = 'T100002'");
		ResultSet rs = ps2.executeQuery();
		int z = 0;
		while(rs.next()) {
			Blob bl1 = rs.getBlob(1);
			System.out.println(bl1.length());
			ImageIcon ii = new ImageIcon(bl1.getBytes(1, (int)bl1.length()));
			java.awt.Image img = ii.getImage();
			jb.setIcon(ii);
		}
		
		con.close();
	}
}
