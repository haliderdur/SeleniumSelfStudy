package com.cydeo.TestPractices.alerts_iframes_windows_Practice;

//TC #5: Window Handle practice
//1. Create a new class called: T5_WindowsPractice
//2. Create new test and make set ups
//3. Go to : https://practice.cydeo.com/windows
//4. Assert: Title is “Windows”
//5. Click to: “Click Here” link
//6. Switch to new Window.
//7. Assert: Title is “New Window”

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TC4_WindowHandling extends TestBase {

    @Test
    public void windowHandle_Test1() {
        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");

        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle);


        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereLink.click();

        //6. Switch to new Window.
        Set<String> windowHandles = driver.getWindowHandles();
        for (String eachWindow : windowHandles) {
            driver.switchTo().window(eachWindow);
        }

        //7. Assert: Title is “New Window”
        Assert.assertTrue(driver.getTitle().equals("New Window"));
    }


}
