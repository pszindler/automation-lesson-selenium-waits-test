import Config.AppProperties;
import Driver.DriverFactory;

import Driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class TestBase {
     protected WebDriver driver;
     protected DriverManager driverManager;


    @BeforeAll
     static void beforeAll() {
        AppProperties properties = new AppProperties();
     }

    @BeforeEach
    void setup() {
        driverManager = DriverFactory.getManager();
        driver = driverManager.getDriver();
    }

    @AfterEach
    void teardown() {
        driverManager.quitDriver();
    }
}
