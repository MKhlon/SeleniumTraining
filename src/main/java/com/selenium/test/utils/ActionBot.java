package com.selenium.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by SG0943274 on 2017-03-25.
 */
public class ActionBot {

    private final WebDriver driver;

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

    public void waitUntilElementVisible(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementInvisible(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
