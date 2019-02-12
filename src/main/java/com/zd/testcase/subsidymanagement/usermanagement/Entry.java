package com.zd.testcase.subsidymanagement.usermanagement;

import com.zd.utils.Common;
import com.zd.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Map;

/**
 * 入职
 */
public class Entry {
    public static String  userEntry(WebDriver driver) throws InterruptedException {
        Utils utils = new Utils();
        Map<String, String> dmap = utils.getdate();
        String name= dmap.get("NAME");
        Common common = new Common();
        //登陆系统
        driver.findElement(By.xpath(".//*[@id='account']")).sendKeys("jj");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath(".//*[@id='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("人资管理系统")).click();
        driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div[1]/div[1]/input")).sendKeys(dmap.get("WORD_NUMBER"));
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("account")).sendKeys(dmap.get("ACCOUNT_NUMBER"));
        driver.findElement(By.xpath(".//*[@id='idCardNo']")).sendKeys(dmap.get("IDENTIFICATION_CARD"));
        driver.findElement(By.name("officephone")).sendKeys(dmap.get("TEL"));
        driver.findElement(By.name("phonenum")).sendKeys(dmap.get("TEL"));
        driver.findElement(By.xpath(".//*[@id='deptName']")).click();

        WebElement bm1=driver.findElement(By.id("orgTree_1_span"));
        Actions actions=new Actions(driver);
        actions.doubleClick(bm1).perform();
        WebElement bm2=driver.findElement(By.id("orgTree_2_span"));
        actions.doubleClick(bm2).perform();
        driver.findElement(By.id("orgTree_21_span")).click();
        //driver.findElement(By.xpath(".//*[@id='orgTree_1_span']")).click();
        driver.findElement(By.xpath(".//*[@class='layui-layer-btn0']")).click();


        Thread.sleep(5000);
//        utils.rl(".//*[@id='worktype']");
//        utils.rl("//*[@id=\"personInfoAddForm\"]/div[6]/div[1]/select");
//        utils.rl("//*[@id=\"corporate\"]");
//        driver.findElement(By.name("entrytime")).sendKeys("1");
//        utils.rl("//*[@id=\"personInfoAddForm\"]/div[8]/div[1]/select");
        WebElement webElement = driver.findElement(By.xpath(".//*[@id='worktype']"));
        driver.findElement(By.name("remarks")).sendKeys("略略略");
        driver.findElement(By.name("QQnum")).sendKeys(dmap.get("QQNUM"));
        driver.findElement(By.name("weixinnum")).sendKeys(dmap.get("TEL"));
        driver.findElement(By.name("RTX")).sendKeys(dmap.get("TEL"));
        driver.findElement(By.name("email")).sendKeys(utils.getEmail(3, 9));
//        utils.rl("//*[@id=\"personInfoAddForm\"]/div[11]/div[1]/select");
//        utils.rl("//*[@id=\"personInfoAddForm\"]/div[11]/div[2]/select");
//        utils.rl("//*[@id=\"personInfoAddForm\"]/div[12]/div[1]/select");
        driver.findElement(By.name("graduatetime")).sendKeys("2018-08-24");
        driver.findElement(By.name("workingtime")).sendKeys("2018-08-24");
        driver.findElement(By.name("protime")).sendKeys("2018-08-24");
        driver.findElement(By.name("zhiyetitletime")).sendKeys("2018-08-24");
        driver.findElement(By.name("graduateschool")).sendKeys("北京大学");
        driver.findElement(By.name("majorname")).sendKeys("计算机");
        driver.findElement(By.name("zhuanyeskilltitle")).sendKeys("专业证书");
        driver.findElement(By.name("zhiyeskilltitle")).sendKeys("职业证书");
        driver.findElement(By.xpath(".//*[@class='layui-layer-btn0 purchase-savebtn']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("人资管理系统"));
        Reporter.log("人资管理系统");
        Thread.sleep(2000);
        return name;
    }
}