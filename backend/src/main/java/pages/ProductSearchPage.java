package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {

    WebDriver wbDriver;

    public ProductSearchPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
        PageFactory.initElements(wbDriver, this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a")
    WebElement prodcutLink;

    @FindBy(xpath = "//input[@id='add-to-cart-button-18']")
    WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-18']")
    WebElement addToWishlistButton;

    public void clickOnProductLink() {
        try {
            prodcutLink.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on product link: " + e.getMessage());
        }
    }

    public void addToCart() {
        try {
            addToCartButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while adding to cart: " + e.getMessage());
        }
    }

    public void addToWishlist() {
        try {
            addToWishlistButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while adding to wishlist: " + e.getMessage());
        }
    }
}

/*
    WebDriver wbDriver;

    // Locators
    By productLinkLocator = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a");
    By addToCartButtonLocator = By.xpath("//input[@id='add-to-cart-button-18']");
    By addToWishlistButtonLocator = By.xpath("//input[@id='add-to-wishlist-button-18']");

    public ProductSearchPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
    }

    public void clickOnProductLink() {
        try {
            WebElement productLink = wbDriver.findElement(productLinkLocator);
            productLink.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on product link: " + e.getMessage());
        }
    }

    public void addToCart() {
        try {
            WebElement addToCartButton = wbDriver.findElement(addToCartButtonLocator);
            addToCartButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while adding to cart: " + e.getMessage());
        }
    }

    public void addToWishlist() {
        try {
            WebElement addToWishlistButton = wbDriver.findElement(addToWishlistButtonLocator);
            addToWishlistButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while adding to wishlist: " + e.getMessage());
        }
    }
}
*/
