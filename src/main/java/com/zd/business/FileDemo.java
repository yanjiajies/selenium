package com.zd.business;

import io.qameta.allure.Attachment;

public class FileDemo {
    @Attachment(value = "Page screenshot",type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot){
        return screenShot;
    }
}
