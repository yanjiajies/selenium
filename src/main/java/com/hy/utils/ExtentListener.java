package com.hy.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

//通过监听器实时监控测试用例的执行状态，重写父类的用例各个状态的方法，主要用于用例执行失败的时候执行截图方法
public class ExtentListener extends  TestListenerAdapter{
    public static WebDriver driver;

    //重写父类onTestFailure方法，通过监听器，每次失败的时候调用该方法
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        try {
            takeScreenShot(tr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //重写父类onTestSuccess方法，每次执行成功时调用该方法
    @Override
    public void  onTestSuccess(ITestResult tr){
        super.onTestSuccess(tr);
        Reporter.log("Success,Nice");
    }

    //重写父类onTestStart方法,每次调用测试之前调用。
    @Override
    public void onTestStart(ITestResult tr){
        super.onTestStart(tr);
    }

    //执行失败报错方法，截图保存，并放到测试报告中
    public void takeScreenShot(ITestResult tr) throws IOException{
        SimpleDateFormat smf = new SimpleDateFormat("MMddHHmmss") ;
        String curTime = smf.format(new java.util.Date());
        String fileName = tr.getName()+"_"+curTime+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //把截图拷贝到自定义的目录
        String src="./img/"+fileName;
        FileUtils.copyFile(srcFile, new File(src));
        //将图片加入测试报告中
        Reporter.log("<img src=../img/" + fileName + " height=\"500\" width=\"1000\" />", true);
    }
}