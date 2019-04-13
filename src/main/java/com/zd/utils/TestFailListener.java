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


                public class TestFailListener extends TestListenerAdapter {
                    public static WebDriver driver;
                    @Override
                    public void onTestFailure(ITestResult result) {
                        takePhoto();
                    }

                    @Attachment(value = "screen shot",type = "image/png")
                    public byte[]  takePhoto(){
                        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                        return screenshotAs;
                    }

                }