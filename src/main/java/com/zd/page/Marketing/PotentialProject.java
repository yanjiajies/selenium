package com.zd.page.Marketing;

import com.zd.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 潜在项目列表页
 */
public class PotentialProject extends BasePage {
    //新增项目
    @FindBy(id = "add")
    WebElement add;
    //修改
    @FindBy(id = "update")
    WebElement update;
    //导入
    @FindBy(id = "import")
    WebElement importP;
    //导出
    @FindBy(id = "export")
    WebElement export;
    //刷新
    @FindBy(id = "refresh")
    WebElement refresh;
    //查询
    @FindBy(id = "searchs")
    WebElement search;
    //查询输入框
    @FindBy(id = "searchInput")
    WebElement searchInput;
    public PotentialProject(WebDriver driver) {
        super(driver);
    }
    public PotentialProject(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void addProject(){
        add.click();
    }
}
