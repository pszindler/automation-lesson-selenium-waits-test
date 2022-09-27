package Homepage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GridProductsPage extends BasePage {

    public static Logger logger = LoggerFactory.getLogger(GridProductsPage.class);
    @FindBy(css = ".product")
    private List<WebElement> products;

    public GridProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<ItemPage> getProducts() {
        return products.stream().map(ItemPage::new).collect(Collectors.toList());
    }

    public ItemPage getProduct(int index) {
        ItemPage item = getProducts().get(index);
        logger.info("Chosen product: " + item.getProductTitle());
        return item;
    }
}
