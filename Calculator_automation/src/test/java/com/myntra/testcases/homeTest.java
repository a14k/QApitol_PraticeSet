package com.myntra.testcases;


import com.myntra.baseClass.baseClass;
import com.myntra.generic.utility.ExtentReporterNG;
import com.myntra.pages.homePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

@Listeners(ExtentReporterNG.class)
public class homeTest extends baseClass {

    @Test
    public void homeTest() throws IOException {
        homePage hp = new homePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        hp.closeDiag.click();
        hp.image.click();
        hp.sweatshirt.click();
        // Run the adb command to take a screenshot and save it to device's /sdcard/ directory
        Runtime.getRuntime().exec("adb shell screencap -p /sdcard/Pictures/Screenshot/myntra.png");
        log.info("Capturing Screenshot");
        //File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //File source= new File(screenshotFile.getAbsolutePath());
//        File destination = new File("/sdcard/Download/screenshot.png");
//        FileUtils.copyFile(source, destination);
        //Files.copy(source,destination, StandardCopyOption.REPLACE_EXISTING);

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.textBrand.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.buyButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.mSize.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.doneButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.goToBag.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.search.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.searchBox.sendKeys("white H&M tshirt for women");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//        hp.imageContainer.click();
        //hp.brand.click();
    }
}
