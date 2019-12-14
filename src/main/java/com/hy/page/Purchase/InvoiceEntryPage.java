package com.hy.page.Purchase;

import com.hy.page.BasePage;
import com.hy.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 发票录入页面
 */
public class InvoiceEntryPage extends BasePage {
    Utils utils=new Utils();
    //来票号码
    @FindBy(xpath = "//*[@id=\"addInvoiceForm\"]/div[1]/div[1]/input")
    WebElement invoicenumber;
    //来票类型Select
    @FindBy(xpath = "//*[@id=\"addInvoiceForm\"]/div[1]/div[2]/select")
    WebElement invoiceType;
    //来票含税金额
    @FindBy(id = "invoiceMoneyTaxes")
    WebElement invoiceMoneyTaxes;
    //税率Select
    @FindBy(id = "taxRateId")
    WebElement taxRate;
    //来票日期
    @FindBy(id = "textLaipiao")
    WebElement invoiceData;
    //关联合同
    @FindBy(id = "contract")
    WebElement contract;
    //合同选择框
    @FindBy(xpath = "//*[@id=\"contractSelectList_frozen\"]/tbody/*[contains(@role, 'row')]")
    List<WebElement> selectContracts;
    //选择合同确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer12\"]/div[3]/a[1]")
    WebElement determine;
    //提交formSubmit()
    @FindBy(xpath = "//*[contains(@onclick, 'formSubmit')]")
    WebElement formSubmit;

    public InvoiceEntryPage(WebDriver driver) {
        super(driver);
    }
    public InvoiceEntryPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void toInvoiceEntry(String invoiceNum,String invoiceMoney_taxes,String invoice_data){
        invoicenumber.sendKeys(invoiceNum);
        utils.rl(invoiceType);
        invoiceMoneyTaxes.sendKeys(invoiceMoney_taxes);
        utils.rl(taxRate);
        invoiceData.sendKeys(invoice_data);
        contract.click();
        try {
            Thread.sleep(1000);
            selectContracts.get(1).click();
        } catch (InterruptedException e) {
            selectContracts.get(1).click();
        }
        determine.click();
        try {
            Thread.sleep(200);
            formSubmit.click();
        } catch (InterruptedException e) {
            formSubmit.click();

        }
    }
}
