package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager extends DriverManager {
    @Override
    protected void startWebDriverManager() {
        try {
            WebDriverManager.firefoxdriver().setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        if (System.getProperty("fullscreenMode").equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

    }
}
