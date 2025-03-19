package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.SwagLabSteps;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(SwagLabSteps.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='root']/div/div[1]")
    WebElement loginLogo;

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userNameField;

    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    public WebElement getLoginLogo(){
        return loginLogo;
    }

    public WebElement getUserNameField(){
        return userNameField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }
}
