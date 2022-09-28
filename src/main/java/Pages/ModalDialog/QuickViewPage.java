package Pages.ModalDialog;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuickViewPage extends BasePage {
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    public QuickViewPage(WebDriver driver) {
        super(driver);
    }

    public QuickViewPage addProductToCart() {
        waitForElement(addToCartBtn);
        addToCartBtn.click();
        return this;
    }
}
