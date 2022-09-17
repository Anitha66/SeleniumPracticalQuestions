package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GenericMethodForMultipleDropdowns {
    static WebDriver driver;
    public static void main(String []args){

        driver = WebDriverManager.chromiumdriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/register");

        WebElement selectDate = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        //approach1
        //Select drpdwnDate = new Select(selectDate);
        //drpdwnDate.selectByVisibleText("8");
        selectValueFromDropdown(selectDate,"15");
    }

    public static void selectValueFromDropdown(WebElement ele,String drpdwnValue){

        Select drpdwn = new Select(ele);
        List<WebElement> allOptions = drpdwn.getOptions();
        System.out.println(allOptions.size());

        for(WebElement option:allOptions){

            if(option.getText().equals(drpdwnValue)){
                option.click();
                break;
            }
        }
    }

}
