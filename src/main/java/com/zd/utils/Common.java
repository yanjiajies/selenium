package com.zd.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
                //Headless Chrome无GUI模式（无页面的UI自动化）
                //ChromeOptions chromeOptions = new ChromeOptions();
                //设置chrome为headless模式
                //chromeOptions.addArguments("--headless");
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


    // Web-related click events
    public void click(String selector, String pathValue) {
        switch (selector) {
            case "id":
                driver.findElement(By.id(pathValue)).click();
                System.out.println("This test click event is used-id: " + pathValue);
                break;
            case "name":
                driver.findElement(By.name(pathValue)).click();
                System.out.println("This test click event is used-name: " + pathValue);
                break;
            case "xpath":
                driver.findElement(By.xpath(pathValue)).click();
                System.out.println("This test click event is used-xpath: " + pathValue);
                break;
            case "cssSelector":
                driver.findElement(By.cssSelector(pathValue)).click();
                System.out.println("This test click event is used-cssSelector: " + pathValue);
                break;
            case "className":
                driver.findElement(By.className(pathValue)).click();
                System.out.println("This test click event is used-className: " + pathValue);
                break;
            case "tagName":
                driver.findElement(By.tagName(pathValue)).click();
                System.out.println("This test click event is used-tagName: " + pathValue);
                break;
            case "linkText":
                driver.findElement(By.linkText(pathValue)).click();
                System.out.println("This test click event is used-linkText: " + pathValue);
                break;
            case "partialLinkText":
                driver.findElement(By.partialLinkText(pathValue)).click();
                System.out.println("This test click event is used-partialLinkText: " + pathValue);
                break;
            default:
                System.out.println("Illegal selector: " + selector + " !!!");
                break;
        }
    }

    //Web-related sendKeys events
    public void sendKeys(String selector, String pathValue, String sendkeys) {
        switch (selector) {
            case "id":
                driver.findElement(By.id(pathValue)).clear();
                driver.findElement(By.id(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-id: " + pathValue);
                System.out.println("By id senKeys value: " + sendkeys);
                break;
            case "name":
                driver.findElement(By.name(pathValue)).clear();
                driver.findElement(By.name(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-name: " + pathValue);
                System.out.println("By name senKeys value: " + sendkeys);
                break;
            case "xpath":
                driver.findElement(By.xpath(pathValue)).clear();
                driver.findElement(By.xpath(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-xpath: " + pathValue);
                System.out.println("By xpath senKeys value: " + sendkeys);
                break;
            case "linkText":
                driver.findElement(By.linkText(pathValue)).clear();
                driver.findElement(By.linkText(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-linkText: " + pathValue);
                System.out.println("By linkText senKeys value: " + sendkeys);
                break;
            case "className":
                driver.findElement(By.className(pathValue)).clear();
                driver.findElement(By.className(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-className: " + pathValue);
                System.out.println("By className senKeys value: " + sendkeys);
                break;
            case "tagName":
                driver.findElement(By.tagName(pathValue)).clear();
                driver.findElement(By.tagName(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-tagName: " + pathValue);
                System.out.println("By tagName senKeys value: " + sendkeys);
                break;
            case "partialLinkText":
                driver.findElement(By.partialLinkText(pathValue)).clear();
                driver.findElement(By.partialLinkText(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-partialLinkText: " + pathValue);
                System.out.println("By partialLinkText senKeys value: " + sendkeys);
                break;
            case "cssSelector":
                driver.findElement(By.cssSelector(pathValue)).clear();
                driver.findElement(By.cssSelector(pathValue)).sendKeys(sendkeys);
                System.out.println("This test sendKeys event is used-cssSelector: " + pathValue);
                System.out.println("By cssSelector senKeys value: " + sendkeys);
                break;
            default:
                System.out.println("Illegal selector: " + selector + " !!!");
                break;
        }
    }

    //Web-related select events ,selectByVisibleText() method
    public void select(String selector, String pathValue, String selectValue) {
        switch (selector) {
            case "id":
                WebElement eId = driver.findElement(By.id(pathValue));
                Select selectId = new Select(eId);
                selectId.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-id: " + pathValue);
                break;
            case "name":
                WebElement eName = driver.findElement(By.id(pathValue));
                Select selectName = new Select(eName);
                selectName.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-name: " + pathValue);
                break;
            case "xpath":
                WebElement eXpath = driver.findElement(By.xpath(pathValue));
                Select selectXpath = new Select(eXpath);
                selectXpath.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-xpath: " + pathValue);
                break;
            case "cssSelector":
                WebElement eCss = driver.findElement(By.cssSelector(pathValue));
                Select selectCss = new Select(eCss);
                selectCss.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-cssSelector: " + pathValue);
                break;
            case "className":
                WebElement eClass = driver.findElement(By.className(pathValue));
                Select selectClass = new Select(eClass);
                selectClass.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-className: " + pathValue);
                break;
            case "tagName":
                WebElement eTagName = driver.findElement(By.tagName(pathValue));
                Select selectTagName = new Select(eTagName);
                selectTagName.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-tagName: " + pathValue);
                break;
            case "linkText":
                WebElement eLinkText = driver.findElement(By.linkText(pathValue));
                Select selectLinkText = new Select(eLinkText);
                selectLinkText.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-linkText: " + pathValue);
                break;
            case "partialLinkText":
                WebElement epart = driver.findElement(By.partialLinkText(pathValue));
                Select selectPart = new Select(epart);
                selectPart.selectByVisibleText(selectValue);
                System.out.println("The select value is: " + selectValue);
                System.out.println("This test select event is used-partialLinkText: " + pathValue);
                break;
            default:
                System.out.println("Illegal selector: " + selector + " !!!");
                break;
        }
    }

    // The web-related read-only date is set by id
    public void selectDateById(String idpath, String date) {
        JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById(\"" + idpath + "\");setDate.removeAttribute('readonly');");
        WebElement setDatElement = driver.findElement(By.id(idpath));
        setDatElement.clear();
        setDatElement.sendKeys(date);
    }

    // The web-related read-only date is set by name
    public void selectDateByName(String namepath, String date) {
        JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementByName(\"" + namepath + "\");setDate.removeAttribute('readonly');");
        WebElement setDatElement = driver.findElement(By.name(namepath));
        setDatElement.clear();
        setDatElement.sendKeys(date);
    }

    // The web-related read-only date is set by ClassName
    public void selectDateByClassName(String ClassNamepath, String date) {
        JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementsByClassName(\"" + ClassNamepath + "\");setDate.removeAttribute('readonly');");
        WebElement setDatElement = driver.findElement(By.className(ClassNamepath));
        setDatElement.clear();
        setDatElement.sendKeys(date);
    }

}
