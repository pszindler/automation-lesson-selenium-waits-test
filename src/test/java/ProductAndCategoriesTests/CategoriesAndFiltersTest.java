package ProductAndCategoriesTests;

import TestBase.Pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesAndFiltersTest extends Pages {

    @Test
    void iterateThroughCategoriesTest() {
        driver.get("http://146.59.32.4/index.php");
        Actions action = new Actions(driver);
        for (int i = 0; i < 7; i++) {
            List<WebElement> categoryAndSubcategory = driver.findElements(By.cssSelector("li > .dropdown-item"));
            WebElement el = categoryAndSubcategory.get(i);
            if (i <= 2) {
                action.moveToElement(categoryAndSubcategory.get(0)).perform();
            } else if (i <= 5) {
                action.moveToElement(categoryAndSubcategory.get(3)).perform();
            }
            category.getVisibleElement(el);
            String categoryName = el.getText();
            el.click();
            int prodCount = productsGridPage.productList.size();


            assertThat(category.getCategoryNameText()).isEqualTo(categoryName);
            assertThat(category.checkForSideMenu()).isTrue();
            assertThat(category.getItemsNumber()).contains(String.valueOf(prodCount));
        }
    }

    @Test
    void filterTest() {
        driver.get("http://146.59.32.4/index.php");
        topMenu.goToArtCategory();
        List<String> items = artPage.artPriceList();
        artPage.moveSlider("26.00");
        List<String> prices = artPage.artPriceList();
        for (String price : prices) {
            assertThat(artPage.priceRange()).contains(price);
        }
        artPage.resetFilter();
        artPage.isArtChanged();
        List<String> newItems = artPage.artPriceList();
        assertThat(newItems.size()).isNotEqualTo(items.size());

    }
}
