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
    private String firstNamePersonalDataInputIdLocator = "input-payment-firstname";
    private String lastNamePersonalDataInputIdLocator = "input-payment-lastname";
    private String emailPersonalDataInputIdLocator = "input-payment-email";
    private String phonePersonalDataInputIdLocator = "input-payment-telephone";
    private String address1PersonalDataInputIdLocator = "input-payment-address-1";
    private String cityPersonalDataInputIdLocator = "input-payment-city";
    private String postCodePersonalDataInputIdLocator = "input-payment-postcode";
    private String countryPersonalDataSelectIdLocator = "input-payment-country";
    private String regionPersonalDataSelectIdLocator = "input-payment-zone";

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

    public CheckoutPage fillFormWithRequiredPersonalData(Buyer buyer, Address address){
        typeFirstName(buyer.getFirstName());
        typeLastName(buyer.getLastName());
        typeEmailAddress(buyer.getEmail());
        typePhoneNumber(buyer.getPhone());
        typeAddressPart1(address.getAddressPart1());
        typeCity(address.getCity());
        typePostCode(address.getPostCode());
        selectCountry(address.getCountry());
        selectRegionOrState(address.getRegion());
        return this;
    }

    private void typeFirstName(String firstName) {
        new ActionBot(getDriver()).type(By.id(firstNamePersonalDataInputIdLocator), firstName);
    }

    private void typeLastName(String lastName) {
        new ActionBot(getDriver()).type(By.id(lastNamePersonalDataInputIdLocator), lastName);
    }

    private void typeEmailAddress(String email) {
        new ActionBot(getDriver()).type(By.id(emailPersonalDataInputIdLocator), email);
    }

    private void typePhoneNumber(String phone) {
        new ActionBot(getDriver()).type(By.id(phonePersonalDataInputIdLocator), phone);
    }

    private void typeAddressPart1(String address) {
        new ActionBot(getDriver()).type(By.id(address1PersonalDataInputIdLocator), address);
    }

    private void typeCity(String city) {
        new ActionBot(getDriver()).type(By.id(cityPersonalDataInputIdLocator), city);
    }

    private void typePostCode(String postCode) {
        new ActionBot(getDriver()).type(By.id(postCodePersonalDataInputIdLocator), postCode);
    }

    private void selectCountry(String countryName) {
        new ActionBot(getDriver()).selectByVisibleText(By.id(countryPersonalDataSelectIdLocator), countryName);
    }

    private void selectRegionOrState(String region) {
        new ActionBot(getDriver()).selectByVisibleText(By.id(regionPersonalDataSelectIdLocator), region);
    }
}
