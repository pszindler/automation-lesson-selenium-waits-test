package Pages.HomePage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopHomePageMenuPage extends BasePage {

    public TopHomePageMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(css = "button[type='submit']")
    private WebElement searchInputSubmitButton;
    @FindBy(css = ".ui-autocomplete li")
    private List<WebElement> autocompleteSuggestions;

    public void enterItemToSearch(String search) {
        searchInput.sendKeys(search);
    }

    public void searchForItem() {
        searchInputSubmitButton.click();
    }
}
