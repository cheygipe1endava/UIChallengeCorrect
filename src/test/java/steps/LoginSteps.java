package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class LoginSteps {

    private WebDriver webDriver;
    private HomePage homePage;

    public LoginSteps(HookHelper hookHelper)
    {
        webDriver = hookHelper.getWebDriver();
    }

    @Given("^the user opens login form overlay from Falabella's home page$")
    public void theUserOpensLoginFormOverlayFromFalabellaSHomePage()
    {
        homePage = new HomePage(webDriver);
        homePage.openLoginFormOverlay();
    }

    @When("^the user types in its credentials for username and password$")
    public void theUserTypesInItsCredentialsForUsernameAndPassword(DataTable fields)
    {
        homePage.processDataTable(fields);
        homePage.EmailInsert();
        homePage.PasswordInsert();
    }

    @And("^clicks login button$")
    public void clicksLoginButton()
    {
        homePage.loginButton();
    }

    @Then("^the page shows error with email/password to the user$")
    public void thePageShowsErrorWithEmailPasswordToTheUser()
    {
        Assert.assertTrue("Error: Logged in with wrong credentials, please check", homePage.invalidLogin());
    }

    @Then("^the user should be signed in$")
    public void theUserShouldBeSignedIn()
    {
        Assert.assertTrue("Error: Unsuccessfully logged in", homePage.userLoggedIn());
    }

    @Then("^user cannot click disabled login button$")
    public void userCannotClickDisabledLoginButton()
    {
        Assert.assertFalse("Error: Login button is enabled for invalid email/password structure", homePage.disabledLoginButton());
    }

    @And("^the page shows error with blank email field$")
    public void thePageShowsErrorWithBlankEmailField()
    {
        homePage.emptyEmailWarning();
    }

    @And("^the page shows error with wrong password format$")
    public void thePageShowsErrorWithWrongPasswordFormat()
    {
        homePage.wrongPasswordFormat();
    }
}