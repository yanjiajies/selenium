package com.zd.testcase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class wytest {
    WebDriver driver;
    long time = System.currentTimeMillis();

    @BeforeClass
    public void testChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void registerTest() {
        driver.get("http://mail.163.com/");
        driver.switchTo().frame("x-URS-iframe");
        String handle1=driver.getWindowHandle();
        driver.findElement(By.id("changepage")).click();
        System.out.println(handle1);
        for (String handles: driver.getWindowHandles()
             ) {
            if (handle1.equals(handles)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        driver.findElement(By.xpath(".//*[@id='tabsUl']/li[1]/a")).click();
        driver.findElement(By.id("nameIpt")).sendKeys("M" + String.valueOf(time));
        driver.findElement(By.id("mainPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("password");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time / 100));
        driver.findElement(By.id("vcodeIpt")).sendKeys("966va");
        driver.findElement(By.id("sendMainAcodeBtn")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainRegA")).click();
        String msgText = driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        System.out.println(msgText);
        Assert.assertEquals(msgText, "  请填写图片中的验证码");

    }

    @AfterClass
    public void closed() {
        //driver.quit();
    }
}
