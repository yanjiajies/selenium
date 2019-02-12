/**
 * 截取验证码的图片方法
 */
package com.zd.testcase.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IdentifyCodeUtile {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.setProperty("webdrver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        //open the browser
        driver.get("http://weixin.sogou.com/antispider/?from=%2fweixin%3Ftype%3d2%26query%3dz+%26ie%3dutf8%26s_from%3dinput%26_sug_%3dy%26_sug_type_%3d");
       WebElement element = driver.findElement(By.xpath("//*[@id=\"seccodeImage\"]"));
        getImgFileByScreenshot(element,driver);
    }

    public static File getImgFileByScreenshot(WebElement element, WebDriver driver){
        if (element == null) throw new NullPointerException("图片元素失败");
        WrapsDriver wrapsDriver = (WrapsDriver) element;    //截取整个页面
        File scrFile = ((TakesScreenshot)wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        try {
            BufferedImage img = ImageIO.read(scrFile);
            int screenshotWidth = img.getWidth();
            Dimension dimension = driver.manage().window().getSize();
            //获取浏览器尺寸与截图的尺寸
            double scale = (double) dimension.getWidth() / screenshotWidth;
            int eleWidth = element.getSize().getWidth();
            int eleHeight = element.getSize().getHeight();
            Point point = element.getLocation();
            int subImgX = (int)(point.getX() / scale); //获得元素的坐标
            int subImgY = (int)(point.getY() / scale);
            int subImgWight = (int)(eleWidth / scale); //获取元素的宽高
            int subImgHeight = (int)(eleHeight / scale);
            //精准的截取元素图片，
            BufferedImage dest = img.getSubimage(subImgX, subImgY, subImgWight, subImgHeight);
            ImageIO.write(dest, "png", scrFile);
            File screenshotLocation= new File("./Test1/test.png");
            FileUtils.copyFile(scrFile, screenshotLocation);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrFile;
    }
}
