package Pages.SummaryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage extends BasePage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='address1']")
    private WebElement address;
    @FindBy(css = "input[name='city']")
    private WebElement city;
    @FindBy(css = "input[name='address1']")
    private WebElement postalCode;
    @FindBy(css = "select[name='id_state']")
    private WebElement state;
    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement confirmAddressesBtn;

    public AddressesPage fillAddressesForm(String adr, String cityName, String zipCode, String USState) {
        address.sendKeys(adr);
        city.sendKeys(cityName);
        postalCode.sendKeys(zipCode);
        new Select(state).selectByValue(USState);
        return this;
    }

    public AddressesPage acceptFrom() {
        confirmAddressesBtn.click();
        return this;
    }



}
