package com.hy.service;

import com.hy.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class LoginOP {
    WebDriver driver;
    Logger logger = Logger.getRootLogger();
    LoginPage lg;
    public LoginOP(WebDriver driver) {
        this.driver = driver;
        lg = new LoginPage(driver);
    }

    public void toLogin(String username, String password) {
        lg.login(username, password);
    }
}
