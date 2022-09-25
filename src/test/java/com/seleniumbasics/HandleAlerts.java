package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HandleAlerts {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //alert window with OK button
        /*driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();*/

        //alert window with OK & Cancel button
        /*driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();//to accept alert
        driver.switchTo().alert().dismiss();//to cancel alert*/

        //alert window with input box
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        Alert alertWindow = driver.switchTo().alert();
        System.out.println("message displayed on alert: "+alertWindow.getText());
        alertWindow.sendKeys("Welcome");
        alertWindow.accept();
        Thread.sleep(2000);


    }
}
