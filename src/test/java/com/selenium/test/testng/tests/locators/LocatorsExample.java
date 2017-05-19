package com.selenium.test.testng.tests.locators;

import com.selenium.test.testng.listeners.ScreenShotOnFailListener;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

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
        WebDriverFactory.getDriver().findElement(By.linkText("Akcesoria")).click(); // not a good practice!!!
        //By.By.partialLinkText()
        System.out.println("Url of link under 'Monitory': " + WebDriverFactory.getDriver().findElement(By.partialLinkText("Monitory")).getAttribute("href") + "\n");
        //By.className()
        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        //By.cssSelector()
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();
        //By.tagName()
        System.out.println("Source element of image found by its 'tagName': " + WebDriverFactory.getDriver().findElement(By.tagName("img")).getAttribute("src") + "\n");
        //By.xpath()
        WebElement imageElement = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img")); //rather avoid using such type of locators
        System.out.println("Source element of image found by 'xpath': " + imageElement.getAttribute("src"));

        WebDriverFactory.getDriver().findElement(By.linkText("Aparaty fotograficzne")).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.stalenessOf(imageElement));

        //Empty text field & no attribute
        System.out.println("What when no text? :" + WebDriverFactory.getDriver().findElement(By.id("logo")).getText() + "\n");//co sie stanie kiedy nie będzie textu?
        System.out.println("What when attribute of element doesn't exist :" + WebDriverFactory.getDriver().findElement(By.id("logo")).getAttribute("class") + "\n");//co sie stanie kiedy nie będzie textu?

        //Nested elements
        WebElement productContainer = WebDriverFactory.getDriver().findElement(By.className("product-thumb"));
        System.out.println("Text in container: " + productContainer.getText() + "\n");
        WebElement linkToProduct = productContainer.findElement(By.cssSelector("h4 > a"));
        System.out.println("Link text from element found inside another element: " + linkToProduct.getText() + "\n");

        //List of elements
        List<WebElement> productContainers = WebDriverFactory.getDriver().findElements(By.className("product-thumb"));
        for(WebElement container: productContainers) {
            System.out.println("Text from link: " + container.findElement(By.cssSelector("h4 > a")).getText());
        }
    }


    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
