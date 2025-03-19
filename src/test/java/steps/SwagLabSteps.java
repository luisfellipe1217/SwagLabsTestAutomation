package steps;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import support.drivers.DriverType;
import support.utils.DriverUtils;

import java.io.IOException;
import java.time.Duration;

import static support.utils.DriverUtils.initExtentReport;

public class SwagLabSteps {
    static WebDriver driver;
    static LoginPage loginPage;
    static ProductsPage productsPage;
    static CheckoutPage checkoutPage;
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
        try {
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
        try {
            driver = DriverUtils.getDriver();
            loginPage = new LoginPage();
            productsPage = new ProductsPage();
            checkoutPage = new CheckoutPage();
            driver.navigate().to("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            logger.info("URL accessed successfully");
            Assert.assertTrue(true);
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getLoginLogo());
            DriverUtils.getExtentTest().pass("Access to the SwagLabs login successfully completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("Eu insiro o UserName: {string}")
    public void eu_insiro_o_user_name(String username) throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getUserNameField());
            DriverUtils.sendKeysToWebElement(loginPage.getUserNameField(), username);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set username successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("Eu insiro o PassWord: {string}")
    public void eu_insiro_o_pass_word(String password) throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(loginPage.getPasswordField());
            DriverUtils.sendKeysToWebElement(loginPage.getPasswordField(), password);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set password successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());
        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("clico no botão Login")
    public void clico_no_botão_login() throws Exception {
        try {
            DriverUtils.waitAndClickElement(loginPage.getLoginButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Login Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @Then("Eu sou capaz de visualizar a Página inicial com uma lista de produtos.")
    public void eu_sou_capaz_de_visualizar_a_página_inicial_com_uma_lista_de_produtos() throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(productsPage.getProductsText());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Products Page is loaded successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }

    }
    @Given("Eu estou na pagina de produtos")
    public void eu_estou_na_pagina_de_produtos() throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(productsPage.getProductsText());
            Assert.assertTrue(true);
            Assert.assertEquals("Products", productsPage.getProductsText().getText());
            DriverUtils.getExtentTest().pass("Products Page is loaded successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("Eu acho algum produto")
    public void eu_acho_algum_produto() throws Exception{
        try {
            DriverUtils.WaitUntilWebElementIsVisible(productsPage.getProductAvailable());
            Assert.assertEquals("Sauce Labs Backpack", productsPage.getProductAvailableName().getText());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Products find successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("clico no botão Add to cart")
    public void clico_no_botão_add_to_cart() throws Exception {
        try {
            DriverUtils.waitAndClickElement(productsPage.getAddToCartButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Add to Cart Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("quando eu clico no botão do carrinho")
    public void quando_eu_clico_no_botão_do_carrinho() throws Exception{
        try {
            DriverUtils.waitAndClickElement(productsPage.getCartButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Cart Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @Then("devo ser capaz de visualizar o mesmo produto no carrinho para finalização da compra")
    public void devo_ser_capaz_de_visualizar_o_mesmo_produto_no_carrinho_para_finalização_da_compra() throws Exception{
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getProductOnCartName());
            Assert.assertEquals("Sauce Labs Backpack", checkoutPage.getProductOnCartName().getText());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Products find on Cart successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("clico no botão Checkout")
    public void clico_no_botão_checkout() throws Exception{
        try {
            DriverUtils.waitAndClickElement(checkoutPage.getCheckoutButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Checkout Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }

    @When("preencho a informação de first name {string}")
    public void preencho_a_informação_de_first_name(String firstName) throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getFirstNameInput());
            DriverUtils.sendKeysToWebElement(checkoutPage.getFirstNameInput(), firstName);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set First Name successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("preencho a informação de Last Name {string}")
    public void preencho_a_informação_de_last_name(String lastName) throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getLastNameInput());
            DriverUtils.sendKeysToWebElement(checkoutPage.getLastNameInput(), lastName);
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set lastName successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("preencho a informação Zip-Code'{int}'")
    public void preencho_a_informação_zip_code(Integer zipCode) throws Exception {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getZipCodeInput());
            DriverUtils.sendKeysToWebElement(checkoutPage.getZipCodeInput(), String.valueOf(zipCode));
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Set zipCode successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("clico no botão Continue")
    public void clico_no_botão_continue() throws IOException, InterruptedException {
        try {
            DriverUtils.waitAndClickElement(checkoutPage.getContinueButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Continue Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("sou capaz de visualizar o Checkout Overview com todas as informações da minha compra")
    public void sou_capaz_de_visualizar_o_checkout_overview_com_todas_as_informações_da_minha_compra() throws IOException {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getCheckoutOverviewText());
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getProductOnCartName());
            Assert.assertTrue(true);
            Assert.assertEquals("Checkout: Overview", checkoutPage.getCheckoutOverviewText().getText());
            Assert.assertEquals("Sauce Labs Backpack",checkoutPage.getProductOnCartName().getText());
            DriverUtils.getExtentTest().pass("Checkout Overview page loaded successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @When("clico em Finish")
    public void clico_em_finish() throws IOException, InterruptedException {
        try {
            DriverUtils.waitAndClickElement(checkoutPage.getFinishButton());
            Assert.assertTrue(true);
            DriverUtils.getExtentTest().pass("Clicked on Finish Button completed", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
    @Then("Sou capaz de visualizar a mensagem de finalização de compra.")
    public void sou_capaz_de_visualizar_a_mensagem_de_finalização_de_compra() throws IOException {
        try {
            DriverUtils.WaitUntilWebElementIsVisible(checkoutPage.getFinishOrderMessage());
            Assert.assertTrue(true);
            Assert.assertEquals("Thank you for your order!",checkoutPage.getFinishOrderMessage().getText());
            DriverUtils.getExtentTest().pass("Finish Order item successfully", MediaEntityBuilder.createScreenCaptureFromPath(DriverUtils.getScreentShotExtentPath()).build());

        } catch (Exception ex) {
            DriverUtils.getExtentTest().fail(ex);
            throw ex;
        }
    }
}
