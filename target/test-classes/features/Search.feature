Feature: Search

  Scenario: The user searches for "cremas" in Falabella's web page
    Given the user is in Falabella's home page
    When the user types "cremas" in the search bar and press enter
    Then the user should be redirected to "crema" resulting matches page