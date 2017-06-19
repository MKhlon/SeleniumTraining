package com.selenium.test.testng.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTest {

    @FindBy(id = "testidbutton")
    private WebElement testButton;

    public void clickTestButton(){
        testButton.click();
    }

    @FindBy(id = "cancelButton")
    private WebElement cancelButton;
}
