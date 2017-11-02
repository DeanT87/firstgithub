package com.test;

import com.google.common.annotations.VisibleForTesting;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Dean on 17/10/2017.
 */
public class FirstTest {

    @BeforeClass
    public static void setupChromeDriverLocation()
    {
       String chromeDriverLocation = "/Users/Dean/chromedriver";
       System.setProperty("webdriver.chrome.driver", chromeDriverLocation);


    }


    @Test
    public void goToWebPage()
    {
        WebDriver chrome = new ChromeDriver();

        chrome.get("http://the-internet.herokuapp.com");

        assertTrue(chrome.getTitle().equals("The Internet"));

        chrome.quit();
    }

    @Test
    public void basicChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://the-internet.herokuapp.com");

        assertTrue(driver.getTitle().equals("The Internet"));
    }

    @AfterClass
    public static void closeBrowser()
    {
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }
}
