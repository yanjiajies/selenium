package com.hy.page.Project;
/**
 * 立项申请列表页
 */

import com.hy.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectApplicationPage extends BasePage {
    //立项申请按钮
    @FindBy(id = "addProjectArchives")
    WebElement projectName;
    //导出按钮
    @FindBy(id = "export")
    WebElement selectIntegratedPlan;
    //刷新按钮
    @FindBy(xpath = "//*[@id=\"archivesApplyBtn\"]/span[3]")
    WebElement refreshProject;
    //删除按钮
    @FindBy(id = "deleteProject")
    WebElement deleteProject;
    //项目查询框
    @FindBy(id = "gsProjName")
    WebElement gsProjName;
    //查询按钮
    @FindBy(id = "search")
    WebElement searchbtm;
    //第一列数据
    @FindBy(xpath = "//*[@id=\"archivesApplyList\"]/tbody/tr[1]")
    WebElement jqgfirstrow_1;

    //提交审批操作
    //修改
    //撤回
    //回退
    //填写项目编号
    // 调用父类的构造方法进行初始化（PageFactor使用对象的时候需要先初始化Page类）
    public ProjectApplicationPage(WebDriver driver) {
        super(driver);
    }

    //初始化，并检验页面title与预期title是否一致
    public ProjectApplicationPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    public void proAppl() {
        projectName.click();
    }
}
