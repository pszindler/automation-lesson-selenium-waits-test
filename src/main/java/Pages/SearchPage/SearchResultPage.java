package Pages.SearchPage;

import Pages.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-id-product] h2")
    private List<WebElement> listOfSearchedItems;

    public String getTheFirstItemName() {
        wait.until(ExpectedConditions.visibilityOf(listOfSearchedItems.get(0)));
        return listOfSearchedItems.get(0).getText();
    }
}
