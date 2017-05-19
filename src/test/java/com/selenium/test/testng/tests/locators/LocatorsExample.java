package com.selenium.test.testng.tests.locators;

import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class LocatorsExample {

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }


    @Test
    public void testFillGoogleForm() {
        WebDriverFactory.getDriver().get("http://sklep-testowy.pl");

        //By.id()
        System.out.println("Text from element found by 'id' :" + WebDriverFactory.getDriver().findElement(By.id("top")).getText() + "\n");
        //By.name()
        System.out.println("Text of 'placeholder' attribute of element found by 'name': " + WebDriverFactory.getDriver().findElement(By.name("search")).getAttribute("placeholder") + "\n");
        //By.linkText()
        WebDriverFactory.getDriver().findElement(By.linkText("Akcesoria")).click();
        //By.By.partialLinkText()
        System.out.println("Url of link under 'Monitory': " + WebDriverFactory.getDriver().findElement(By.partialLinkText("Monitory")).getAttribute("href") + "\n");
        //By.className()
        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        //By.cssSelector()
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();
        //By.tagName()
        System.out.println("Source element of image found by its 'tagName': " + WebDriverFactory.getDriver().findElement(By.tagName("img")).getAttribute("src") + "\n");
        //By.xpath()
        System.out.println("Source element of image found by 'xpath': " + WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img")).getAttribute("src"));

    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
