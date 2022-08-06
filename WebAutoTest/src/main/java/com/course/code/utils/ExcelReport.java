package com.course.code.utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class ExcelReport {

    public static int rowNumber = 1;

    public static void main(String[] args) {
    writeExcel("test","Login","testLoginFail01","注释","pass","");
    }

    public static void writeExcel(String packabeName,String className,String methodName,String remark,String result,String resaon){



        try {
            String path = "src/java/java/com/course/code/datas/TestData.xlsx";
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
            XSSFSheet sheet = wb.getSheetAt(0);
            //获得excel行数
            int rowNums = sheet.getLastRowNum();
            System.out.println("多少行：" + rowNums);
            //往sheet中追加一行数据
            int rowCurrentNumber = rowNums + 1;
            sheet.createRow(rowCurrentNumber);
            XSSFRow row = sheet.getRow(rowCurrentNumber);

            CellStyle cellStyle2 = wb.createCellStyle();
            cellStyle2.setFillForegroundColor(IndexedColors.RED.getIndex());
            cellStyle2.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyle2.setBorderBottom(CellStyle.BORDER_THIN);

            if(row != null){
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String currentTime = dateFormat.format(now);

                //创建单元格并赋值
                row.createCell(0).setCellValue(currentTime);
                row.createCell(1).setCellValue(packabeName);
                row.createCell(2).setCellValue(className);
                row.createCell(3).setCellValue(methodName);
                row.createCell(4).setCellValue(remark);
                row.createCell(5).setCellValue(result);


                if(result.equals("fail")){
                    row.getCell(5).setCellStyle(cellStyle2);
                }
                row.createCell(6).setCellValue(resaon);


            }else {
                System.out.println("行为空");
            }
            FileOutputStream outputStream = new FileOutputStream(path);
            wb.write(outputStream);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
