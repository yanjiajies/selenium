package com.hy.page;
/**
 * 可以更具所有页面Common部分，都具有的功能，建一个CommonPage页面，存在Common功能的页面集成CommonPage，可以直接调用父类的方法
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {
    //导入
    @FindBy(id = "import")
    WebElement importFile;
    //导出
    @FindBy(id = "export")
    WebElement exportFile;
    public CommonPage(WebDriver driver) {
        super(driver);
    }
    public CommonPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void toImportFile(){
        importFile.click();
    }
    public void toExportFile(){
        exportFile.click();
    }
}
