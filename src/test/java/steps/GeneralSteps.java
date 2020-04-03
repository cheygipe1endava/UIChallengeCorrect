package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class GeneralSteps
{
    private WebDriver webDriver;
    private HomePage homePage;

    public GeneralSteps(HookHelper hookHelper)
    {
        webDriver = hookHelper.getWebDriver();
    }

    @Given("^the user logs in Falabella's web page$")
    public void theUserLogsInFalabellaSWebPage(DataTable fields)
    {
        homePage = new HomePage(webDriver);
        homePage.processDataTable(fields);
        homePage.loginProcess();
        homePage.userLoggedIn();
    }

    @And("^the user closes the session$")
    public void theUserClosesTheSession()
    {
        homePage = new HomePage(webDriver);
        homePage.hoverAccountOptions();
        homePage.clickLogout();
        homePage.verifyLogout();
    }
}
