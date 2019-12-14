package com.hy.Demo;

import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Demo {


//    //监听方法
//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver;
//        //设置driver路径
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
//        //实例化driver
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        //实例化EventFiringWebDriver对象，传入driver
//        EventFiringWebDriver eventFiringWebDriver =new EventFiringWebDriver(driver);
//        //实例化自定义侦听对象
//        MyEventListener myEventListener=new MyEventListener();
//        //将自定义侦听对象注册到EventFiringWebDriver对象中
//        eventFiringWebDriver.register(myEventListener);
//        //使用EventFiringWebDriver对象打开网页（一定要加http）
//        eventFiringWebDriver.get("http:www.baidu.com");
//        eventFiringWebDriver.get("http:www.qq.com");
//        //后退
//        eventFiringWebDriver.navigate().back();
//        eventFiringWebDriver.findElement(By.xpath("//*[@id=\"su\"]"));
//        eventFiringWebDriver.quit();
//    }


    //HTML5 Video
//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.get("http://videojs.com/");
//        WebElement video=driver.findElement(By.xpath("//*[@id=\"txplayer_69d82a42092d52d27aba852efa1bd0bc\"]/txpdiv[3]/video[1]"));
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        String source=(String) jse.executeScript("return arguments[0].currentSrc",video);
//        System.out.println(source);
//        Assert.assertEquals("https://vjs.zencdn.net/v/oceans.mp4",source);
//        jse.executeScript("arguments[0].play()",video);
//        WebElement account=driver.findElement(By.id("account"));
//        System.out.println(jse.executeScript("return arguments[0].placeholder",account).toString());
//        jse.executeScript("arguments[0].pause",video);
//}


    //Canvas
//        public static void main(String[] args) throws InterruptedException {
//            WebDriver driver;
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            Thread.sleep(2000);
//            driver.get("http://literallycanvas.com/");
//            WebElement canvas = driver.findElement(By.xpath("//*[@id=\"literally-canvas\"]/div[1]/div[1]/canvas[2]"));
//            Actions actions =new Actions(driver);
//            actions.clickAndHold(canvas).moveByOffset(10,0).perform();
//}
//    public static void main(String[] args) throws InterruptedException, AWTException {
//        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        driver.get("https://www.baidu.com");
//        // 指定图片的路径，这里我放桌面上
//        StringSelection sel = new StringSelection("C:\\Users\\Administrator\\Desktop\\selenium.jpg");
//
//        // 把图片文件路径复制到剪贴板
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
//        System.out.println("selection" +sel);
//
//        // 点击照相机这个按钮
//        driver.findElement(By.xpath("//*/span[@class='soutu-btn']")).click();
//
//        // 点击本地上传图片
//        driver.findElement(By.xpath("//*/input[@class='upload-pic']")).click();
//
//        // 新建一个Robot类的对象
//        Robot robot = new Robot();
//        Thread.sleep(1000);
//        Color color=robot.getPixelColor(500,300);
//        System.out.println(color.toString());
//        // 按下回车
//        //robot.keyPress(KeyEvent.VK_ENTER);
//
//        // 释放回车
//        //robot.keyRelease(KeyEvent.VK_ENTER);
//
//        // 按下 CTRL+V
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//
//        // 释放 CTRL+V
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//        Thread.sleep(1000);
//
//        // 点击回车 Enter
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }
    public static void main(String[] args) {
        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        // Navigate to Google
        driver.get("http://test.sunxung.cn:3083/basicComponents/login.html");

        // Locate the searchbox using its name
        WebElement element = driver.findElement(By.name("account"));

        // Enter a search query
        element.sendKeys("chenjiabin1");

        // Submit the query. Webdriver searches for the form using the text input element automatically
        // No need to locate/find the submit button
        WebElement element1 = driver.findElement(By.name("password"));
        element1.sendKeys("123456");
        driver.findElement(By.id("submit")).click();

        // This code will print the page title
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
