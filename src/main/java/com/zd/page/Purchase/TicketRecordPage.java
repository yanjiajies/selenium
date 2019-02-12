package com.zd.page.Purchase;

import com.zd.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 来票记录页面
 */
public class TicketRecordPage extends BasePage {
    //发票录入
    @FindBy(id = "invoiceAdd")
    WebElement invoiceAdd;
    //修改
    @FindBy(id = "invoiceUpdate")
    WebElement invoiceUpdate;
    //刷新
    @FindBy(id = "refreshInvoice")
    WebElement refreshInvoice;
    public TicketRecordPage(WebDriver driver) {
        super(driver);
    }
    public TicketRecordPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void invoiceAdd(){
        invoiceAdd.click();
    }
}
