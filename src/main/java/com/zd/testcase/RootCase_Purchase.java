package com.zd.testcase;

import com.zd.utils.Common;
import com.zd.testcase.subsidymanagement.usermanagement.Entry;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;


/**
 * 采购联系单根用例
 */
public class RootCase_Purchase{
    private Common common = new Common();
    private WebDriver driver;
    //必须install，要不然不会将testNG里的browser赋值进去
    @Parameters({"browser","nodeUrl"})
    @BeforeClass
    public void beforeMethod(String browser,String nodeUrl) throws InterruptedException, MalformedURLException {
//        if(browser.equals("Chrome"))driver =common.openChrome();
//        else if (browser.equals("FireFox"))driver=common.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
        driver.get(nodeUrl);
    }
    @Test
    public void Purchase() throws InterruptedException{

        Entry.userEntry(driver);
        //服务采购联系单
        //fillin.getfillin("//*[@id=\"addService\"]");
        //工程采购联系单
        //fillin.getfillin("//*[@id=\"addEngineering\"]");
        //人力采购联系单

        //修改采购联系单

        //删除采购联系单

        //提交申请后撤回采购联系单

        //导出

        //筛选查询
    }
    @AfterMethod
    public void afterMethod(){
        //InitialOperation.driver.manage().deleteAllCookies();//每次最后执行清除所有Cookies
        //InitialOperation.quit();//关闭浏览器
    }

}
