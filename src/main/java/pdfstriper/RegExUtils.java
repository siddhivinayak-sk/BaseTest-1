package pdfstriper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegExUtils {
	
	private RegExUtils() {}

	
	/**
	 * Get list of items from the given source by using given pattern
	 * @param pattern
	 * @param source
	 * @return
	 */
	public static List<String> getStringBy(String pattern, String source, boolean dotAll) {
		List<String> retVal = new ArrayList<>();
		Matcher matcher = null;
		if(dotAll) {
			matcher = Pattern.compile(pattern, Pattern.DOTALL).matcher(source);
		}
		else {
			matcher = Pattern.compile(pattern).matcher(source);
		}
        while(matcher.find()) {
        	retVal.add(matcher.group());
        }
        return retVal;
	}
	
	public static <T> T getFirst(Collection<T> ob) {
		return null != ob && !ob.isEmpty()?ob.stream().findFirst().get():null; 
	}
	
	public static String getSecondIteamFromPattern(String pattern, String source, String token) {
        String retVal = "";
        List<String> result = RegExUtils.getStringBy(pattern, source, false);
        String firstItem = RegExUtils.getFirst(result);
        if(null != firstItem && firstItem.contains(token)) {
        	retVal = firstItem.split(token)[1].trim();
        }
        return retVal;
	}
	
	public static int getLineCount1(String source) {
		source = source.replaceAll("\r\n", "\n");
		source = source.replaceAll("\n\r", "\n");
		source = source.replaceAll("\r", "\n");
		return getStringBy("\n", source, true).size();
	}
	
	public static String normalize(String normalizedPattern, String source) {
		while(source.contains(normalizedPattern + normalizedPattern)) {
			source = source.replaceAll(normalizedPattern + normalizedPattern, normalizedPattern);
		}
		return source;
	}
	

	public static List<String> getMultiLines(String pattern, String source, String startTxt, String endTxt, List<String> midTxtList) {
		Map<Integer, String> retVal = new HashMap<>();
		retVal.put(0, "");
		
        String inion = RegExUtils.getFirst(RegExUtils.getStringBy(pattern, source, true)).replace(endTxt, "");
		for(String midTxt:midTxtList) {
	        Integer indexOfMid = inion.indexOf(midTxt);
	        retVal.put(indexOfMid, "");
		}
        List<String> lineList = RegExUtils.getStringBy("(.*)", inion, false);
        for(String line:lineList) {
        	for(int start = 0; start < retVal.size(); start++) {
        		List<Integer> keyList = new ArrayList<>(retVal.keySet()); 
        		Integer key = keyList.get(start);
        		int startInd = (null != key)?key:0;
        		int endInd = (start == retVal.size() - 1)?line.length() - 1:keyList.get(start + 1);
        		endInd = (endInd < 0)?0:endInd;
        		if(line.length() > endInd) {
        			String tempText = line.substring(startInd, endInd);
        			retVal.put(key, retVal.get(key) + tempText);
        		}
        	}
        }
    	return retVal.values().stream().<String>map(e -> RegExUtils.normalize(" ", e)).collect(Collectors.toList());
	}
	
	public static Map<Integer, List<String>> getTab1(String pattern, String source, String startTxt, String endTxt) {
		Map<Integer, List<String>> retVal = new HashMap<>();
        String inion = RegExUtils.getFirst(RegExUtils.getStringBy(pattern, source, true)).replace(endTxt, "");
        
        startTxt = startTxt.replace("     ", "\t");
        startTxt = normalize("\t", startTxt);
        startTxt = normalize(" ", startTxt);
        
        inion = inion.replace("     ", "\t");
        inion = normalize("\t", inion);
        inion = normalize(" ", inion);
        inion = inion.replace(startTxt, "");
        
        List<String> lineList = RegExUtils.getStringBy("(.*)", inion, false);
        
        int count = 0;
        for(String line:lineList) {
        	if(line.contains("\t") && line.trim().length() > 1) {
        		retVal.put(count++, Arrays.asList(line.split("\t")));
        	}
        }
        return retVal;
	}
	

	public static Map<Integer, List<String>> getTab2(String pattern, String source, String startTxt, String endTxt) {
        String inion = RegExUtils.getFirst(RegExUtils.getStringBy(pattern, source, true)).replace(endTxt, "");
       // System.out.println("inion::"+inion);
        inion = inion.replaceAll(startTxt, "");
        System.out.println("inion::"+inion);
        inion = inion.replaceAll("([0-9]+)/([0-9]+)/([0-9]+)", "</TD><TD>$1/$2/$3</TD>");
        inion = inion.replaceAll("</TD>   ([0-9]+) ", "</TD>   <TD>$1</TD><TD>");
		inion = inion.replaceAll(" ([a-zA-Z])[ ]+</TD>",  "</TD><TD>$1</TD>");
		inion = inion.replaceAll("\r\n",  "\n");
		inion = inion.replaceAll("\n\r",  "\n");
		inion = inion.replaceAll("\r",  "\n");
		inion = inion.replaceAll("\n",  "\n<NewLine>");
		inion = inion.replaceAll("<NewLine>([ 0-9]+)  ",  "</TR><TR><TD>$1</TD><TD>");
		inion = inion.replaceAll("<NewLine>",  "");
		inion = inion.replaceAll("<TR><TD>[ ]+</TD>", "");
		inion = inion.replaceAll("<TD>[ ]+", "<TD>");
		inion = inion.replaceAll("[ ]+</TD>", "</TD>");
		inion = inion.replaceAll("</TD>[ ]+<TD>", "</TD><TD>");
		inion = inion.replaceAll("     ", "<----->");
		inion = normalize("<----->", inion);
		inion = normalize(" ", inion);
		inion = inion.replaceAll("</TR><TR>", "<TR>");
		List<String> lineList = RegExUtils.getStringBy("(.*)", inion, false);
		//System.out.println("lineList::"+lineList);
		int count = 0;
		Map<Integer, List<String>> finalMap = new HashMap<>();
		List<String> lastLine = null;
		for(String line:lineList) {
			Matcher matcher = Pattern.compile("<TR><TD>([^<>]+)</TD><TD>([^<>]+)</TD><TD>([^<>]+)</TD><TD>([^<>]+)</TD><TD>([^<>]+)</TD><TD>([^<>]+)<----->([^<>]+)<-----> ").matcher(line);
			if(matcher.find()) {
				lastLine = new ArrayList<>();
				lastLine.add(matcher.group(1));
				lastLine.add(matcher.group(2));
				lastLine.add(matcher.group(3));
				lastLine.add(matcher.group(4));
				lastLine.add(matcher.group(5));
				lastLine.add(matcher.group(6));
				lastLine.add(matcher.group(7));
				finalMap.put(count++, lastLine);
			}
			else {
				line = line.replaceAll("</TR><TD>", "");
				if(line.contains("<----->")) {
					lastLine.set(1, lastLine.get(1) + " " + line.split("<----->")[0]);
					lastLine.set(5, lastLine.get(5) + " " + line.split("<----->")[1]);
				}
			}
		}
    	return finalMap;
	}

	public static final String CONST_FIRT_IDTABLE = "Sr\\.[ ]+Name";
	public static final String CONST_FIRT_IDTABLE_R = "<StartTable>";
	public static final String CONST_EMPTY = "";
	public static final String CONST_SPACE = " ";
	public static final String CONST_CR = "\r";
	public static final String CONST_LF = "\n";
	public static final int CONST_0 = 0;
	public static final int CONST_1 = 1;
	public static final String CONST_TAB_START = "           1 ";
	public static final String CONST_PER_LINE = "(.*)";
	public static final String[] markers = {"Nominee", "Place :"};
	public static final int[] CONST_COLUMN_STARTS = {0, 13, 37, 44, 57, 61, 83, 106, 132};
	public static final String TABLE_START = "<table>";
	public static final String TABLE_END = "</table>";
	public static final String ROW_START = "<tr>";
	public static final String ROW_END = "</tr>";
	public static final String COLUMN_START = "<td>";
	public static final String COLUMN_END = "</td>";
	
	public static List<Table> getTables(String data) {
		List<Table> retVal = new ArrayList<>();
		if(null == data) {
			return retVal;
		}
		data = data.replaceAll(CONST_FIRT_IDTABLE, CONST_FIRT_IDTABLE_R);
		Matcher matcher = Pattern.compile(CONST_FIRT_IDTABLE_R).matcher(data);
		while(matcher.find()) {
			Table newTable = new Table();
			newTable.setStartIndex(matcher.end());
			retVal.add(newTable);
		}
		for(int tableNo = CONST_0; tableNo < retVal.size(); tableNo++) {
			Table currentTable = retVal.get(tableNo);
			int nextIndex = ((tableNo + CONST_1) < retVal.size())?retVal.get(tableNo + CONST_1).getStartIndex():data.length() - CONST_1;
			String tableData = data.substring(currentTable.getStartIndex(), nextIndex);
			boolean isMarkerFound = false;
			for(String marker:markers) {
				if(tableData.contains(marker)) {
					isMarkerFound = true;
					tableData = tableData.substring(CONST_0, tableData.indexOf(marker));
					tableData = tableData.substring(tableData.indexOf(CONST_TAB_START), tableData.length());
					currentTable.setSource(tableData);
					Matcher tMatcher = Pattern.compile(CONST_PER_LINE).matcher(tableData);
					while(tMatcher.find()) {
						String tData = tMatcher.group(CONST_1);
						tData = tData.replaceAll(CONST_CR, CONST_EMPTY).replaceAll(CONST_CR, CONST_EMPTY);
						if(tData.length() > CONST_0) {
							List<Column> tempCols = new ArrayList<>();
							for(int index = CONST_0; index < CONST_COLUMN_STARTS.length; index++) {
								int subIndex = ((index + CONST_1) < CONST_COLUMN_STARTS.length)?CONST_COLUMN_STARTS[index + CONST_1]:tData.length() - CONST_1;
								if(tData.length() > subIndex && subIndex >= CONST_COLUMN_STARTS[index]) {
									tempCols.add(new Column(normalize(CONST_SPACE, tData.substring(CONST_COLUMN_STARTS[index], subIndex))));
								}
							}
							if(!tempCols.isEmpty() && tempCols.get(CONST_0).getData().replace(CONST_SPACE, CONST_EMPTY).length() > CONST_0) {
								Row row = new Row();
								row.setSource(tData);
								row.setColumns(tempCols);
								currentTable.getRows().add(row);
							}
							else if(!currentTable.getRows().isEmpty()) {
								Row row = currentTable.getRows().get(currentTable.getRows().size() - CONST_1);
								for(int index = CONST_0; index < CONST_COLUMN_STARTS.length; index++) {
									if(row.getColumns().size() > index && tempCols.size() > index) {
										row.getColumns().get(index).setData(normalize(CONST_SPACE, row.getColumns().get(index).getData() + CONST_SPACE + tempCols.get(index).getData()));
									}
								}
							}
						}
					}
				}
			}
			if(!isMarkerFound) {
				currentTable.setSource(tableData);
				currentTable.setError(true);
			}
		}
		return retVal;
	}
	
	public static class Table {
		private List<Row> rows;
		private String source;
		private int startIndex;
		private int endIndex;
		private boolean isError;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public List<Row> getRows() {
			if(null == rows) {
				rows = new ArrayList<>();
			}
			return rows;
		}

		public void setRows(List<Row> rows) {
			this.rows = rows;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}

		public boolean isError() {
			return isError;
		}

		public void setError(boolean isError) {
			this.isError = isError;
		}
		
		public String toString() {
			return TABLE_START + rows + TABLE_END;
		}
	}
	
	public static class Row {
		private List<Column> columns;
		private String source;
		
		public List<Column> getColumns() {
			if(null == columns) {
				columns = new ArrayList<>();
			}
			return columns;
		}
		public void setColumns(List<Column> columns) {
			this.columns = columns;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}

		public String toString() {
			return ROW_START + columns + ROW_END;
		}

	}
	
	public static class Column {
		private String data;

		public Column(String data) {
			super();
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
		
		public String toString() {
			return COLUMN_START + data + COLUMN_END;
		}
	}
	
}
