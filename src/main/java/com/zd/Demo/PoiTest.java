//package com.zd.Demo;
///**
// * 讲excel中的中文转换成拼音，在控制台输出
// */
//
//import java.io.FileInputStream;
//
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//public class PoiTest {
//    @org.testng.annotations.Test//解析excel
//    public void fun1() throws Exception{
//        //获得待解析的Excel文件
//        //得到Excel工作簿对象
//        HSSFWorkbook wb =
//                new HSSFWorkbook(
//                        new FileInputStream("C:\\Users\\Administrator\\Desktop\\新建工作表.xls"));
//        //取出要解析的文件中的表格,0代表取出的是sheet1表格
//        HSSFSheet sheet = wb.getSheetAt(0);
//        //获得表格中一共有多少行
//        int rowcount = sheet.getLastRowNum();
//        System.out.println(rowcount);
//        //遍历并取出表格中的每一行数据
//        for(int i = 1 ; i <= rowcount ; i ++ ){
//            HSSFRow row = sheet.getRow(i);
//            //获得行中每个单元格的值
//            //short cellCount = row.getLastCellNum();
//            //对应的第几个获取，2为第三列
//            String name = row.getCell(2).getStringCellValue();
//            //生成城市全拼
//            String namepy = PoiUtile.hanziToPinyin(name, "");
//            //将字符串拼接为简码
//            System.out.println(namepy);
//        }
//    }
//}
