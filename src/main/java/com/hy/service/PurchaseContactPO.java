package com.hy.service;
/**
 * SoftAssert软断言，与硬断言不同的是软断言在断言失败后会继续执行。
 */

import com.hy.page.Purchase.*;
import com.hy.page.Purchase_VUE.PurchaseSheetPage;
import org.openqa.selenium.WebDriver;


public class PurchaseContactPO {
    WebDriver driver;
    //将所有所涉及到的Page定义为逻辑层的成员变量（属性）
    private PurchaseContactPage pcp;
    private PurchaseNumberPage purchaseNumberPage;
    private PurchaseSheetPage psp;
    private ApprovalPage ap;
    private PurchaseMainPage pmp;
    private PurchasingDemandPage pdp;
    private ProcurementContractPage prcp;
    private AddProcurementContractPage apcp;
    private TicketRecordPage trp;
    private InvoiceEntryPage iep;
    private PaymentApprovalSheetPage pasp;
    private AddPaymentApprovalPage apap;
    private RecordPaymentPage rpp;
    private MaterialFillPage mfp;
    private HumanFillPage hfp;
    private ProcureReviewPage prp;
    public PurchaseContactPO(WebDriver driver) {
        this.driver = driver;
        purchaseNumberPage =new PurchaseNumberPage(driver);
        pcp = new PurchaseContactPage(driver);
        psp = new PurchaseSheetPage(driver);
        ap=new ApprovalPage(driver);
        pmp=new PurchaseMainPage(driver);
        pdp=new PurchasingDemandPage(driver);
        prcp=new ProcurementContractPage(driver);
        apcp=new AddProcurementContractPage(driver);
        trp=new TicketRecordPage(driver);
        iep=new InvoiceEntryPage(driver);
        pasp=new PaymentApprovalSheetPage(driver);
        apap=new AddPaymentApprovalPage(driver);
        rpp=new RecordPaymentPage(driver);
        mfp=new MaterialFillPage(driver);
        hfp=new HumanFillPage(driver);
        prp=new ProcureReviewPage(driver);
    }
    public void itemSelection(String name) {
        pcp.sheetInfo();
        psp.fillInfo(name);
//        (typeName.equals("service")){
//            pfp.fillInfo(contact_number, estimated_amount, task_name, demand_time,
//                    packet_number, incoming_amount, warranty_period, service_period,
//                    conditions, project_background, remark);
//            pcp.submissionA(typeName);
//            //移入评审
//            //pcp.moveInto();
//        }else  (typeName.equals("material")){
//            mfp.fillInfo(contact_number,estimated_amount,task_name,demand_time,
//                    packet_number,incoming_amount,warranty_period,service_period,
//                    conditions,project_background,remark,t_name,t_st,
//                    t_number,t_unit,t_remark);
//            pcp.submissionA(typeName);
//        }else  (typeName.equals("human")){
//            hfp.fillInfo(contact_number,estimated_amount,task_name,demand_time,
//                    packet_number,incoming_amount,warranty_period,service_period,
//                    conditions,demand_des,remark);
//            pcp.submissionA(typeName);
//        }else  (typeName.equals("engineer")){
//            pfp.fillInfo(contact_number, estimated_amount, task_name, demand_time,
//                    packet_number, incoming_amount, warranty_period, service_period,
//                    conditions, project_background, remark);
//            pcp.submissionA(typeName);
//        }
    }

    public void toExamination(){
        ap.toAgree();
    }
    public void fillPurNumber(String purNum,String purjob){
//        pcp.fillPurchaseNumber();
        purchaseNumberPage.fillPurchasenNum(purNum,purjob);
    }
    //
    public void implementationReq(String operation,String signNum){
        pdp.fillSignNumbers(operation,signNum);
    }
    //选择菜单(采购管理系统)
    public void selectionMenu(String menu){
        pmp.selectionMenu(menu);
    }
    public void contract(){
        prcp.contractOperation();
    }
    //新增采购合同
    public void addPurchaseContract(String contract_num,String K2_num,String contract_name,String amount_contracted,
                                    String signed_person,String signing_date,String crt_startDate,String crt_endDate,
                                    String purchase_buyer,String contacts_name,String contacts_phone,String qualityAssuranceAcc,
                                    String warranty_info,String payment_explain,String final_Amount,String contract_Sign_Num,String purchaseType){
        apcp.addProcurementContract(contract_num,K2_num,contract_name,amount_contracted,
                signed_person,signing_date,crt_startDate,crt_endDate,
                purchase_buyer,contacts_name,contacts_phone,qualityAssuranceAcc,
                warranty_info,payment_explain,final_Amount,contract_Sign_Num,purchaseType);

    }
    //新增来票
    public void addInvoice(String invoiceNum,String invoiceMoney_taxes,String invoice_data){
        trp.invoiceAdd();
        iep.toInvoiceEntry(invoiceNum,invoiceMoney_taxes,invoice_data);
    }
    //新增支付审批单
    public void addPaymentApproval(String type,String paymoney,String admissionrequ,String project_schedule,String pay_mentreason,
                                   String res){
        pasp.addPaymentApproval(type);
        apap.addPaymentApproval(paymoney,admissionrequ,project_schedule,pay_mentreason,res);
    }
    //确认付款
    public void payment(String checkdata){ rpp.toConfirmPayment(checkdata); }
    //评审审批移入
//    public void toAddReview(){ pcp.addReview(); }
    //评审审批移出
//    public void toDelReview(){ pcp.delReview(); }
    //新增评审记录

    //采购评审通过
    public void  reviewAdopt(String meeting_name,String meeting_site,String meeting_time){
        prp.reviewAdopt(meeting_name,meeting_site,meeting_time);
    }
    //采购评审退回
}
