package poitest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



/**
 *
 * @author Rudra.Tiwari
 */
public class FileIO {
    
    private List<String> columnNames = new ArrayList<String>();
    private List<String> rowValues = null;    
    private Map<Integer, List> excellMap = new HashMap<Integer, List>();
    
    public void readManifestFile(String filePath){
        try {
             
            FileInputStream file = new FileInputStream(new File(filePath));
            Iterator< Row> rowIterator = null;
            if(filePath.toLowerCase().endsWith(".xlsx")){
                //Get the workbook instance for XLSX file
                XSSFWorkbook  workbook = new XSSFWorkbook (file);
                //Get first sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);
                //Iterate through each rows from first sheet
                rowIterator = sheet.iterator();
            } else if(filePath.toLowerCase().endsWith(".xls")){
                //Get the workbook instance for XLS file
                HSSFWorkbook  workbook = new HSSFWorkbook (file);
                //Get first sheet from the workbook
                HSSFSheet sheet = workbook.getSheetAt(0);
                //Iterate through each rows from first sheet
                rowIterator = sheet.iterator();
            }
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if(row.getRowNum() != 0 ) { 
                    rowValues = new ArrayList<String>();
                }
                //For each row, iterate through each columns
                //Iterator< Cell> cellIterator = row.cellIterator();
                //while(cellIterator.hasNext()) {                     
                for(int j = 0; j < 20; j ++) {
                    Cell cell = row.getCell(j); //cellIterator.next();
                    
                    if(row.getRowNum() == 0 ) {
                        if(cell == null) continue; 
                        else columnNames.add(cell.getStringCellValue());                        
                    } else {
                        if(j >= columnNames.size()) continue;
                        if( !columnNames.get(j).isEmpty() && cell == null) rowValues.add("");
                        else{                        
                            switch(cell.getCellType()) {                            
                                case Cell.CELL_TYPE_BOOLEAN:
                                    rowValues.add(cell.getBooleanCellValue() + "");
                                    break;
                                case Cell.CELL_TYPE_NUMERIC:
                                    rowValues.add(cell.getNumericCellValue() + "");
                                    break;
                                case Cell.CELL_TYPE_FORMULA:
                                case Cell.CELL_TYPE_BLANK:
                                case Cell.CELL_TYPE_ERROR:
                                case Cell.CELL_TYPE_STRING:
                                    rowValues.add(cell.getStringCellValue() + "");
                                    break;                            
                            }
                        }
                    }
                }
                //System.out.println("");
                if(row.getRowNum() != 0 ) { 
                    excellMap.put(row.getRowNum(), rowValues);
                }
            }
            file.close();          
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List[] getRecord(String searchColName, String searchColValue) {
        int searchPos = -1;
        List[] searchData = null;
        for(int i = 0; i < columnNames.size(); i++){
            if(columnNames.get(i).toLowerCase().matches(".*"+searchColName.toLowerCase()+".*")){
                searchPos = i;
                break;
            }
        }
        if(searchPos >= 0){
            Set<Entry<Integer, List>> excellEntry = excellMap.entrySet();
            Iterator ite = excellEntry.iterator();
            while(ite.hasNext()){
              Entry<Integer, List> valueRecord =  (Entry) ite.next();
              List<String> rowData = valueRecord.getValue();
              if(rowData.get(searchPos)!= null && rowData.get(searchPos).toLowerCase().equals(searchColValue)){
                  searchData = new List[]{columnNames, rowData};
                  return searchData;
              }
            }
        }
        return searchData;
    }
    public static void main(String args[]){
        new FileIO().readManifestFile("D:\\working\\Project\\Project specs\\Random House\\Updated Requirements Jan 2015\\Manifest\\Aptara_Frontlist2014_r163.xlsx");
    }
    
}

