package com.hy.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * 操作excel文件
 */
public class Demo {
//    public static void main(String[] args) throws IOException, ParseException {
//        String filePath ="C:\\Users\\Administrator\\Desktop\\11.xls"; //文件路径
//        HSSFWorkbook workbook =new HSSFWorkbook();//新建一个excel文件对象
//        HSSFSheet sheet =workbook.createSheet("TEST");//workbook.createSheet创建工作表(Sheet)，方法传入表单名称
//        HSSFRow row =sheet.createRow(0);//创建行，从0开始
//        HSSFCell cell =row.createCell(0);//创建行的单元格，从0开始
//        cell.setCellValue("张三");
//        row.createCell(1).setCellValue(false);
//        FileOutputStream fos= new FileOutputStream(filePath);//用流进行写出
//        workbook.write(fos);//保存Excel文件
//        fos.close();//关闭文件流
//        System.out.println("OK");
//    }

    public static void main(String[] args) throws IOException {
        Workbook workbook =null;
        File file = new File("C:\\Users\\Administrator\\Desktop\\11.xls");
        InputStream is=new FileInputStream(file);
        workbook=new HSSFWorkbook(is);
        Sheet sheet = workbook.getSheet("Sheet1");
        int rowTotalNum=sheet.getLastRowNum()+1;
        //使用.getPhysicalNumberOfCells()返回不包含空列的列数，或使用getLastCellNum()返回包含空列的列数。
        int columns = sheet.getRow(0).getLastCellNum();
        System.out.println("rowTotalNum="+rowTotalNum+"columns="+columns);
    }
}
