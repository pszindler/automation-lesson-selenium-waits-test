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
        driver = new DriverFactory().createInstance(System.getProperty("activeBrowser"));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
