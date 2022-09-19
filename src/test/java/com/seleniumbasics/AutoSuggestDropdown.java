package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class AutoSuggestDropdown {

    public static void main(String []args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");

        List<WebElement> autosuggestionList = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']"));
        System.out.println("123");
        System.out.println(autosuggestionList.size());


        for (WebElement listitem :autosuggestionList){
            System.out.println(listitem.getText());
            /*if (listitem.getText().equalsIgnoreCase("selenium")){
                listitem.click();
                System.out.println("hii");
                break;
            }*/
        }

    }
}
