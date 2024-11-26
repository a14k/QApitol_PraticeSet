package com.myntra.baseClass;

import com.myntra.generic.utility.Utility;
import com.myntra.testcases.homeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class baseClass {
    public AppiumDriver driver;
    public Utility utility;
    public static Logger log = Logger.getLogger(baseClass.class.getName());
    @BeforeMethod
    public void setUp() throws MalformedURLException, URISyntaxException {

        Properties props = System.getProperties();
//        System.out.println("Current working directory is " + props.getProperty("user.dir"));
        PropertyConfigurator.configure(props.getProperty("user.dir")+ "\\src\\main\\resources\\properties\\log4j.properties");
//        C:\Users\Qapitol\IdeaProjects\Calculator_automation\src\main\resources\properties\log4j.properties
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ANDROID");
        caps.setCapability("platformVersion", "15");
        caps.setCapability("deviceName", "Pixel 7a");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("appPackage", "com.myntra.android");
        caps.setCapability("appActivity", "com.myntra.android.activities.react.ReactActivity ");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        log.info("Initializing Appium Driver...");
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Terminating Appium Driver...");
        }
    }

}
