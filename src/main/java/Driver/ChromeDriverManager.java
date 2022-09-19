package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager extends DriverManager {

    @Override
    public void startWebDriverManager() {
        try {
            WebDriverManager.chromedriver().setup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();
        if (System.getProperty("fullscreenMode").equalsIgnoreCase("true")) {
            options.addArguments("start-maximized");
        }
        driver = new ChromeDriver(options);
    }
}
