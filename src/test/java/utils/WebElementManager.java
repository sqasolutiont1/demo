package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementManager extends WDManager{
    int TIMEOUT = 10;
    public void waitForPageToBeLoaded(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(pageLoadCondition);
    }
    public String getTextFromElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return driver.findElement(locator).getText();
    }
}
