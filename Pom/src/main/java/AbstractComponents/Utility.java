package UTILITY;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
WebDriver driver;
    public Utility(WebDriver driver) {
        this.driver=driver;
    }

    public  void  wait1(String Xpath) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
    }
    public  void scroll(int val,int val1) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + val + "," + val1 + ")");

    }
    public static void select(WebElement Webelementyear , WebElement WebElementmonth, String Month, String Year){
        Select selectyear = new Select(Webelementyear);
        selectyear.selectByVisibleText(Year);
        Select selectmonth = new Select(WebElementmonth);
        selectmonth.selectByVisibleText(Month);
    }

}
