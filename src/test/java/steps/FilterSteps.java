package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;

public class FilterSteps {

    private HomePage homePage;
    private ProductPage productPage;
    private WebDriver webDriver;

    public FilterSteps(HookHelper hookHelper)
    {
        webDriver = hookHelper.getWebDriver();
    }

    @Given("^the user searches for \"([^\"]*)\" in search bar$")
    public void theUserSearchesForInSearchBar(String searchProduct)
    {
        homePage = new HomePage(webDriver);
        productPage = new ProductPage(webDriver);
        homePage.typeInSearchBar(searchProduct);
        productPage.confirmSearchPage(searchProduct);
    }

    @Given("^the user is in crema product page$")
    public void theUserIsInCremaProductPage()
    {
        productPage = new ProductPage(webDriver);
    }

    @When("^the user clicks price button$")
    public void theUserClicksPriceButton()
    {
        productPage.priceButtonClick();
    }

    @And("^types prices between \"([^\"]*)\" to \"([^\"]*)\" in price fields and applies the price filter$")
    public void typesPricesBetweenToInPriceFieldsAndAppliesThePriceFilter(String minimumPrice, String maximumPrice)
    {
        productPage.priceFilter(minimumPrice, maximumPrice);
    }

    @Then("the user should only see products with prices in the input range")
    public void theUserShouldOnlySeeProductsWithPricesInTheInputRange()
    {
        Assert.assertTrue("Error: Unsuccessfully applied price filter", productPage.priceFilterApplied());
    }

    @Then("^the page shows error with wrong price range$")
    public void thePageShowsErrorWithWrongPriceRange()
    {
        Assert.assertTrue("Error: Wrong price range is being valid, please check", productPage.wrongPriceFilterRange());
    }

    @Then("^the user cannot click a disabled apply filter button$")
    public void theUserCannotClickADisabledApplyFilterButton()
    {
        Assert.assertTrue("Error: Apply filter button is not being disabled, please check", productPage.disabledApplyFilterButton());
    }
}
