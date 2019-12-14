package com.hy.page;
/**
 * PageObject思想，对象库层，将可能需要操作的元素定位方式和操作
 * 优点：减少代码冗余，业务和实现分开，降低维护的成本。
 *
 * @CacheLookup：意思是说找到元素之后将缓存元素，重复的使用这些元素，将使测试的速度大大加快。 PageFactor
 * *
 * * PageFactoryDemo 整体思想同于PageObject思想，只是表象显示上不太一样，它通过注解的方式来定位元素对象
 * *
 * * WebDriver 提供了这两种元素对象管理的思想，总的来说没有谁好谁坏，
 * * 看个人习惯，实际工程也可以两者结合使用。就个人而言更习惯PageObject思想，
 * * 但PageFactor也不错，通过注解方式代码看起来更加简洁。
 *
 *  登录页
 *
 *
 *
 *
 *  可以先将page类注入操作层，然后再进行@Findby初始化操作
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //登录账号元素
    @FindBy(id = "account")
    WebElement login_withAccount;
    //登录密码元素
    @FindBy(id = "password")
    WebElement login_withPassword;
    //提交按钮元素
    @FindBy(id = "submit")
    WebElement login_submitBtn;
    //登录错误信息
    @FindBy(id = "error-msg")
    WebElement login_error_msg;
    //账号错误信息
    @FindBy(id = "account-error")
    WebElement login_account_error;
    // 调用父类的构造方法进行初始化（PageFactor使用对象的时候需要先初始化Page类）
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //初始化，并检验页面title与预期title是否一致
    public LoginPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    // 登录方法
    public void login(String username, String password) {
        if (username==""||password==""){ login_submitBtn.click();}
        else{
            login_withAccount.clear();
            login_withPassword.clear();
            login_withAccount.sendKeys(username);
            //可以通过操作js来进行一些js操作
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //修改setAttribute属性
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",login_withAccount);
            login_withPassword.sendKeys(password);
            login_submitBtn.click();}
    }

    public WebElement getLogin_error_msg() {
        return login_error_msg;
    }

    public WebElement getLogin_account_error() {
        return login_account_error;
    }
}