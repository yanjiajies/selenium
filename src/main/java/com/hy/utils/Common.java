package com.hy.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class Common {
    /*使用ThreadLocal来保证程序的线程安全，以免TestNG在进行多线程并发测试时发生线程安全问题*/
    public static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>();
    private static WebDriver driver;
    //启动谷歌浏览器
    public WebDriver getDriver(String browserType) throws InterruptedException {
        WebDriver driver=threadDriver.get();
        if(driver==null){
            if(browserType.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                //Headless Chrome无GUI模式（无页面的UI自动化）
                //ChromeOptions chromeOptions = new ChromeOptions();
                //设置chrome为headless模式
                //chromeOptions.addArguments("headless");
                //设置浏览器窗口打开大小  （非必须）
                //chromeOptions.addArguments("--window-size=1920,1080");
                threadDriver.set(driver);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                Thread.sleep(1000);
            }
        }
        return driver;
    }
    //启动火狐浏览器,启动不了
//    public WebDriver openFireFox() throws  InterruptedException{
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        return driver;
//    }
    //使用Grid的方法启动本地的火狐
    public WebDriver openFireFox() throws InterruptedException, MalformedURLException {
        DesiredCapabilities firefoxDC = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.56.1:5555/wd/hub"), firefoxDC);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        return driver;
    }
    //刷新
    public static void refresh() {
        driver.navigate().refresh();
    }
    //退出
    public static void quit() {
        driver.quit();
    }




}
