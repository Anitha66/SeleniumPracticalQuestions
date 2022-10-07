package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BootstrapDropdown {

    public static void main(String []args){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");

        driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
        List<WebElement> drpdwnValues = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
        System.out.println(drpdwnValues.size());
        for(WebElement value:drpdwnValues){
            if(value.getText().equals("Action")){
                value.click();
                break;
            }
        }

        driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();
        List<WebElement> values = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Action']"));
        selectOptionsFromDropdown(values,"Action");
    }

    public static void selectOptionsFromDropdown(List<WebElement> elementList, String value){
        for(WebElement ele:elementList){
            if(ele.getText().equals(value)){
                ele.click();
                break;
            }
        }

    }


}
