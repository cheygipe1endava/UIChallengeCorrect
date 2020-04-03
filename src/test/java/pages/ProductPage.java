package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ProductPage extends BasePage
{
    private boolean verifyProductPageRedirection = false;
    private String firstMatchText, objectNameText;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private List<WebElement> productResults;
    private By productsCatalog = By.id("testId-searchResults-products");
    private By priceButton = By.id("testId-Accordion-Precio");
    private By applyFilterButton = By.className("jsx-3084763500");
    private By minPrice = By.id("testId-range-from");
    private By maxPrice = By.id("testId-range-to");
    private By appliedFiltersField = By.id("testId-SelectedFilters-container");
    private By sellingBrand = By.xpath("//*[@data-brand]");
    private By objectName = By.xpath("//*[@data-name]");
    private By disabledApplyFilterButton = By.xpath("//*[@class='jsx-3084763500' and @disabled]");
    private By productPageLoad = By.xpath("//*[@class='jsx-1987097504 main']");
    private By wrongPriceRangeWarning = By.xpath("//*[@id='testId--desktop-container']//child::p[contains(text(),'Ingresa un rango de precios')]");
    private By productResultList = By.xpath("//*[@id='testId-searchResults-products']//child::div");
    private By addToCartButton = By.xpath("//*[@id='buttonForCustomers']//button");
    private By popUpAddedToCart = By.xpath("//*[@class='doc-click-overlay']//child::span[contains(text(),' Producto(s) agregado(s)')]");
    private By confirmProductAdded = By.xpath("//*[@class='jsx-351245194 item-info']");
    private By goToShoppingBagButton = By.xpath("//*[@id='linkButton']//parent::div");
    private By shoppingCart = By.xpath("//*[@id='testId-userActions-basket']//i[@data-count]");

    public ProductPage(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,Long.parseLong("15"));
    }

    public boolean pageLoadReady(WebDriver driver)
    {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }

    public boolean confirmSearchPage(String searchProduct)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsCatalog));
        productResults = webDriver.findElements(productResultList);
        firstMatchText = productResults.get(0).getText().toLowerCase();
        if(firstMatchText.contains(searchProduct))
        {
            verifyProductPageRedirection = true;
        }
        return verifyProductPageRedirection;
    }

    public void priceButtonClick()
    {
        wait.until(this::pageLoadReady);
        webDriver.findElement(priceButton).click();
    }

    public void priceFilter(String minimumPrice, String maximumPrice)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(minPrice));
        wait.until(ExpectedConditions.visibilityOfElementLocated(maxPrice));
        clickAndSendData(minPrice, minimumPrice);
        clickAndSendData(maxPrice, maximumPrice);
        webDriver.findElement(applyFilterButton).findElement(By.tagName("i")).click();
    }

    public boolean priceFilterApplied()
    {
        return priceFilterVerification(appliedFiltersField);
    }

    public boolean wrongPriceFilterRange()
    {
        return priceFilterVerification(wrongPriceRangeWarning);
    }

    public boolean disabledApplyFilterButton()
    {
        boolean verifyDisabledApplyFilterButton = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(disabledApplyFilterButton));
        if(webDriver.findElement(disabledApplyFilterButton).isDisplayed())
        {
            verifyDisabledApplyFilterButton = true;
        }
        return verifyDisabledApplyFilterButton;
    }

    public void clickFirstMatch()
    {
        if(verifyProductPageRedirection) {productResults.get(0).click();}
    }

    public boolean confirmFirstMatchPage()
    {
        boolean verifyInsideTheProductPage = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPageLoad));
        String sellingBrandText = webDriver.findElement(sellingBrand).getText().toLowerCase();
        objectNameText = webDriver.findElement(objectName).getText().toLowerCase();
        if(firstMatchText.contains(sellingBrandText) && firstMatchText.contains(objectNameText))
        {
            verifyInsideTheProductPage = true;
        }
        return verifyInsideTheProductPage;
    }

    public void clickAddToCartButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        webDriver.findElement(addToCartButton).click();
    }

    public boolean productAddedToCart()
    {
        boolean verifyProductAddedToCart = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAddedToCart));
        String confirmProductAddedText = webDriver.findElement(confirmProductAdded).getText().toLowerCase();
        String shoppingCartIcon = webDriver.findElement(shoppingCart).getAttribute("data-count");
        if(confirmProductAddedText.contains(objectNameText) && !shoppingCartIcon.equals("0"))
        {
            verifyProductAddedToCart = true;
        }
        return verifyProductAddedToCart;
    }

    public void clickGoToShoppingBag()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAddedToCart));
        webDriver.findElement(goToShoppingBagButton).click();
    }
}
