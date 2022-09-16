package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementvsFindElements {

    public static void main(String args[]){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        //findElement --returns single webelement
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchBox.sendKeys("Anitha");

        //findElement --returns single webelement even if it has list of elements
        WebElement ele = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(ele.getText());



        //findelements -- returns list of multiple web elements

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(links.size());

        for(WebElement element:links){

            System.out.println(element.getText());
        }

        //findelements -- returns even if it is one web element
        List<WebElement> search = driver.findElements(By.xpath("//input[@id='small-searchterms']"));
        System.out.println(search.size());

        //findelements -- returns zero if web element not found. no exception thrown
        List<WebElement> searchText = driver.findElements(By.xpath("//input[@id='small']"));
        System.out.println(searchText.size());

        //findElement --returns no element found exception if element not found
        //WebElement input = driver.findElement(By.xpath("//input[@id='Office']"));



    }

}
