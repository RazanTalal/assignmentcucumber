Feature: User Registration
  Scenario: Registering a new account
    Given I am on the registration page
    When I register with valid information
    Then I should see a success message