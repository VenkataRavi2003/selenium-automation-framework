package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class WebShopLoginPage {

    WebDriver wbDriver;

    public WebShopLoginPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
        PageFactory.initElements(wbDriver, this);
    }

    @FindBy(xpath="//input[@id='Email']")
    WebElement emailField;

    @FindBy(xpath="//input[@id='Password']")
    WebElement passwordField;

    @FindBy(xpath="//input[@class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(xpath="//a[@class='ico-logout']")
    WebElement logoutButton;

    public void loginToWebShop(String email, String password) {
        try {
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while logging in: " + e.getMessage());
        }
    }

    public void isLoginSuccessful() {
        try {
            if (logoutButton.isDisplayed()) {
                System.out.println("Login successful, redirected to homepage.");
            } else {
                System.out.println("Login failed, still on login page.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while logging in : " + e.getMessage());
        }

    }
}


   /* WebDriver wbDriver;

    // Locators
    By emailFieldLocator = By.xpath("//input[@id='Email']");
    By passwordFieldLocator = By.xpath("//input[@id='Password']");
    By loginButtonLocator = By.xpath("//input[@class='button-1 login-button']");
    By logoutButtonLocator = By.xpath("//a[@class='ico-logout']");

    public WebShopLoginPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
    }

    public void loginToWebShop(String email, String password) {
        try {
            WebElement emailField = wbDriver.findElement(emailFieldLocator);
            WebElement passwordField = wbDriver.findElement(passwordFieldLocator);
            WebElement loginButton = wbDriver.findElement(loginButtonLocator);

            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while logging in: " + e.getMessage());
        }
    }

    public void isLoginSuccessful() {
        try {
            WebElement logoutButton = wbDriver.findElement(logoutButtonLocator);
            if (logoutButton.isDisplayed()) {
                System.out.println("Login successful, redirected to homepage.");
            } else {
                System.out.println("Login failed, still on login page.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while logging in: " + e.getMessage());
        }
    }
}
*/


























