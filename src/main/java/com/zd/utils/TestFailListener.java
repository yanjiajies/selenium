package com.zd.utils;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;


public class TestFailListener implements IHookable {
        public static WebDriver driver;
        @Override
        public void run(IHookCallBack callBack, ITestResult testResult) {
            callBack.runTestMethod(testResult);
            if (testResult.getThrowable() != null) {
                try {
                    takeScreenShot(testResult.getMethod().getMethodName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Attachment(value = "Failure in method {0}", type = "image/png")
        private byte[] takeScreenShot(String methodName) throws IOException {
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screenshot);
        }
}