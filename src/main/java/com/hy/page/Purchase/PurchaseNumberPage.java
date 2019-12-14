package com.hy.page.Purchase;

import com.hy.page.BasePage;
import com.hy.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * 采购申请编号弹窗
 */
public class PurchaseNumberPage extends BasePage {
    //采购申请编号
    @FindBy(xpath = "//*[contains(@onkeyup, 'check')]")
    WebElement purchaseApplicationNumber;
    //采购方式Select
    @FindBy(id = "dftMethodSlt")
    WebElement procurementMethod;
    //组织机构Select
    @FindBy(id = "dftOrgSlt")
    WebElement organization;
    //采购专职Select
    @FindBy(id = "dftExecutorSlt")
    WebElement purchaseJob;
    //确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[1]")
    WebElement determine;

    Utils utils=new Utils();
    public PurchaseNumberPage(WebDriver driver) {
        super(driver);
    }
    public PurchaseNumberPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void fillPurchasenNum(String purNum,String purjob){
        purchaseApplicationNumber.sendKeys(purNum);
        utils.rl(procurementMethod);
        utils.rl(organization);
        Select sel =new Select(purchaseJob);
        sel.selectByVisibleText(purjob);
        //List<WebElement> purchaseJobs= sel.getOptions();
        determine.click();

    }


}
