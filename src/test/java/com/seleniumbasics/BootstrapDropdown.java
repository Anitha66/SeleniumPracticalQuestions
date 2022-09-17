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

        driver.get("https://www.hdfcbank.com/");

        driver.findElement(By.xpath("//span[text()='Select Product Type']")).click();
        List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
        System.out.println(productTypes.size());
        for(WebElement product:productTypes){
            if(product.getText().equals("Accounts")){
                product.click();
            }
        }


    }


}
