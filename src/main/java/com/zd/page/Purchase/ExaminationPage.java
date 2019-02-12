package com.zd.page.Purchase;

import com.zd.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 审批列表页
 */
public class ExaminationPage extends BasePage{
    //@FindBy(xpath = "//*[@id=\"approvalProcessList\"]/tbody/tr[2]/td[11]/a")
    //WebElement examine;
    @FindBy(xpath = "//*[contains(@onclick, 'viewApprovalProcess')]")
    List<WebElement> examine;
    public ExaminationPage(WebDriver driver) {
        super(driver);
    }

    public ExaminationPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    //根据新建采购联系获取的id查找对应的数据 //*[@id="020de4f7fc8a4ad582e3e81e4412633e"]/td[11]/a
    public void getExamine(){
        examine.get(0).click();
    }
}
