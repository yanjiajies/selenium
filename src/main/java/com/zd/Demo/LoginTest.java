package com.zd.Demo;

import com.zd.service.LoginOP;
import com.zd.utils.Common;
import com.zd.utils.ListenerVerify;
import com.zd.utils.Verify;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.net.MalformedURLException;
@ContextConfiguration({"classpath*:/spring-test-config.xml"})
@Listeners({ListenerVerify.class})
public class LoginTest extends AbstractTestNGSpringContextTests {
    @Autowired
    Common common;
    WebDriver driver;

    //必须install，要不然不会将testNG里的browser赋值进去
    @Parameters({"browser", "nodeUrl"})
    @BeforeClass
    public void beforeMethod(String browser, String nodeUrl) throws InterruptedException, MalformedURLException {
//        if (browser.equals("Chrome")) driver = common.openChrome();
//        else if (browser.equals("FireFox")) driver = common.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
        driver.get(nodeUrl);
    }
    //登录成功
    @Test(priority = 3)
    public void successLogin() {
        LoginOP loginOP =new LoginOP(driver);
        loginOP.toLogin("jj","123456");
        Verify.assertEquals(driver.getTitle(),"首页","登录校验失败");
    }
    //登录失败，密码错误
    @Test(priority = 2)
    public void failLogin_pwd(){
        LoginOP loginOP =new LoginOP(driver);
        loginOP.toLogin("jj","654321");
    }
    //登录失败，未输入账号密码
    @Test(priority = 1)
    public void failLogin_null(){
        LoginOP loginOP =new LoginOP(driver);
        loginOP.toLogin("","");
    }
}
