package com.hy.testcase.test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class ReadUtile {
    public static void main(String[] args) {
        File imageFile = new File("./Test1/111.jpg");
        Tesseract tessreact = new Tesseract();
        tessreact.setDatapath("F:/tessdata");
        try {
            String result = tessreact.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

    }}