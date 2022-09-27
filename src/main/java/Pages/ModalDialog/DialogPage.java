package Pages.ModalDialog;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogPage extends BasePage {

    public DialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-content-btn .btn-primary")
    private WebElement proceedToShoppingCartBtn;
    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement continueShoppingBtn;

    public DialogPage proceedToShoppingCart() {
        waitForElement(proceedToShoppingCartBtn);
        proceedToShoppingCartBtn.click();
        return this;
    }

    public DialogPage continueShopping() {
        waitForElement(continueShoppingBtn);
        continueShoppingBtn.click();
        return this;
    }



}
