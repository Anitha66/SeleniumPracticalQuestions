package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleInnerIframes {
    public static void main(String []args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerFrame);

        WebElement innerFrame = driver.findElement(By.xpath("(//iframe[@src='SingleFrame.html'])[1]"));
        driver.switchTo().frame(innerFrame);

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Welcome");
        Thread.sleep(5000);


    }
    }
