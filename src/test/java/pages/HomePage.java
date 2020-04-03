package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage extends BasePage{

    private WebDriver webDriver;
    private WebDriverWait wait;
    private List<List<String>> dataTable;
    private By emailInput = By.id("emailAddress");
    private By searchBar = By.id("searchQuestionSolr");
    private By loginDiv = By.className("fb-masthead-login");
    private By accountDropDown = By.className("fb-masthead__dropdown__menu");
    private By passwordField = By.xpath("//input[@type='password' or @name='password']");
    private By loggedInText = By.xpath("//*[@id='header-login-modal']//child::div[contains(text(),'Bienvenid@')]");
    private By LoginButton = By.xpath("//*[@class='Login__body__wb-dH']//child::p[contains(text(),'Iniciar sesión')]");
    private By loginContainer = By.xpath("//*[@id='header-login-modal']//child::span[contains(text(),'Inicia sesión')]");
    private By invalidLoginMessage = By.className("Login__message__3fDqw");
    private By DisabledLoginButton = By.xpath("//p[contains(text(),'Iniciar sesión')]//parent::button[@disabled]");
    private By emptyEmailWarning = By.xpath("//*[@class='Login__body__wb-dH']//child::p[contains(text(),'Por favor ingresa tu e-mail')]");
    private By wrongPasswordFormatWarning = By.xpath("//*[@class='Login__body__wb-dH']//child::p[contains(text(),'Formato de contraseña')]");
    private By findLogoutElement = By.xpath("//*[@class='fb-filter-header__list-item']//a[@href='#']");
    private By findLoginDivText = By.xpath("//*[@class='fb-masthead-login__user-info']//div[contains(text(),'Inicia sesión')]");

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Long.parseLong("15"));
    }

    public void processDataTable(DataTable fields)
    {
        dataTable = fields.cells();
    }

    public void fillEmailAndPassword(By by, int tableField0, int tableField1)
    {
        if(dataTable.get(tableField0).get(tableField1) != null)
        {
            clickAndSendData(by, dataTable.get(tableField0).get(tableField1));
        }
        clickAndSendData(by, "");
    }

    public void openLoginFormOverlay()
    {
        webDriver.findElement(loginDiv).click();
    }

    public void EmailInsert()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginContainer));
        fillEmailAndPassword(emailInput, 0,1);
    }

    public void PasswordInsert()
    {
        fillEmailAndPassword(passwordField, 1,1);
    }

    public void loginButton()
    {
        webDriver.findElement(LoginButton).click();
    }

    public boolean disabledLoginButton()
    {
        boolean checkEnabledLoginButton = false;
        if(webDriver.findElement(DisabledLoginButton).isEnabled())
        {
            checkEnabledLoginButton = true;
        }
        return checkEnabledLoginButton;
    }

    public boolean emptyEmailWarning()
    {
        return waitAndValidateWarningMessageEmailAndPassword(emptyEmailWarning);
    }

    public boolean wrongPasswordFormat()
    {
        return waitAndValidateWarningMessageEmailAndPassword(wrongPasswordFormatWarning);
    }

    public boolean invalidLogin()
    {
        WebElement incorrectCredentials = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage));
        return incorrectCredentials.isEnabled();
    }

    public boolean userLoggedIn()
    {
        return waitAndValidateByText(loggedInText, "Bienvenid");
    }

    public boolean verifyLogout()
    {
        return waitAndValidateByText(findLoginDivText, "Inicia");
    }

    public void hoverAccountOptions()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginDiv));
        WebElement hoverAction = webDriver.findElement(loginDiv);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(hoverAction).perform();
    }

    public void clickLogout()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountDropDown));
        webDriver.findElement(findLogoutElement).click();
    }

    public void typeInSearchBar(String searchProduct)
    {
        clickAndSendData(searchBar, searchProduct + Keys.ENTER);
    }

    public void loginProcess()
    {
        openLoginFormOverlay();
        EmailInsert();
        PasswordInsert();
        loginButton();
    }
}
