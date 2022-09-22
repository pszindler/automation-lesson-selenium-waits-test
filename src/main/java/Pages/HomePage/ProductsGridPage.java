package Pages.HomePage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsGridPage extends BasePage {
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@id='content']/section/div/div")
    private List<WebElement> productList;
    List<Product> products;

    public List<Product> getListOfProducts() {
        List<Product> listOfProd = new ArrayList<>();

        for (WebElement product: productList) {
            listOfProd.add(new Product(product));
        }
        return listOfProd;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts() {
        this.products = getListOfProducts();
    }

    public Product getRandomProd() {
        return pickRandomWebElement(products);
    }
}
