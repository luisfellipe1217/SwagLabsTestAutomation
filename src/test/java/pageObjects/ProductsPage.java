package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.SwagLabSteps;

public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(SwagLabSteps.getDriver(), this);
    }

    @FindBy(xpath = "//span[@data-test='title']")
    WebElement productsText;

    @FindBy(xpath = "//a[@id='item_4_title_link']")
    WebElement productAvailable;

    @FindBy(xpath = "//*[@id='item_4_title_link']/div")
    WebElement productAvailableName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    WebElement cartButton;

    public WebElement getProductsText(){
        return productsText;
    }

    public WebElement getProductAvailable(){
        return productAvailable;
    }

    public WebElement getProductAvailableName() {
        return productAvailableName;
    }

    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
