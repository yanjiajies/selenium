package com.hy.utils;

import io.qameta.allure.Attachment;

public class AllureUploadFile {
    @Attachment(value = "Page screenshot",type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot){
        return screenShot;
    }
}
