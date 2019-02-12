package com.zd.page.Purchase;

import com.zd.page.BasePage;
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
    //填写联系单
    @FindBy(id = "lockOrUnLockUser")
    WebElement lockOrUnLockUser;
    //服务
    @FindBy(id = "addService")
    WebElement addService;
    //工程
    @FindBy(id = "addEngineering")
    WebElement addEngineering;
    //物资
    @FindBy(id = "addMaterial")
    WebElement addMaterial;
    //人力
    @FindBy(id = "addHuman")
    WebElement addHuman;
    //导出
    @FindBy(id = "export")
    WebElement export;
    //刷新
    @FindBy(id = "refreshPurchaseApply")
    WebElement refreshPurchaseApply;
    //提交申请
    @FindBy(linkText = "提交申请")
    WebElement submission;
    @FindBy(xpath = "//*[@id=\"layui-layer4\"]/div[3]/a[1]")
    WebElement determine_4;
    @FindBy(xpath = "//*[@id=\"layui-layer3\"]/div[3]/a[1]")
    WebElement determine_3;
    //第一行数据
    @FindBy(xpath = "//*[@id=\"purchaseApplyList\"]/tbody/tr[2]")
    WebElement data_id;
    //采购申请编号applyNumber(this)
    @FindBy(xpath = "//*[contains(@onclick, 'applyNumber')]")
    WebElement purchaseNumber;
    //移入评审addReview
    @FindBy(xpath ="//*[contains(@onclick, 'addReview')]")
    List<WebElement> addReviews;
    //移出评审delReview
    @FindBy(xpath ="//*[contains(@onclick, 'delReview')]")
    List<WebElement> delReviews;



    public PurchaseContactPage(WebDriver driver) {
        super(driver);
    }

    public PurchaseContactPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    Actions action = new Actions(driver);

    public void clickLockOrUnLockUser(String typeName) {
        //鼠标悬停事件
        action.moveToElement(lockOrUnLockUser).perform();
        Map<String, WebElement> typeMap = new HashMap<String, WebElement>();
        typeMap.put("service", addService);
        typeMap.put("engineer", addEngineering);
        typeMap.put("material", addMaterial);
        typeMap.put("human", addHuman);
        for (Map.Entry<String, WebElement> type : typeMap.entrySet()
        ) {
            if (typeName.equals(type.getKey())) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    type.getValue().click();
                }
                type.getValue().click();
                break;
            }
        }
    }

    public String submissionA(String typeName) {
        String id = data_id.getAttribute("id");
        System.out.println("-----------" + id + "------------ ");
        submission.click();
        if (typeName.equals("human")) determine_3.click();
        else determine_4.click();
        return id;
    }
    public void fillPurchaseNumber(){
        purchaseNumber.click();
    }
    public void addReview(){
        addReviews.get(0).click();
    }
    public void delReview(){
        delReviews.get(0).click();
    }
    public void moveInto(){addReviews.get(0).click();}
}
