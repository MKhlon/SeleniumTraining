package com.selenium.test.testng.tests.scenarios;

import com.selenium.test.pages.LandingPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

@Listeners({ScreenShotOnFailListener.class})
public class PlacingNewOrders {

    private static final String CATEGORY = "Akcesoria";
    private static final String SUBCATEGORY = "Monitory";
    private static final String ITEM = "Samsung SyncMaster 941BW";

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void shouldPlaceNewOrderWithoutRegistration() {
        new LandingPage()
                .goToProductList(CATEGORY, SUBCATEGORY)
                    .addItemToCart(ITEM)
                    .showCartItemsList()
                    .goToCheckout()
                        .selectGuestCheckoutOption();
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
