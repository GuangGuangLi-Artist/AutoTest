package com.course.code.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static Object[][] getData(String filePath,String fileName,String sheetName) throws IOException{

        File file = new File(filePath + "\\" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(inputStream);
        }else if(fileExtensionName.equals(".xls")){
            workbook = new HSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<>();
        for (int i = 0; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            String fileds[] = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                fileds[j] = row.getCell(j).getStringCellValue();
            }
            records.add(fileds);
        }
        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }


        return results;
    }

}
