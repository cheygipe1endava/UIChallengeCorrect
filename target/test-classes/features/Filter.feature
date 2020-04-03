Feature: Filter

  Background: The user signs in Falabella's web page
    Given the user searches for "crema" in search bar

  Scenario: The user needs to filter by object price
    Given the user is in crema product page
    When the user clicks price button
    And types prices between "5000" to "20000" in price fields and applies the price filter
    Then the user should only see products with prices in the input range

  Scenario: The user cannot filter by object price with a lower final price
    Given the user is in crema product page
    When the user clicks price button
    And types prices between "5000" to "4900" in price fields and applies the price filter
    Then the page shows error with wrong price range

  Scenario: The user cannot filter by object price with empty price fields
    Given the user is in crema product page
    When the user clicks price button
    And types prices between " " to " " in price fields and applies the price filter
    Then the user cannot click a disabled apply filter button

  Scenario: The user can filter by object price with only initial price
    Given the user is in crema product page
    When the user clicks price button
    And types prices between "5000" to " " in price fields and applies the price filter
    Then the user should only see products with prices in the input range

  Scenario: The user can filter by object price with only final price
    Given the user is in crema product page
    When the user clicks price button
    And types prices between " " to "20000" in price fields and applies the price filter
    Then the user should only see products with prices in the input range