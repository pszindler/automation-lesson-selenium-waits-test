import Config.AppPropertiesSingleton;
import Driver.DriverFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {
     protected WebDriver driver;

    @BeforeAll
     static void beforeAll() {
        AppPropertiesSingleton.getInstance();
     }

    @BeforeEach
    void setup() {
        driver = new DriverFactory().createInstance();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
