package TestBase;

import Pages.Category.ArtPage;
import Pages.Category.Category;
import Pages.HomePage.ProductsGridPage;
import Pages.HomePage.TopMenu;
import Pages.SearchPage.SearchResultPage;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends TestBase {

    public static ProductsGridPage productsGridPage;
    public static TopMenu topMenu;
    public static SearchResultPage searchResultPage;
    public static Category category;
    public static ArtPage artPage;

    @BeforeEach
    public void createInstances() {
        productsGridPage = new ProductsGridPage(driver);
        topMenu = new TopMenu(driver);
        searchResultPage = new SearchResultPage(driver);
        category = new Category(driver);
        artPage = new ArtPage(driver);
    }
}
