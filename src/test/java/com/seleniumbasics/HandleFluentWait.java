package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class HandleFluentWait {


    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);

        By eleLocator = By.xpath("//h3[normalize-space()='Selenium']");

        WebElement element = waitForElementWithFluentWait(driver, eleLocator, 30, 5);
        element.click();
    }

    public static WebElement waitForElementWithFluentWait(WebDriver driver, By eleLocator, int timeout, int pollingTime) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(eleLocator);
            }
        });

        return element;
    }

}