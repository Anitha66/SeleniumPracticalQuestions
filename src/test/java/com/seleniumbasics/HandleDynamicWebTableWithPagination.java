package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HandleDynamicWebTableWithPagination {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://datatables.net/");


        //Find total number of entries
        String text = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
        System.out.println(text);
        String getText = text.substring(text.indexOf("of ") + 3, text.indexOf(" entries"));

        int noOfEntries = Integer.parseInt(getText);
        System.out.println("noOfEntries :" + noOfEntries);
        //Find total number of pages
        int totalPageCount = 0;

        if (noOfEntries % 10 == 0) {
            totalPageCount = noOfEntries / 10;
        } else {

            totalPageCount = noOfEntries / 10 + 1;
        }
        System.out.println("totalPageCount :" + totalPageCount);

        //Find total number of rows in each page
        for (int p = 1; p <= totalPageCount; p++) {

            WebElement activePage = driver.findElement(By.xpath("//a[@class='paginate_button current']"));
            activePage.click();

            int rC = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();//row count
            System.out.println("total num of rows in a rows " + p + " :" + rC);

            WebElement next = driver.findElement(By.xpath("//a[text()='Next']"));
            next.click();
        }

        //get the details of User with particular age limit
        for (int p = 1; p <= totalPageCount; p++) {

            WebElement activePage = driver.findElement(By.xpath("//a[@class='paginate_button current']"));
            activePage.click();

            int rC = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();//row count
            System.out.println("total num of rows in a rows " + p + " :" + rC);

            for (int i = 1; i <= rC; i++) {

                String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[1]")).getText();
                String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[2]")).getText();
                String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[3]")).getText();
                String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[4]")).getText();
                if (Integer.parseInt(age) >50) {
                    System.out.println(name + "    " + position + "    " + office + "    " + age);
                }
            }

            WebElement next = driver.findElement(By.xpath("//a[text()='Next']"));
            next.click();
        }
    }
}
