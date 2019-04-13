package com.zd.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


/**
 * Author: 灵枢
 * Date: 2019/3/28
 * Time: 17:11
 * Description:
 */
@Listeners({TestngListener.class})
public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}