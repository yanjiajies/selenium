package com.hy.page.HumanCapital;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HumanCapitalMenuPage extends BasePage {
    //一级-人员需求
    @FindBy(xpath = "/html/body/div[2]/ul/li/ul/li[1]/a")
    WebElement demand;
    //人员需求-人员需求申请
    @FindBy(className = "peopleDemandManagement")
    WebElement peopleDemandManagement;
    //人员需求-面试记录
    @FindBy(xpath = "/html/body/div[2]/ul/li/ul/li[1]/ul/li[2]/a")
    WebElement interviewRecordManagement;
    //一级-人员信息
    @FindBy(xpath = "//*[contains(@code, 'personnelinfoManagement')]")
    WebElement personnelinfoManagement;
    //人员信息-人员档案
    @FindBy(xpath = "//*[contains(@code,'personnelinfo')]")
    WebElement personnelinfo;
    //人员信息-牌价信息
    @FindBy(className = "bidPriceManagement")
    WebElement bidPriceManagement;
    //一级-人工成本
    @FindBy(xpath = "//*[contains(@code,'manpowerCost')]")
    WebElement manpowerCost;
    //其他暂时不用
    public HumanCapitalMenuPage(WebDriver driver){
        super(driver);
    }
}
