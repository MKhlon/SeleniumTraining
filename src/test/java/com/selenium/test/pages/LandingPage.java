package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    public LandingPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(TestsConfig.getBaseURL());
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().getTitle().equals("Your Store");
    }

}
