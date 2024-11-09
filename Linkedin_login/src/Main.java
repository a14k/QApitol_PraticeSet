import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main
{
 public static <webElement> void main(String args[])throws IOException {
     WebDriver driver = new ChromeDriver();
     String password = "ankambast@28";
     driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
     driver.findElement(By.id("username")).sendKeys("ankita.ambast30@gmail.com");
     driver.findElement(By.id("password")).sendKeys(password);
     driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();
     //driver.findElement(By.xpath("M23 9v2h-2v7a3 3 0 01-3 3h-4v-6h-4v6H6a3 3 0 01-3-3v-7H1V9l11-7z")).click();;
     driver.findElement(By.xpath("//strong[text()=\"Start a post, try writing with AI\"]")).click();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     WebElement postText= driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
     postText.sendKeys("hi everyone Welcome to QAPitol QA");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.findElement(By.id("ember298")).click();


 }

}