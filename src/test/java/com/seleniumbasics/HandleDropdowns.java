package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropdowns {

    public static void main(String []args){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/register");

        //handle dropdowns
       WebElement selectDate = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));

        Select drpdwnDate = new Select(selectDate);
        //drpdwnDate.selectByVisibleText("5");
        //drpdwnDate.selectByValue("15");
        //drpdwnDate.selectByIndex(4);

        List<WebElement> allOptions = drpdwnDate.getOptions();
        System.out.println(allOptions.size());
        for(WebElement option:allOptions){

        if(option.getText().equals("9")){
            option.click();
            break;
        }
        }
    }


}
