package com.sk.json.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CollectDataUtil {

	public static void main(String...args) {
		String source = "C:\\sandeep\\code\\amigos\\server-proxy-benchmarking\\20220823_ServerProxy-PerfData-HPA\\ServerProxy-PerfData-HPA";
		String report = "C:\\sandeep\\code\\amigos\\server-proxy-benchmarking\\report.csv";
		
		CollectDataUtil util = new CollectDataUtil();
		util.collectData(source, report);
	}
	
	
	
	public boolean collectData(String sourcePath, String reportPath) {
		try {
			Data data = collectData(sourcePath);
			data.toFile(reportPath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Data collectData(String sourcePath) throws IOException {
		List<DataRow> rows = collectListOfFiles(sourcePath)
				.stream()
				.map(filePath -> {
					try {
						return collectDataRow(filePath.toString());
					} catch (IOException e) {
						e.printStackTrace();
						return new DataRow();
					}
				})
				.filter(drows -> null != drows.filename)
				.collect(Collectors.toList());
		Data data = new Data();
		data.setRows(rows);
		return data;
	}
	
	public DataRow collectDataRow(String sourceFilePath) throws IOException {
		DataRow row = new DataRow();
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(sourceFilePath);
		row.filename = sourceFilePath;
		row.l1 = file.getName();
		row.l2 = file.getParentFile().getName();
		row.l3 = file.getParentFile().getParentFile().getName();
		
		JsonNode rootNode = mapper.readTree(file);
		row.totalHits = rootNode.at(JsonPointer.compile("/metrics/iterations/count")).asText();
		row.totalTime = getTimeFromFile(file.getParent() + "/K6_output.txt");
		row.throughPut = rootNode.at(JsonPointer.compile("/metrics/iterations/rate")).asText();
		row.success = rootNode.at(JsonPointer.compile("/metrics/http_req_failed/fails")).asText();
		row.failure = rootNode.at(JsonPointer.compile("/metrics/http_req_failed/passes")).asText();
		row.failureRate = rootNode.at(JsonPointer.compile("/metrics/http_req_failed/value")).asText();
		row.p50 = rootNode.at(JsonPointer.compile("/metrics/http_req_duration{expected_response:true}/p(50)")).asText();
		row.p75 = rootNode.at(JsonPointer.compile("/metrics/http_req_duration{expected_response:true}/p(75)")).asText();
		row.p90 = rootNode.at(JsonPointer.compile("/metrics/http_req_duration{expected_response:true}/p(90)")).asText();
		row.p95 = rootNode.at(JsonPointer.compile("/metrics/http_req_duration{expected_response:true}/p(95)")).asText();
		row.p99 = rootNode.at(JsonPointer.compile("/metrics/http_req_duration{expected_response:true}/p(99)")).asText();
		
		return row;
	}
	
	public String getTimeFromFile(String path) throws IOException {
		String retVal = "";
		String data = new String(Files.readAllBytes(Paths.get(path)));
		Matcher matcher = Pattern.compile(", ([0-9A-Za-z\\.]+) max duration \\(").matcher(data);
		if(matcher.find()) {
			retVal = matcher.group(1);
		}
		return retVal;
	}
	
	public List<Path> collectListOfFiles(String path) throws IOException {
		List<Path> paths = new ArrayList<>();
		Files.walkFileTree(Paths.get(path), new FileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(file.toString().endsWith(".json")) {
					paths.add(file);
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
		return paths;
	}
	
}

class Data {
	List<DataRow> rows = new ArrayList<>();

	public List<DataRow> getRows() {
		return rows;
	}

	public void setRows(List<DataRow> rows) {
		this.rows = rows;
	}
	
	public boolean toFile(String filename) {
		StringBuilder builder = new StringBuilder();
		builder.append("Filename");
		builder.append(",");
		builder.append("Scenario");
		builder.append(",");
		builder.append("Case");
		builder.append(",");
		builder.append("Total Hits");
		builder.append(",");
		builder.append("Total Time");
		builder.append(",");
		builder.append("Throughput");
		builder.append(",");
		builder.append("Success");
		builder.append(",");
		builder.append("Failure");
		builder.append(",");
		builder.append("FailureRate");
		builder.append(",");
		builder.append("P50");
		builder.append(",");
		builder.append("P75");
		builder.append(",");
		builder.append("P90");
		builder.append(",");
		builder.append("P95");
		builder.append(",");
		builder.append("P99");
		builder.append(",");
		builder.append("Path");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write(builder.toString());
			bw.newLine();
			rows.stream().forEach(row -> {
				try {
					bw.write(row.toString());
					bw.newLine();
				} catch(IOException e) {
					e.printStackTrace();
				}
			});
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}

class DataRow {
	String filename;
	String totalHits;
	String totalTime;
	String throughPut;
	String success;
	String failure;
	String p50;
	String p75;
	String p90;
	String p95;
	String p99;
	String l1;
	String l2;
	String l3;
	String failureRate;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getTotalHits() {
		return totalHits;
	}
	public void setTotalHits(String totalHits) {
		this.totalHits = totalHits;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getThroughPut() {
		return throughPut;
	}
	public void setThroughPut(String throughPut) {
		this.throughPut = throughPut;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getFailure() {
		return failure;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	public String getP50() {
		return p50;
	}
	public void setP50(String p50) {
		this.p50 = p50;
	}
	public String getP75() {
		return p75;
	}
	public void setP75(String p75) {
		this.p75 = p75;
	}
	public String getP90() {
		return p90;
	}
	public void setP90(String p90) {
		this.p90 = p90;
	}
	public String getP95() {
		return p95;
	}
	public void setP95(String p95) {
		this.p95 = p95;
	}
	public String getP99() {
		return p99;
	}
	public void setP99(String p99) {
		this.p99 = p99;
	}
	public String getL1() {
		return l1;
	}
	public void setL1(String l1) {
		this.l1 = l1;
	}
	public String getL2() {
		return l2;
	}
	public void setL2(String l2) {
		this.l2 = l2;
	}
	public String getL3() {
		return l3;
	}
	public void setL3(String l3) {
		this.l3 = l3;
	}
	public String getFailureRate() {
		return failureRate;
	}
	public void setFailureRate(String failureRate) {
		this.failureRate = failureRate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(l1);
		builder.append(",");
		builder.append(l3);
		builder.append(",");
		builder.append(l2);
		builder.append(",");
		builder.append(totalHits);
		builder.append(",");
		builder.append(totalTime);
		builder.append(",");
		builder.append(throughPut);
		builder.append(",");
		builder.append(success);
		builder.append(",");
		builder.append(failure);
		builder.append(",");
		builder.append(failureRate);
		builder.append(",");
		builder.append(p50);
		builder.append(",");
		builder.append(p75);
		builder.append(",");
		builder.append(p90);
		builder.append(",");
		builder.append(p95);
		builder.append(",");
		builder.append(p99);
		builder.append(",");
		builder.append(filename);
		return builder.toString();
	}
}

