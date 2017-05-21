package com.selenium.test.testng.tests.scenarios;

import com.selenium.test.pages.LandingPage;
import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.testng.annotations.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Listeners({ScreenShotOnFailListener.class})
public class PlacingNewOrders {

    private static final String CATEGORY = "Akcesoria";
    private static final String SUBCATEGORY = "Monitory";
    private static final String ITEM = "Samsung SyncMaster 941BW";
    private static final String COMMENT = "Komentarz do testowego zamówienia";
    private static final String SUCCESSFUL_ORDER_CONFIRMATION_TEXT = "Twoje zamówienie zostało przetworzone!";

    @DataProvider(name = "buyerAndAddressData")
    public Object[][] createData1() {

        Buyer buyer = new Buyer();
        buyer.setFirstName("Tester");
        buyer.setLastName("Testowicz");
        buyer.setEmail("tester.testowicz@gmail.com");
        buyer.setPassword("pass123");
        buyer.setPhone("123654789");

        Address address = new Address()
                .withAddressPart1("Testowa 7")
                .withCity("Testowo")
                .withPostCode("39-100")
                .withCountry("Poland")
                .withRegion("Malopolskie");

        return new Object[][] {
                {buyer, address},
        };
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test(dataProvider = "buyerAndAddressData")
    public void shouldPlaceNewOrderWithoutRegistration(Buyer buyer, Address address) {
        assertEquals(
                new LandingPage()
                .goToProductList(CATEGORY, SUBCATEGORY)
                    .addItemToCart(ITEM)
                    .showCartItemsList()
                    .goToCheckout()
                        .selectGuestCheckoutOption()
                        .continueToPaymentDetails()
                        .fillFormWithRequiredPersonalData(buyer, address)
                        .continueToDeliveryMethod()
                        .fillDeliveryMethodComment(COMMENT)
                        .continueToPaymentMethod()
                        .continueToOrderConfirmation()
                        .confirmOrder()
                            .getPageHeader(), SUCCESSFUL_ORDER_CONFIRMATION_TEXT);
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
