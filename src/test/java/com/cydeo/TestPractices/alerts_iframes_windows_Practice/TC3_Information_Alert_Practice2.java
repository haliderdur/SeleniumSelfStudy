package com.cydeo.TestPractices.alerts_iframes_windows_Practice;

//TC #3: Information alert practice
//1. Open browser
//2. Go to website: https://practice.cydeo.com/javascript_alerts
//3. Click to “Click for JS Prompt” button
//4. Send “hello” text to alert
//5. Click to OK button from the alert
//6. Verify “You entered:  hello” text is displayed.

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

public class TC3_Information_Alert_Practice2 {

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
    public void jsAlertTest_3() {

        //3. Click to “Click for JS Prompt” button
        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromptBtn.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered:  hello” text is displayed.
        WebElement helloText = driver.findElement(By.xpath("//p[.='You entered: Hello']"));

        Assert.assertTrue(helloText.isDisplayed());
    }
}
