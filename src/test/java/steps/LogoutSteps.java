package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class LogoutSteps {

    private WebDriver webDriver;
    private HomePage homePage;

    public LogoutSteps(HookHelper hookHelper)
    {
        webDriver = hookHelper.getWebDriver();
    }

    @Given("^the user is currently logged in Falabella's home page$")
    public void theUserIsCurrentlyLoggedInFalabellaSHomePage()
    {
        homePage = new HomePage(webDriver);
    }

    @When("^the user hover on account div$")
    public void theUserHoverOnAccountDiv()
    {
        homePage.hoverAccountOptions();
    }

    @And("^clicks logout option$")
    public void clicksLogoutOption()
    {
        homePage.clickLogout();
    }

    @Then("^the user should be signed out$")
    public void theUserShouldBeSignedOut()
    {
        Assert.assertTrue("Error: Unsuccessfully logged out", homePage.verifyLogout());
    }
}