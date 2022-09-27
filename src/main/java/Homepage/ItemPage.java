package Homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ItemPage {

    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement price;

    public ItemPage(WebElement element) {
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public float getProductPrice() {
        return Float.parseFloat(price.getText().replace("$", ""));
    }
}
