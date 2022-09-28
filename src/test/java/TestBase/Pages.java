package TestBase;

import Pages.Homepage.GridProductsPage;
import Pages.Homepage.TopMenuPage;
import Pages.ModalDialog.DialogPage;
import Pages.Product.ProductPage;
import Pages.ModalDialog.QuickViewPage;
import Pages.ShoppingCart.ShoppingCartPage;
import Pages.SummaryPage.*;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends TestBase {
    public static DialogPage dialogPage;
    public static ShoppingCartPage shoppingCartPage;
    public static AddressesPage addressesPage;
    public static ConfirmationPage confirmationPage;
    public static PaymentPage paymentPage;
    public static PersonalInfoPage personalInfoPage;
    public static ShippingPage shippingPage;
    public static ProductPage productPage;
    public static GridProductsPage gridProductsPage;
    public static TopMenuPage topMenuPage;
    public static QuickViewPage quickViewPage;

    @BeforeEach
    public void createInstances() {
        dialogPage = new DialogPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        addressesPage = new AddressesPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        paymentPage = new PaymentPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        shippingPage = new ShippingPage(driver);
        productPage = new ProductPage(driver);
        gridProductsPage = new GridProductsPage(driver);
        topMenuPage = new TopMenuPage(driver);
        quickViewPage = new QuickViewPage(driver);

    }
}
