/**
 * 写测试用例时，我们尽可能得不要去写相互依赖的测试用例，
 * Case依赖的另一个Case，那么另一个Case只是你这个Case的前提条件，
 * 所以就算离开另一个Case，你这个Case也应该能独立运行，也就是说Case要保持原子性。
 */
package com.hy.testcase;

import com.hy.utils.Common;
import com.hy.testcase.subsidymanagement.usermanagement.Entry;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * 人员信息根用例
 */
public class RootCase_User {
    private Common common = new Common();
    private WebDriver driver;

    /**
     * @BeforeClass 在调用当前类的第一个测试方法之前运行，注释方法仅运行一次。
     * @AfterClass 在调用当前类的第一个测试方法之后运行，注释方法仅运行一次
     * @BeforeTest（BeforeTest早于AfterClass执行） 注释的方法将在属于<test>标签内的类的所有测试方法运行之前运行。
     * @AfterTest(AfterTest晚于AfterClass执行) 注释的方法将在属于<test>标签内的类的所有测试方法运行之后运行。
     * @BeforeMethod（每一个@Test之前都会执行，执行多次，执行晚于BeforeTest和BeforeClass） 注释方法将在每个测试方法之前运行。
     * @AfterMethod 注释方法将在每个测试方法之后运行。
     */
    @BeforeSuite
    public void beforeMethod() throws InterruptedException {
        //driver = common.openChrome();
    }

    /**
     * 1、timeOut定义一个方法的执行执行，当这个测试方法执行超过指定的值，就会报错
     * 该一般用在某个流程如果多长时间内如果没法执行结束那就得去优化，timeOut（最长测试时间）
     * 2、在不做额外设置的情况下，测试方法的执行顺序是根据方法名的ASCII先后来执行的
     * 3、priority参数可以对执行多个@Test进行执行顺序的排序
     * 4、dependsOnMethod=“依赖方法的方法名"(某些场景需要用到case间互相依赖，使用dependsOnMethods后，执行该用例前会执行
     * 参数配置的方法，比如run方法执行时，会先执行run2)
     */
    @Test(timeOut = 10000, priority = 1, dependsOnMethods = "run2")
    public void run() throws InterruptedException {
        //  driver.navigate().back();浏览器后退操作

        //  driver.navigate().forward();浏览器前进操作

        //  driver.navigate().refresh();页面刷新

        //  Dimension dimension = new Dimension(900, 800);
        //  driver.manage().window().setSize(dimension);设置大小

        //  driver.manage().window().getSize();获取大小

        //  Point point = new Point(500, 600);
        //  driver.manage().window().setPosition(point);//设置窗口位置

        //  driver.manage().window().getPosition();获取窗口位置

        //  driver.manage().window().fullscreen();全屏

        //  driver.getCurrentUrl();获取URL 地址

        //String name=
        Entry.userEntry(driver);
//        Reporter.log("入职测试通过");
//        Quit.userQuit(driver);
//        SelectName.selectByName(driver,name);
//        ModifyingInformation.ModifyingUserInformation(driver);
    }

    @Test
    public void run2() throws InterruptedException {

    }

    @AfterMethod
    public void afterMethod() {
        //InitialOperation.driver.manage().deleteAllCookies();//每次最后执行清除所有Cookies
        //InitialOperation.quit();//关闭浏览器
    }

}
