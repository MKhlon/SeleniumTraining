package com.selenium.test.testng.tests.waits;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDiverWaitExample {

    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void shouldPresentHowImplicitWaitWorks(){

        //WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebDriverFactory.getDriver().get("http://sklep-testowy.pl");

        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();
        WebDriverFactory.getDriver().findElement(By.cssSelector("h4 > a")).click();

        WebDriverFactory.getDriver().findElement(By.id("button-cart")).click();
    }

    @Test
    public void shouldPresentHowExplicitWaitWorks(){

        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebDriverFactory.getDriver().get("http://sklep-testowy.pl");

        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();
        WebDriverFactory.getDriver().findElement(By.cssSelector("h4 > a")).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));

        //Talk about differences:
        //ExpectedConditions.presenceOfElementLocated(By.id("button-cart"));
        //ExpectedConditions.visibilityOfElementLocated(By.id("button-cart")); // it may not be visible e.g. display:none visibility: hidden in css
        //ExpectedConditions.elementToBeClickable(By.id("button-cart")); // it may be disabled like here: <button type="button" disabled>Click Me!</button>

        addToCartBtn.click();
    }

    @Test
    public void shouldPresentHowWebDriverWaitWorks() {

        WebDriverFactory.getDriver().get("http://sklep-testowy.pl");

        WebDriverFactory.getDriver().findElement(By.linkText("Akcesoria")).click();
        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();

        //WebElement imageElement = WebDriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img"));

        WebDriverFactory.getDriver().findElement(By.linkText("Aparaty fotograficzne")).click();

        /*WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.stalenessOf(imageElement));*/

        List<WebElement> productContainers = WebDriverFactory.getDriver().findElements(By.className("product-thumb"));
        for(WebElement container: productContainers) {
            System.out.println("Text from link: " + container.findElement(By.cssSelector("h4 > a")).getText());
        }
    }

    @Test
    public void shouldPresentHowFluentWaitWorks() {

        WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebDriverFactory.getDriver().get("http://sklep-testowy.pl");

        WebDriverFactory.getDriver().findElement(By.className("form-control")).sendKeys("iPhone");
        WebDriverFactory.getDriver().findElement(By.cssSelector("div#search button.btn")).click();
        WebDriverFactory.getDriver().findElement(By.cssSelector("h4 > a")).click();

        Wait wait = new FluentWait(WebDriverFactory.getDriver())
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));

        WebDriverFactory.getDriver().findElement(By.id("button-cart")).click();
    }

    // example from: http://qeworks.com/handle-ajax-call-selenium-webdriver/
    public void waitForAjax(int timeoutInSeconds) {

        WebDriver driver = WebDriverFactory.getDriver();

        System.out.println("Checking active ajax calls by calling 'jquery.active'");
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor)driver;

                for (int i = 0; i< timeoutInSeconds; i++)
                {
                    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
                    //"return angular.element(document.body).injector().get(\'$http\').pendingRequests.length;"    // for Angular
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long)numberOfAjaxConnections;
                        System.out.println("Number of active jquery ajax calls: " + n);
                        if (n.longValue() == 0L)
                            break;
                    }
                    Thread.sleep(1000);
                }
            }
            else {
                System.out.println("Web driver: " + driver + " cannot execute javascript");
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }

}
