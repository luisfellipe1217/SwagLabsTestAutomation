package support.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager {
    private static WebDriver driver = null;

    public WebDriver getDriver() {
        WebDriverManager.iedriver().setup();
        return getInstance();
    }

    public static synchronized WebDriver getInstance() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        if(driver == null) {
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
