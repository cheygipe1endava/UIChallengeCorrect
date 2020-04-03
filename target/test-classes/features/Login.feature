Feature: Login

  Scenario: The user unsuccessfully signs in Falabella's web page with both wrong credentials
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy@gmail.com |
      | password | 1234                |
    And clicks login button
    Then the page shows error with email/password to the user

  Scenario: The user unsuccessfully signs in Falabella's web page with wrong password
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy4785692@gmail.com |
      | password | 1234                       |
    And clicks login button
    Then the page shows error with email/password to the user

  Scenario: The user unsuccessfully signs in Falabella's web page with wrong email
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy@gmail.com |
      | password | sD4eMa9TKtsFdJGs    |
    And clicks login button
    Then the page shows error with email/password to the user

  Scenario: The user unsuccessfully signs in Falabella's web page with blank fields
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    |  |
      | password |  |
    Then user cannot click disabled login button

  Scenario: The user unsuccessfully signs in Falabella's web page with email as blank field
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    |                  |
      | password | sD4eMa9TKtsFdJGs |
    Then user cannot click disabled login button
    And the page shows error with blank email field

  Scenario: The user unsuccessfully signs in Falabella's web page with password as blank field
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy4785692@gmail.com |
      | password |                            |
    Then user cannot click disabled login button

  Scenario: The user unsuccessfully signs in Falabella's web page with password not meeting the required eight characters format
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy4785692@gmail.com |
      | password | 1234567                    |
    And clicks login button
    Then user cannot click disabled login button
    And the page shows error with wrong password format

  Scenario: The user successfully signs in Falabella's web page
    Given the user opens login form overlay from Falabella's home page
    When the user types in its credentials for username and password
      | email    | testdummy4785692@gmail.com |
      | password | sD4eMa9TKtsFdJGs           |
    And clicks login button
    Then the user should be signed in
    And the user closes the session

