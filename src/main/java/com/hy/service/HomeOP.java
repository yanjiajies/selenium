package com.hy.service;

import com.hy.page.HomePage;
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
