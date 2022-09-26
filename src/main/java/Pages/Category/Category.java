package Pages.Category;

import Pages.HomePage.TopMenu;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Category extends TopMenu {
    public Category(WebDriver driver) {
        super(driver);
    }


    @Getter
    @FindBy(css = ".h1")
    private WebElement categoryName;

    @FindBy(css = "#search_filters")
    private WebElement filterMenu;

    @FindBy(css = "div#js-product-list-top p")
    private WebElement itemCounterText;

    public boolean checkForSideMenu() {
        return filterMenu.isDisplayed();
    }

    public String getCategoryNameText() {
        return categoryName.getText();
    }

    public String getItemsNumber() {
        return itemCounterText.getText();
    }


}
