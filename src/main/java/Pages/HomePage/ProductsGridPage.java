package Pages.HomePage;

import Pages.BasePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsGridPage extends BasePage {
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product")
    public List<WebElement> productList;
    @Getter
    public List<Product> products;

    public ProductsGridPage setListOfProducts() {
        List<Product> listOfProd = new ArrayList<>();

        for (WebElement product: productList) {
            listOfProd.add(new Product(product));
        }
        this.products = listOfProd;
        return this;
    }

    public Product getRandomProd() {
        return pickRandomWebElement(products);
    }

    public void visibleProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
    }
}
