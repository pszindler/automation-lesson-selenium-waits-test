package Pages.HomePage;

import Pages.BasePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TopMenu extends BasePage {

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(css = "button[type='submit']")
    private WebElement searchInputSubmitButton;
    @FindBy(css = ".ui-widget .ui-menu-item")
    private List<WebElement> autocompleteSuggestions;
    @FindBy(linkText = "ART")
    private WebElement artCategory;
    @Getter
    @FindBy(css = "#top-menu li [data-depth='0']")
    protected List<WebElement> mainCategory;

    public TopMenu enterItemToSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    public TopMenu searchForItem() {
        searchInputSubmitButton.click();
        return this;
    }

    public List<WebElement> getAutocompleteSuggestionHints() {
        return getVisibleElements(autocompleteSuggestions);
    }

    public List<String> getAutocompleteSuggestionText() {
        List<String> textHints = new ArrayList<>();
        for (WebElement el : getAutocompleteSuggestionHints()) {
            textHints.add(el.getText());
        }
        return textHints;
    }

    public TopMenu goToArtCategory() {
        artCategory.click();
        return this;
    }

}
