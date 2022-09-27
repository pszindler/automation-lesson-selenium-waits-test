package TestBase;

import Pages.ModalDialog.DialogPage;
import Pages.ShoppingCart.ShoppingCartPage;
import Pages.SummaryPage.AddressesPage;
import Pages.SummaryPage.ConfirmationPage;
import Pages.SummaryPage.PaymentPage;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends TestBase {
    public static DialogPage dialogPage;
    public static ShoppingCartPage shoppingCartPage;
    public static AddressesPage addressesPage;
    public static ConfirmationPage confirmationPage;
    public static PaymentPage paymentPage;

    @BeforeEach
    public void createInstances() {
        dialogPage = new DialogPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        addressesPage = new AddressesPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        paymentPage = new PaymentPage(driver);
    }
}
