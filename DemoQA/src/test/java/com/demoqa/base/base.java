package com.demoqa.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {


    public WebDriver driver;
    @BeforeClass
    public void beforeTest() throws IOException {
        driver = new ChromeDriver();
        System.out.println("Before Test");
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterClass
    public void afterTest(){
        System.out.println("After Test");
        // driver.close();
    }

}