package com.hy.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class AllureListener extends TestListenerAdapter {
    public static WebDriver driver;

    //重写父类onTestFailure方法，通过监听器，每次失败的时候调用该方法
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        try {
            takeScreenShot(tr.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //重写父类onTestSuccess方法，每次执行成功时调用该方法
    @Override
    public void  onTestSuccess(ITestResult tr){
        super.onTestSuccess(tr);
        Reporter.log("Success,Nice");
    }

    //重写父类onTestStart方法,每次调用测试之前调用。
    @Override
    public void onTestStart(ITestResult tr){
        super.onTestStart(tr);
    }

    //执行失败报错方法，截图保存，并放到测试报告中
    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) throws IOException {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}