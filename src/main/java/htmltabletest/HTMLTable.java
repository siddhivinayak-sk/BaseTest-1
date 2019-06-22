/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmltabletest;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Sandeep
 */
public class HTMLTable {
    String fileData;
    String fileName;
    String filePath;
    String logBuffer = "";
    boolean dirty;
    
    HTMLTable(String filePath) {
        this.filePath = filePath;
        fileName = new File(filePath).getName();
        fileData = HTMLTable.readFile(filePath);
        check(traverse(fileData));
    }
    
    public void check(ArrayList<Table> tableList) {
        for(Table table:tableList) {
            for(int rowi = 1; rowi <= table.getRowList().size(); rowi++) {
                Row row = table.getRowList().get(rowi - 1);
                for(int columni = 1; columni <= row.getColumnList().size(); columni++) {
                    Column column = row.getColumnList().get(columni - 1);
                    for(int i = 1; i <= column.getRowspan(); i++) {
                        for(int j = 1; j <= column.getColspan(); j++) {
                            if(i > 1 || j > 1) {
                                try {
                                    table.getRowList().get(rowi + i - 1).getColumnList().add(new Column(0, 0, column.getLine(), ""));
                                }
                                catch(IndexOutOfBoundsException e) {
                                    setLog("Incorrect rowspan value", column.getLine());
                                }
                            }
                        }
                    }
                }
            }
        }
        for(Table table:tableList) {
            for(Row row:table.getRowList()) {
                if(row.getColumnList().size() > table.getColumn()) {
                    setLog("Extra column found, check row", row.getLineNo());
                }
                else if(row.getColumnList().size() < table.getColumn()) {
                    setLog("Need more column to make valid table, check row", row.getLineNo());
                }
            }
        }
    }
    
