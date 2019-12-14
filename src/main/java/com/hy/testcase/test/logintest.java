package com.hy.testcase.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class logintest {
    WebDriver driver;
    @BeforeClass
    public void testCooking(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void runCooking() throws InterruptedException{
        driver.get("http://test.sunxung.cn:3083/basicComponents/index.html");
        driver.findElement(By.xpath(".//*[@id='account']")).sendKeys("jj");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath(".//*[@id='submit']")).click();
        Thread.sleep(5000);
        Cookie cookie = new Cookie("test_sid","f4ca49bd11fe4dc9b7d2af6168766e33");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
    }
}
