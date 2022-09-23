package TestBase;

import Pages.HomePage.ProductsGridPage;
import Pages.HomePage.TopHomePageMenuPage;
import Pages.SearchPage.SearchResultPage;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends TestBase {

    public static ProductsGridPage productsGridPage;
    public static TopHomePageMenuPage topHomePageMenuPage;
    public static SearchResultPage searchResultPage;

    @BeforeEach
    public void createInstances() {
        productsGridPage = new ProductsGridPage(driver);
        topHomePageMenuPage = new TopHomePageMenuPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }
}
