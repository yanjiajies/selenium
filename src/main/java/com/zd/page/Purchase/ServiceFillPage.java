package com.zd.page.Purchase;

import com.zd.page.BasePage;
import com.zd.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.util.List;


/**
 * 填写采购联系单页面_服务1
 */
public class ServiceFillPage extends BasePage {
    //选择项目按钮_服务and工程//*[@id="addPurchaseApplyForm"]/div/div[1]/div[1]/div[3]/input
    ////*[contains(@onclick, '20181019001')]
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[1]/div[3]/input")
    WebElement selectionProject;
    //项目单选框
    @FindBy(xpath = "//*[@id=\"projectSelectList_frozen\"]/tbody/*[contains(@role, 'row')]")
    List<WebElement> selectRadios;
    //选择项目确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[1]")
    WebElement determine;
    WebElement determine_eng;
    //联系电话
    @FindBy(name = "contactNumber")
    WebElement contactNumber;
    //采购项Select
    @FindBy(id = "purchaseItemSlt")
    WebElement purchaseItemSlt;
    //估算金额
    @FindBy(id = "estimatedAmount2")
    WebElement estimatedAmount;
    //采购任务名称
    @FindBy(name = "taskName")
    WebElement taskName;
    //需求日期
    @FindBy(name = "demandTime")
    WebElement demandTime;
    //是否框架Select
    @FindBy(name = "whetherFrame")
    WebElement whetherFrame;
    //建议采购方Select
    @FindBy(name = "procurementMethod")
    WebElement procurementMethod;
    //暂定包数
    @FindBy(name = "provisionalPacketNumber")
    WebElement provisionalPacketNumber;
    //付款方式Select
    @FindBy(name = "paymentMethod")
    WebElement paymentMethod;
    //进项金额
    @FindBy(id = "incomingAmount2")
    WebElement incomingAmount;
    //保质期限
    @FindBy(name = "warrantyPeriod")
    WebElement warrantyPeriod;
    //服务期限
    @FindBy(name = "servicePeriod")
    WebElement servicePeriod;
    //采购依据
    @FindBy(name = "purchaseBasis")
    List<WebElement> purchaseBasis;
    //专用资质条件
    @FindBy(name = "qualificationConditions")
    WebElement qualificationConditions;
    //采购背景、事由
    @FindBy(name = "projectBackground")
    WebElement projectBackground;
    //备注
    @FindBy(name = "remarks")
    WebElement remarks;
    //选择附件按钮
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[15]/div/input[2]")
    WebElement selectionAttachments;
    //返回按钮
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[16]/input[1]")
    WebElement ret;
    //保存为草稿按钮
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[16]/input[2]")
    WebElement saveDraft;
    //提交按钮
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[16]/input[3]")
    WebElement submissionFill;

    Utils utils =new Utils();
    public ServiceFillPage(WebDriver driver) {
        super(driver);
    }
    public ServiceFillPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void fillInfo(String contact_number, String estimated_amount, String task_name, String demand_time,
                         String packet_number, String incoming_amount, String warranty_period, String service_period,
                         String conditions, String project_background, String remark) {
        selectionProject.click();

//        (new WebDriverWait(driver,10)).
//                until(new ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver){
//                        return driver.findElement(By.xpath()).isSelected();
//                    }
//                })
        try {
            Thread.sleep(500);
            selectRadios.get(1).click();;
        } catch (InterruptedException e) {
            selectRadios.get(1).click();;
        }
        determine.click();
        contactNumber.sendKeys(contact_number);
        utils.rl(purchaseItemSlt);
        estimatedAmount.sendKeys(estimated_amount);
        //taskName.sendKeys(task_name);
        demandTime.sendKeys(demand_time);
        utils.rl(whetherFrame);
        utils.rl(procurementMethod);
        provisionalPacketNumber.sendKeys(packet_number);
        utils.rl(paymentMethod);
        incomingAmount.sendKeys(incoming_amount);
        warrantyPeriod.sendKeys(warranty_period);
        servicePeriod.sendKeys(service_period);
        purchaseBasis.get(0).click();
        qualificationConditions.sendKeys(conditions);
        projectBackground.sendKeys(project_background);
        remarks.sendKeys(remark);
        selectionAttachments.click();
        //上传文件使用Autoit工具
        try {
            utils.fileUploadRobot();
        } catch (Exception e) {
            Reporter.log("上传文件失败");
        }
        saveDraft.click();
    }

}
