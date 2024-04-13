package com.swaglabs.tests;

import com.swaglabs.pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01_LoginTest {

    WebDriver driver ;

    @BeforeMethod
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void validLoginTC()
    {
        //step 1: enter username
        //step 2: enter password
        //step 3: click on login button
        new P01_LoginPage(driver)
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginButton();
        //Assertion: validate login functionality
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void invalidLoginTC()
    {
        //step 1: enter username
        //step 2: enter password
        //step 3: click on login button
        //Assertion: validate login functionality
        new P01_LoginPage(driver)
                .enterUsername("standard_user")
                .enterPassword("ahmed")
                .clickOnLoginButton();
        //Assertion: validate login functionality
        Assert.assertFalse(new P01_LoginPage(driver).verifyLoginFunctionality("https://www.saucedemo.com/inventory.html"));
    }

    @AfterMethod
    public void quit()
    {
        //close > close current tab only
        //quit > close all tabs
        driver.quit();
    }
}
