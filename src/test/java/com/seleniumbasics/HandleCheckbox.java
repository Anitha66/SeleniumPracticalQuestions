package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HandleCheckbox {

    public static void main(String []args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://itera-qa.azurewebsites.net/home/automation");

        //1.select specific checkbox
        //driver.findElement(By.xpath("//input[@type='checkbox'and @id='friday']")).click();

        //2.select all checkBoxes
        List<WebElement> checkBoxes =  driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));

        //using for loop
        /*for(int i=0;i<checkBoxes.size();i++){

            checkBoxes.get(i).click();
        }*/

        //using for each loop
        /*for(WebElement ele:checkBoxes){

            ele.click();
        }*/

        //3 Select multiple  checkboxes by our choice
        //Click on sunday & friday

        /*for(WebElement ele:checkBoxes){

            String chkBoxValue = ele.getAttribute("id");
            if(chkBoxValue.equals("sunday")||chkBoxValue.equals("friday")){

                ele.click();
                Thread.sleep(3000);
            }
        }*/

        //4..Select last two checkboxes
        int totalCheckBoxCount = checkBoxes.size();
        /*for(int i=totalCheckBoxCount-2;i<checkBoxes.size();i++){

            checkBoxes.get(i).click();
            Thread.sleep(3000);
        }*/
        //5 Select frist two checkboxes
        for(int i=0;i<totalCheckBoxCount;i++){

            if(i<2){
                checkBoxes.get(i).click();
                Thread.sleep(3000);
            }

        }

    }
}
