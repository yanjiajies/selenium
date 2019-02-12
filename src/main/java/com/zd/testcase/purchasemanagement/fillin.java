package com.zd.testcase.purchasemanagement;

import com.zd.utils.Common;
import com.zd.utils.Utils;
import org.testng.Reporter;
import java.util.Map;

/**
 * 采购
 */
public class fillin {
    public static void getfillin(String str)throws InterruptedException{
        Utils utils = new Utils();
        Map<String,String> dmap= utils.getdate();
        Common common=new Common();
        //登陆系统
        common.sendKeys("xpath",".//*[@id='account']","jj");
        common.sendKeys("xpath",".//*[@id='password']","123456");
        common.click("xpath",".//*[@id='submit']");
        Thread.sleep(2000);
        common.click("linkText","采购管理系统");
        common.click("xpath","//*[@id=\"lockOrUnLockUser\"]");
        //选择服务
        common.click("xpath",str);
        common.click("xpath","//*[@id=\"addPurchaseApplyForm\"]/div[1]/div[3]/input");
        Thread.sleep(2000);
        //选择项目中的动态id，后期链接数据库随机取值
        common.click("id","d79f4300d14a48039db91edd5226b10f");
        Thread.sleep(2000);
        common.click("xpath","//*[@id=\"layui-layer1\"]/div[3]/a[1]");
        common.sendKeys("name","contactNumber",dmap.get("TEL"));
//        utils.rl("//*[@id=\"purchaseItemSlt\"]");
//        utils.sendKeys("xpath","//*[@id=\"estimatedAmount2\"]","10000");
//        utils.sendKeys("id","textXuqiu",Utils.newDate());
//        utils.rl("//*[@id=\"addPurchaseApplyForm\"]/div[7]/div[1]/select");
//        utils.rl("//*[@id=\"addPurchaseApplyForm\"]/div[7]/div[2]/select");
//        utils.rl("//*[@id=\"addPurchaseApplyForm\"]/div[8]/div[2]/select");
        common.sendKeys("name","provisionalPacketNumber","10000");
        common.sendKeys("xpath","//*[@id=\"incomingAmount2\"]","10000");
        common.sendKeys("xpath","//*[@id=\"addPurchaseApplyForm\"]/div[9]/div[2]/input",String.valueOf((int)(10+Math.random()*(20-10+1))));
        common.sendKeys("xpath","//*[@id=\"addPurchaseApplyForm\"]/div[9]/div[2]/input",String.valueOf((int)(10+Math.random()*(20-10+1))));
        common.sendKeys("name","servicePeriod",String.valueOf((int)(10+Math.random()*(20-10+1))));
        common.click("name","purchaseBasis");
        common.sendKeys("name","qualificationConditions","略略略");
        common.sendKeys("name","projectBackground","略略略");
        common.click("xpath","//*[@id=\"addPurchaseApplyForm\"]/div[15]/div/input[2]");
        //上传文件使用Autoit工具
        Runtime rn = Runtime.getRuntime();
        try {
            String filePath="C:\\Users\\Administrator\\Desktop\\uploadFile.exe";
            //执行uploadFile.exe
            rn.exec(filePath);
            Reporter.log("文件上传成功");
        } catch (Exception e) {
            Reporter.log("文件上传失败");
        }
        //保证上传完成已经再点击保存，必须要等待
        Thread.sleep(2000);
        //保存为草稿
        common.click("xpath","//*[@id=\"addPurchaseApplyForm\"]/div[16]/input[2]");
        //断言
        //Assert.
    }
}