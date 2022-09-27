package Purchase;

import TestBase.Pages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest extends Pages {

    @Test
    void shouldMakePurchase() {
        gridProductsPage.clickProduct(1);
        productPage.addProductToCart();
        dialogPage.proceedToShoppingCart();
        shoppingCartPage.proceedToCheckOut();
        personalInfoPage.fillPersonalInfoForm()
                .acceptForm();
        addressesPage.fillAddressesForm("sdfds", "sdfsd", "12345", "2")
                .acceptFrom();
        shippingPage.ConfirmDeliveryOption();
        paymentPage.proceedPayment();

        assertThat(confirmationPage.getConfirmationStatus()).isEqualTo("YOUR ORDER IS CONFIRMED");

    }
}
