Feature: Search
  User should be able to search any product

  Scenario: Search by collection
    Given I am on the homepage of the desidutchstore
    When I search for collection of "vegetables"
    Then I should see "Vegetables"

  Scenario: Search by category
    Given I am on the homepage of the desidutchstore
    When I search for category of "Vegetable"
    Then I should see items for "Vegetable"