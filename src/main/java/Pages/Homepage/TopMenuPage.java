package Pages.Homepage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#_desktop_logo a")
    private WebElement topLogo;
    @FindBy(css = ".cart-preview a")
    private WebElement cart;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void goToHomepage() {
        waitForElementToBeClickable(topLogo);
        topLogo.click();
    }

    public void goToCart() {
        cart.click();
    }
}
