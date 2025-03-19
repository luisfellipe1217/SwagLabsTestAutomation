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

    public WebElement getProductsText(){
        return productsText;
    }
}
