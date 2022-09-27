package Pages.SummaryPage;

import Models.User;
import Models.UserFactory;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends BasePage {

    public PersonalInfoPage(WebDriver driver) {super(driver);}

    @FindBy(css = "input[name=firstname]")
    private WebElement firstName;
    @FindBy(css = "input[name=lastname]")
    private WebElement lastName;
    @FindBy(css = "input[name=email]")
    private WebElement email;
    @FindBy(css = "input[name=customer_privacy]")
    private WebElement customerPrivacy;
    @FindBy(css = "input[name=psgdpr]")
    private WebElement generalConditionsOfUse;

    @FindBy(css = "button[data-link-action=register-new-customer]")
    private WebElement continueBtn;

    public PersonalInfoPage fillPersonalInfoForm() {
        waitForElement(continueBtn);
        User user = UserFactory.generateUser();
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        customerPrivacy.click();
        generalConditionsOfUse.click();
        return this;
    }

    public PersonalInfoPage acceptForm() {
        continueBtn.click();
        return this;
    }
}
