package com.hy.page.Purchase_VUE;

import com.hy.page.BasePage;
import com.hy.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;


public class PurchaseSheetPage extends BasePage {
    Utils utils = new Utils();
    /*ivu-select-selection下标
     5.采购类型选择框
     6.框架类型
     7.采购项
     8.建议采购方式
     9.付款方式*/
    @FindBy(className = "ivu-select-selection")
    List<WebElement> purchaseTypes;
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[4]/div/div/div/div[2]/ul[2]/li[1]")
    WebElement purchaseClass;
    //框架类型(非框架、通用框架（不用关联项目）、专用框架)
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[5]/div/div/div/div[2]/ul[2]/li")
    List<WebElement> frameTypes;
    //选择项目按钮
    @FindBy(xpath = "//*[contains(@class, 'ivu-input-group-append')]")
    WebElement selectProjects;
    //选择项目单选
    @FindBy(xpath = "/html/body/div[25]/div[2]/div/div/div[2]/div/div[2]/div/div[2]/table/tbody/tr[6]/td[1]/div/div/label/span/input")
    WebElement projectRadios;
    //选择项目确认按钮
    @FindBy(xpath = "/html/body/div[25]/div[2]/div/div/div[3]/div/button[2]/span")
    WebElement projectConfirm;
    //联系电话
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[6]/div[5]/div/div/div/input")
    WebElement contactNumber;
    //通用框架联系电话
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[6]/div/div/div/input")
    WebElement fContactNumber;
    //需求日期ivu-input-with-suffix
    @FindBy(xpath = "//*[contains(@class, 'ivu-input-with-suffix')]")
    List<WebElement> dates;
    //采购任务名称
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[8]/div/div/div/input")
    WebElement taskName;
    //选择采购项
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[6]/div[6]/div/div/div/div[2]/ul[2]/li")
    WebElement item;
    //公开竞争性谈判
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[10]/div/div/div/div[2]/ul[2]/li[1]")
    WebElement procurementMode;
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[11]/div/div/div/div[2]/ul[2]/li[3]")
    WebElement paymentMethod;
    //暂定包数
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[12]/div/div/div/input")
    WebElement packetNumber;
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[13]/div/div/div/input")
    WebElement amountInput;
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[14]/div/div/div/div[1]/div/input")
    WebElement deliveryTime;
    //质保期限（月）
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[15]/div/div/div/input")
    WebElement warrantyPeriod;
    //估算金额（元）
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[16]/div/div/div/input")
    WebElement estimatedAmount;
    //专用资质条件
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[17]/div/div/div/textarea")
    WebElement qualificationConditions;
    //项目概况
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[18]/div/div/div/textarea")
    WebElement projectDverview;
    //本次采购必要性说明
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[19]/div/div/div/textarea")
    WebElement explain;
    //备注
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[20]/div/div/div/textarea")
    WebElement remarks;
    //附件数组
    @FindBy(xpath = "//*[contains(@class, 'ivu-upload-drag')]")
    List<WebElement> enclosures;
    //提交联系单按钮
    @FindBy(xpath = "/html/body/div[23]/div/div[2]/div/div/form/div/div[28]/button[3]/span/span")
    WebElement submission;


    public PurchaseSheetPage(WebDriver driver) {
        super(driver);
    }

    public PurchaseSheetPage(WebDriver driver, String title) {
        super(driver, title);
    }

    public void fillInfo(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        purchaseTypes.get(5).click();
        purchaseClass.click();
        purchaseTypes.get(6).click();
        if (!name.equals("generalFramework")) {
            if (name.equals("nonFramed")) frameTypes.get(0).click();
            if (name.equals("dedicatedFramework")) frameTypes.get(1).click();
            selectProjects.click();
            projectRadios.click();
            projectConfirm.click();
            contactNumber.sendKeys("18569545340");
            purchaseTypes.get(7).click();
            item.click();
            purchaseTypes.get(8).click();
            procurementMode.click();
            purchaseTypes.get(9).click();
            paymentMethod.click();
        } else {
            frameTypes.get(2).click();
            fContactNumber.sendKeys("18569545340");
            taskName.sendKeys("测试");
            purchaseTypes.get(7).click();
            procurementMode.click();
            purchaseTypes.get(8).click();
            paymentMethod.click();
        }
        dates.get(1).sendKeys("2019-11-11");
        packetNumber.sendKeys("123");
        amountInput.sendKeys("10000");
        deliveryTime.sendKeys("2019-10-26");
        warrantyPeriod.sendKeys("12");
        estimatedAmount.sendKeys("10");
        qualificationConditions.sendKeys("测试专用资质条件");
        projectDverview.sendKeys("测试项目简况");
        explain.sendKeys("测试本次采购必要性说明");
        remarks.sendKeys("测试备注");
        enclosures.get(0).click();
        try {
            utils.fileUploadRobot("d:\\Downloads\\12312312.pdf");
            enclosures.get(1).click();
            utils.fileUploadRobot("d:\\Downloads\\采购项目重点内容说明.docx");
            enclosures.get(2).click();
            utils.fileUploadRobot("d:\\Downloads\\采购项目重点内容说明.docx");
            enclosures.get(3).click();
            utils.fileUploadRobot("d:\\Downloads\\采购项目重点内容说明.docx");
            enclosures.get(4).click();
            utils.fileUploadRobot("d:\\Downloads\\采购项目重点内容说明.docx");
            enclosures.get(5).click();
            utils.fileUploadRobot("d:\\Downloads\\采购项目重点内容说明.docx");
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submission.click();
    }
}
