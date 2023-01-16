package com.cydeo.TestPractices.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TC #1: Etsy Title Verification
//1. Open Chrome browser
//2. Go to https://www.etsy.com
//3. Search for “wooden spoon”
//4. Verify title:
//Expected: “Wooden spoon | Etsy”

public class TC01_Etsy_TitleVerif {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.etsy.com ");
        WebElement acceptButton = driver.findElement(By.cssSelector("#gdpr-single-choice-overlay " +
                "> div > div.wt-overlay__footer.wt-pt-xs-3 > div:nth-child(2) > button"));
        acceptButton.click();

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title test PASS!");
        } else {
            System.out.println("Title test FAILED!!!");
        }

        driver.close();

    }
}
