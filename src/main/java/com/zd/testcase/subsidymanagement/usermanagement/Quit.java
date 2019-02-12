package com.zd.testcase.subsidymanagement.usermanagement;

import com.zd.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * 离职
 */
public class Quit {
    public static void userQuit(WebDriver driver) throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"4476a3db88ca43bc9844e569ead83b7c\"]")).click();
        driver.findElement(By.id("delete")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("leavedate")).sendKeys(Utils.newDate());
        driver.findElement(By.name("leavereason")).sendKeys(Utils.newDate());
        driver.findElement(By.xpath(".//*[@class='layui-layer-btn0']")).click();

    }
}
