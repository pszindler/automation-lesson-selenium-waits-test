package Pages.Product;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    public ProductPage addProductToCart() {
        waitForElement(addToCartBtn);
        addToCartBtn.click();
        return this;
    }


}
