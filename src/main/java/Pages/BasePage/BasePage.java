package Pages.BasePage;

import Pages.HomePage.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    static final Duration TIMEOUT = Duration.ofSeconds(Long.parseLong(System.getProperty("webElementTimeout")));
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);
    }

    public Product pickRandomWebElement(List<Product> elements) {
        int index = new Random().nextInt(elements.size()-1);
        return elements.get(index);
    }

    public List<WebElement> getVisibleElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public WebElement getVisibleElement(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        return el;
    }
}
