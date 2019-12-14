package com.hy.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * 拖动滑动校验码
 */
public class YZMDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.qichacha.com/user_login");
        //driver.findElement(By.id("verifyLogin")).click();
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",driver.findElement(By.id("verifyLogin")));

        Thread.sleep(2000);
        WebElement dragger =driver.findElement(By.cssSelector("#nc_1_n1z"));
        Actions actions=new Actions(driver);
        //左键按下不释放 clickAndHold()、clickAndHold(WebElement onElement)
        actions.clickAndHold(dragger).build().perform();
        for (int i=0;i<20;i++){
            //.移动/悬浮 moveByOffset(int xOffset, int yOffset)、moveToElement(WebElement toElement)、moveToElement(WebElement toElement, int xOffset, int yOffset)
            //以当前鼠标位置为中心，将鼠标移到(xOffset, yOffset) 坐标轴
            actions.moveByOffset(20,0).perform();
        }
    }
}
