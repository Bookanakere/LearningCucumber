Feature: Search
  User should be able to search any product

  Scenario: Search by text input
    Given I am on the homepage of the desidutchstore
    When I search for "snacks"
    Then I should see all the products under the category of snacks