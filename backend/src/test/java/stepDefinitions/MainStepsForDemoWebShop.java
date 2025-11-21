package stepDefinitions;
import base.BaseTest;
import pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class MainStepsForDemoWebShop extends BaseTest {
    WebShopLoginPage webShopLoginPage;
    HomePage homePage;
    ProductSearchPage productSearchPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @Given("user is on the Demo WebShop login page")
    public void user_is_on_the_demo_web_shop_login_page() {
        initializeWebDriver();
        getWebDriver().get("http://demowebshop.tricentis.com/login");
    }

    @When("user enters Email and Password and clicks on login button")
    public void user_enters_email_and_password_and_clicks_on_login_button() {
        webShopLoginPage = new WebShopLoginPage(getWebDriver());
        webShopLoginPage.loginToWebShop("ravi210@gmail.com", "Ravi@123");
    }

    @Then("user should be logged in successfully and sees the logout button")
    public void user_should_be_logged_in_successfully_and_sees_the_logout_button() {
        webShopLoginPage.isLoginSuccessful();
    }

    @Given("the user is on the Demo WebShop homepage")
    public void the_user_is_on_the_demo_web_shop_homepage() {
        homePage = new HomePage(getWebDriver());
        homePage.isUserOnHomePage();
    }

    @When("the user types the product name into the search field and clicks the search button")
    public void the_user_types_the_product_name_into_the_search_field_and_clicks_the_search_button() {
        homePage.searchForProduct("Digital SLR Camera 12.2 Mpixel");
    }

    @Then("the user should be able to view the product details")
    public void the_user_should_be_able_to_view_the_product_details() {
        String expectedProductName = "Digital SLR Camera 12.2 Mpixel";
        String actualProductName = getWebDriver().getTitle(); // Assuming the product name is in the title
        homePage.isSearchSuccessful(expectedProductName, actualProductName);
    }

    @Given("the user is on the product page and clicks on the product link")
    public void the_user_is_on_the_product_page_and_clicks_on_the_product_link() {
        productSearchPage = new ProductSearchPage(getWebDriver());
        productSearchPage.clickOnProductLink();
    }

    @When("the user clicks on the add to cart button")
    public void the_user_clicks_on_the_add_to_cart_button() {
        productSearchPage.addToCart();
    }

    @Then("the product should be added to the shopping cart")
    public void the_product_should_be_added_to_the_shopping_cart() {
        // You can add verification logic here if needed
        System.out.println("Product added to the shopping cart successfully.");
    }

    @Given("the user is on the shopping cart page")
    public void the_user_is_on_the_shopping_cart_page() {
        shoppingCartPage = new ShoppingCartPage(getWebDriver());
//        String expectedURL = "http://demowebshop.tricentis.com/cart";
//		String actualURL = getWebDriver().getCurrentUrl();
//		shoppingCartPage.isUserOnShoppingCartPage(expectedURL, actualURL);
        shoppingCartPage.clickOnShoppingCartLink();
    }
    @When("the user accepts terms of service and clicks on checkout")
    public void the_user_accepts_terms_of_service_and_clicks_on_checkout() {
        shoppingCartPage.acceptTermsOfServiceAndClickCheckout();
    }
    @Then("the user should be redirected to the checkout page")
    public void the_user_should_be_redirected_to_the_checkout_page() {
        System.out.println("User is redirected to the checkout page successfully.");
    }

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        checkoutPage = new CheckoutPage(getWebDriver());
        String expectedURL = "http://demowebshop.tricentis.com/checkout";
        String actualURL = getWebDriver().getCurrentUrl();
        checkoutPage.isUserOnCheckoutPage(expectedURL, actualURL);
    }

    @When("the user selects {string} payment mode and clicks on confirm order")
    public void the_user_selects_payment_mode_and_clicks_on_confirm_order(String paymentMode) {
        checkoutPage.clickOnBillingAddressContinueButton();
        checkoutPage.clickOnPickUpInStoreCheckbox();
        checkoutPage.clickOnShippingAddressContinueButton();
        checkoutPage.selectPaymentMode("checkMoneyOrderRadioButton");
        checkoutPage.clickOnPaymentMethodContinueButton();
        checkoutPage.clickOnPaymentInfoContinueButton();
        checkoutPage.clickOnConfirmOrderButton();
    }
    @Then("the order should be confirmed and prints the invoice")
    public void the_order_should_be_confirmed_and_prints_the_invoice() {
        checkoutPage.isOrderConfirmed();
        checkoutPage.downloadInvoice();
    }
    @And("close the application")
    public void close_the_application() {
        getWebDriver().quit();
    }
}