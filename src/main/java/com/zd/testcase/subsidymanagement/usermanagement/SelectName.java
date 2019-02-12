package com.zd.testcase.subsidymanagement.usermanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 查询和刷新
 */
public class SelectName {
    public static void selectByName(WebDriver driver,String name)throws InterruptedException{
        driver.findElement(By.id("searchInput")).sendKeys(name);
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("refreshPersonInfo")).click();
    }
}
