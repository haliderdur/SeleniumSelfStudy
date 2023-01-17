package com.cydeo.TestPractices.actions;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TC2_HoverOver extends TestBase {

    @Test
    public void hoverOverTest() {
        driver.get("https://practice.cydeo.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        WebElement img1Text = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Actions action = new Actions(driver);
        action.moveToElement(img1).perform();

        Assert.assertTrue(img1.isDisplayed());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<WebElement> imageTexts = driver.findElements(By.xpath("//h5[contains(text(),'name:')]"));


        for (WebElement eachImage : images) {
            action.moveToElement(eachImage).perform();

            for (WebElement eachImageText : imageTexts) {

                if (eachImageText.isDisplayed()) {
                    Assert.assertTrue(eachImageText.isDisplayed());
                    System.out.println(eachImageText.getText());
                    break;
                }
            }
        }


    }
}
