package com.hy.business;

import com.hy.service.HomeOP;
import com.hy.service.LoginOP;
import com.hy.service.PurchaseContactPO;
import com.hy.service.SignOutOP;
import com.hy.utils.*;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 采购管理系统用例
 */
@Listeners({AllureListener.class})
@ContextConfiguration({"classpath*:/spring-test-config.xml"})
public class PurchaseManagement extends AbstractTestNGSpringContextTests {
    @Autowired
    Common common;
    @Autowired
    Utils utils;
    private WebDriver driver;
    LoginOP loginOP;
    HomeOP homeOP;
    PurchaseContactPO pcpo;
    SignOutOP soop;
    String purchaseType = "服务";

    @Parameters({"browser", "nodeUrl"})
    @BeforeClass
    public void beforeMethod(String browser, String nodeUrl) throws InterruptedException {
//        if (browser.equals("Chrome")) driver = common.openChrome();
//        else if (browser.equals("FireFox")) driver = common.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
        driver = common.getDriver(browser);
        driver.get(nodeUrl);
        loginOP = new LoginOP(driver);
        homeOP = new HomeOP(driver);
        pcpo = new PurchaseContactPO(driver);
        soop = new SignOutOP(driver);
        AllureListener.driver = driver;
    }

    /**
     * 登录
     */
    @Test(description = "登录", priority = 0)
    @Link(name = "禅道", type = "mylink")//通过配置文件的url,可以配置指定的地址
    @Issue("DL-0001")// 通过配置文件的url,可以配置指定的地址
    @TestCaseId("AG-450234")//通过配置文件的url,可以配置指定的地址
    @Description("验证系统是否能正常登录")//测试用例的描述
    @Severity(SeverityLevel.BLOCKER)//优先级
    @Step("Login")
    public void Login() {
        loginOP.toLogin("ADMIN4", "aa123456");
        //Assert.assertEquals("111","222");
        FileInputStream fis;
        AllureUploadFile fileDemo = new AllureUploadFile();
        try {
            File file = new File("F:\\seleniumHuayun\\img\\_0211152923.png");
            fis = new FileInputStream(file);
            byte[] read = new byte[1024 * 1024];
            fis.read(read);
            fileDemo.saveScreenshot(read);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Verify.assertEquals(driver.getTitle(), "首页", "登录校验失败");
        //homeOP.menuClick("采购管理系统");
        homeOP.menuClick("采购管理系统");
    }

    //采购类型数据驱动
    @DataProvider(name = "purchaseType")
    public Object[][] purchaseType() {
        return new Object[][]{
                {"service", "服务"},
                {"engineer", "工程"},
                {"material", "物资"},
                {"human", "人力"}
        };
    }
    //框架类型数据驱动
    @DataProvider(name = "frameTypes")
    public Object[][] frameTypes() {
        return new Object[][]{
                {"nonFramed", "非框架"},
                {"generalFramework", "通用框架"},
                {"dedicatedFramework", "专用框架"}
        };
    }

    //使用POI读取excel数据，数据驱动‘
    @DataProvider(name = "contactData")
    public Object[][] contactData() {
        return utils.testData("C:\\Users\\Administrator\\Desktop\\11.xls");

    }

    /**
     * 进入采购管理系统->保存采购联系单草稿->提交->刷新
     * 数据驱动，执行新增人力,物资,服务,工程四个联系单
     */
    @Test(description = "填写新增联系单(数据驱动三种类型)", priority = 1, dataProvider = "frameTypes")
    public void contactList(String name, String type) throws IOException, AWTException, InterruptedException {
        //创建截图目录
        //FileHandler.createDir(new File("/screenshot"));
        //浏览器截图
        //File srcFile=
        //        ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(srcFile,new File("/screenshot/error.png"));
        //截屏方法二  截屏整个浏览器
        //BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        //ImageIO.write(image,"png",new File("/screenshot/screen_robot.png"));
        //homeOP.menuClick("采购管理系统");
        pcpo.itemSelection(name);
        Thread.sleep(500);
        driver.navigate().refresh();
    }

    /**
     * 审批流程->预审->二级审批->一级审批
     * 执行四次,将上一个Test中新增的四个联系单全部审批通过
     */
    @Test(description = "采购审批", priority = 2)
    public void examine() {
        pcpo.selectionMenu("审批列表");
        pcpo.toExamination();
        driver.navigate().refresh();
    }

    /**
     * 采购评审审批
     */
    @Test(description = "评审", priority = 4)
    public void reviewApproval() {
        pcpo.selectionMenu("采购评审");
        pcpo.reviewAdopt("会议1", "水澄", "2019-11-11");
    }

    /**
     * 填写采购申请编号->采购需求执行（中标会签编号）->新增采购合同
     */
    @Test(description = "采购流程", priority = 3)
    public void purchase() throws InterruptedException {
        soop.toSignOut("一级审批退出");
        Login();
        homeOP.menuClick("采购管理系统");
        pcpo.fillPurNumber(utils.getUUID(), "陈乐");
        //pcpo.selectionMenu("采购需求");
        //pcpo.implementationReq("中标会签编号",utils.getUUID());
        pcpo.selectionMenu("采购合同");
        pcpo.contract();
        pcpo.addPurchaseContract(utils.getUUID(), utils.getUUID(), "略略略", "10000",
                "略略略", "2018-09-10", "2018-09-10", "2018-09-10",
                "测试", "略略略", utils.getTel(), "10000",
                "自动化", "测试", "10000", utils.getUUID(), purchaseType);
        Thread.sleep(500);
    }

    /**
     * 新增来票
     */
    @Test(description = "新增来票", priority = 4)
    public void invoice() {
        pcpo.selectionMenu("来票记录");
        pcpo.addInvoice(utils.getUUID(), "10000", "2018-09-10");
    }

    /**
     * 支付审批单
     */
    @Test(description = "填写支付审批单", priority = 5)
    public void addPaymentApproval() {
        pcpo.selectionMenu("支付审批单");
        pcpo.addPaymentApproval(purchaseType, "10000", "自动化", "自动化", "自动化", "略略略");
        soop.toSignOut("支付审批单退出");
        soop.toSignOut("预审退出");
        soop.toSignOut("二级审批退出");
    }

    /**
     * 确认付款
     */
    @Test(description = "确认付款", priority = 7)
    public void confirmPayment() {
        //Login();
        pcpo.selectionMenu("付款记录");
        pcpo.payment("2019111111");
    }



    //只执行一次，在最后
    @AfterClass
    public void end() {

    }

}
