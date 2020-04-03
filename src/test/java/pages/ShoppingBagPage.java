package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingBagPage extends BasePage
{
    private WebDriver webDriver;
    private WebDriverWait wait;
    private By productsInBag = By.className("fb-product-item");
    private By deleteProduct = By.xpath("//*[@class='fb-prod-actionButton']//a[text()='Eliminar']");
    private By emptyBag = By.xpath("//*[@class='fb-order-status__empty-basket']");

    public ShoppingBagPage(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,Long.parseLong("15"));
    }

    public void clickDeleteProduct()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsInBag));
        webDriver.findElement(deleteProduct).click();
    }

    public boolean emptyShoppingBag(String emptyMessage)
    {
        boolean verifyEmptyShoppingBag = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyBag));
        String emptyShoppingBagText = webDriver.findElement(emptyBag).getText().toLowerCase();
        if(emptyShoppingBagText.contains(emptyMessage))
        {
            verifyEmptyShoppingBag = true;
        }
        return verifyEmptyShoppingBag;
    }
}
