package Pages.Homepage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ItemPage extends BasePage {

    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement price;
    @FindBy(css = ".product-miniature")
    private WebElement product;

    public ItemPage(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public float getProductPrice() {
        return Float.parseFloat(price.getText().replace("$", ""));
    }

    public WebElement getProduct() {
        return product;
    }
}
