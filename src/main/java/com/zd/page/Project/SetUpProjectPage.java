package com.zd.page.Project;
/**
 * 立项基本信息页面
 */

import com.zd.page.BasePage;
import com.zd.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SetUpProjectPage extends BasePage {
    //综合计划
    @FindBy(id = "projectname")
    WebElement projectName;
    //选择综合计划(单选框)
    @FindBy(xpath = "//*[@id=\"projectSelectDiv\"]/table/tbody/tr[2]/td[1]/input")
    WebElement comprehensivePlanRadio;
    //选择综合计划(确定)
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[1]")
    WebElement determine;
    //选择综合计划(查询框)
    @FindBy(xpath = "//*[@id=\"projectName\"]")
    WebElement projectNamePlan;
    //选择综合计划(关闭)
    @FindBy(xpath = "//*[@id=\"layui-layer1\"]/div[3]/a[2]")
    WebElement close;
    //项目级别(select)
    @FindBy(id = "projLevel")
    WebElement projLevel;
    //项目类型(select)
    @FindBy(id = "projType")
    WebElement projType;
    //业务产品类别
    @FindBy(xpath = "//*[@id=\"productType\"]")
    WebElement productType;
    //项目名称
    @FindBy(id = "gsProjName")
    WebElement gsProjName;
    //项目简称
    @FindBy(id = "projNameShort")
    WebElement projNameShort;
    //申请部门
    @FindBy(id = "applyDept")
    WebElement applyDept;
    //选择申请部门(双击事件)
    @FindBy(id = "rolePermissionTree_1_span")
    WebElement rolePermissionTree_1_span;
    //选择一级部门(双击事件)事业部
    @FindBy(xpath = "//*[@id=\"rolePermissionTree_2_span\"]")
    WebElement rolePermissionTree_2_span;
    //选择二级部门(双击事件)GP
    @FindBy(xpath = "//*[@id=\"rolePermissionTree_21_span\"]")
    WebElement rolePermissionTree_21_span;
    //选择申请部门确认按钮
    @FindBy(xpath = ".//*[@class='layui-layer-btn0']")
    WebElement determineTree;
    //项目经理
    @FindBy(id = "projManagerName")
    WebElement projManagerName;
    //协同部门
    @FindBy(name = "assistDept")
    WebElement assistDept;
    //选择协同部门(点击选择)
    @FindBy(id = "rolePermissionTree_1_check")
    WebElement rolePermissionTree_1_check;
    //选择协同部门确认按钮
    @FindBy(xpath = ".//*[@class='layui-layer-btn0']")
    WebElement assistDeptDetermine;
    //项目实施地
    @FindBy(id = "estimatedPlace")
    WebElement estimatedPlace;
    //客户经理
    @FindBy(id = "customerManager")
    WebElement customerManager;
    //合同签署状况
    @FindBy(id = "constract")
    WebElement constract;
    //客户单位
    @FindBy(id = "clientUnit")
    WebElement clientUnit;
    //客户单位联系人
    @FindBy(id = "clientProjManager")
    WebElement clientProjManager;
    //预计投入人数
    @FindBy(id = "estimatedLabor")
    WebElement estimatedLabor;
    //预计工作量
    @FindBy(id = "estimatedWork")
    WebElement estimatedWork;
    //预计项目开始时间(2018-08-01)
    @FindBy(id = "beginDate")
    WebElement beginDate;
    //预计项目结束时间(2018-08-01)
    @FindBy(id = "endDate")
    WebElement endDate;
    //项目目标
    @FindBy(id = "projGoal")
    WebElement projGoal;
    //项目介绍
    @FindBy(id = "projContent")
    WebElement projContent;
    //请填写预期进度安排及相关产出
    @FindBy(id = "estimatedSchedule")
    WebElement estimatedSchedule;
    //项目交付验收标准
    @FindBy(id = "projAcceptanceStandard")
    WebElement projAcceptanceStandard;
    //其他说明
    @FindBy(id = "remark")
    WebElement remark;
    //选择附件(使用Autoit工具)
    @FindBy(xpath = "//*[@id=\"project\"]/div[15]/div/input[2]")
    WebElement projectEnclosure;
    //下一步按钮
    @FindBy(xpath = "//*[@id=\"addProjectArchivesForm\"]/div[3]/input[1]")
    WebElement next;
    //取消按钮
    @FindBy(xpath = "//*[@id=\"addProjectArchivesForm\"]/div[3]/input[2]")
    WebElement cancel;
    Utils utils=new Utils();
    //调用父类的构造方法进行初始化（PageFactor使用对象的时候需要先初始化Page类）
    public SetUpProjectPage(WebDriver driver) {
        super(driver);
    }

    //初始化，并检验页面title与预期title是否一致
    public SetUpProjectPage(WebDriver driver, String titile) {
        super(driver, titile);
    }

    //输入立项基本信息
    public void projectInformation(String product_type, String gsProj_name, String proj_name_short,
                                   String proj_manager_name, String estimated_place, String customer_manager,
                                   String constract_info, String client_unit, String client_proj_manager, String estimated_labor,
                                   String estimated_work, String begin_date, String end_date, String proj_goal,
                                   String proj_content, String estimated_schedule, String proj_acceptance_standard,
                                   String remark_inof) {
        projectName.click();
        comprehensivePlanRadio.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        determine.click();
        utils.rl(projLevel);
        utils.rl(projType);
        productType.sendKeys(product_type);
        gsProjName.sendKeys(gsProj_name);
        projNameShort.sendKeys(proj_name_short);
        applyDept.click();
        Actions actions = new Actions(driver);
        actions.doubleClick(rolePermissionTree_1_span).perform();
        actions.doubleClick(rolePermissionTree_2_span).perform();
        rolePermissionTree_21_span.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        determineTree.click();
        projManagerName.sendKeys(proj_manager_name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assistDept.click();
        rolePermissionTree_1_check.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assistDeptDetermine.click();
        estimatedPlace.sendKeys(estimated_place);
        customerManager.sendKeys(customer_manager);
        constract.sendKeys(constract_info);
        clientUnit.sendKeys(client_unit);
        clientProjManager.sendKeys(client_proj_manager);
        estimatedLabor.sendKeys(estimated_labor);
        estimatedWork.sendKeys(estimated_work);
        beginDate.sendKeys(begin_date);
        endDate.sendKeys(end_date);
        projGoal.sendKeys(proj_goal);
        projContent.sendKeys(proj_content);
        estimatedSchedule.sendKeys(estimated_schedule);
        projAcceptanceStandard.sendKeys(proj_acceptance_standard);
        remark.sendKeys(remark_inof);
        projectEnclosure.click();
        //上传文件使用Autoit工具
        Runtime rn = Runtime.getRuntime();
        try {
            String filePath = "C:\\Users\\Administrator\\Desktop\\uploadFile.exe";
            //执行uploadFile.exe
            rn.exec(filePath);
            Reporter.log("文件上传成功");
        } catch (Exception e) {
            Reporter.log("文件上传失败");
        }
        //保证上传完成已经再点击保存，必须要等待
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //next.click();
    }
}
