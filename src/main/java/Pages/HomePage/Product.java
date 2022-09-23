package Pages.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class Product {

    public Product(WebElement product) {
        PageFactory.initElements(new DefaultElementLocatorFactory(product), this);
    }

    @FindBy(css = ".product-title")
    private WebElement articleName;
//    @FindBy(xpath = "article/div/div/div/span[@class='regular-price']")
//    private WebElement regularPrice;
    @FindBy(css = ".price")
    private WebElement currentPrice;
//    @FindBy(xpath = "article/div/div/div/span[@class='discount-percentage discount-product']")
//    private WebElement discountPercentage;

    public String getArticleName() {
        return articleName.getText();
    }

    @Override
    public String toString() {
        return "Product{" +
                "articleName=" + articleName.getText() +
                ", currentPrice=" + currentPrice.getText() +
                '}';
    }
}
