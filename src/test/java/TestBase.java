import Config.AppProperties;
import Driver.DriverFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {
     protected WebDriver driver;

    @BeforeAll
     static void beforeAll() {
        AppProperties properties = new AppProperties();
     }

    @BeforeEach
    void setup() {
        String browser = System.getProperty("browserName");
        driver = new DriverFactory().createInstance(browser);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
