package com.selenium.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by SG0943274 on 2017-03-25.
 */
public class ActionBot {

    private final WebDriver driver;

    private final int DEFAULT_TIMEOUT = 5;

    public static final String SKIP_VALUE = "SKIP_VALUE";

    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void waitUntilElementClickableAndClickOnIt(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(getDriver().findElement(locator));
    }

    public WebElement waitUntilElementVisible(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementInvisible(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Type something into an input field. WebDriver doesn't normally clear these
     * before typing, so this method does that first. It also sends a return key
     * to move the focus out of the element.
     */
    public void type(By locator, String text) {
        if(!text.equals(SKIP_VALUE)) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void selectByVisibleText(By id, String text) {
        new Select(driver.findElement(id)).selectByVisibleText(text);
    }

    public void jumpFromAccordionTab(By accordionTabLocator, By buttonLocator) {
        waitUntilElementVisible(accordionTabLocator, DEFAULT_TIMEOUT);
        waitUntilElementClickableAndClickOnIt(buttonLocator, DEFAULT_TIMEOUT);
        waitUntilElementInvisible(accordionTabLocator, DEFAULT_TIMEOUT);
    }

}
