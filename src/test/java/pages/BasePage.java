package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private boolean verifyStatus;

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        wait = new WebDriverWait(webDriver, Long.parseLong("15"));
    }

    public void clickAndSendData(By by, String data){
        WebElement element = webDriver.findElement(by);
        element.click();
        element.sendKeys(data);
    }

    public boolean waitAndValidateByText(By by, String text)
    {
        verifyStatus = false;
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String textValidation = webDriver.findElement(by).getText();
        if(textValidation.contains(text))
        {
            verifyStatus = true;
        }
        return verifyStatus;
    }

    public boolean priceFilterVerification(By by)
    {
        verifyStatus = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        if (webDriver.findElement(by).isDisplayed())
        {
            verifyStatus = true;
        }
        return verifyStatus;
    }

}
