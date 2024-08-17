package basetest.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Path;

public class TestLevel {
	
	public static void main(String...args) throws IOException {
		TestLevel testLevel = new TestLevel();
		testLevel.process("C:\\sandeep\\daily\\20230519\\test1.txt");
		testLevel.process("C:\\sandeep\\daily\\20230519\\test2.txt");
		testLevel.process("C:\\sandeep\\daily\\20230519\\test3.txt");
		testLevel.process("C:\\sandeep\\daily\\20230519\\test4.txt");
	}
	
	String S = "{";
	String E = "}";
	String DS = "\\";
	String LIS = "<<<<";
	String LIE = ">>>>";
	String P_NUM = "([0-9]+)";

	void process(String filePath) throws IOException {
		String content = read(filePath);
		content = addLevel(content);
		content = findBlockAndInsertLine(content, "dxpKotlinApplication|dxpKotlinLibrary", "    additionalDependencyCheckSuppressionPaths = setOf(File(\"\\$projectDir/ops/DependencyCheckSuppressions.xml\"), File(\"\\$projectDir/ops/owasp-centralized-suppresion-file.xml\"))");
		content = cleanLevel(content);
		write(parentPath(filePath) + "/out" + fileName(filePath), content);
	}
	
	String findBlockAndInsertLine(String content, String blockBeginWith, String insertLine) {
		int indexOfModule = findAt(content, blockBeginWith, true, -1);
		if(indexOfModule > 0) {
			String sectionNo = findAtString(content, DS + S + "-" + LIS + P_NUM + LIE, indexOfModule);
			if(null != sectionNo) {
				String endingSectionNo = sectionNo.replace(S, E);
				StringBuilder sb = new StringBuilder();
				Matcher m1 = Pattern.compile("(" + DS + endingSectionNo + ")").matcher(content);
				if(m1.find(indexOfModule)) {
					m1.appendReplacement(sb, insertLine + "\r\n$1");
				}
				m1.appendTail(sb);
				content = sb.toString();
			}
		}
		return content;
	}
	
	String findAtString(String content, String pattern, int from) {
		Matcher m1 = Pattern.compile(pattern).matcher(content);
		if(from > -1) {
			if(m1.find(from)) {
				return m1.group();
			} else {
				return null;
			}
		} else {
			if(m1.find()) {
				return m1.group();
			} else {
				return null;
			}
		}
	}

	int findAt(String content, String pattern, boolean isEnd, int from) {
		Matcher m1 = Pattern.compile(pattern).matcher(content);
		if(from > -1) {
			if(m1.find(from)) {
				if(isEnd) {
					return m1.end();
				} else {
					return m1.start();
				}
			} else {
				return -1;
			}
		} else {
			if(m1.find()) {
				if(isEnd) {
					return m1.end();
				} else {
					return m1.start();
				}
			} else {
				return -1;
			}
		}
	}
	
	String addLevel(String content) {
		int level = -1;
		StringBuilder sb = new StringBuilder();
		Matcher m1 = Pattern.compile("(" + DS + S + "|" + DS + E  + ")").matcher(content);
		while(m1.find()) {
			if(m1.group(1).equals(S)) {
				level++;
				m1.appendReplacement(sb, "$1-" + LIS + level + LIE);
			} else if (m1.group(1).equals(E)) {
				m1.appendReplacement(sb, "$1-" + LIS + level + LIE);
				level--;
			}
		}
		m1.appendTail(sb);
		return sb.toString();
	}
	
	String cleanLevel(String content) {
		return content.replaceAll(DS + S + "-" + LIS + P_NUM + LIE, S).replaceAll(DS + E + "-" + LIS + P_NUM + LIE, E);
	}
	
	String parentPath(String filePath) {
		return Paths.get(filePath).getParent().toString();
	}

	String fileName(String filePath) {
		return Paths.get(filePath).getFileName().toString();
	}
	
	void write(String filePath, String content) throws IOException {
		Path path = Paths.get(filePath);
		Files.deleteIfExists(path);
		Files.writeString(path, content, StandardOpenOption.CREATE);
	}
	
	String read(String filePath) throws IOException {
		return Files.readString(Paths.get(filePath));
	}
}
