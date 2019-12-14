package com.hy.page.Purchase;

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 采购联系单列表页
 */
public class PurchaseContactPage extends BasePage {
    //填写联系单"*[contains(@class, 'ivu-icon-md-add')]"
    ////a[contains(text(),"填写联系单")]
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/button[1]")
    WebElement lockOrUnLockUser;
    //导出
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/button[2]")
    WebElement export;
    //刷新
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/button[3]")
    WebElement refreshPurchaseApply;
    //提交申请
    @FindBy(linkText = "提交申请")
    List<WebElement> submissions;
    //采购申请编号applyNumber(this)
    @FindBy(linkText = "采购申请编号")
    List<WebElement> purchaseNumbers;
    //移入评审addReview
    @FindBy(linkText ="移入评审")
    List<WebElement> addReviews;
    //移出评审delReview
    @FindBy(linkText ="移出评审")
    List<WebElement> delReviews;
    //退回
    //合并
    //修改
    //清空
    //查询

    //初始化driver
    public PurchaseContactPage(WebDriver driver) {
        super(driver);
    }
    //初始化driver,并校验title是否正确
    public PurchaseContactPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    //点击填写联系单按钮
    public void sheetInfo(){
        lockOrUnLockUser.click();
    }

























    //    Actions action = new Actions(driver);

//    public void clickLockOrUnLockUser(String typeName) {
//        //鼠标悬停事件
//        action.moveToElement(lockOrUnLockUser).perform();
//        Map<String, WebElement> typeMap = new HashMap<String, WebElement>();
//        typeMap.put("service", addService);
//        typeMap.put("engineer", addEngineering);
//        typeMap.put("material", addMaterial);
//        typeMap.put("human", addHuman);
//        for (Map.Entry<String, WebElement> type : typeMap.entrySet()
//        ) {
//             (typeName.equals(type.getKey())) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    type.getValue().click();
//                }
//                type.getValue().click();
//                break;
//            }
//        }
//    }

//    public String submissionA(String typeName) {
//        String id = data_id.getAttribute("id");
//        System.out.println("-----------" + id + "------------ ");
//        submission.click();
//         (typeName.equals("human")) determine_3.click();
//        else determine_4.click();
//        return id;
//    }
//    public void fillPurchaseNumber(){
//        purchaseNumber.click();
//    }
//    public void addReview(){
//        addReviews.get(0).click();
//    }
//    public void delReview(){
//        delReviews.get(0).click();
//    }
//    public void moveInto(){addReviews.get(0).click();}
}
