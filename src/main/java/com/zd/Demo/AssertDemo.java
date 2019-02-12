package com.zd.Demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.DriverFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class AssertDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.baidu.com");
        assertEqual(driver.getTitle(),"百度一下，你就知道1",driver);
        System.out.println(driver.getTitle());
    }
    //封装断言方法assertEquals，当断言失败，对错误进行捕获，并截取当前页面信息，保存到自定义目录与测试报告中
    public static void assertEqual(Object object, Object object2,WebDriver driver) throws IOException {
        try{
            Assert.assertEquals(object,object2,"不相同");
        }catch (Error error){
            SimpleDateFormat smf = new SimpleDateFormat("MMddHHmmss") ;
            String curTime = smf.format(new java.util.Date());
            String fileName = "_"+curTime+".png";
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //把截图拷贝到自定义的目录
            String src="./img/"+fileName;
            FileUtils.copyFile(srcFile, new File(src));
            //将图片加入测试报告中
            Reporter.log("<img src=../img/" + fileName + " height=\"500\" width=\"1000\" />", true);
        }
    }
}
