package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class ProductsInCategoryListPage extends BasePage {

    public ProductsInCategoryListPage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.cssSelector("div#content h2")).isDisplayed();
    }

    public ProductsInCategoryListPage addItemToCart(String itemName) {
        getDriver().findElement(By.xpath("//div[./div/h4/a[contains(text(),'" + itemName + "')]]/div[contains(@class,'button-group')]/button[contains(@onclick,'cart')]")).click();
        return this;
    }

    public ProductsInCategoryListPage showCartItemsList() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.col-sm-3 button"))).click();
        return this;
    }
}
