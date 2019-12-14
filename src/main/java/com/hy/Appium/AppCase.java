package com.hy.Appium;

import com.hy.utils.AllureListener;
import com.hy.utils.ExtentListener;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

@Listeners({AllureListener.class})
public class AppCase {
    AndroidDriver driver;//创建driver对象
    @BeforeClass
    public void init() throws MalformedURLException {
        DesiredCapabilities des =new DesiredCapabilities();//DesiredCapabilities负责启动服务端时的参数配置，启动session的时候必须提供
        des.setCapability("platformName","Android");//配置平台的名称
        des.setCapability("platformVersion","6.0.0");//配置平台的版本
        des.setCapability("udid","192.168.136.101:5555");//连接的物理设备的唯一设备标识(可以通过adb devices命令获取)
        des.setCapability("deviceName","S7");//使用手机类型或者模拟器类型
        //app安装后的包名（在启动app后可以通过'adb shell dumpsys window w |findstr \/ |findstr name='命令获取）
        des.setCapability("appPackage","com.sx.huayuntest");
        des.setCapability("appActivity","com.sx.huayun.activity.login.LoginActivity");//app测试人员常常要获取activity，进行相关测试(获取方法同上)
        des.setCapability("unicodeKeyboard","True");//支持中文输入
        des.setCapability("resetKeyboard","True");//支持中文输入
        //des.setCapability("newCommandTimeout","10");//没有新命令时的超时时间设置
        //A new session could not be created的解决方法
        des.setCapability("appWaitActivity","com.sx.huayun.activity.login.LoginActivity");//Value和appActivity配置一致
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        des.setCapability("sessionOverride", true);
        des.setCapability("nosign", "True");//跳过检查和对应用进行 debug 签名的步骤
        //通过给AndroidDriver对象传入url和DesiredCapabilities配置来构造driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);//虚拟机默认地址
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//元素等待时间
        ExtentListener.driver=driver;
    }
    @Test
    public void testContext() throws InterruptedException {
        //driver.findElement(By.id("com.sx.huayun:id/username_edit")).sendKeys("admin");
        //driver.findElement(By.id("com.sx.huayun:id/password_edit")).sendKeys("123456");
        //driver.findElement(By.id("com.sx.huayun:id/btn_Submit")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","123456");
        SimpleDateFormat smf = new SimpleDateFormat("MMddHHmmss") ;
        String curTime = smf.format(new java.util.Date());
        //将测试的结果输出到测试报告中
        Reporter.log(curTime+"登录测试通过");
        loginPage.assertContain("com.sx.huayun:id/password_edit");

    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
