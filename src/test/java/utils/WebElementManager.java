package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebElementManager extends WDManager {
    int TIMEOUT = 10;
    WebDriverWait wait;

    public WebElementManager() {
        super();
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void waitForPageToBeLoaded() {
        final String javaScriptToLoadAngular =
                "var injector = window.angular.element('body').injector();" +
                        "var $http = injector.get('$http');" +
                        "return ($http.pendingRequests.length === 0)";

        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
            }
        };
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .until(pendingHttpCallsCondition);
    }

    public String getTextFromElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return driver.findElement(locator).getText();
    }

    public void fillInText(By locator, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        /**
         * verify if the field was filled in.
         */
        String actualTextInTheTextFiled = element.getAttribute("value");
        Assert.assertTrue(actualTextInTheTextFiled.equals(text));
    }
}
