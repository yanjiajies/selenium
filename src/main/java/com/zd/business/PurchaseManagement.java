package com.zd.business;

import com.zd.service.HomeOP;
import com.zd.service.LoginOP;
import com.zd.service.PurchaseContactPO;
import com.zd.service.SignOutOP;
import com.zd.utils.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

/**
 * 采购管理系统用例
 */
@Listeners({TestFailListener.class})
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
    String purchaseType ="服务";
    //必须install，要不然不会将testNG里的browser赋值进去
    @Parameters({"browser", "nodeUrl"})
    @BeforeClass
    public void beforeMethod(String browser, String nodeUrl) throws InterruptedException, MalformedURLException {
//        if (browser.equals("Chrome")) driver = common.openChrome();
//        else if (browser.equals("FireFox")) driver = common.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
        driver=common.getDriver(browser);
        driver.get(nodeUrl);
        loginOP = new LoginOP(driver);
        homeOP = new HomeOP(driver);
        pcpo = new PurchaseContactPO(driver);
        soop = new SignOutOP(driver);
        TestFailListener.driver=driver;
    }

    /**
     * 登录
     */
    @Test(description = "Login",priority = 0)
    public void Login(){
        loginOP.toLogin("admin", "edeming123");
        Verify.assertEquals(driver.getTitle(), "首页", "登录校验失败");
        //homeOP.menuClick("采购管理系统");
    }
    //采购类型数据驱动
    @DataProvider(name = "purchaseType")
    public Object[][] purchaseType(){
        return new Object[][]{
                {"service","服务"},
                {"engineer","工程"},
                {"material","物资"},
                {"human","人力"}
        };
    }
    //使用POI读取excel数据，数据驱动‘
    @DataProvider(name="contactData")
    public Object[][] contactData(){
        return utils.testData("C:\\Users\\Administrator\\Desktop\\11.xls");

    }
    /**
     * 进入采购管理系统->保存采购联系单草稿->提交->刷新
     * 数据驱动，执行新增人力,物资,服务,工程四个联系单
     */
    @Test(description = "新增联系单", priority = 1, threadPoolSize = 10,dataProvider = "contactData")
    public void contactList(HashMap<String,String> data) throws IOException, AWTException {
        //创建截图目录
        //FileHandler.createDir(new File("/screenshot"));
        //浏览器截图
        //File srcFile=
        //        ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(srcFile,new File("/screenshot/error.png"));
        //截屏方法二  截屏整个浏览器
        //BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        //ImageIO.write(image,"png",new File("/screenshot/screen_robot.png"));

        pcpo.itemSelection("service", utils.getTel(), "0", data.get("name"),
                "2018-09-30", "10", "1", "12", "12",
                "注册资金不少于100万，具有ISO90001认证", "保证省电动汽车公司专网内各种业务资产的全程可控和全时可用，及时对仿冒泛终端、非法终端接入、未知恶意软件传播、网内异常流量/异常数据访问、业务系统故障、业务运行异常等重要业务风险事件进行感知和检测，做到终端安全接入可管可控。具体服务采购内容详见技术规范书。",
                    Keys.chord(Keys.SHIFT,"zdh"),"方便面","ASK123","1000","个","自动化","自动化测试");
            //driver.navigate().refresh();
    }

    /**
     * 审批流程->预审->二级审批->一级审批
     * 执行四次,将上一个Test中新增的四个联系单全部审批通过
     */
    @Test(description = "审批", priority = 2)
    public void examine(){
        soop.toSignOut("采购联系单退出");
        pretrial();
        soop.toSignOut("预审退出");
        twoLevel();
        soop.toSignOut("二级审批退出");
        oneLevel();
        driver.navigate().refresh();
        //soop.toSignOut("一级审批退出");
    }
    /**
     * 采购评审审批
     */
    @Test(description = "评审",priority = 4)
    public void reviewApproval(){
        pcpo.selectionMenu("采购评审");
        pcpo.reviewAdopt("会议1","水澄","2019-11-11");
    }

    /**
     *填写采购申请编号->采购需求执行（中标会签编号）->新增采购合同
     */
    @Test(description = "采购流程", priority = 3)
    public void purchase() {
        soop.toSignOut("一级审批退出");
        Login();
        pcpo.fillPurNumber(utils.getUUID(),"佳杰");
        pcpo.selectionMenu("采购需求");
        pcpo.implementationReq("中标会签编号",utils.getUUID());
        pcpo.selectionMenu("采购合同");
        pcpo.contract();
        pcpo.addPurchaseContract(utils.getUUID(),utils.getUUID(),"略略略","10000",
                "略略略","2018-09-10","2018-09-10","2018-09-10",
                "测试","略略略",utils.getTel(),"10000",
                "自动化","测试","10000",utils.getUUID(),purchaseType);
    }

    /**
     * 新增来票
     */
    @Test(description = "新增来票",priority = 4)
    public void invoice(){
        pcpo.selectionMenu("来票记录");
        pcpo.addInvoice(utils.getUUID(),"10000","2018-09-10");
    }

    /**
     * 支付审批单
     */
    @Test(description = "填写支付审批单",priority = 5)
    public void addPaymentApproval(){
        pcpo.selectionMenu("支付审批单");
        pcpo.addPaymentApproval(purchaseType,"10000","自动化","自动化","自动化","略略略");
        soop.toSignOut("支付审批单退出");
        pretrial();
        soop.toSignOut("预审退出");
        twoLevel();
        soop.toSignOut("二级审批退出");
        oneLevel();
    }

    /**
     * 确认付款
     */
    @Test(description = "确认付款",priority = 7)
    public void confirmPayment(){
        Login();
        pcpo.selectionMenu("付款记录");
        pcpo.payment("2019111111");
    }

    /**
     * 采购预审
     */
    public void pretrial(){
        loginOP.toLogin("chenjiabin1", "123456");
        homeOP.menuClick("采购管理系统");
        pcpo.toExamination();
    }

    /**
     * 采购二级审批
     */
    public void twoLevel(){
        loginOP.toLogin("chenjiabin1", "123456");
        homeOP.menuClick("采购管理系统");
        pcpo.toExamination();
    }

    /**
     * 采购一级审批
     */
    public void oneLevel(){
        loginOP.toLogin("chenjiabin1", "123456");
        homeOP.menuClick("采购管理系统");
        pcpo.toExamination();
    }

    //只执行一次，在最后
    @AfterClass
    public void end(){

    }

}
