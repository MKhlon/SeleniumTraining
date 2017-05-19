package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

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

    public ProductsInCategoryListPage goToProductList(String category, String subcategory) {
        Actions action = new Actions(getDriver());

        action
                .moveToElement(getDriver()
                        .findElement(By
                                .linkText(category)))
                .moveToElement(getDriver()
                        .findElement(By
                                .partialLinkText(subcategory)))
                .click()
                .build()
                .perform();

        return new ProductsInCategoryListPage();
    }
}
