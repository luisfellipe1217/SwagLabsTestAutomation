package support.drivers;

import org.openqa.selenium.WebDriver;
import support.hooks.Hooks;

import java.net.MalformedURLException;

public class DriverManager {
    static String driverPath;

    public static WebDriver getManager(DriverType type) throws MalformedURLException {
        switch (type) {
            case CHROME: ChromeDriverManager chrDrvMng = new ChromeDriverManager();
                Hooks.setRunningDriver(type);
                return chrDrvMng.getDriver();
            case IE: IEDriverManager ieDrvMng = new IEDriverManager();
                Hooks.setRunningDriver(type);
                return ieDrvMng.getDriver();
            case FIREFOX: FirefoxDriverManager fireDrvMng = new FirefoxDriverManager();
                Hooks.setRunningDriver(type);
                return fireDrvMng.getDriver();
            default:
                return null;
        }
    }
}
