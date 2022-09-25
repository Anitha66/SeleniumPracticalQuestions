package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandleLinks {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        //driver.findElement(By.linkText("Today's Deals")).click();
        //driver.findElement(By.partialLinkText("Deals")).click();

        //how to capture all links of the webpage

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Count of links: "+ links.size());

        //print all the links of webpage
        for(WebElement link:links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));

        }


    }
    }
