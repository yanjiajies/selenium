package com.zd.page;
/**
 * 工作台页面
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class HomePage extends BasePage {
    @FindBy(linkText = "经营分析系统")
    WebElement operationAnalysisManagement;
    @FindBy(linkText = "综合计划系统")
    WebElement comperhensivePlanManagement;
    @FindBy(linkText = "营销管理系统")
    WebElement marketingManagement;
    @FindBy(xpath = "//*[contains(@code, 'humanCapitaManagement')]")
    WebElement humanCapitaManagement;
    @FindBy(linkText = "财务辅助系统 ")
    WebElement financesAccesoryManagement;
    @FindBy(linkText = "项目管理系统")
    WebElement projectManagement;
    @FindBy(xpath = "//*[contains(@code, 'purchasingManagement')]")
    WebElement purchasingManagement;
    @FindBy(linkText = "基础平台系统")
    WebElement systemManagement;
    @FindBy(className = "user-btn text-overflow")
    WebElement personal;
    @FindBy(className = "fa fa-power-off")
    WebElement signOut;

    // 调用父类的构造方法进行初始化（PageFactor使用对象的时候需要先初始化Page类）
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //初始化，并检验页面title与预期title是否一致
    public HomePage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    public void homeMenu(String menuName) {
        Map<String, WebElement> menus = new HashMap<String, WebElement>();
        menus.put("经营分析系统", operationAnalysisManagement);
        menus.put("综合计划系统", comperhensivePlanManagement);
        menus.put("营销管理系统", marketingManagement);
        menus.put("人资管理系统", humanCapitaManagement);
        menus.put("财务辅助系统", financesAccesoryManagement);
        menus.put("项目管理系统", projectManagement);
        menus.put("采购管理系统", purchasingManagement);
        menus.put("基础平台系统", systemManagement);
        for (Map.Entry<String, WebElement> menu : menus.entrySet()
        ) {
            if (menu.getKey().equals(menuName)) {
                menu.getValue().click();
                break;
            }
        }
    }
}