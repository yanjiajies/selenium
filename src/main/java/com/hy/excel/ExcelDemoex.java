package com.hy.excel;

import com.hy.utils.Utils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.List;

public class ExcelDemoex {
    public static void main(String[] args) throws IOException {
        Utils u=new Utils();
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("数据");
        ExcelDemo excelDemo=new ExcelDemo();
        InputStream inputStream = null;
        inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\华云打卡9月.xlsx"));
        List<String> list=excelDemo.read(inputStream);
        for (int i=1;i<=255;i++){
            HSSFRow row=sheet.createRow(5);
//            row.createCell(1).setCellValue(list.get(i));
//            HSSFRow row1=sheet.createRow(i+1);
//            row1.createCell(1).setCellValue(list.get(i));
//            HSSFCell cell=row.createCell(0);
//            cell.setCellValue(u.generate());
//            HSSFCell cell2=row.createCell(1);
//            cell2.setCellValue(u.getTel());
            HSSFCell cell3=row.createCell(i);
            cell3.setCellValue(list.get(i));}
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\test.xls"));
        workbook.write(fos);
        workbook.close();
        fos.close();
//        try {
//            excelup("C:\\Users\\Administrator\\Desktop\\test.xls");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void excelup(@NotNull String filename) throws Exception {
        //判断传入的字符串是否匹配给定的正则
        if(filename.matches("^.+\\.(?i)((xls)|(xlsx))$"));
        FileInputStream fis=new FileInputStream(filename);
        //判断文件是否是xls后缀,然后new对应的工作簿对象
        Workbook workbook=filename.matches("^.+\\.(?i)(xls)$")?new HSSFWorkbook(fis):new XSSFWorkbook(fis);
        //获取工作簿第一个Sheet
        Sheet sheet=workbook.getSheetAt(0);
        for (int i=1;i<100;i++){
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(2);
            System.out.println(cell.getStringCellValue());
        }
    }
}
