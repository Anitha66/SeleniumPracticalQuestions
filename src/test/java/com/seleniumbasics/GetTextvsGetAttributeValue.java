package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetTextvsGetAttributeValue {

    public static void main(String []args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/login");
        WebElement emailInputBox = driver.findElement(By.id("Email"));
        emailInputBox.sendKeys("adm123@gmail.com");

    }

}
