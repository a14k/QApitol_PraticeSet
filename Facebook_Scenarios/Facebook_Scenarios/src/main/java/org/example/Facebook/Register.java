package org.example.Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    WebDriver driver;
    public Register(WebDriver driver){
        this.driver= driver;
    }
    public void createAccount()
    {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.name("firstname")).sendKeys("Abc");
        driver.findElement(By.name("lastname")).sendKeys("def");
        driver.findElement(By.name("reg_email__")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("abc@28");
        // Select birthday
        Select day = new Select(driver.findElement((By.name("birthday_day"))));
        day.selectByValue("12");

        Select month = new Select(driver.findElement((By.name("birthday_month"))));
        month.selectByValue("8");

        Select year = new Select(driver.findElement((By.name("birthday_year"))));
        year.selectByValue("1990");

        // Select gender
        driver.findElement(By.xpath("//label[text()='Female']")).click();

    }
}
