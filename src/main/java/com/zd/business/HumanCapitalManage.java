package com.zd.business;

import com.zd.service.HomeOP;
import com.zd.service.LoginOP;
import com.zd.service.SignOutOP;
import com.zd.utils.Common;
import com.zd.utils.TestListener;
import com.zd.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * 人资管理系统用例
 */
@Listeners({TestListener.class})
@ContextConfiguration({"classpath*:/spring-test-config.xml"})
public class HumanCapitalManage extends AbstractTestNGSpringContextTests{
    @Autowired
    Common common;
    @Autowired
    Utils utils;
    WebDriver driver;
    LoginOP loginOP;
    HomeOP homeOP;
    SignOutOP soop;

    @BeforeMethod
    @Parameters({"browser", "nodeUrl"})
    public void beforeMethod(String browser,String nodeUrl) throws InterruptedException, MalformedURLException {
        //WebDriver driver=browser.equals("Chrome")?common.openChrome():common.openFireFox();
        driver=common.getDriver(browser);
        driver.get(nodeUrl);
        loginOP = new LoginOP(driver);
        homeOP=new HomeOP(driver);
        soop=new SignOutOP(driver);
        TestListener.driver=driver;
    }
    @Test(description = "Login",priority = 0)
    public void Login(){
        //多线程运行时，账号不能一样，会被挤掉的
        loginOP.toLogin("chenjiabin1","123456");
        homeOP.menuClick("人资管理系统");
    }
    @AfterClass
    public void end(){}
}
