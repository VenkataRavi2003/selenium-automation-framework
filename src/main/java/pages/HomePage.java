package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver wbDriver;

    public HomePage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
        PageFactory.initElements(wbDriver, this);
    }
    @FindBy(xpath = "//input[@id='small-searchterms']")
    WebElement searchField;
//        @FindBy(xpath = "//input[@id='wrong-searchterms']") // Intentionally incorrect
//        WebElement searchField;

    @FindBy(xpath="//input[@class='button-1 search-box-button']")
    WebElement searchButton;

    @FindBy(xpath="/html/body/div[4]/div[1]/div[2]")
    WebElement searchResult;

    public void isUserOnHomePage() {
        if(searchResult.isDisplayed()) {
            System.out.println("User is on the homepage.");
        } else {
            System.out.println("User is not on the homepage.");
        }
    }

    public void searchForProduct(String productName) {
        try {

            searchField.sendKeys(productName);
            searchButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
    public void isSearchSuccessful(String expectedProductName,String actualProductName) {
        if(actualProductName.contains(expectedProductName)) {
            System.out.println("Product details displayed correctly.");
        } else {
            System.out.println("Product details not displayed correctly.");
        }
    }
}

/*
    WebDriver wbDriver;

    // Locators
    By searchFieldLocator = By.xpath("//input[@id='small-searchterms']");
    By searchButtonLocator = By.xpath("//input[@class='button-1 search-box-button']");

    public HomePage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
    }

    public void isUserOnHomePage(String expectedURL, String actualURL) {
        if (actualURL.equals(expectedURL)) {
            System.out.println("User is on the homepage.");
        } else {
            System.out.println("User is not on the homepage.");
        }
    }

    public void searchForProduct(String productName) {
        try {
            WebElement searchField = wbDriver.findElement(searchFieldLocator);
            WebElement searchButton = wbDriver.findElement(searchButtonLocator);

            searchField.sendKeys(productName);
            searchButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void isSearchSuccessful(String expectedProductName, String actualProductName) {
        if (actualProductName.contains(expectedProductName)) {
            System.out.println("Product details displayed correctly.");
        } else {
            System.out.println("Product details not displayed correctly.");
        }
    }
}
*/














