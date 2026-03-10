package com.course.code.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    /**
     * 读取 Excel 数据并返回为 DataProvider 要求的 Object[][]
     * * @param filePath  文件路径
     * @param fileName  文件名
     * @param sheetName 表名
     * @return 二维数组数据
     */
    public static Object[][] getData(String filePath, String fileName, String sheetName) throws IOException {
        File file = new File(filePath + File.separator + fileName);

        // 1. 使用 Try-with-resources 自动关闭 Workbook，防止文件被占用
        // 直接传入 File 对象比 FileInputStream 更节省内存且对格式判断更准
        try (Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("❌ 未找到指定的 Sheet: " + sheetName);
            }

            // 2. DataFormatter 是 POI 提供的利器：它能把数字、日期等自动格式化为字符串
            DataFormatter formatter = new DataFormatter();
            List<Object[]> records = new ArrayList<>();

            // 3. 遍历行（从第 0 行开始，如果要跳过标题行，请把 i 设为 1）
            int rowCount = sheet.getLastRowNum();
            for (int i = 0; i <= rowCount; i++) {
                Row row = sheet.getRow(i);

                // 跳过空行
                if (row == null) continue;

                int colCount = row.getLastCellNum();
                String[] fields = new String[colCount];

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    // 核心优化：使用 formatter 避免 getStringCellValue 遇到数字时报错
                    fields[j] = formatter.formatCellValue(cell);
                }
                records.add(fields);
            }

            // 4. 将 List 转换为 Object[][]
            return records.toArray(new Object[0][]);
        }
    }
}