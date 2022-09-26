package Pages.Category;

import Pages.BasePage.BasePage;
import Pages.HomePage.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ArtPage extends BasePage {
    public ArtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.ui-slider-handle:nth-of-type(1)")
    private WebElement leftSlider;
    @FindBy(css = "a.ui-slider-handle:nth-of-type(2)")
    private WebElement rightSlider;
    @FindBy(css = ".faceted-slider p")
    private WebElement priceRange;
    @FindBy(css = "div > .product-miniature .price")
    private List<WebElement> artProductsPrice;
    @FindBy(css = ".close")
    private WebElement closeFilter;

    public ArtPage moveSliderRightToLeft() {
        actions.dragAndDropBy(rightSlider, -12, 0).perform();
        return this;
    }

    public ArtPage isArtChanged() {
        getVisibleElements(artProductsPrice);
        return this;
    }

    public void moveSlider(String value) {
        while (!priceRange.getText().contains(value)) {
            moveSliderRightToLeft();
        }
        isArtChanged();
    }

    public String priceRange() {
        return priceRange.getText();
    }

    public List<String> artPriceList() {
        return artProductsPrice.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public ArtPage resetFilter() {
        closeFilter.click();
        return this;
    }

}
