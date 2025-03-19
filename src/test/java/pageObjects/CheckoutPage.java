package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.SwagLabSteps;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(SwagLabSteps.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='item_4_title_link']/div")
    WebElement productOnCartName;

    @FindBy(xpath = "//*[@id='remove-sauce-labs-backpack']")
    WebElement removeProductCartButton;

    @FindBy(xpath = "//*[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//*[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement checkoutOverviewText;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    WebElement finishOrderMessage;


    public WebElement getProductOnCartName() {
        return productOnCartName;
    }

    public WebElement getRemoveProductCartButton(){
        return removeProductCartButton;
    }

    public WebElement getCheckoutButton(){
        return checkoutButton;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput(){
        return lastNameInput;
    }

    public WebElement getZipCodeInput() {
        return zipCodeInput;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getCheckoutOverviewText() {
        return checkoutOverviewText;
    }

    public WebElement getFinishButton() {
        return finishButton;
    }

    public WebElement getFinishOrderMessage() {
        return finishOrderMessage;
    }
}
