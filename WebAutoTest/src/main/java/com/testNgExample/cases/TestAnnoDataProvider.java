package com.testNgExample.cases;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 数据驱动 (Data-Driven Testing)
 * dataProvider 指定提供数据的方法名。该方法必须返回 Object[][] 或 Iterator<Object[]>。
 * dataProviderClass 指定 DataProvider 方法所在的类。如果不填，默认在当前类查找。
 */

public class TestAnnoDataProvider {

    private static Logger logger = LoggerFactory.getLogger(TestAnnoDataProvider.class);

    @Test(dataProvider = "dataLogin")
    public void testDataProvider(String userName,String passWord,String expectedResult) {

        logger.info("testDataProvider");
        System.out.println("用户名:" + userName + " 密码 :" + passWord + " 预期结果:" + expectedResult) ;
        System.out.println("当前线程名:" + Thread.currentThread().getName() + " 当前线程ID:[" + Thread.currentThread().getId() + "]");

    }


    @DataProvider(name = "dataLogin")
    public Object[][] dataPrivoderUse(){
        //读取excel文件内容到dataprivoder
        String filePath = "src/test/resources/dataProviderUse.xlsx";
        Object[][] res = getTestData(filePath, "用户信息");
        return res;

    }


    public static Object[][] getTestData(String filePath, String sheetName){
        Object[][] data = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();// 获取总行数（不含标题行
            int colCount = sheet.getRow(0).getLastCellNum();// 获取总列数

            data = new Object[rowCount][colCount];

            // 从第1行开始遍历（跳过第0行标题）
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i+ 1);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    //将单元格内容统一转为 String 处理
                    data[i][j] = new DataFormatter().formatCellValue(cell);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;

    }

}
