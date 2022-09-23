package SearchTests;

import TestBase.Pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchPageTest extends Pages {

    @Test
    public void searchForItemFromHomePageTest() {

        driver.get("http://146.59.32.4/index.php");

        String pickedItem = productsGridPage
                .setListOfProducts()
                .getRandomProd()
                .getArticleName();

        topHomePageMenuPage.enterItemToSearch(pickedItem)
                .searchForItem();

        assertThat(searchResultPage.getTheFirstItemName()).isEqualTo(pickedItem);

    }

//    @ParameterizedTest
//    @ValueSource(strings = {"HUMMINGBIRD", "MUG"})
    @Test
    void checkIfDropDownAppearsWithAutoSuggestion() {
        driver.get("http://146.59.32.4/index.php");

        topHomePageMenuPage.enterItemToSearch("HUMMINGBIRD");
        List<WebElement> el = topHomePageMenuPage.getAutocompleteSuggestions();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + el);



    }
}
