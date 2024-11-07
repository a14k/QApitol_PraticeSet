import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class Main
{
 public static void main(String args[])throws IOException
 {
     WebDriver driver=new ChromeDriver();
     String password ="ankambast@28";
     driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
     driver.findElement(By.id("username")).sendKeys("ankita.ambast30@gmail.com");
     driver.findElement(By.id("password")).sendKeys(password);
     driver.findElement(By.xpath("//button[@aria-label='Sign in']")).click();
     driver.close();
 }
}