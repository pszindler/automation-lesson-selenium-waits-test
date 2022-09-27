package Pages.ShoppingCart;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-detailed-actions .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public ShoppingCartPage proceedToCheckOut() {
        waitForElement(proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        return this;
    }
}
