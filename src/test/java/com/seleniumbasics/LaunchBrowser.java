package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://amazon.in"); //opens url
        //returns title of current webpage
        System.out.println("Current WebPage Title: "+ driver.getTitle());

        //returns url of current webpage
        System.out.println("Current WebPage Url: "+ driver.getCurrentUrl());

        //returns html  of current webpage
        System.out.println("Current html WebPage: "+ driver.getPageSource());






    }
}