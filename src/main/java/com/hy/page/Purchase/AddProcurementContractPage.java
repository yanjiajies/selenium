package com.hy.page.Purchase;

import com.hy.page.BasePage;
import com.hy.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.logging.Logger;


/**
 * 新增采购合同页
 */
public class AddProcurementContractPage extends BasePage{
    Utils utils =new Utils();
    //合同编号
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[1]/div[1]/input")
    WebElement contractNum;
    //K2编号
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[1]/div[2]/input")
    WebElement K2Num;
    //合同名称
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[2]/div[1]/input")
    WebElement contractName;
    //合同签订金额
    @FindBy(id = "signmoney2")
    WebElement amountContracted;
    //签订人
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[3]/div[1]/input")
    WebElement signedPerson;
    //签订日期
    @FindBy(id = "signingDate")
    WebElement signingDate;
    //合同开始时间
    @FindBy(name = "contractStartDate")
    WebElement contractStartDate;
    //合同结束时间
    @FindBy(name = "contractEndDate")
    WebElement contractEndDate;
    //*[contains(@onclick, 'x64_3.01.3730.spkg') and @name='delete'] contains中的条件可以用and
    //采购专员to6()
    @FindBy(xpath = "//*[contains(@onclick, 'to6')]")
    List<WebElement> purchaseBuyers;
    //选择采购专员单选框
    @FindBy(id="executor")
    List<WebElement> executors;
    //采购专员弹框确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer4\"]/div[3]/a[1]")
    WebElement executorDetermine;
    //供应商
    @FindBy(xpath = "//*[contains(@onclick, 'selectsupplier')]")
    WebElement supplie;
    //供应商勾选框
    @FindBy(xpath = "//*[@id=\"supplierSelectList_frozen\"]/tbody/tr[2]")
    WebElement choiceSupplie;
    //供应商确定按钮
    @FindBy(xpath = "//*[@id=\"layui-layer5\"]/div[3]/a[1]")
    WebElement determine;
    //供应商联系人
    @FindBy(name = "supplierContactsName")
    WebElement supplierContactsName;
    //联系电话
    @FindBy(name = "contactsPhone")
    WebElement contactsPhone;
    //是否质保金Select
    @FindBy(name = "whetherWarrantyGold")
    WebElement whetherWarrantyGold;
    //质保金
    @FindBy(id = "warrantyGold2")
    WebElement warrantyGold2;
    //质保条件期限
    @FindBy(name = "warrantyInfo")
    WebElement warrantyInfo;
    //是否框架合合同Select
    @FindBy(name = "frameworkContract")
    WebElement frameworkContract;
    //付款方式Select
    @FindBy(name = "paymentMethod")
    WebElement paymentMethod;
    //付款方式说明
    @FindBy(name = "paymentMethodExplain")
    WebElement paymentMethodExplain;
    //决算金额
    @FindBy(id="finalAmount2")
    WebElement finalAmount2;
    //合同流程编号
    @FindBy(name="contractSignNum")
    WebElement contractSignNum;
    //合同扫描件
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[11]/div/input[2]")
    WebElement contractEnclosure;
    //其他附件
    @FindBy(xpath = "//*[@id=\"procurementContractAddDiv\"]/div[12]/div/input[2]")
    WebElement otherEnclosure;
    //采购类型
    @FindBy(id = "type")
    WebElement type;
    //关联采购需求选择按钮
    @FindBy(xpath = "//*[contains(@onclick, 'selectDemand')]")
    WebElement selectDemand;
    //关联采购需求选择框
    @FindBy(xpath = "//*[@id=\"demandSelectList_frozen\"]/tbody/*[contains(@role, 'row')]")
    List<WebElement> selectDemandxzs;
    //关联项目选择按钮selectProject
    @FindBy(xpath = "//*[contains(@onclick, 'selectProject')]")
    WebElement selectProject;
    //关联项目选择框
    @FindBy(xpath = "//*[@id=\"projectSelectList_frozen\"]/tbody/*[contains(@role, 'row')]")
    List<WebElement> projectSelect;
    //关联确认按钮
    @FindBy(xpath = "//*[@id=\"layui-layer6\"]/div[3]/a[1]")
    WebElement determine8;
    //采购项(先关联采购需求或者项目)
    @FindBy(id = "purchaseItemSlt")
    WebElement purchaseItemSlt;
    //提交按钮
    @FindBy(xpath = "//*[contains(@onclick, 'formSubmit(1)')]")
    WebElement formSubmit;
    //提交确认
    @FindBy(xpath = "//*[@id=\"layui-layer7\"]/div[3]/a[1]")
    WebElement determine6;

    public AddProcurementContractPage(WebDriver driver) {
        super(driver);
    }
    public AddProcurementContractPage(WebDriver driver, String titile) {
        super(driver, titile);
    }
    public void addProcurementContract(String contract_num,String K2_num,String contract_name,String amount_contracted,
                                       String signed_person,String signing_date,String crt_startDate,String crt_endDate,
                                       String purchase_buyer,String contacts_name,String contacts_phone,String qualityAssuranceAcc,
                                       String warranty_info,String payment_explain,String final_Amount,String contract_Sign_Num,String purchaseType){
        contractNum.sendKeys(contract_num);
        K2Num.sendKeys(K2_num);
        contractName.sendKeys(contract_name);
        amountContracted.clear();
        amountContracted.sendKeys(amount_contracted);
        signedPerson.sendKeys(signed_person);
        try {
            Thread.sleep(5000);
            purchaseBuyers.get(0).click();
            Thread.sleep(1000);
            executors.get(0).click();
        } catch (InterruptedException e) {
            purchaseBuyers.get(0).click();
        }
        executorDetermine.click();
        signingDate.sendKeys(signing_date);
        contractStartDate.sendKeys(crt_startDate);
        contractEndDate.sendKeys(crt_endDate);
        supplie.click();
        choiceSupplie.click();
        determine.click();
        supplierContactsName.sendKeys(contacts_name);
        contactsPhone.sendKeys(contacts_phone);
        utils.rl(whetherWarrantyGold);
        warrantyGold2.clear();
        warrantyGold2.sendKeys(qualityAssuranceAcc);
        warrantyInfo.sendKeys(warranty_info);
        utils.rl(frameworkContract);
        utils.rl(paymentMethod);
        paymentMethodExplain.sendKeys(payment_explain);
        finalAmount2.clear();
        finalAmount2.sendKeys(final_Amount);
        contractSignNum.sendKeys(contract_Sign_Num);
        contractEnclosure.click();
        try {
            utils.fileUploadRobot("");
            otherEnclosure.click();
            utils.fileUploadRobot("");
        } catch (Exception e) {
            Logger.getLogger("上传附件失败");
        }
        utils.rl(type,purchaseType);
        //selectProject.click();
        selectDemand.click();
        try {
            Thread.sleep(2000);
            //projectSelect.get(1).click();
            selectDemandxzs.get(1).click();
        } catch (InterruptedException e) {
            //projectSelect.get(1).click();
            selectDemandxzs.get(1).click();
        }
        determine8.click();
        //utils.rl(purchaseItemSlt);
        formSubmit.click();
        determine6.click();
    }
}

