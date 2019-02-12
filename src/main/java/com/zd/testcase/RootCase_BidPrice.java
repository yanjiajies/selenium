package com.zd.testcase;

import com.zd.utils.Common;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


/**
 * 人员信息根用例
 */
public class RootCase_BidPrice{
    private Common common = new Common();
    private WebDriver driver;

    @Parameters({"browser","nodeUrl"})
    @BeforeSuite
    public void beforeMethod(String browser,String nodeUrl) throws InterruptedException{
//        if(browser.equals("Chrome"))driver =utils.openChrome();
//        else if (browser.equals("FireFox"))driver=utils.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
//        driver.get(nodeUrl);
    }
    //@PoiUtile
    public void run() throws InterruptedException{
    }
    //@AfterMethod
    public void afterMethod(){
        //InitialOperation.driver.manage().deleteAllCookies();//每次最后执行清除所有Cookies
        //InitialOperation.quit();//关闭浏览器
    }

}
