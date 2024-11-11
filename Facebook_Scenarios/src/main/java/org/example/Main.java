package org.example;

import org.example.Facebook.Login;
import org.example.Facebook.Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        Register register=new Register (driver);
        register.createAccount();
        Login login=new Login (driver);
        login.letslogin();
        Createpost cp=new Createpost (driver);
        cp.post();
        driver.close();
        
    }
}