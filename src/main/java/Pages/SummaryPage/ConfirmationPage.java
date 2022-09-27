package Pages.SummaryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card-title.h1")
    private WebElement titleConfirmed;

    public String getConfirmationStatus() {
        waitForElement(titleConfirmed);
        return titleConfirmed.getText();
    }
}
