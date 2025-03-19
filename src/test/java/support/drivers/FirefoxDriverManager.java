package support.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager {
    private static WebDriver driver = null;

    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return getInstance();
    }

    public static synchronized WebDriver getInstance() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        if(driver == null) {
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
