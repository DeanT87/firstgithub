package com.test; /**
 * Created by Dean on 19/10/2017.
 */

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;



import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;





public class WaitLists {

    public static WebDriver driver = new ChromeDriver();

  /*  @BeforeClass
    public static void addingWait() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); <<< This is a Implicity Wait

    } */

    @Test
    public void passTest()
    {

       /* driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebDriverWait waitForStartButton = new WebDriverWait(driver, 20);           <<<< This is a Explicit Wait
        waitForStartButton.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start>button")));
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        waitForElementToBeVisible(By.cssSelector("#start>button"), 2); <<< This is another type of Explicit Wait


        */

       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) // <<< This is a Fluent Wait
               .withTimeout(30, TimeUnit.SECONDS)
               .pollingEvery(10, TimeUnit.SECONDS)
               .ignoring(org.openqa.selenium.NoSuchElementException.class);

       driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

       WebElement startButton = wait.until(new Function<WebDriver, WebElement>() {
           public WebElement apply(WebDriver driver) {
               return driver.findElement(By.cssSelector("#start>button"));
           }
           });

       startButton.click();

       WebElement helloWorldText = wait.until(new Function<WebDriver, WebElement>() {
           public WebElement apply(WebDriver driver) {
               return driver.findElement(By.id("finish"));
           }
       });

       String textFromElement = helloWorldText.getText();

       assertThat(textFromElement, equalTo("Hello World!"));

    }

    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
    }
}
