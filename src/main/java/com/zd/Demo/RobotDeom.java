package com.zd.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class RobotDeom {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(1535,863);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //robot.mouseMove(500,500);
//        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
////        driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.get("https://blog.csdn.net/scholar_man/article/details/48035251");
//        //将鼠标移动到对应x,y坐标上
//        robot.mouseMove(500,500);
//        //滚动鼠标滑轮
//        robot.mouseWheel(40);
//        System.out.println(robot.getPixelColor(500,500));
    }
}
