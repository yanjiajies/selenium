package com.zd.utils;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;


public class TestFailListener extends TestListenerAdapter {
        public  static WebDriver driver;

        public class AllureReporterListener implements IHookable {

            @Override
            public void run(IHookCallBack callBack, ITestResult testResult) {

                callBack.runTestMethod(testResult);
                if (testResult.getThrowable() != null) {
                    try {
                        takeScreenShot(testResult.getMethod().getMethodName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            @Attachment(value = "Failure in method {0}", type = "image/png")
            private byte[] takeScreenShot(String methodName) throws IOException {

                return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            }
        }

    }