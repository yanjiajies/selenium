package com.zd.page.Purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaterialFillPage extends ServiceFillPage{
    //选择项目按钮物资
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div/div[1]/div[1]/div[3]/input")
    WebElement selectionProject_m;
    //物资需求清单_名称
    @FindBy(className = "tname")
    WebElement tname;
    //物资需求清单_型号规格
    @FindBy(className = "tst")
    WebElement tst;
    //物资需求清单_数量
    @FindBy(className = "tnumber")
    WebElement tnumber;
    //物资需求清单_单位
    @FindBy(className = "tunit")
    WebElement tunit;
    //物资需求清单_测试
    @FindBy(className = "tremark")
    WebElement tremark;
    //物资需求清单_新增一条
    @FindBy(className = "demand-add")
    WebElement demandAdd;
    //物资需求清单_删除按钮
    @FindBy(xpath = "//*[contains(@onclick, 'delRow')]")
    WebElement delRow;
    //上传按钮
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div/div[1]/div[16]/div/input[2]")
    WebElement selectionAttachments;
    //保存为草稿
    @FindBy(xpath = "//*[@id=\"addPurchaseApplyForm\"]/div/div[2]/input[2]")
    WebElement saveDraft;
    public MaterialFillPage(WebDriver driver) {
        super(driver);
    }
    //新增物资的物资需求清单
    public void addMaterial(String t_name,String t_st,String t_number,String t_unit,String t_remark){
        tname.sendKeys(t_name);
        tst.sendKeys(t_st);
        tnumber.sendKeys(t_number);
        tunit.sendKeys(t_unit);
        tremark.sendKeys(t_remark);
        demandAdd.click();
        delRow.click();
    }
    public void fillInfo(String contact_number, String estimated_amount, String task_name, String demand_time,
                         String packet_number, String incoming_amount, String warranty_period, String service_period,
                         String conditions, String project_background, String remark,String t_name,String t_st,
                         String t_number,String t_unit,String t_remark) {
        selectionProject_m.click();
        try {
            Thread.sleep(500);
            selectRadios.get(1).click();
        } catch (InterruptedException e) {
            selectRadios.get(1).click();
        }
        determine.click();
        super.contactNumber.sendKeys(contact_number);
        utils.rl(purchaseItemSlt);
        estimatedAmount.sendKeys(estimated_amount);
        taskName.sendKeys(task_name);
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
        addMaterial(t_name,t_st,t_number,t_unit,t_remark);
        selectionAttachments.click();
        //上传文件使用Autoit工具
        utils.fileUpload();
        saveDraft.click();
    }
}
