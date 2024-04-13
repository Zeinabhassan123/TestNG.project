package com.swaglabs.pages;

import com.swaglabs.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //driver
    private final WebDriver driver;
    //Locators
    private final By username = By.id("user-name"); //send data
    private final By password = By.id("password");//send data
    private final By loginButton = By.id("login-button"); //click

    //Driver constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Actions
    public P01_LoginPage enterUsername (String user)
    {
        Utility.sendData(driver,username,user);
        return this;
    }
    public P01_LoginPage enterPassword (String pass)
    {
        Utility.sendData(driver,password,pass);
        return this;
    }
    public P02_LandingPage clickOnLoginButton ()
    {
        Utility.clicking(driver,loginButton);
        return new P02_LandingPage(driver);
    }



    //Validations
    public boolean verifyLoginFunctionality(String expectedUrl)
    {
        return driver.getCurrentUrl().equals(expectedUrl); //true , false
        //https://www.saucedemo.com/   ?   https://www.saucedemo.com/inventory.html
    }


}