    private ArrayList<Table> traverse(String data) {
        ArrayList<Table> tableList = new ArrayList<Table>();
        try {
            Matcher tableMatcher = Pattern.compile("(?ius)<table(.+?)</table>").matcher(data);
            while(tableMatcher.find()) {
                Table table = new Table(getLineNo(tableMatcher.start()), tableMatcher.group());
                Matcher rowMatcher = Pattern.compile("(?ius)<tr(.+?)</tr>").matcher(tableMatcher.group());
                while(rowMatcher.find()) {
                    Row row = new Row(getLineNo(tableMatcher.start() + rowMatcher.start()), rowMatcher.group());
                    Matcher columnMatcher = Pattern.compile("(?ius)<td(.+?)>").matcher(rowMatcher.group());
                    while(columnMatcher.find()) {
                        int colspan = 1;
                        int rowspan = 1;
                        Matcher colspanMatcher = Pattern.compile("colspan=\"([^\"]+)\"").matcher(columnMatcher.group());
                        if(colspanMatcher.find()) {
                            try {
                                colspan = Integer.parseInt(colspanMatcher.group(1));
                                if(colspan < 1) {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e) {
                                setLog("Invalid colspan value", getLineNo(tableMatcher.start() + rowMatcher.start() + columnMatcher.start() + colspanMatcher.start()));
                            }
                        }
                        Matcher rowspanMatcher = Pattern.compile("rowspan=\"([^\"]+)\"").matcher(columnMatcher.group());
                        if(rowspanMatcher.find()) {
                            try {
                                rowspan = Integer.parseInt(rowspanMatcher.group(1));
                                if(rowspan < 1) {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e) {
                                setLog("Invalid rowspan value", getLineNo(tableMatcher.start() + rowMatcher.start() + columnMatcher.start() + rowspanMatcher.start()));
                            }
                        }
                        Column column = new Column(colspan, rowspan, getLineNo(tableMatcher.start() + rowMatcher.start() + columnMatcher.start()), columnMatcher.group());
                        row.getColumnList().add(column);
                    }
                    table.getRowList().add(row);
                }
                table.refresh();
                tableList.add(table);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return(tableList);
        }
    }
    
    public int getLineNo(int x) {
        int line = 0;
        Pattern pattern = Pattern.compile("\n");
        Matcher matcher = pattern.matcher(fileData);
        matcher.region(0, x);
        while(matcher.find()) {
                line++;
        }
        return(line);
    }
    
    public boolean isDirty() {
        return(dirty);
    }
    
    public void setLog(String text) {
        logBuffer = logBuffer + "[TAB] - " + fileName + ": " + text + "\n";
        dirty = true;
    }

    public void setLog(String text, int lineNo) {
        logBuffer = logBuffer + "[TAB] " + lineNo + " - " + fileName + ": " + text + "\n";
        dirty = true;
    }
    
    class Table {
        private int row;
        private int column;
        private int lineNo;
        private String data;
        private ArrayList<Row> rowList;
        
        public Table() {
            row = 0;
            column = 0;
            lineNo = 0;
            this.data = "";
        }
        public Table(int line, String data) {
            row = 0;
            column = 0;
            rowList = new ArrayList<Row>();
            lineNo = line;
            this.data = data;
        }
        public Table(ArrayList<Row> list, int line, String data) {
            row = 0;
            column = 0;
            rowList = list;
            lineNo = line;
            this.data = data;
        }
        public Table(int r, int c, ArrayList<Row> list, int line, String data) {
            row = r;
            column = c;
            rowList = list;
            lineNo = line;
            this.data = data;
        }
        public void setRow(int r) {
            row = r;
        }
        public void setColumn(int c) {
            column = c;
        }
        public void setRowList(ArrayList<Row>  list) {
            rowList = list;
        }
        public void setLineNo(int line) {
            lineNo = line;
        }
        public void setData(String data) {
            this.data = data;
        }
        public int getRow() {
            return(row);
        }
        public int getColumn() {
            return(column);
        }
        public ArrayList<Row> getRowList() {
            return(rowList);
        }
        public int getLineNo() {
            return(lineNo);
        }
        public String getData() {
            return(data);
        }
        public void refresh() {
            row = rowList.size();
            if(row > 0) {
                column = rowList.get(0).getColumnList().size();
            }
        }
    }
    
    public String getReport() {
        return(logBuffer);
    }
    
    class Row {
        private ArrayList<Column> columnList;
        private int lineNo;
        private String data;
        public Row(String data) {
            columnList = new ArrayList<Column>();
            lineNo = 0;
            this.data = data;
        }
        public Row(int line, String data) {
            columnList = new ArrayList<Column>();
            lineNo = line;
            this.data = data;
        }
        public Row(ArrayList<Column> list, int line, String data) {
            columnList = list;
            lineNo = line;
            this.data = data;
        }
        public void setColumnList(ArrayList<Column> list) {
            columnList = list;
        }
        public void setLineNo(int line) {
            lineNo = line;
        }
        public void setData(String data) {
            this.data = data;
        }
        public ArrayList<Column> getColumnList() {
            return(columnList);
        }
        public int getLineNo() {
            return(lineNo);
        }
        public String getData() {
            return(data);
        }
    }
    
    class Column {
        private int colspan;
        private int rowspan;
        private int lineNo;
        private String data;
        public Column(String data) {
            colspan = 0;
            rowspan = 0;
            lineNo = 0;
            this.data = data;
        }
        public Column(int line, String data) {
            colspan = 0;
            rowspan = 0;
            lineNo = line;
            this.data = data;
        }
        public Column(int c, int r, int line, String data) {
            colspan = c;
            rowspan = r;
            lineNo = line;
            this.data = data;
        }
        public void setColspan(int c) {
            colspan = c;
        }
        public void setRowspan(int r) {
            rowspan = r;
        }
        public void setLineNo(int line) {
            lineNo = line;
        }
        public void setData(String data) {
            this.data = data;
        }
        public int getColspan() {
            return(colspan);
        }
        public int getRowspan() {
            return(rowspan);
        }
        public int getLine() {
            return(lineNo);
        }
        public String getData() {
            return(data);
        }
    }

    public static boolean writeFile(String data, String fileName) {
        boolean flag = false;
        try {
            if(data == null) {
                data = "";
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(data);
            bw.flush();
            bw.close();
        }
        catch(Exception e) {
            flag = false;
            e.printStackTrace();
        }
        finally {
            return(flag);
        }
    }

    public static String readFile(String fileName) {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String temp = "";
            while((temp = br.readLine()) != null) {
                text = text + "\n" + temp;
            }
            br.close();
        }
        catch(Exception e) {
            text = "";
            e.printStackTrace();
        }
        finally {
            return(text);
        }
    }
    
    public static void main(String...args) {
        HTMLTable table = new HTMLTable("e:\\important\\office_work\\dbhteb-87\\epub\\HEBK013-C04_p43-57.html");
        if(table.isDirty()) {
            writeFile(table.getReport(), "e:\\important\\office_work\\dbhteb-87\\epub\\table.log");
        }
    }
}
