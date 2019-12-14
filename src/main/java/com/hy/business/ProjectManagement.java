package com.hy.business;

import com.hy.page.HomePage;
import com.hy.service.ProjectOP;
import com.hy.utils.Common;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class ProjectManagement {
    private Common common = new Common();
    private WebDriver driver;

    //必须install，要不然不会将testNG里的browser赋值进去
    @Parameters({"browser", "nodeUrl"})
    @BeforeClass
    public void beforeMethod(String browser, String nodeUrl) throws InterruptedException, MalformedURLException {
//        if (browser.equals("Chrome")) driver = common.openChrome();
//        else if (browser.equals("FireFox")) driver = common.openFireFox();
//        else System.out.println("browser参数有误，只支持Chrome和FireFox");
        driver.get(nodeUrl);
    }
    @Test
    public void setUpProject(){
        //LoginOP loginOP =new LoginOP(driver);
       // loginOP.toLogin("jj","123456");
        HomePage homePage=new HomePage(driver);
        homePage.homeMenu("项目管理系统");
        ProjectOP projectOP =new ProjectOP(driver);
        projectOP.proAppl();
        projectOP.setUpProject("2018年EC事业部华东区财务业务线项目",
                "2017年浙江省电力公司基于大数据平台的资金预算管理辅助决策分析建设-开发实施项目",
                "诸北500kV变电站220kV送出工程",
                "崔术清","绍兴","662891",
                "收到施工技术联系单","浙江省送变电工程公司","张杰锋","2人",
                "2","2017-12-01","2018-12-31","项目目标：本期在诸北变安装2套光传输设备，站内光缆余缆箱的安装及变电所内进场光缆敷设、熔接测试等，对端站点白塔变、柯城变、江桃变需各扩充光接口板，站内光缆余缆箱的安装及变电所内进场光缆敷设、熔接测试等，变电所业务接入时配合等工作。",
                "项目简介：基建项目诸北500kV变电站220kV送出工程应浙江省送变电工程公司专业分包给浙江华云信息科技有限公司IC事业部完成在诸北变安装2套光传输设备，站内光缆余缆箱的安装及变电所内进场光缆敷设、熔接测试等，对端站点白塔变、柯城变、江桃变需各扩充光接口板，站内光缆余缆箱的安装及变电所内进场光缆敷设、熔接测试等，变电所业务接入时配合等工作，本工程包工包料具体费用以审计按实决算为准。",
                "预期进度安排及相关产出：根据现场基建施工需要完成，通信设备安装部分满足业主进度目标要求，按时完成业主阶段性进度计划和验收工作。",
                "项目交付验收标准：符合本公司自检自评施工质量优良，符合《浙江省电力公司通信工程质量》建设要求和通信站达标和创一流的建设要求。",
                "自动化");
    }
}
