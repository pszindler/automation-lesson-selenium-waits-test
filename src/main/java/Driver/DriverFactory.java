package Driver;

import Driver.Manager.*;
import Exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance (String browserFromConfig) {
        WebDriver driver;
        BrowserTypes browser = BrowserTypes.valueOf(browserFromConfig.toUpperCase());

        switch (browser) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                break;
            case IE:
                driver = new IEDriverManager().createDriver();
                break;
            case SAFARI:
                driver = new SafariDriverManager().createDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().createDriver();
                break;
            default:
              throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
