package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HandleImplicitWait {

    public static void main(String []args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//h3[normalize-space()='Selenium']")).click();







    }






    }
