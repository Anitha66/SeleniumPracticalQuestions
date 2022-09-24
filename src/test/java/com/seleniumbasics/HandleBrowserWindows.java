package com.seleniumbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {

    public static void main(String []args) throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        //getWindowHandle
        String windowId = driver.getWindowHandle();
        System.out.println("windowId: "+ windowId);
        Thread.sleep(3000);
        //getWindowHandles
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIds = driver.getWindowHandles();
        //Method 1 Iterator
        /*Iterator<String> it = windowIds.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        System.out.println("parent Window Id: "+ parentWindowId);
        System.out.println("child Window Id: "+ childWindowId);*/

        //Method 2 List/Arraylist
        List<String> windowIdsList = new ArrayList<>(windowIds);

        /*String parentWindowId = windowIdsList.get(0);
        String childWindowId = windowIdsList.get(1);

        System.out.println("parent Window Id: "+ parentWindowId);
        System.out.println("child Window Id: "+ childWindowId);*/

        //Switch to Windows
        /*driver.switchTo().window(parentWindowId);
        System.out.println("Parent Window Title: "+ driver.getTitle());

        driver.switchTo().window(childWindowId);
        System.out.println("Child Window Title: "+ driver.getTitle());*/

        //get window title using for each loop

        for(String winId : windowIdsList){

            String title = driver.switchTo().window(winId).getTitle();
            System.out.println("title: "+ title);
        }

        //close the active window
        //driver.close();

        //close the browser i.e., close all the windows
        //driver.quit();

        //close the specific window
        for(String winId : windowIdsList){

            String title = driver.switchTo().window(winId).getTitle();
            if(title.contains("HR Software")){

                driver.close();
            }
        }

    }
}
