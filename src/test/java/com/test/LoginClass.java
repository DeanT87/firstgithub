package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dean on 20/10/2017.
 */
public class LoginClass {

    WebDriver driver;
    By testemail = By.cssSelector("input[type='email']");
    By testpassword = By.cssSelector("input[type='password']");

    public LoginClass(WebDriver driver)
    {
        this.driver = driver;
    }

    public void typeUserName()
    {
        driver.findElement(testemail).sendKeys("imggamingtest4@gmail.com");
    }

    public void typePassword()
    {
        driver.findElement(testpassword).sendKeys("testimggaming");
    }
}
