package com.cydeo.TestPractices.alerts_iframes_windows_Practice;

//TC #2: Confirmation alert practice
//1. Open browser
//2. Go to website: https://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Confirm” button
//4. Click to OK button from the alert
//5. Verify “You clicked: Ok” text is displayed.

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

public class TC2_Confirmation_Alert_Practice {

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
    public void jsAlertTest_2() {
        WebElement confirmAlertbtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        //3. Click to “Click for JS Confirm” button
        confirmAlertbtn.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());
    }

}
