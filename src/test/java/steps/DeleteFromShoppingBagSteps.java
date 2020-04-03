package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.ShoppingBagPage;

public class DeleteFromShoppingBagSteps
{
    private ProductPage productPage;
    private ShoppingBagPage shoppingBagPage;
    private WebDriver webDriver;

    public DeleteFromShoppingBagSteps(HookHelper hookHelper)
    {
        webDriver = hookHelper.getWebDriver();
    }

    @And("^adds the product to the shopping bag and closes pop up$")
    public void addsTheProductToTheShoppingBagAndClosesPopUp()
    {
        productPage = new ProductPage(webDriver);
        productPage.clickAddToCartButton();
    }

    @Given("^the user added a product and clicks on go to shopping bag button$")
    public void theUserAddedAProductAndClicksOnGoToShoppingBagButton()
    {
        shoppingBagPage = new ShoppingBagPage(webDriver);
        productPage.clickGoToShoppingBag();
    }

    @When("^the user clicks to delete the product from the shopping bag$")
    public void theUserClicksToDeleteTheProductFromTheShoppingBag()
    {
        shoppingBagPage.clickDeleteProduct();
    }

    @Then("^the web page displays message \"([^\"]*)\" to user saying the bag is empty$")
    public void theWebPageDisplaysMessageToUserSayingTheBagIsEmpty(String emptyMessage)
    {
        Assert.assertTrue("Successfully deleted item from shopping cart", shoppingBagPage.emptyShoppingBag(emptyMessage));
    }
}
