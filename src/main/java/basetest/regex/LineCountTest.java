package basetest.regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCountTest {
	
	public static void main(String...args) throws Exception {
		new LineCountTest().go("C:/sandeep/code/dbCheque/Shellscript", "C:\\sandeep\\code\\temp\\report.csv");
	}

	
	
	public void go(String sourceDir, String output) throws Exception {
		Path source = Paths.get(sourceDir);
		StringBuilder sb = new StringBuilder();
		Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		    		if(false == Files.isDirectory(file, LinkOption.NOFOLLOW_LINKS)) {
		    			if(file.toString().endsWith(".sh") || file.toString().endsWith(".pc") || file.toString().endsWith(".h") || file.toString().endsWith(".mk") || file.toString().endsWith(".ctl") || file.toString().endsWith(".java")) {
		    				byte[] data = Files.readAllBytes(file);
		    				Matcher m = Pattern.compile("\n").matcher(new String(data));
		    				int count = 0;
		    				while(m.find()) {
		    					count++;
		    				}
		    				if(count != 0) {
		    					count++;
		    				}
		    				sb.append(file.getFileName().toString().substring(file.getFileName().toString().indexOf('.')));
		    				sb.append(",");
		    				sb.append(file.getFileName());
		    				sb.append(",");
		    				sb.append(count);
		    				sb.append("\n");
		    			}
		    		}
		            return FileVisitResult.CONTINUE;
		        }
		});
		Files.write(Paths.get(output), sb.toString().getBytes(), StandardOpenOption.CREATE);
	}
}
