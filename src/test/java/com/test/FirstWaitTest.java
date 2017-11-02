package com.test; /**
 * Created by Dean on 18/10/2017.
 */

import com.google.common.annotations.VisibleForTesting;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;


public class FirstWaitTest {
    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setupChromeDriverLocation() {
       // String chromeDriverLocation = "/Users/Dean/chromedriver";
       // System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

       // WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Before
    public void goToAccountPage()
    {

        driver.get("http://google.com");

    }

    @Test
    public void findAnElement_ShouldPass()
    {
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("Cheese");
        element.submit();

    }

    @Test
    public void findAnElement_ShouldFail()
    {
        WebElement element = driver.findElement(By.id("Bait-id"));
    }

    @AfterClass
    public static void quitDriver()
    {

        driver.quit();
    }
}
