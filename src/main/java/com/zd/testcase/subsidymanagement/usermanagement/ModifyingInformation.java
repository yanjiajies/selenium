package com.zd.testcase.subsidymanagement.usermanagement;

import com.zd.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Map;

/**
 * 修改人员信息
 */
public class ModifyingInformation {
    public static void ModifyingUserInformation(WebDriver driver) throws InterruptedException{
        Utils utils = new Utils();
        Map<String, String> dmap =utils.getdate();
        //登陆系统
        driver.findElement(By.xpath(".//*[@id='account']")).sendKeys("jj");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath(".//*[@id='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("人资管理系统")).click();
        //用户id，后期准备直接从数据库中随机获取
        driver.findElement(By.xpath("//*[@id=\"ce8ae743067141c98cf2893643b1002e\"]")).click();
        driver.findElement(By.id("update")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(dmap.get("NAME"));
        driver.findElement(By.xpath("//*[@id=\"personInfoUpdateForm\"]/div[18]/input[2]")).click();
    }
}
