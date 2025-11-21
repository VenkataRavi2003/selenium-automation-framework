package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver wbDriver;
    public ShoppingCartPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
        PageFactory.initElements(wbDriver, this);
    }

    @FindBy(xpath="(//span[@class='cart-label'])[1]")
    WebElement shoppingCartLink;

    @FindBy(xpath="//input[@id='termsofservice']")
    WebElement termsOfServiceCheckbox;

    @FindBy(xpath="//button[@id='checkout']")
    WebElement checkoutButton;

    public void clickOnShoppingCartLink() {
        try {
            shoppingCartLink.click();
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
    public void isUserOnShoppingCartPage(String expectedURL, String actualURL) {
        try {
            if (actualURL.equals(expectedURL)) {
                System.out.println("User is on the Shopping Cart page");
            } else {
                System.out.println("User is NOT on the Shopping Cart page");
            }
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
    public void acceptTermsOfServiceAndClickCheckout() {
        try {
            termsOfServiceCheckbox.click();
            checkoutButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
}

/*
    WebDriver wbDriver;

    // Locators
    By shoppingCartLinkLocator = By.xpath("(//span[@class='cart-label'])[1]");
    By termsOfServiceCheckboxLocator = By.xpath("//input[@id='termsofservice']");
    By checkoutButtonLocator = By.xpath("//button[@id='checkout']");

    public ShoppingCartPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
    }

    public void clickOnShoppingCartLink() {
        try {
            WebElement shoppingCartLink = wbDriver.findElement(shoppingCartLinkLocator);
            shoppingCartLink.click();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void isUserOnShoppingCartPage(String expectedURL, String actualURL) {
        try {
            if (actualURL.equals(expectedURL)) {
                System.out.println("User is on the Shopping Cart page");
            } else {
                System.out.println("User is NOT on the Shopping Cart page");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void acceptTermsOfServiceAndClickCheckout() {
        try {
            WebElement termsOfServiceCheckbox = wbDriver.findElement(termsOfServiceCheckboxLocator);
            WebElement checkoutButton = wbDriver.findElement(checkoutButtonLocator);

            termsOfServiceCheckbox.click();
            checkoutButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
*/
