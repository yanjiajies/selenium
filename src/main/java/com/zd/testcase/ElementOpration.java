package com.zd.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 多窗口切换方法
 */
public class ElementOpration {
    WebDriver driver;
    @BeforeClass
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.jd.com/");
    }
    @Test
    public void run() throws InterruptedException{
        //点击京东左侧菜单中的 手机
        WebElement phone_link = driver.findElement(By.linkText("手机"));
        phone_link.click();
        Thread.sleep(500);

        // 获取当前页面句柄
        String handle = driver.getWindowHandle();
        // 获取所有页面的句柄，并循环判断不是当前的句柄
        for (String temhandle : driver.getWindowHandles()) {
            if (!temhandle.equals(handle))
                driver.close();
            driver.switchTo().window(temhandle);

        }

        WebElement xiaomi_link = driver.findElement(By.linkText("小米"));
        xiaomi_link.click();
        Thread.sleep(5000);
        driver.findElement(By.id("key")).sendKeys("手机");
        driver.findElement(By.xpath("//*[@id=\"search-2014\"]/div/button/i")).click();

    }
}
