package com.zd.service;

import com.zd.page.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeOP {
    WebDriver driver;
    HomePage homePage;
    public HomeOP(WebDriver driver){
        this.driver=driver;
        homePage=new HomePage(driver);
    }
    public  void menuClick(String menuName){
        homePage.homeMenu(menuName);
    }
}
