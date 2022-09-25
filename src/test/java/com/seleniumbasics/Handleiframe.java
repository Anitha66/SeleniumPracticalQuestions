package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Handleiframe {
    public static void main(String []args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        //switch to first frame
        driver.switchTo().frame("frm1");
        driver.findElement(By.xpath("//select[@id='selectnav2']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        //switch to second frame
        driver.switchTo().frame("frm2");
        driver.findElement(By.xpath("//select[@id='selectnav2']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        //switch to third frame
        driver.switchTo().frame("frm3");
        driver.findElement(By.xpath("//select[@id='selectnav2']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

    }
}
