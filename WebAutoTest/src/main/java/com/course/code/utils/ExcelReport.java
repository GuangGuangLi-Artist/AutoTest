package com.course.code.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelReport {

    // 建议：测试运行时 Excel 文件放在 target 或特定报告目录下，
    // 这里保持你的路径，请确保该目录下确实存在 TestData.xlsx 且包含至少一个 Sheet
    private static final String FILE_PATH = "src/main/resources/TestData.xlsx";

    public static void main(String[] args) {
        // 测试运行
        writeExcel("com.test.cases", "LoginTest", "testLoginFail01", "登录模块测试", "fail", "用户名或密码错误");
        writeExcel("com.test.cases", "LoginTest", "testLoginSuccess", "登录模块测试", "pass", "无");
    }

    /**
     * 将测试结果写入 Excel 报告
     *
     * @param packageName 包名
     * @param className   类名
     * @param methodName  方法名
     * @param remark      备注/用例描述
     * @param result      测试结果 (pass/fail)
     * @param reason      失败原因
     */
    public static void writeExcel(String packageName, String className, String methodName, String remark, String result, String reason) {
        File file = new File(FILE_PATH);

        // 验证文件是否存在
        if (!file.exists()) {
            System.err.println("❌ 错误：找不到模板文件 " + FILE_PATH + "，请先手动创建并添加标题行。");
            return;
        }

        // 1. 先将文件读入内存 (使用 WorkbookFactory 自动识别格式)
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int lastRow = sheet.getLastRowNum();
            // 在最后一行之后创建新行
            Row row = sheet.createRow(lastRow + 1);

            // 获取当前时间
            String currentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

            // 2. 填充数据
            row.createCell(0).setCellValue(currentTime);
            row.createCell(1).setCellValue(packageName);
            row.createCell(2).setCellValue(className);
            row.createCell(3).setCellValue(methodName);
            row.createCell(4).setCellValue(remark);

            Cell resultCell = row.createCell(5);
            resultCell.setCellValue(result.toUpperCase()); // 统一转大写

            row.createCell(6).setCellValue(reason);

            // 3. 处理样式 (如果是失败则标红)
            if ("fail".equalsIgnoreCase(result)) {
                resultCell.setCellStyle(getFailStyle(workbook));
            } else if ("pass".equalsIgnoreCase(result)) {
                resultCell.setCellStyle(getPassStyle(workbook));
            }

            // 4. 修改内存数据后，再统一写回文件
            // 注意：FileOutputStream 必须在 Workbook 操作之后开启，否则会清空原文件
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }

            System.out.println("成功追加测试结果: " + methodName + " [" + result + "]");

        } catch (Exception e) {
            System.err.println("❌ 写入 Excel 失败！");
            System.err.println("常见原因：1. TestData.xlsx 正在被 Excel 软件打开；2. 缺少 poi-ooxml 依赖。");
            e.printStackTrace();
        }
    }

    /**
     * 创建失败样式：红色背景 + 白色字体
     */
    private static CellStyle getFailStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置红色背景
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 设置居中
        style.setAlignment(HorizontalAlignment.CENTER);

        // 设置字体
        Font font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        style.setFont(font);

        return style;
    }

    /**
     * 创建成功样式：绿色字体
     */
    private static CellStyle getPassStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(IndexedColors.GREEN.getIndex());
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
}