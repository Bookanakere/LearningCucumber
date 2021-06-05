Feature: Checkout
  User should be able to add products to the cart and check out

  Scenario: Add products to the cart and checkout
    Given I am on the homepage of the desidutchstore
    When I add products to the cart
    And checkout
    Then I should be taken to the payment page

