package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleExplicitWait {

    public static void main(String []args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);

        By  eleLocator = By.xpath("//h3[normalize-space()='Selenium']");

        waitForElementPresentExplicitly(driver,eleLocator,10).click();

    }

    public static WebElement waitForElementPresentExplicitly(WebDriver driver, By locator, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return driver.findElement(locator);
    }


}
