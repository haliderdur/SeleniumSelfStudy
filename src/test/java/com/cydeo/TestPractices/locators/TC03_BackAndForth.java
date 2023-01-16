package com.cydeo.TestPractices.locators;

/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
  Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
  Expected: Google
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03_BackAndForth {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com ");

        Thread.sleep(1500);

        WebElement rejectCookies = driver.findElement(By.id("W0wltc"));
        rejectCookies.sendKeys(Keys.ENTER);

        Thread.sleep(1500);

        driver.findElement(By.className("gb_j")).click();

        String actualGmailTitle = driver.getTitle();
        String expectedGmailTitle = "Gmail";
        if (actualGmailTitle.equals(expectedGmailTitle)) {
            System.out.println("Gmail title is \"" + actualGmailTitle + "\" as expected = PASS!");
        } else {
            System.out.println("Gmail actual title(" + actualGmailTitle + ") is not expected as \"" + expectedGmailTitle + "\" = FAILED!!!");
        }

        Thread.sleep(1500);

        driver.navigate().back();

        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";

        if (actualGmailTitle.equals(expectedGmailTitle)) {
            System.out.println("Google title is \"" + actualGoogleTitle + "\" as expected = PASS!");
        } else {
            System.out.println("Google actual title(" + actualGoogleTitle + ") is not expected as \"" + expectedGoogleTitle + "\" = FAILED!!!");
        }

        driver.close();


    }
}
