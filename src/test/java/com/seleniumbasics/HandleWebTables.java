package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleWebTables {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        //to find number of rows in a table
        int rC = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();//row count
        System.out.println("total num of rows in a table: " + rC);

        //to find number of columns in a table
        int cC = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();//column count
        System.out.println("total num of columns in a table: " + cC);

        //retrieve particular value at specific row/column data
        String value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[2]/td[1]")).getText();
        System.out.println("value :" + value);

        //retrieve all the data from table
        for (int i = 2; i <= rC; i++) {
            for (int j = 1; j <= cC; j++) {

                String data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(data+" ");

            }
            System.out.println();
        }

        System.out.println("print required data");
        //retrieve required data
        for (int i = 2; i <= rC; i++) {

            String getCompanyName = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[1]")).getText();
            System.out.println(getCompanyName);
            if(getCompanyName.equals("Island Trading")){

                String contact = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[2]")).getText();
                String country = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[3]")).getText();

                System.out.print("contact: "+contact+ " country: "+ country);
            break;
            }
        }

    }


}
