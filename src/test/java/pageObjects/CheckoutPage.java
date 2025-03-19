package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.SwagLabSteps;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(SwagLabSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a[@id='item_4_title_link']/div")
    WebElement productOnCartName;

    public WebElement getProductOnCartName() {
        return productOnCartName;
    }
}
