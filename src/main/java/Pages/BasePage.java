package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected static final int WEB_ELEMENT_TIMEOUT = Integer.parseInt(System.getProperty("webElementTimeout"));
    protected static final int WEB_ELEMENT_POOLING = Integer.parseInt(System.getProperty("webElementPooling"));
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        initDrivers(driver);
        PageFactory.initElements(driver, this);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public BasePage(WebDriver driver, WebElement element) {
        initDrivers(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    private void initDrivers(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WEB_ELEMENT_TIMEOUT), Duration.ofMillis(WEB_ELEMENT_POOLING));
        actions = new Actions(driver);
        logger.debug("Created WebDriverWait with timeout: " + WEB_ELEMENT_TIMEOUT + "s and sleep: " + WEB_ELEMENT_POOLING + "ms");
    }

    protected void highLight(WebElement element, String color) {
        jse.executeScript("arguments[0].style.border='3px solid " + color + '\'', element);
    }

    protected void highLight(WebElement element) {
        highLight(element, "red");
    }

    public Dimension getViewPortSize() {
        int width = Integer.parseInt(String.valueOf(jse.executeScript("return window.innerWidth")));
        int height = Integer.parseInt(String.valueOf(jse.executeScript("return window.innerHeight")));

        return new Dimension(width, height);
    }

    public boolean isPageLoaded() {
        return isDOMLoaded() && isAjaxCompletedTasks();
    }

    public boolean isDOMLoaded() {
        String state = jse.executeScript("return document.readyState").toString();
        return state.equals("complete");
    }

    public boolean isAjaxCompletedTasks() {
        String state = jse.executeScript("return jQuery.active").toString();
        return state.equals("0");
    }

    public void waitForLoad() {
        wait.until(driver -> isPageLoaded());
    }

    public void hoverOnElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    protected String getSingleNodeText(WebElement element) {
        String text = element.getText().trim();
        List<WebElement> children = element.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void isItemNotVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.invisibilityOf(elements.get(0)));
    }

    public boolean isElementChanged(WebElement element) {
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}