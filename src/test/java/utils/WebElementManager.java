package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementManager extends WDManager{
    int TIMEOUT = 10;

    public void waitForPageToBeLoaded(){
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
    public String getTextFromElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return driver.findElement(locator).getText();
    }

    public void fillInText(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        driver.findElement(locator).sendKeys(text);
    }
}
