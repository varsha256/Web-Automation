package Executor;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class TestDataReader {
   private static HashMap<String, HashMap<String,String>> testDataMap;


public static void readTestdataSheet() throws IOException {
    testDataMap= new HashMap<>();
    String FilePath= System.getProperty("user.dir")+"/src/test/TestData/TestExecutionSheet.xls";
    loadMap(FilePath);
}
    private static void loadMap(String filePath) throws IOException {
        FileInputStream fs = new FileInputStream(new File (filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sheet=  wb.getSheet("TestData");
        int lastRowNum = sheet.getLastRowNum();
       for(int i=1;i<=lastRowNum;i++){
           int lastCellNum= sheet.getRow(i).getLastCellNum();
           String testcase= sheet.getRow(i).getCell(0).getStringCellValue();
           HashMap<String,String> map= new HashMap<>();
           for(int j=1;j<lastCellNum;j++){
               map.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(i).getStringCellValue());
           }
           testDataMap.put(testcase,map);
       }

wb.close();

    }

    public static HashMap<String, HashMap<String, String>> getTestDataMap() {
        return testDataMap;
    }

    public static String getTestData(String testname, String key){
        return  getTestDataMap().get(testname).get(key);

    }
}
