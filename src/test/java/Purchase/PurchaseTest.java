package Purchase;

import TestBase.Pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest extends Pages {

    @Test
    void shouldMakePurchase() {
        int mainPageProductNumber = gridProductsPage.getProducts().size();
        for (int i = 0; i < mainPageProductNumber; i++) {
            gridProductsPage.goToQuickView(i);
            quickViewPage.addProductToCart();
            dialogPage.continueShopping();
            topMenuPage.goToHomepage();
        }

        topMenuPage.goToCart();

       /* for (int i = 0; i < mainPageProductNumber - 1; i++) {
            shoppingCartPage.deleteItem();
            List<WebElement> cartItems = shoppingCartPage.getItemsList();
        }*/


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
