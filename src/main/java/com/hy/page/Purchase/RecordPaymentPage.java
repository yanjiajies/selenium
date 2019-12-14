package com.hy.page.Purchase;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 付款记录页面
 */
public class RecordPaymentPage extends BasePage {
    //付款确认操作update
    @FindBy(xpath = "//*[contains(@onclick, 'update')]")
    List<WebElement> confirmPayments;
    //财务稽核日期
    @FindBy(id = "checktime")
    WebElement checktime;
    //确认
    @FindBy(xpath = "//*[@id=\"layui-layer12\"]/div[3]/a[1]")
    WebElement determine;

    public RecordPaymentPage(WebDriver driver) { super(driver); }
    public RecordPaymentPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void toConfirmPayment(String checkdata){
        confirmPayments.get(0).click();
        checktime.sendKeys(checkdata);
        determine.click();
    }
}
