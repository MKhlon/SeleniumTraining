package com.selenium.test.testng.tests.scenarios;

import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

@Listeners({ScreenShotOnFailListener.class})
public class PlacingNewOrders {

    private final String BASE_URL = "http://sklep-testowy.pl";

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void shouldPlaceNewOrderWithoutRegistration() {
        WebDriverFactory.getDriver().get(BASE_URL);
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
