package com.hy.page.Purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HumanFillPage extends ServiceFillPage{
    @FindBy(name = "demandDescribe")
    WebElement demandDescribe;
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[11]/div/input[2]")
    WebElement selectionAttachments;
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div[12]/input[2]")
    WebElement saveDraft;

    public HumanFillPage(WebDriver driver) { super(driver); }
    public void fillInfo(String contact_number, String estimated_amount, String task_name, String demand_time,
                         String packet_number, String incoming_amount, String warranty_period, String service_period,
                         String conditions, String demand_des,String remark) {
        taskName.sendKeys(task_name);
        demandTime.sendKeys(demand_time);
        contactNumber.sendKeys(contact_number);
        estimatedAmount.sendKeys(estimated_amount);
        utils.rl(whetherFrame);
        utils.rl(procurementMethod);
        provisionalPacketNumber.sendKeys(packet_number);
        utils.rl(paymentMethod);
        incomingAmount.sendKeys(incoming_amount);
        warrantyPeriod.sendKeys(warranty_period);
        servicePeriod.sendKeys(service_period);
        qualificationConditions.sendKeys(conditions);
        demandDescribe.sendKeys(demand_des);
        remarks.sendKeys(remark);
        selectionAttachments.click();
        //上传文件使用Autoit工具
        utils.fileUpload("");
        saveDraft.click();
    }
}
