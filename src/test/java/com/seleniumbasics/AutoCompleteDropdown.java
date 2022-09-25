package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AutoCompleteDropdown {
    public static void main(String []args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.in/");

        WebElement searchBox  = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("travel");
        Thread.sleep(3000);
        searchBox.sendKeys(Keys.ARROW_DOWN);


        String text = null;
        String getFirstValue = searchBox.getAttribute("value");
        System.out.println("getFirstValue:"+getFirstValue);
        int loopCount =0;
        
        do{
            text = searchBox.getAttribute("value");
            System.out.println("text: "+ text);

            if(text.equals("travel bag for wome")){

                searchBox.sendKeys(Keys.ENTER);
                System.out.println("match found");
                text=null;
                break;
            }
            if(getFirstValue.equals(text)){
                loopCount +=1;
                if(loopCount>1) {
                    System.out.println("match not found");
                    break;
                }
            }

            searchBox.sendKeys(Keys.ARROW_DOWN);
           Thread.sleep(2000);
        }while(!text.isEmpty());



    }
}
