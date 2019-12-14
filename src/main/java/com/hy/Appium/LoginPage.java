package com.hy.Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.temporal.ChronoUnit;

public class LoginPage {
    AndroidDriver androidDriver;
   @AndroidFindBy(id = "com.sx.huayun:id/username_edit")
   @WithTimeout(time = 1000, chronoUnit = ChronoUnit.SECONDS)
    AndroidElement username;
   @AndroidFindBy(id = "com.sx.huayun:id/password_edit")
   AndroidElement password;
   @AndroidFindBy(id = "com.sx.huayun:id/btn_Submit")
   AndroidElement smb;
    public LoginPage(AndroidDriver androidDriver){
        this.androidDriver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    public void login(String usern,String passw){
        username.sendKeys(usern);
        password.sendKeys(passw);
        smb.click();
    }
    public void assertContain(String text) throws InterruptedException {
        String pageSource = this.androidDriver.getPageSource();
        System.out.println(pageSource);
        if (pageSource.contains(text)){
            Assert.assertTrue(true);
        }else {
            Assert.assertFalse(true);
        }
    }
}
