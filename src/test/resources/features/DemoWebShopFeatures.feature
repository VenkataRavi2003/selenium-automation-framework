Feature: Placing Order In Demo WebShop Application

  Scenario: Logging into Demo WebShop
    Given user is on the Demo WebShop login page
    When user enters Email and Password and clicks on login button
    Then user should be logged in successfully and sees the logout button

  Scenario: Searching for a product
    Given the user is on the Demo WebShop homepage
    When the user types the product name into the search field and clicks the search button
    Then the user should be able to view the product details

  Scenario: Adding a product to the shopping cart
    Given the user is on the product page and clicks on the product link
    When the user clicks on the add to cart button
    Then the product should be added to the shopping cart

  Scenario: Proceeding to checkout
    Given the user is on the shopping cart page
    When the user accepts terms of service and clicks on checkout
    Then the user should be redirected to the checkout page

  Scenario: Confirming the order
    Given the user is on the checkout page
    When the user selects "cashondelivery" payment mode and clicks on confirm order
    Then the order should be confirmed and prints the invoice
    And close the application