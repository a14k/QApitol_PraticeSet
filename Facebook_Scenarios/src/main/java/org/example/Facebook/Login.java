package org.example.Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver)
    {
        this.driver= driver;

    }
    public void letslogin()
    {
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("email")).sendKeys("ankitaambast@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Ank");
        driver.findElement(By.name("login")).click();
    }
}
