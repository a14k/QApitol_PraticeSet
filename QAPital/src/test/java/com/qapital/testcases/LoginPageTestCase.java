package com.qapital.testcases;

import com.qapital.base.BaseClass;
import com.qapital.pages.LoginPage;
import com.qapital.util.ReadExcel;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTestCase {
    private static final Logger logger = Logger.getLogger(LoginPageTestCase.class);
        //LogManager.getLogger(LoginPageTestCase.class);

    LoginPage loginPage;
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize();
        logger.debug("Entered into SetUp");
        loginPage = new LoginPage();
    }

    @DataProvider(name = "data")
    public Object[][] loginData() throws IOException {
       Object[][] data =  ReadExcel.getData();

       return data;
    }

    @Test(dataProvider = "data")
    public void testLogin(String user,
                          String pass) throws IOException, InterruptedException {
        loginPage.login(user,pass);
        String expected = "QAPit0l";

        String actual = "QAPit0l";
        Assert.assertEquals(actual,expected,"This is not same");
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        BaseClass.quit();
    }
}

