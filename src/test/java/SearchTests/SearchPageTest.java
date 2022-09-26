package SearchTests;

import TestBase.Pages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        topMenu.enterItemToSearch(pickedItem)
                .searchForItem();

        assertThat(searchResultPage.getTheFirstItemName()).isEqualTo(pickedItem);

    }

    @ParameterizedTest
    @ValueSource(strings = {"HUMMINGBIRD", "MUG", "POSTER", "CUSHION"})
    void checkIfDropDownAppearsWithAutoSuggestion(String values) {
        driver.get("http://146.59.32.4/index.php");

        topMenu.enterItemToSearch(values);
        List<String> el = topMenu.getAutocompleteSuggestionText();

        assertThat(el).anyMatch(i -> i.contains(values));
    }
}
