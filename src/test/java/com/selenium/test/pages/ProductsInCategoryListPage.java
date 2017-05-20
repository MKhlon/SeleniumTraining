package com.selenium.test.pages;

import com.selenium.test.utils.ActionBot;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class ProductsInCategoryListPage extends BasePage {

    private static String pageHeaderLocator = "div#content h2";
    private String showCartItemsBtnLocator = "div.col-sm-3 button";
    private String goToCheckoutFromCartIcn = "div#cart i.fa-share";

    public ProductsInCategoryListPage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.cssSelector(pageHeaderLocator)).isDisplayed();
    }

    public ProductsInCategoryListPage addItemToCart(String itemName) {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.xpath("//div[./div/h4/a[contains(text(),'" + itemName + "')]]/div[contains(@class,'button-group')]/button[contains(@onclick,'cart')]"), 5);
        return this;
    }

    public ProductsInCategoryListPage showCartItemsList() {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.cssSelector(showCartItemsBtnLocator), 5);
        return this;
    }

    public CheckoutPage goToCheckout() {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.cssSelector(goToCheckoutFromCartIcn), 5);
        return new CheckoutPage(false);
    }
}
