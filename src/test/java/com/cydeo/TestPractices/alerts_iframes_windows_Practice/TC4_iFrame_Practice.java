package com.cydeo.TestPractices.alerts_iframes_windows_Practice;

//TC #4: Iframe practice
//1. Create a new class called: T4_Iframes
//2. Create new test and make set ups
//3. Go to: https://practice.cydeo.com/iframe
//4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

import com.cydeo.base.TestBase;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC4_iFrame_Practice extends TestBase {

    @Test
    public void iframeTest_1() {

        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        // driver.switchTo().frame(0);
        // WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        // driver.switchTo().frame(iframe);

        //4. Assert: “Your content goes here.” Text is displayed.
        WebElement textArea = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(textArea.isDisplayed());

        driver.switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        WebElement TinyMCEtext = driver.findElement(By.tagName("h3"));

        String actualTinyMCEtext = TinyMCEtext.getText();
        String expectedTinyMCEtext = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualTinyMCEtext, expectedTinyMCEtext);


    }
}
