package com.test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


/**
 * Created by Dean on 20/10/2017.
 */
public class LoginTest {
    WebDriver driver;


    @Test
    public void LoginEmail() {
        driver = new ChromeDriver();

        // URL for email
        driver.get("http://gmail.com");

        LoginClass login = new LoginClass(driver);

        login.typeUserName();

        // Click Next and then enter password
        driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();

        // Put a wait in to wait for next page to load and then enter password
        WebDriverWait password = new WebDriverWait(driver, 20);
        password.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        login.typePassword();

        // Submit
        driver.findElement(By.cssSelector("span[class='RveJvd snByac']")).click();

        // Maing the system wait for page to load (3 Seconds)
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Assert you can see the email inbox page
        assertTrue(driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji T-I-KE L3']")).isDisplayed());
    }


    @AfterMethod
    public void tearDown()
        {

        // Quit Driver

        driver.quit();

    }
    }









