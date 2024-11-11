package page;

import com.demoqa.base.base;
import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Pages extends base {

    @Test
    public void textBoxTest() {
        System.out.println("HomePage Test");
        driver.findElement(By.xpath("//div[text()='Elements']"));

        /* SELECT TEXT_BOX  */

        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.id("userName")).sendKeys("neha@gmail.com");
        driver.findElement(By.id("userEmail")).sendKeys("neha123@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("BLR");

        driver.findElement(By.id("permanentAddress")).sendKeys("BBSR");
        WebElement sumbitButton= driver.findElement(By.xpath("//button[text()='Submit']"));
        // sumbitButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", sumbitButton);

    }

    /*CheckBOX*/

    @Test
    public void checkBoxTest() {
        System.out.println("HomePage Test");
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        WebElement checkBox= driver.findElement(By.xpath("//input[@id='tree-node-home']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", checkBox);


        WebElement plusIcon =driver.findElement(By.xpath("//button[@aria-label='Expand all']//*[name()='svg']"));
        plusIcon.click();

    }
    /*Radio Button*/

    @Test
    public void radioButtonTest() {
        System.out.println("HomePage Test");
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
        WebElement readioButton= driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", readioButton);
        // readioButton  .click();
    }

    /*WebTable*/
    @Test
    public void webTablePageTest() {
        System.out.println("HomePage Test");

        WebElement webTable = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", webTable);

        WebElement AddButton = driver.findElement(By.id("addNewRecordButton"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click()", AddButton);

        /* Register form */
        driver.findElement(By.id("firstName")).sendKeys("Neha");
        driver.findElement(By.id("lastName")).sendKeys("G");
        driver.findElement(By.id("userEmail")).sendKeys("neha@gmail.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("300000");
        driver.findElement(By.id("department")).sendKeys("RMG");
        WebElement sumbitButton= driver.findElement(By.xpath("//button[text()='Submit']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click()", sumbitButton);

        /* Search Add Item*/
        driver.findElement(By.id("searchBox")).sendKeys("Neha");
        driver.findElement(By.id("basic-addon2")).click();

        /*verify neha is present or not */
        WebElement getEmail=driver.findElement(By.xpath("//div[text()='neha@gmail.com']"));

        Assert.assertEquals(getEmail.getText(), "neha@gmail.com" ,"matched");
        System.out.println("NEHA IS ADDED");

    }
    /*Button Action related operation */

    @Test
    public void buttonclickTest() throws InterruptedException {

        WebElement buttonText=driver.findElement(By.xpath("//span[text()='Buttons']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", buttonText);

        WebElement doubleClickText = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        WebElement rightClickText = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Double Click Me']")));
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Right Click Me']")));

        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", doubleClickText);


        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClickText).perform();
        actions.contextClick(rightClickText).perform();

        WebElement clickoption=driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickoption).perform();

    }
    /* lINK RELATED OPERATION */
    @Test
    public void LinksTest() {
        System.out.println("HomePage Test");
        WebElement link = driver.findElement(By.xpath("//span[text()='Links']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();

        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);

        driver.findElement(By.xpath("//a[text()='Home' and @id='simpleLink']")).click();

        Set<String> allId = driver.getWindowHandles();
        System.out.println(allId);

        for( String id : allId){
            driver.switchTo().window(originalWindow);

        }

        //driver.findElement(By.xpath("//a[text()='ZYX6y' and @id='dynamicLink' ]")).click();
        WebDriverWait wait =new WebDriverWait(driver , Duration.ofSeconds(200));
        WebElement dynamicLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ZYX6y' and @id='dynamicLink']")));
        dynamicLink.click();

        Set<String> allIdd = driver.getWindowHandles();
        System.out.println(allId);

        for( String id : allIdd){
            driver.switchTo().window(originalWindow);

        }


    }
    @Test
    public void brokenLinksTest() throws InterruptedException {
        System.out.println("HomePage Test");
        // WebElement BrokenLink =  driver.findElement(By.xpath("//span[text() ='Broken Links - Images']"));
        // BrokenLink .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement BrokenLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Broken Links - Images']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", BrokenLink);

        JavascriptExecutor js2=(JavascriptExecutor) driver;
        WebElement validLink = driver.findElement(By.xpath("//a[text()='Click Here for Valid Link']"));
        js2.executeScript("arguments[0].click()", validLink);




    }
    /* File upload And Download*/
    @Test
    public void checkUploadAndDownloadTest() throws InterruptedException {
        System.out.println("HomePage Test");
        WebElement uploadDownloadText=  driver.findElement(By.xpath("//span[text()='Upload and Download']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", uploadDownloadText);

        WebElement download =driver.findElement(By.xpath("//a[text()='Download']"));
        JavascriptExecutor js1=(JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click()", download);

        WebElement uploadFILE=driver.findElement(By.xpath("//input[@id='uploadFile']"));
        uploadFILE.sendKeys("C:\\Users\\Qapitol QA\\Downloads");

    }

    /* Find Dynamic Properties */
    @Test
    public void checkDynamicTest(){
        System.out.println("HomePage Test");
        WebElement dynElement= driver.findElement(By.xpath("//*[name()='svg']/following-sibling::span[text()='Dynamic Properties']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", dynElement);

    }









}