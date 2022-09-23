package Pages.HomePage;

import Pages.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class TopHomePageMenuPage extends BasePage {

    public TopHomePageMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(css = "button[type='submit']")
    private WebElement searchInputSubmitButton;
    @FindBy(css = "li > .ui-corner-all > .product")
    public List<WebElement> autocompleteSuggestions;
    public List<String> autocompleteSuggestionText;



    public List<WebElement> getAutocompleteSuggestions() {
        return autocompleteSuggestions;
    }


    public TopHomePageMenuPage enterItemToSearch(String search) {
        searchInput.sendKeys(search);
        return this;
    }

    public TopHomePageMenuPage searchForItem() {
        searchInputSubmitButton.click();
        return this;
    }

    public List<String> getAutocompleteSuggestionText() {
        wait.until(ExpectedConditions.visibilityOfAllElements(autocompleteSuggestions));
        for (WebElement element: getAutocompleteSuggestions()) {
            autocompleteSuggestionText.add(element.getText());
        }
        return this.autocompleteSuggestionText;
    }
}
