package Driver;

import Driver.Manager.*;
import Exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance () throws BrowserNotSupportedException {
        String browserFromConfig = System.getProperty("browserInUse");
        BrowserTypes browser = BrowserTypes.valueOf(browserFromConfig.toUpperCase());
        return switch (browser) {
            case CHROME -> new ChromeDriverManager().createDriver();
            case FIREFOX -> new FirefoxDriverManager().createDriver();
            case IE -> new IEDriverManager().createDriver();
            case SAFARI -> new SafariDriverManager().createDriver();
            case EDGE -> new EdgeDriverManager().createDriver();
        };
    }
}
