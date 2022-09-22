import Pages.HomePage.ProductsGridPage;
import Pages.HomePage.TopHomePageMenuPage;
import Pages.SearchPage.SearchResultPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestCase extends TestBase {

    @Test
    void searchTestPositiveCase() {
        ProductsGridPage pgp = new ProductsGridPage(driver);
        TopHomePageMenuPage topMenu = new TopHomePageMenuPage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);

        driver.get("http://146.59.32.4/index.php");

        pgp.setProducts();
        String pickedItem = pgp.getRandomProd().getArticleName();
        topMenu.enterItemToSearch(pickedItem);
        topMenu.searchForItem();

        assertThat(searchPage.getTheFirstItemName()).isEqualTo(pickedItem);

    }
}
