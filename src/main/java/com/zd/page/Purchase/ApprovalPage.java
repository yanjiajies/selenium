package com.zd.page.Purchase;

import com.zd.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 采购审批页
 */

public class ApprovalPage extends BasePage {
    //审批意见
    @FindBy(xpath = "//*[@id=\"approvalOpinion\"]")
    WebElement approvalOpinion;
    //同意按钮
    @FindBy(id = "tongy")
    WebElement tongy;
    //驳回按钮
    @FindBy(id = "boh")
    WebElement boh;
    //同意确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[1]")
    WebElement determine;
    public ApprovalPage(WebDriver driver) {
        super(driver);
    }
    public ApprovalPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    /**
     * 同意审批，审批通过
     */
    public void toAgree(){
        tongy.click();
        determine.click();
    }
}
