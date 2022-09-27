package Pages.SummaryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#payment-option-1")
    private WebElement paymentOptionByCheck;
    @FindBy(css = "#checkout-payment-step [method] .ps-shown-by-js")
    private WebElement agreeToTheTerms;
    @FindBy(css = ".btn-primary.center-block")
    private WebElement placeOrder;

    public void proceedPayment() {
        waitForElement(placeOrder);
        paymentOptionByCheck.click();
        agreeToTheTerms.click();
        placeOrder.click();
    }
}
