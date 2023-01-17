package com.cydeo.TestPractices.actions;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_DragAndDrop extends TestBase {

    @Test
    public void dragAndDropTest() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("droptarget"));

        Actions action = new Actions(driver);
        action.dragAndDrop(smallCircle, bigCircle).perform();
        // Another approach to perform action;
        // action.moveToElement(smallCircle).pause(1000).clickAndHold().pause(1000).moveToElement(bigCircle).release().perform();

        Assert.assertEquals(bigCircle.getText(), "You did great!");

    }

}
