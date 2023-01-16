package com.cydeo.TestPractices.alerts_iframes_windows_Practice;

//TC #1: Information alert practice
//1. Open browser
//2. Go to website: https://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Alert” button
//4. Click to OK button from the alert
//5. Verify “You successfully clicked an alert” text is displayed.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_Information_Alert_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void jsAlertTest_1() {
        WebElement jsAlertbtn = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //3. Click to “Click for JS Alert” button
        jsAlertbtn.click();

        //4. Click to OK button from the alert
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());

    }

}

















