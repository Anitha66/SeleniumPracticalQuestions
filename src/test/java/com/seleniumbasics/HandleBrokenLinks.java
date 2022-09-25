package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HandleBrokenLinks {
    public static void main(String[] args) throws IOException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("http://www.deadlinkcity.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenLinks = 0;

        for(WebElement ele:links){

            String url = ele.getAttribute("href");
            if(url==null || url.isEmpty()){
                continue;
            }
            URL link = new URL(url);
            try {
                HttpURLConnection conn = (HttpURLConnection) link.openConnection();
                conn.connect();
                if (conn.getResponseCode() >= 400) {

                    System.out.println(conn.getResponseCode() + url + " is" + " Broken link");
                    brokenLinks++;
                } else {

                    System.out.println(conn.getResponseCode() + url + " is" + " valid link");

                }
            }catch (Exception e){
                System.out.println("exception message");
            }
        }

        System.out.println("num of brokenLinks" + brokenLinks);
        driver.quit();


    }
}
