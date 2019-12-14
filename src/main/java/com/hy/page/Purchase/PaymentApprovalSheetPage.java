package com.hy.page.Purchase;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentApprovalSheetPage extends BasePage {
    //填写支付审批单
    @FindBy(id = "lockOrUnLockUser")
    WebElement lockOrUnLockUser;
    //所有审批单类型(方法一，FindAll方法，取并集,获取所有FindBy元素)
    @FindAll({
            @FindBy(id = "add"),
            @FindBy(id = "add1"),
            @FindBy(id = "add2"),
            @FindBy(id = "addHuman")
            })
    List<WebElement> types;
    //方法二,获取到id为lockOrUnLockUser的ul下所有的li中的span元素
    //@FindBy(xpath = "//*[@id=\"lockOrUnLockUser\"]/ul/li/span")
    //List<WebElement> types;
    //刷新
    @FindBy(id = "refreshpaymentInformation")
    WebElement refreshpaymentInformation;

    public PaymentApprovalSheetPage(WebDriver driver) {
        super(driver);
    }
    public PaymentApprovalSheetPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    Actions action = new Actions(driver);
    public void addPaymentApproval(String typeName){
        action.moveToElement(lockOrUnLockUser).perform();
        for (WebElement type:types
             ) {
            if(type.getText().equals(typeName)){
                type.click();
                break;
            }
        }
    }
}
