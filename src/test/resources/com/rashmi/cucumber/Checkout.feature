Feature: Checkout
  User should be able to add products to the cart and check out

  Scenario: Add products to the cart and checkout
    Given I am on the "Condiments" section
    When I add "Kissan Mixed Fruit Jam 500g" to the cart
    And checkout
    Then I should be taken to the information page

