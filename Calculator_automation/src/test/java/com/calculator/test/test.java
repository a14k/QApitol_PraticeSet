package com.calculator.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class test {
    public AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "ANDROID");
            caps.setCapability("platformVersion", "14");
            caps.setCapability("deviceName", "OnePlus");
            caps.setCapability("automationName", "UIAutomator2");
            caps.setCapability("appPackage", "com.oneplus.calculator");
            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
            caps.setCapability("udid", "45efc30");
            caps.setCapability("ignoreHiddenApiPolicyError", "true");
            caps.setCapability("noReset", "true");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

//    @BeforeClass
//    public void emulatorSetup() throws MalformedURLException, URISyntaxException, InterruptedException {
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "ANDROID");
//        caps.setCapability("platformVersion", "15");
//        caps.setCapability("deviceName", "Pixel 7a");
//        caps.setCapability("automationName", "UIAutomator2");
//        caps.setCapability("appPackage", "com.myntra.android");
//        caps.setCapability("appActivity", "com.myntra.android.SplashActivity");
//        caps.setCapability("app", "C:\\Users\\Qapitol\\Downloads\\com.myntra.android_80110384_apps.evozi.com.apk");
////        caps.setCapability("udid", "45efc30");
////        caps.setCapability("ignoreHiddenApiPolicyError", "true");
////        caps.setCapability("noReset", "true");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
//        Thread.sleep(10000);
//        WebElement studio = driver.findElement(By.xpath(
//                "//android.widget.Button[@content-desc=\"tabButton_studio\"]"));
//        studio.click();
//    }

    @Test
    public void calc_add() {
        driver.findElement(By.id("com.oneplus.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.oneplus.calculator:id/img_op_add")).click();
        driver.findElement(By.id("com.oneplus.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.oneplus.calculator:id/eq")).click();
        WebElement resultField = driver.findElement(By.id("com.oneplus.calculator:id/result"));
        String result = resultField.getText();
        System.out.println(result);
        Assert.assertEquals(result, "4", "The addition result is incorrect!");

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}