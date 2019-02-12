package com.zd.page.Project;
/**
 * 项目主页面
 */

import com.zd.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProjectMainPage extends BasePage {
    //立项申请菜单
    @FindBy(className = "projectApply open active")
    @CacheLookup
    WebElement projectApply;
    //项目档案菜单
    @FindBy(className = "projectArchives")
    @CacheLookup
    WebElement projectArchives;
    //项目变更菜单
    @FindBy(className = "projectChange")
    @CacheLookup
    WebElement projectChange;
    //评审记录菜单
    @FindBy(className = "reviewRecordManagement")
    @CacheLookup
    WebElement reviewRecordManagement;
    //项目审批菜单
    @FindBy(className = "projectApproval")
    @CacheLookup
    WebElement projectApproval;
    //项目执行数据菜单
    @FindBy(className = "execute_data")
    @CacheLookup
    WebElement executeData;
}
