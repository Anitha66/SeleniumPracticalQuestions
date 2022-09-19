package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandleJqueryDropdown {
    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        driver.findElement(By.id("justAnInputBox")).click();

        //selectChoiceValues(driver,"choice 2");
        //selectChoiceValues(driver, "choice 1", "choice 2", "choice 3");
        selectChoiceValues(driver,"all");
    }

    public static void selectChoiceValues(WebDriver driver, String... value) {

        List<WebElement> choicelist = driver.findElements(By.xpath("(//div[@class='comboTreeWrapper'])[1]//span[@class='comboTreeItemTitle']"));

        if (!value[0].equalsIgnoreCase("all")) {

            for (WebElement choice : choicelist) {

                String getChoiceTxt = choice.getText();
                for (String val : value) {

                    if (getChoiceTxt.equals(val)) {
                        System.out.println("Selected");
                        choice.click();
                        break;
                    }
                }

            }

        } else {
            for (WebElement choice : choicelist) {
                choice.click();
            }
        }


    }


}
