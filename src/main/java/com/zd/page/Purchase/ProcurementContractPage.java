package com.zd.page.Purchase;

import com.zd.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 采购合同列表页
 */
public class ProcurementContractPage extends BasePage {
    //新增按钮
    @FindBy(id = "add")
    WebElement add;
    //刷新按钮
    @FindBy(id = "refreshProcurementContract")
    WebElement refresh;
    //导入按钮
    @FindBy(id = "import")
    WebElement toimport;
    //导出按钮
    @FindBy(id = "export")
    WebElement export;
    //查询输入框
    @FindBy(id = "searchInput")
    WebElement searchInput;
    //查询按钮
    @FindBy(id = "search")
    WebElement search;
    @FindBy(xpath = "//*[contains(@onclick, 'update')")
    List<WebDriver> update;

    public ProcurementContractPage(WebDriver driver) {
        super(driver);
    }
    public ProcurementContractPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void contractOperation(){
        add.click();
    }

}
