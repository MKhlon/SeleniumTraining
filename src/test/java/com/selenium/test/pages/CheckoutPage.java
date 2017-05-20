package com.selenium.test.pages;

import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.utils.ActionBot;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class CheckoutPage extends BasePage {

    private WebElement accordion; // it works because id of element is "accordion'

    private String guestCheckoutRadioBtnCssLocator = "input[value=guest]";
    private String checkoutOptionAccordionIdLocator = "collapse-checkout-option";
    private String continueCheckoutOptionsBtnIdLocator = "button-account";

    public CheckoutPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return accordion.isDisplayed();
    }

    public CheckoutPage selectGuestCheckoutOption() {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.cssSelector(guestCheckoutRadioBtnCssLocator), 5);
        return this;
    }

    public  CheckoutPage continueToPaymentDetails(){
        new ActionBot(getDriver()).waitUntilElementVisible(By.id(checkoutOptionAccordionIdLocator), 5);
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.id(continueCheckoutOptionsBtnIdLocator), 5);
        new ActionBot(getDriver()).waitUntilElementInvisible(By.id(checkoutOptionAccordionIdLocator), 5);
        return this;
    }
}
