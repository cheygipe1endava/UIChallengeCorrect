Feature: Delete from the shopping cart

  Background: The user signs in Falabella's web page and searches for a product
    Given the user logs in Falabella's web page
      | email    | testdummy4785692@gmail.com |
      | password | sD4eMa9TKtsFdJGs           |
    And the user searches for "historia" in search bar and selects first match
    And adds the product to the shopping bag and closes pop up

  Scenario: The user needs to delete a product from the shopping bag
  Given the user added a product and clicks on go to shopping bag button
  When the user clicks to delete the product from the shopping bag
  Then the web page displays message "tu bolsa de compras está vacía" to user saying the bag is empty
  And the user closes the session