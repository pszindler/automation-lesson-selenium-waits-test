package Driver;

import Driver.Manager.*;
import Exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance() {
        return switch (getBrowserFromCfg()) {
            case CHROME -> new ChromeDriverManager().createDriver();
            case FIREFOX -> new FirefoxDriverManager().createDriver();
            case IE -> new IEDriverManager().createDriver();
            case SAFARI -> new SafariDriverManager().createDriver();
            case EDGE -> new EdgeDriverManager().createDriver();
        };
    }

    private BrowserTypes getBrowserFromCfg() {
        String browser = System.getProperty("browserInUse").toUpperCase();
        try {
            return BrowserTypes.valueOf(browser);
        } catch (IllegalArgumentException e) {
            throw new BrowserNotSupportedException(browser);
        }
    }
}
