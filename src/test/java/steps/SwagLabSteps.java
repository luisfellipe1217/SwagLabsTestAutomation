package steps;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import support.drivers.DriverType;
import support.utils.DriverUtils;

import java.sql.Driver;
import java.time.Duration;

import static support.utils.DriverUtils.*;

public class SwagLabSteps {
    static WebDriver driver;
    static LoginPage loginPage;
    static ProductsPage productsPage;
    private static final Logger logger = LogManager.getLogger(SwagLabSteps.class);

    public static WebDriver getDriver() {
        return driver;
    }

    @Given("Teste: {string}")
    public void teste(String testCase) {
        initExtentReport(testCase);
    }

    @Given("Que eu esteja usando o navegador {string}")
    public void que_eu_esteja_usando_o_navegador(String browser) throws Exception {
        try{
            logger.info("------ STARTING BATTERY OF TESTS ----------");
            DriverUtils.setBrowserName(browser);
            switch (browser) {
                case "CHROME":
                    DriverUtils.selectBrowser(DriverType.CHROME);
                    logger.info(DriverType.CHROME + " browser selected and opened successfully");
                    Assert.assertTrue(true);
                    break;
                case "FIREFOX":
                    DriverUtils.selectBrowser(DriverType.FIREFOX);
                    logger.info(DriverType.FIREFOX + "browser selected and opened successfully");
                    Assert.assertTrue(true);
                    break;
                case "IE":
                    DriverUtils.selectBrowser(DriverType.IE);
                    logger.info(DriverType.IE + "browser selected and openend successfully");
                    Assert.assertTrue(true);
                    break;
            }
            DriverUtils.getExtentTest().pass("Browser selected and opened successfully");
            String brw = browser;
        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @Given("Eu acesso o site SwagLabs")
    public void eu_acesso_o_site_swag_labs() throws Exception {
        try{
            driver = DriverUtils.getDriver();
            loginPage = new LoginPage();
            productsPage = new ProductsPage();
            driver.navigate().to("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            logger.info("URL accessed successfully");
            Assert.assertTrue(true);
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getLoginLogo());
            DriverUtils.getExtentTest().pass("Access to the SwagLabs login successfully completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        }catch (Exception ex){
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("Eu insiro o UserName: {string}")
    public void eu_insiro_o_user_name(String username) throws Exception {
        try{
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getUserNameField());
            DriverUtils.sendKeysToWebElement(loginPage.getUserNameField(), username);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set username sucefully",  MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        }
        catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("Eu insiro o PassWord: {string}")
    public void eu_insiro_o_pass_word(String password) throws Exception{
        try{
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getPasswordField());
            DriverUtils.sendKeysToWebElement(loginPage.getPasswordField(), password);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set password sucefully",  MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());
        }
        catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("clico no botão Login")
    public void clico_no_botão_login() throws Exception {
       try{
           DriverUtils.waitAndClickElement(loginPage.getLoginButton());
           Assert.assertTrue(true);
           DriverUtils.getExtentTest().pass("Clicked on Loggin Button completed",  MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

       } catch(Exception ex){
           DriverUtils.getExtentTest().fail(ex);
           throw ex;
       }
    }
    @Then("Eu sou capaz de visualizar a Página inicial com uma lista de produtos.")
    public void eu_sou_capaz_de_visualizar_a_página_inicial_com_uma_lista_de_produtos() throws Exception {
        try{
            DriverUtils.WaitUntilWebElementIsVisible(productsPage.getProductsText());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Products Page is loaded succesfully",  MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch(Exception ex){
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }

    }
}
