package support.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    private static WebDriver driver = null;

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return getInstance();
    }

    public static synchronized WebDriver getInstance() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        if (driver == null) {
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
