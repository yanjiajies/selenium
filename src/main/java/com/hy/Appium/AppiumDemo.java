package com.hy.Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDemo {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver;
        DesiredCapabilities des = new DesiredCapabilities();
        //    des.setCapability("automationName", "Appium");//Selendroid //自动化的模式选择
        //    des.setCapability("app", "C:\\software\\CalcTest.apk");//配置待测试的apk的路径
        //    des.setCapability("browserName", "chrome");  //h5
        des.setCapability("platformName", "Android");//平台名称
        des.setCapability("platformVersion", "6.0.0");//手机操作系统版本
        des.setCapability("udid", "192.168.115.101:5555");//连接的物理设备的唯一设备标识
        des.setCapability("deviceName", "S7");//使用的手机类型或模拟器类型  UDID
        des.setCapability("appPackage", "com.android.calculator2");//App安装后的包名,注意与原来的CalcTest.apk不一样
        des.setCapability("appActivity", "com.android.calculator2.Calculator");//app测试人员常常要获取activity，进行相关测试,后续会讲到
//        des.setCapability("unicodeKeyboard", "True");//支持中文输入
//        des.setCapability("resetKeyboard", "True");//支持中文输入
//        des.setCapability("newCommandTimeout", "10");//没有新命令时的超时时间设置
        //A new session could not be created的解决方法
        des.setCapability("appWaitActivity","com.android.calculator2.Calculator");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        des.setCapability("sessionOverride", true);
        des.setCapability("nosign", "True");//跳过检查和对应用进行 debug 签名的步骤

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();//定位'1'
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();//定位'+'
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();//定位'6'
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();//定位'='
    }
}
