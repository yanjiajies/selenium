package com.hy.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ExcelDemo {
    public static List<String> read(InputStream inputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        List<String> list = new ArrayList<String>();
        BigDecimal bigDecimal;
        BigDecimal bigDecimal1;
        /*
          获取单个sheet 页，单个单元格的数据。
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row0 = sheet.getRow(0);
        XSSFCell cell = row0.getCell(0);
        System.out.println(cell.getRichStringCellValue().getString());*/
        //获取excel表格中的所有数据
        //workbook.getNumberOfSheets(); 获取sheet 页个数。
        int sheetNum = workbook.getNumberOfSheets();
        //System.out.println(sheetNum);
        //for循环遍历单元格内容
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            //根据下标获取sheet
            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            //workbook.getSheetName(sheetIndex) 根据下标获取sheet 名称
            //System.out.println("sheet序号："+sheetIndex+"，sheet名称："+workbook.getSheetName(sheetIndex));
            //循环该sheet页中的有数据的每一行
            //打印行号，某人起始是0  System.out.println(sheet.getLastRowNum());
            //打印行数
            //System.out.println(sheet.getPhysicalNumberOfRows());
            //遍历每行内容从行号为0开始
            for (int rowIndex = 0; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                //System.out.println(rowIndex);打印遍历行号
                //根据行号，遍历该行
                XSSFRow row = sheet.getRow(rowIndex);
                //如果该行为空，则结束本次循环
                if (row == null) {
                    continue;
                }
                //num 为该行 有效单元格个数，取 num的话，取值会不全。   lastnum为 有效单元格最后各个单元格的列号，这样可以遍历取到该行所有的单元格
                //System.out.println("num  " + row.getPhysicalNumberOfCells());
                //System.out.println("lastnum " + row.getLastCellNum());
                for(int cellnum = 0;cellnum<row.getLastCellNum(); cellnum++){
                    XSSFCell cell = row.getCell(cellnum);
                    if (cell != null) {

                        cell.setCellType(CellType.STRING);
                        //cell.setCellType(Cell.CELL_TYPE_STRING); 是为了修改数据类型，因为我的单元格中有数字类型。如果不这样写会出现下面的错误。
                /*        Exception in thread "main" java.lang.IllegalStateException:
                         Cannot get a text value from a numeric cell
                        at org.apache.poi.xssf.usermodel.XSSFCell.typeMismatch(XSSFCell.java:991)
                        at org.apache.poi.xssf.usermodel.XSSFCell.getRichStringCellValue(XSSFCell.java:399)
                        at net.oschina.excel.ReadExcel.read(ReadExcel.java:55)
                        at net.oschina.excel.ReadExcel.main(ReadExcel.java:68)

                        POI操作Excel时数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串并写入数据库时，
                        就会出现Cannot get a text value from a numeric cell的异常错误，解决办法就是先设置Cell的类型，
                        然后就可以把纯数字作为String类型读进来了：

                        */
                        //打印出读出的数据。
                        //System.out.println("第"+rowIndex+"行      第"+cellnum+"列    内容为："+cell.getRichStringCellValue().getString());
                        //System.out.println(cell.getRichStringCellValue().getString());
                        String str=cell.getRichStringCellValue().getString();
                        //System.out.println(str.split("\r")[0]);
                        try {
                            bigDecimal=new BigDecimal(str.split("\\/")[0]);
                            bigDecimal1=new BigDecimal(str.split("\\/")[1]);
                            list.add(bigDecimal1.subtract(bigDecimal).toString());
                        }catch (Exception e){
                            list.add("");
                        }
                    }
                }
            }
        }return list;
    }

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            //获取文件标识符。
            inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\华云打卡9月.xlsx"));
            //System.out.println(inputStream);
            read(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}