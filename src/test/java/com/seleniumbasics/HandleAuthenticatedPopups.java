package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HandleAuthenticatedPopups {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //driver.get("https://the-internet.herokuapp.com/basic_auth");

        //syntax
        //https://admin:admin@the-internet.herokuapp.com/basic_auth
        //https://username:password@URL

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);



    }

    }
