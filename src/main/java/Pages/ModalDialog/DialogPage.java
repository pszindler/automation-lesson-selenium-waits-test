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

    public DialogPage proceedToShoppingCart() {
        proceedToShoppingCartBtn.click();
        return this;
    }

}
