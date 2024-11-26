package com.myntra.generic.utility;

import com.google.common.io.Files;
import com.myntra.baseClass.baseClass;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.StandardCopyOption;

public class Utility extends baseClass {

    public void captureScreenShot(AppiumDriver driver, String screenShotName){
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File source= new File(screenshotFile.getAbsolutePath());
            File destination = new File("/sdcard/Download/screenshot.png");
            FileUtils.copyFile(source, destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
