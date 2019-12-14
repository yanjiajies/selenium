package com.hy.page.Purchase;

import com.hy.page.BasePage;
import com.hy.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 填写支付单页面
 */
public class AddPaymentApprovalPage extends BasePage{
    //采购联系单号
    @FindBy(xpath = "//*[contains(@onclick, 'selectprocurement')]")
    WebElement selectprocurement;
    //采购联系单单选框
    @FindBy(xpath = "//*[@id=\"procurementSelectDiv\"]/tr[1]/td[1]/input")
    WebElement select;
    //确认
    @FindBy(xpath = "//*[@id=\"layui-layer13\"]/div[3]/a[1]")
    WebElement determine13;
    //采购合同名称selectContract
    @FindBy(xpath = "//*[contains(@onclick, 'selectContract')]")
    WebElement selectContract;
    //选择合同
    @FindBy(xpath = "//*[@id=\"contractData\"]/tr[1]/td[1]/input")
    WebElement selectContractFrame;
    //选择合同确认
    @FindBy(xpath = "//*[@id=\"layui-layer15\"]/div[3]/a[1]")
    WebElement determine12;
    //本次申请付款金额
    @FindBy(id = "paymentmoney")
    WebElement paymentmoney;
    //付款条件
    @FindBy(id = "admissionrequirements")
    WebElement admissionrequirements;
    //项目进度
    @FindBy(id = "projectschedule")
    WebElement projectschedule;
    //付款事由
    @FindBy(id = "paymentreason")
    WebElement paymentreason;
    //其他说明
    @FindBy(id = "reset")
    WebElement reset;
    //上传附件
    @FindBy(xpath = "//*[@id=\"addpaymentInformationForm\"]/div[10]/div/input[2]")
    WebElement upload;
    //保存为草稿formSubmit(true)
    @FindBy(xpath = "//*[contains(@onclick, 'formSubmit(true)')]")
    WebElement formSubmitT;
    //提交
    @FindBy(xpath = "//*[contains(@onclick, 'formSubmit(false)')]")
    WebElement formSubmitF;

    public AddPaymentApprovalPage(WebDriver driver) { super(driver); }
    public AddPaymentApprovalPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    Utils utils=new Utils();
    public void addPaymentApproval(String paymoney,String admissionrequ,String project_schedule,String pay_mentreason,
                                   String res){
        selectContract.click();
        try {
            Thread.sleep(500);
            selectContractFrame.click();
        } catch (InterruptedException e) {
            selectContractFrame.click();
        }
        determine12.click();
//        selectprocurement.click();
//        try {
//            Thread.sleep(1000);
//            select.click();
//        } catch (InterruptedException e) {
//            select.click();
//        }
//        determine13.click();
        paymentmoney.sendKeys(paymoney);
        admissionrequirements.sendKeys(admissionrequ);
        projectschedule.sendKeys(project_schedule);
        paymentreason.sendKeys(pay_mentreason);
        reset.sendKeys(res);
        upload.click();
        utils.fileUpload("");
        formSubmitF.click();
    }
}
