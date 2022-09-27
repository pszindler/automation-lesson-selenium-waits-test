package Purchase;

import TestBase.Pages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest extends Pages {

    @Test
    void shouldMakePurchase() {
        int mainPageProductNumber = gridProductsPage.getProducts().size();
        for (int i = 0; i < mainPageProductNumber; i++){
            gridProductsPage.clickProduct(i);
            productPage.addProductToCart();
            dialogPage.continueShopping();
            topMenuPage.goToHomepage();
        }

        topMenuPage.goToCart();
        shoppingCartPage.proceedToCheckOut();
        personalInfoPage.fillPersonalInfoForm()
                .acceptForm();
        addressesPage.fillAddressesForm("Duck", "Orlando", "42132", "Alaska")
                .acceptFrom();
        shippingPage.ConfirmDeliveryOption();
        paymentPage.proceedPayment();

        assertThat(confirmationPage.getConfirmationStatus()).contains("YOUR ORDER IS CONFIRMED");

    }
}
