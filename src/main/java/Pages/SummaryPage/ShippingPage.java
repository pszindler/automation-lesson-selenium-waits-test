package Pages.SummaryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage {

    @FindBy(css = "button[name=confirmDeliveryOption]")
    private WebElement continueBtn;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void ConfirmDeliveryOption() {
        continueBtn.click();
    }
}
