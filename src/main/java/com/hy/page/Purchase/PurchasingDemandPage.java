package com.hy.page.Purchase;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 采购需求页面
 */
public class PurchasingDemandPage extends BasePage {
    //导出按钮
    @FindBy(id = "export")
    WebElement export;
    //刷新按钮
    @FindBy(id = "refreshPurchaseDemandExecution")
    WebElement refresh;
    //查询输入框
    @FindBy(id = "searchInput")
    WebElement searchInput;
    //查询按钮
    @FindBy(id = "search")
    WebElement search;
    //操作：中标会签编号
    @FindBy(xpath = "//*[contains(@onclick, 'execution')]")
    List<WebElement> signNumbers;
    //中标会签编号输入框
    @FindBy(xpath = "//*[contains(@onkeyup, 'check')]")
    WebElement signNumber;
    //确认
    @FindBy(xpath = "//*[@id=\"layui-layer4\"]/div[3]/a[1]")
    WebElement determine;

    public PurchasingDemandPage(WebDriver driver) {
        super(driver);
    }
    public PurchasingDemandPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void fillSignNumbers(String operation,String signNum){
        for (WebElement signNumber:signNumbers
             ) {
            if (signNumber.getText().equals(operation)){
                signNumber.click();
                break;
            }
        }
        signNumber.sendKeys(signNum);
        determine.click();
    }
}
