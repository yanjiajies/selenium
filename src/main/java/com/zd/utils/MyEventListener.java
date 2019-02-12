package com.zd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyEventListener  extends AbstractWebDriverEventListener {
    //传入url和driver，当侦听driver访问传入的url后会触发该方法
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("afterNavigateTo"+url);
    }
    //传入driver，当发生back事件时，会触发该方法
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("afterNavigateBack");
    }
    //传入元素和driver，当该元素发生点击事件的时候，会触发该方法
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("afterClickOn"+element.getText());
    }
}
