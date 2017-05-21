package com.selenium.test.pages;

import com.selenium.test.utils.ActionBot;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by SG0943274 on 5/21/2017.
 */
public class SuccessfulOrderConfirmationPage extends BasePage{

    private static String successBreadcrumbCssLocator = "[href*=success]";

    @FindBy(tagName = "h1")
    WebElement pageHeader;

    public SuccessfulOrderConfirmationPage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return new ActionBot(getDriver()).waitUntilElementVisible(By.cssSelector(successBreadcrumbCssLocator), 5).isDisplayed(); //TODO propagate
    }

    public String getPageHeader(){
        return pageHeader.getText();
    }

}
