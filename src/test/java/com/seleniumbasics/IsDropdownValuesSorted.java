package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IsDropdownValuesSorted {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        WebElement drpdwn = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selectdrpdwn = new Select(drpdwn);
        List<WebElement> optionsList = selectdrpdwn.getOptions();

        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();

        for (WebElement option : optionsList) {

            originalList.add(option.getText());
            tempList.add(option.getText());
        }
        Collections.sort(tempList);

        System.out.println(originalList);
        System.out.println(tempList);

        if (originalList.equals(tempList)) {

            System.out.println("dropdown values are in sort order");
        } else {
            System.out.println("dropdown values are not in sort order");
        }

    }
}
