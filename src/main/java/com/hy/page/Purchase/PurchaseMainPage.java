package com.hy.page.Purchase;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * 采购主页面
 */
public class PurchaseMainPage extends BasePage {
    //需求填报
    @FindBy(className = "procurementApplyManagement ")
    WebElement procurementApplyManagement;
    //采购需求菜单
    @FindBy(xpath = "/html/body/div[2]/ul/li/ul/li[2]/a")
    WebElement procurementDemandManagement;
    //采购需求-执行
    @FindBy(xpath = "/html/body/div[2]/ul/li/ul/li[2]/ul/li[2]/a")
    WebElement implementation;
    //采购合同菜单
    @FindBy(className = "procurementContractManagement")
    WebElement procurementContractManagement;
    //来票记录菜单
    @FindBy(className = "invoiceManagement")
    WebElement invoiceManagement;
    //支付审批单菜单
    @FindBy(className = "paymentInformationManagement")
    WebElement paymentInformationManagement;
    //付款记录菜单
    @FindBy(className = "paymentInformationsManagement")
    WebElement paymentInformationsManagement;
    //供应商菜单
    @FindBy(className = "supplierManagement")
    WebElement supplierManagement;
    //审批列表菜单VUE
    @FindBy(className = "ivu-menu-item-selected")
    WebElement approvalProcessManagement;
    //综合查询菜单
    @FindBy(xpath = "/html/body/div[2]/ul/li/ul/li[9]/a")
    WebElement comprehensiveQueryManagement;
    //采购评审菜单
    @FindBy(className = "procurementApprovalManagement")
    WebElement procurementApprovalManagement;
    //个人
    @FindBy(xpath = "/html/body/div[1]/ul[2]/li/div")
    WebElement personal;
    //退出
    @FindBy(xpath = "/html/body/div[1]/ul[2]/li/ul/li[4]")
    WebElement signOut;
    //确认
    @FindBy(linkText = "确定")
    WebElement determine_1;
    @FindBy(linkText = "确定")
    WebElement determine_3;
    @FindBy(linkText = "确定")
    WebElement determine_18;

    public PurchaseMainPage(WebDriver driver) {
        super(driver);
    }

    public PurchaseMainPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    Actions action = new Actions(driver);

    public void selectionMenu(String menuName) {
        Map<String, WebElement> menuMap = new HashMap<String, WebElement>();
        menuMap.put("采购联系单", procurementApplyManagement);
        menuMap.put("采购需求", procurementDemandManagement);
        menuMap.put("采购合同", procurementContractManagement);
        menuMap.put("来票记录", invoiceManagement);
        menuMap.put("支付审批单", paymentInformationManagement);
        menuMap.put("付款记录", paymentInformationsManagement);
        menuMap.put("供应商", supplierManagement);
        menuMap.put("审批列表", approvalProcessManagement);
        menuMap.put("综合查询", comprehensiveQueryManagement);
        menuMap.put("采购评审",procurementApprovalManagement);
        for (Map.Entry<String, WebElement> meun : menuMap.entrySet()
        ) {
            if (meun.getKey().equals(menuName)) {
                if (menuName.equals("采购需求")) {
                    meun.getValue().click();
                    implementation.click();
                    break;
                }
                meun.getValue().click();
                break;
            }
        }
    }

    public void toSignOut(String name) {
        action.moveToElement(personal).perform();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            signOut.click();
        }finally {
            signOut.click();
        }
        if (name.equals("采购联系单退出")) {
            determine_1.click();
        }else if(name.equals("支付审批单退出")){
            determine_18.click();
        }
        else {
                determine_3.click();
        }
    }
}