package com.zd.service;

import com.zd.page.Purchase.PurchaseMainPage;
import org.openqa.selenium.WebDriver;

public class SignOutOP {
    WebDriver driver;
    PurchaseMainPage pmp;
    public SignOutOP(WebDriver driver) {
        this.driver = driver;
        pmp=new PurchaseMainPage(driver);
    }
    public void toSignOut(String name){
        pmp.toSignOut(name);
    }
}
