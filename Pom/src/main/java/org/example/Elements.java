package org.example;

public class Elements {

    public void textbox() throws InterruptedException {
//        base.wait1("//input[@class=' mr-sm-2 form-control']");
        //driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        LandingPage lp = new LandingPage(driver);
        lp.goTo();
        lp.elementText();
        // driver.findElement(By.xpath("//input[@class=' mr-sm-2 form-control']")).sendKeys("Ankita");
        //driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Address");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("permananent Address");
        //driver.findElement(By.xpath("//button[@id='submit']")).click();
        base.scroll(0, 200);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
}
