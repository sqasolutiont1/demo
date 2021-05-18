package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WDManager {
    public static WebDriver driver;

    public WDManager() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
