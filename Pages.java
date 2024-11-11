package page;

import com.demoqa.base.base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class Pages extends base {
    @Test
    public void textbox() throws InterruptedException {
        base.wait1("//input[@class=' mr-sm-2 form-control']");
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.xpath("//input[@class=' mr-sm-2 form-control']")).sendKeys("Ankita");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Address");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("permananent Address");
        //driver.findElement(By.xpath("//button[@id='submit']")).click();
        base.scroll(0, 200);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test
    public void check() throws InterruptedException {

        base.wait1("//li[@class='btn btn-light active']");
        driver.findElement(By.id("item-1")).click();
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        boolean selected = driver.findElement(By.xpath("//span[@class='rct-checkbox']")).isEnabled();
        Assert.assertTrue(selected);
    }

    @Test
    public void raidobutton() {
        driver.findElement(By.id("item-2")).click();

        base.scroll(0, 200);
        wait1("//label[@for='yesRadio']");
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
    }

    @Test
    public void button() {
        base.scroll(0, 200);
        driver.findElement(By.id("item-4")).click();

        base.scroll(0, 200);
        base.wait1("//div[@class='header-wrapper']");


        Actions act = new Actions(driver);
        WebElement doubleclick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        act.doubleClick(doubleclick).build().perform();
        WebElement rightclick = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightclick).build().perform();
        WebElement click = driver.findElement(By.xpath("//button[@class='btn btn-primary'][.='Click Me']"));
        act.click(click).build().perform();
    }

    @Test
    public void links() {
        base.scroll(0, 200);
        driver.findElement(By.id("item-5")).click();
        base.scroll(0, 200);

        List<WebElement> link = driver.findElements(By.xpath("//p/a"));
        for (int i = 0; i < link.size(); i++) {
            link.get(i).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

    }

    @Test
    public void brokenLinks() throws IOException, InterruptedException {
        base.scroll(0, 500);
        driver.findElement(By.id("item-6")).click();

        List<WebElement> Links = driver.findElements(By.xpath("//p/following-sibling::a"));

        for (WebElement link : Links) {

            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("HEAD");

            conn.connect();

            int repcode = conn.getResponseCode();

            System.out.println(conn.getResponseCode());


        }
    }
    @Test
    public void Pratice_form()
    {
        base.scroll(0, 500);
        driver.findElement(By.xpath("(//div[@class='header-wrapper'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Ankita");
        driver.findElement(By.id("lastName")).sendKeys("Laki");
        driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        WebElement dateField = driver.findElement(By.id("dateOfBirthInput"));
        dateField.sendKeys("1999-15-04");
        driver.findElement(By.id("subjectsContainer")).sendKeys("Selenium, java , TestNG");
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
        driver.findElement(By.id("currentAddress")).sendKeys("123 laxmi appt");
        WebElement image_Upload = driver.findElement(By.id("imageUpload"));
        image_Upload.sendKeys("\"C:\\Users\\Qapitol\\Downloads\\shared image.jpg\"");
        WebElement dropDown = driver.findElement(By.id("state"));
        Select stateSelect = new Select(dropDown);
        stateSelect.selectByVisibleText("NCR");
        WebElement dropDown1 = driver.findElement(By.id("city"));
        Select citySelect = new Select(dropDown1);
        citySelect.selectByVisibleText("Delhi");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }



}

