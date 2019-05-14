package com.zd.utils;

import io.qameta.allure.Attachment;

public class FileDemo {
    @Attachment(value = "Page screenshot",type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot){
        return screenShot;
    }
}
