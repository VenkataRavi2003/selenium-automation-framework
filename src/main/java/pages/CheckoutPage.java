package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver wbDriver;
    public CheckoutPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
        PageFactory.initElements(wbDriver, this);
    }

    @FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[1]")
    WebElement billingAdrressContinueButton;

    @FindBy(xpath="//input[@id='PickUpInStore']")
    WebElement pickUpInStoreCheckbox;

    @FindBy(xpath="(//input[@class='button-1 new-address-next-step-button'])[2]")
    WebElement shippingAddressContinueButton;

    @FindBy(xpath="//input[@id='paymentmethod_0']")
    WebElement cashOnDeliveryRadioButton;

    @FindBy(xpath="//input[@id='paymentmethod_1']")
    WebElement checkMoneyOrderRadioButton;

    @FindBy(xpath="//input[@id='paymentmethod_3']")
    WebElement creditCardRadioButton;

    @FindBy(xpath="//input[@id='paymentmethod_3']")
    WebElement purchaseOrderRadioButton;

    @FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
    WebElement paymentMethodContinueButton;

    @FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']")
    WebElement paymentInfoContinueButton;

    @FindBy(xpath="//input[@class='button-1 confirm-order-next-step-button']")
    WebElement confirmOrderButton;

    @FindBy(xpath="//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement orderConfirmationMessage;

    @FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
    WebElement orderCompletedContinueButton;

    @FindBy(xpath="//a[contains(text(),'Orders')]")
    WebElement ordersLink;

    @FindBy(xpath="(//input[@class='button-2 order-details-button'])[1]")
    WebElement orderDetailsButton;

    @FindBy(xpath="//a[@class='button-2 pdf-order-button']")
    WebElement downloadInvoiceButton;

    public void isUserOnCheckoutPage(String expectedURL, String actualURL) {
        try {
            if (actualURL.equals(expectedURL)) {
                System.out.println("User is on the Checkout page");
            } else {
                System.out.println("User is NOT on the Checkout page");
            }
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }
    public void clickOnBillingAddressContinueButton() {
        try {
            billingAdrressContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on billing address continue button: " + e.getMessage());
        }
    }
    public void clickOnPickUpInStoreCheckbox() {
        try {
            pickUpInStoreCheckbox.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on pick up in store checkbox: " + e.getMessage());
        }
    }
    public void clickOnShippingAddressContinueButton() {
        try {
            shippingAddressContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on shipping address continue button: " + e.getMessage());
        }
    }
    public void selectPaymentMode(String paymentMode) {
        try {
            switch (paymentMode.toLowerCase()) {
                case "cashondelivery":
                    cashOnDeliveryRadioButton.click();
                    break;
                case "checkmoneyorder":
                    checkMoneyOrderRadioButton.click();
                    break;
                case "creditcard":
                    creditCardRadioButton.click();
                    break;
                case "purchaseorder":
                    purchaseOrderRadioButton.click();
                    break;
                default:
                    System.out.println("Invalid payment mode: " + paymentMode);
            }
        } catch (Exception e) {
            System.out.println("Error occurred while selecting payment mode: " + e.getMessage());
        }
    }
    public void clickOnPaymentMethodContinueButton() {
        try {
            paymentMethodContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on payment method continue button: " + e.getMessage());
        }
    }
    public void clickOnPaymentInfoContinueButton() {
        try {
            paymentInfoContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on payment info continue button: " + e.getMessage());
        }
    }
    public void clickOnConfirmOrderButton() {
        try {
            confirmOrderButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on confirm order button: " + e.getMessage());
        }
    }
    public void isOrderConfirmed() {
        try {
            if(orderConfirmationMessage.isDisplayed()) {
                System.out.println("Order has been successfully processed!");
                orderCompletedContinueButton.click();
            } else {
                System.out.println("Order confirmation message is not displayed.");
            }
        }catch(Exception e) {
            System.out.println("Error occurred while confirming the order: " + e.getMessage());
        }
    }

    public void downloadInvoice() {
        try {
            ordersLink.click();
            orderDetailsButton.click();
            downloadInvoiceButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while downloading the invoice: " + e.getMessage());
        }
    }
}


/*
    WebDriver wbDriver;

    // Locators
    By billingAddressContinueButtonLocator = By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]");
    By pickUpInStoreCheckboxLocator = By.xpath("//input[@id='PickUpInStore']");
    By shippingAddressContinueButtonLocator = By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]");
    By cashOnDeliveryRadioButtonLocator = By.xpath("//input[@id='paymentmethod_0']");
    By checkMoneyOrderRadioButtonLocator = By.xpath("//input[@id='paymentmethod_1']");
    By creditCardRadioButtonLocator = By.xpath("//input[@id='paymentmethod_3']");
    By purchaseOrderRadioButtonLocator = By.xpath("//input[@id='paymentmethod_3']");
    By paymentMethodContinueButtonLocator = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
    By paymentInfoContinueButtonLocator = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
    By confirmOrderButtonLocator = By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
    By orderConfirmationMessageLocator = By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
    By orderCompletedContinueButtonLocator = By.xpath("//input[@class='button-2 order-completed-continue-button']");
    By ordersLinkLocator = By.xpath("//a[contains(text(),'Orders')]");
    By orderDetailsButtonLocator = By.xpath("(//input[@class='button-2 order-details-button'])[1]");
    By downloadInvoiceButtonLocator = By.xpath("//a[@class='button-2 pdf-order-button']");

    public CheckoutPage(WebDriver wbDriver) {
        this.wbDriver = wbDriver;
    }

    public void isUserOnCheckoutPage(String expectedURL, String actualURL) {
        try {
            if (actualURL.equals(expectedURL)) {
                System.out.println("User is on the Checkout page");
            } else {
                System.out.println("User is NOT on the Checkout page");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void clickOnBillingAddressContinueButton() {
        try {
            WebElement billingAddressContinueButton = wbDriver.findElement(billingAddressContinueButtonLocator);
            billingAddressContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on billing address continue button: " + e.getMessage());
        }
    }

    public void clickOnPickUpInStoreCheckbox() {
        try {
            WebElement pickUpInStoreCheckbox = wbDriver.findElement(pickUpInStoreCheckboxLocator);
            pickUpInStoreCheckbox.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on pick up in store checkbox: " + e.getMessage());
        }
    }

    public void clickOnShippingAddressContinueButton() {
        try {
            WebElement shippingAddressContinueButton = wbDriver.findElement(shippingAddressContinueButtonLocator);
            shippingAddressContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on shipping address continue button: " + e.getMessage());
        }
    }

    public void selectPaymentMode(String paymentMode) {
        try {
            WebElement paymentModeElement;
            switch (paymentMode.toLowerCase()) {
                case "cashondelivery":
                    paymentModeElement = wbDriver.findElement(cashOnDeliveryRadioButtonLocator);
                    break;
                case "checkmoneyorder":
                    paymentModeElement = wbDriver.findElement(checkMoneyOrderRadioButtonLocator);
                    break;
                case "creditcard":
                    paymentModeElement = wbDriver.findElement(creditCardRadioButtonLocator);
                    break;
                case "purchaseorder":
                    paymentModeElement = wbDriver.findElement(purchaseOrderRadioButtonLocator);
                    break;
                default:
                    System.out.println("Invalid payment mode: " + paymentMode);
                    return;
            }
            paymentModeElement.click();
        } catch (Exception e) {
            System.out.println("Error occurred while selecting payment mode: " + e.getMessage());
        }
    }

    public void clickOnPaymentMethodContinueButton() {
        try {
            WebElement paymentMethodContinueButton = wbDriver.findElement(paymentMethodContinueButtonLocator);
            paymentMethodContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on payment method continue button: " + e.getMessage());
        }
    }

    public void clickOnPaymentInfoContinueButton() {
        try {
            WebElement paymentInfoContinueButton = wbDriver.findElement(paymentInfoContinueButtonLocator);
            paymentInfoContinueButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on payment info continue button: " + e.getMessage());
        }
    }

    public void clickOnConfirmOrderButton() {
        try {
            WebElement confirmOrderButton = wbDriver.findElement(confirmOrderButtonLocator);
            confirmOrderButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on confirm order button: " + e.getMessage());
        }
    }

    public void isOrderConfirmed() {
        try {
            WebElement orderConfirmationMessage = wbDriver.findElement(orderConfirmationMessageLocator);
            if (orderConfirmationMessage.isDisplayed()) {
                System.out.println("Order has been successfully processed!");
                WebElement orderCompletedContinueButton = wbDriver.findElement(orderCompletedContinueButtonLocator);
                orderCompletedContinueButton.click();
            } else {
                System.out.println("Order confirmation message is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while confirming the order: " + e.getMessage());
        }
    }

    public void downloadInvoice() {
        try {
            WebElement ordersLink = wbDriver.findElement(ordersLinkLocator);
            ordersLink.click();
            WebElement orderDetailsButton = wbDriver.findElement(orderDetailsButtonLocator);
            orderDetailsButton.click();
            WebElement downloadInvoiceButton = wbDriver.findElement(downloadInvoiceButtonLocator);
            downloadInvoiceButton.click();
        } catch (Exception e) {
            System.out.println("Error occurred while downloading the invoice: " + e.getMessage());
        }
    }
*/
