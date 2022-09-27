package Pages.ShoppingCart;

import Pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-detailed-actions .btn-primary")
    private WebElement proceedToCheckoutBtn;
    @FindBy(css = ".cart-items .cart-item:nth-of-type(1) .float-xs-left")
    private WebElement trashBtn;
    @Getter
    @FindBy(css = "li > .product-line-grid > .clearfix")
    private List<WebElement> itemsList;

    public ShoppingCartPage proceedToCheckOut() {
        proceedToCheckoutBtn.click();
        return this;
    }

    public ShoppingCartPage deleteItem() {
        waitForLoad();
        trashBtn.click();
        return this;
    }

}
