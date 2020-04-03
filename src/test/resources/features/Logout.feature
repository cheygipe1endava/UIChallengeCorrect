Feature: Logout

  Background: The user signs in Falabella's web page
    Given the user logs in Falabella's web page
      | email    | testdummy4785692@gmail.com |
      | password | sD4eMa9TKtsFdJGs           |

  Scenario: The user successfully signs out of Falabella's web page
    Given the user is currently logged in Falabella's home page
    When the user hover on account div
    And clicks logout option
    Then the user should be signed out