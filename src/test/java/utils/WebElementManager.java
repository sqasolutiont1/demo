package utils;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class WebElementManager extends WDManager {

  public WebElementManager() {
    super();
  }

  public void selectTravelTo(By locator, String text){
    getClickableElement(locator).sendKeys(text);
    getClickableElement(By.xpath("(//*[@class='el-scrollbar__view el-select-dropdown__list'])[2]//*/li/div/*[contains(text(),'"+text+"')]")).click();
  }

  public void selectDestinationTo(By locator, String text) {
    getClickableElement(locator).sendKeys(text);
    getClickableElement(By.xpath("(//*[@class='el-scrollbar__view el-select-dropdown__list'])[4]//*/li/div/*[contains(text(),'"+text+"')]")).click();
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
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class);
    wait.until(new Function<WebDriver, ExpectedCondition<WebElement>>() {
      public ExpectedCondition<WebElement> apply(WebDriver driver) {
        return ExpectedConditions.elementToBeClickable(driver.findElement(locator));
      }
    });
    return driver.findElement(locator).getText();
  }

  public void fillInText(By locator, String text) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class);
    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {
        return driver.findElement(locator);
      }
    });
    element.sendKeys(text);
    /**
     * verify if the field was filled in.
     */
    String actualTextInTheTextFiled = element.getAttribute("value");
    Assert.assertTrue(actualTextInTheTextFiled.equals(text));
  }

  public void pressOnBtn(By locator) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class);
    wait.until(new Function<WebDriver, WebElement>() {
      public WebElement apply(WebDriver driver) {
        return driver.findElement(locator);
      }
    }).click();
  }

  public void waitForElementIsNotPresentOnPageAnymore(By locator) {
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(5))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class);
    wait.until(new Function<WebDriver, ExpectedCondition<Boolean>>() {
      public ExpectedCondition<Boolean> apply(WebDriver driver) {
        return ExpectedConditions.invisibilityOf(driver.findElement(locator));
      }
    });
  }

  public WebElement getClickableElement(By locator) {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.elementToBeClickable(locator));
  }


  public List<WebElement> getClickableElements(By locator) {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class)
        .until(driver -> driver.findElements(locator));
  }


  public void waitForAttributeValue(By locator, String attributeName, String value) {
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.attributeContains(locator, attributeName, value));
  }

  public void waitForAttributeValueNotPresent(By locator, String attributeName, String value) {
    new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        WebElement button = driver.findElement(locator);
        String enabled = "";
        try {
          enabled = button.getAttribute(attributeName);
        } catch (NullPointerException e) {
          enabled = "";
        }
        if (enabled != null) {
          if (enabled.equals(value))
            return false;
          else
            return true;
        }
        return true;
      }
    });
  }

  public Boolean waitForElementToBeDisplayed(By locator) {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(30))
        .pollingEvery(Duration.ofMillis(50))
        .ignoring(NoSuchElementException.class)
        .until(driver -> driver.findElement(locator).isDisplayed());
  }

  public Boolean isAllImagesLoaded(WebElement element) {
    Object tmp = ((JavascriptExecutor) driver)
        .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != " +
            "\"undefined\" && arguments[0].naturalWidth > 0", element);
    return true;
  }


}
