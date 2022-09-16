package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StatusOfWebElement {

public static void main(String []args){


    WebDriver driver = WebDriverManager.chromedriver().create();
    driver.manage().window().maximize();

    driver.get("https://demo.nopcommerce.com/register");

    WebElement searchElement = driver.findElement(By.xpath("//input[@id='small-searchterms']"));

    System.out.println("display status: "+ searchElement.isDisplayed());//true
    System.out.println("display status: "+ searchElement.isEnabled());//true

    /*isSelected() is used for radio buttons, checkboxes,dropdowns*/
    WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
    System.out.println("display status: "+ radioButton.isSelected());//false

    radioButton.click();
    System.out.println("display status: "+ radioButton.isSelected());//true


}

}
