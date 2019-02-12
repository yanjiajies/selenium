package com.zd.page.Purchase;

import com.zd.page.BasePage;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 采购评审页面
 */
public class ProcureReviewPage extends BasePage {
    //新增
    @FindBy(id = "add")
    WebElement add;
    //评审记录
    //@FindBy(xpath = "//*[@id=\"purchaseReviewList\"]/tbody")
    //会议名称
    @FindBy(xpath = "//*[@id=\"addPurchaseReviewForm\"]/div[1]/div/input")
    WebElement meetingName;
    //会议地点
    @FindBy(xpath = "//*[@id=\"addPurchaseReviewForm\"]/div[2]/div[1]/input")
    WebElement meetingSite;
    //会议时间
    @FindBy(id="meetingTime")
    WebElement meetingTime;
    //确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[1]")
    WebElement confirm;
    //选择评审记录
    @FindBy(xpath = "//*[@id=\"purchaseReviewList\"]/tbody/tr[2]/td[4]")
    WebElement selectp;
    //评审通过Finash
    @FindBy(xpath = "//*[contains(@onclick, 'Finash')")
    WebElement finash;
    //评审编辑Update
    @FindBy(xpath = "//*[contains(@onclick, 'Update')")
    WebElement update;
    //评审退回backs
    @FindBy(xpath = "//*[contains(@onclick, 'backs')")
    WebElement backs;
    //通过确定
    @FindBy(xpath = "//*[@id=\"layui-layer13\"]/div[3]/a[1]")
    WebElement sure;
    public ProcureReviewPage(WebDriver driver) {
        super(driver);
    }
    public ProcureReviewPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    Actions action=new Actions(driver);
    public void reviewAdopt (String meeting_name,String meeting_site,String meeting_time){
        add.click();
        meetingName.sendKeys(meeting_name);
        meetingSite.sendKeys(meeting_site);
        meetingTime.sendKeys(meeting_time);
        meetingName.click();
        confirm.click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.doubleClick(selectp).perform();

        //finash.click();
        //sure.click();
    }
}
