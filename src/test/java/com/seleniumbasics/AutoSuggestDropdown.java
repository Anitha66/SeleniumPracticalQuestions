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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
        driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("selenium");

        List<WebElement> autosuggestionList = driver.findElements(By.xpath("//ul[@class='sa_drw']//li[@role='option']"));
        System.out.println(autosuggestionList.size());


        for (WebElement listitem :autosuggestionList){
            String match = listitem.getAttribute("query");
            if (match.equalsIgnoreCase("Selenium")){
                listitem.click();
                System.out.println("suggestion found");
                break;
            }
        }

    }
}
