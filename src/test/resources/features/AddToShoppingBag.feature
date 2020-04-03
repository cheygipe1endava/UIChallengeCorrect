Feature: Add to shopping cart

  Background: The user signs in Falabella's web page and searches for a product
    Given the user logs in Falabella's web page
      | email    | testdummy4785692@gmail.com |
      | password | sD4eMa9TKtsFdJGs           |
    And the user searches for "historia" in search bar and selects first match

  Scenario: The user needs to add a product to the shopping bag
    Given the user is in a product page
    When the user clicks button to add the product to the bag
    Then the web page displays pop up message to user with the confirmation
    And the user goes to shopping bag to delete the product from it and message "tu bolsa de compras está vacía" is displayed
    And the user closes the session



