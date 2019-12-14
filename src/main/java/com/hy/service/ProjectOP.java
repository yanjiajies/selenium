package com.hy.service;

import com.hy.page.Project.ProjectApplicationPage;
import com.hy.page.Project.SetUpProjectPage;
import org.openqa.selenium.WebDriver;

public class ProjectOP {
    WebDriver driver;
    ProjectApplicationPage pap;
    SetUpProjectPage setUpProjectPage;

    public ProjectOP(WebDriver driver){
        this.driver=driver;
        pap=new ProjectApplicationPage(driver);
        setUpProjectPage = new SetUpProjectPage(driver);
    }
    public void proAppl(){
        pap.proAppl();
    }
    public void setUpProject(String product_type,String gsProj_name,String proj_name_short,
                             String proj_manager_name,String estimated_place,String customer_manager,
                             String constract_info,String client_unit,String client_proj_manager,String estimated_labor,
                             String estimated_work,String begin_date,String end_date,String proj_goal,
                             String proj_content,String estimated_schedule,String proj_acceptance_standard,
                             String remark_inof){
        setUpProjectPage.projectInformation(product_type,gsProj_name,proj_name_short,
                proj_manager_name,estimated_place,customer_manager,
                constract_info,client_unit,client_proj_manager,estimated_labor,
                estimated_work,begin_date,end_date,proj_goal,
                proj_content,estimated_schedule,proj_acceptance_standard,
                remark_inof);
    }

}
