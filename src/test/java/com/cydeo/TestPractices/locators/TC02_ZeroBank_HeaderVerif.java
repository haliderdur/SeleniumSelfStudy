package com.cydeo.TestPractices.locators;

/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_ZeroBank_HeaderVerif {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://zero.webappsecurity.com/login.html");

        String actualHeader = driver.findElement(By.tagName("h3")).getText();

        String expectedHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header test PASS!");
        } else {
            System.out.println("Header test FAILED!!!");
        }

        driver.close();

    }
}
