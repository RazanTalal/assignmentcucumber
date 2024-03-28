Feature: User Registration
  As a potential customer
  I want to register for an account
  So that I can access the features of the website

  Scenario: Register a new account and verify login
    Given I am on the registration page
    When I fill in the registration form with valid information
    And I select Newsletter Subscribe and Privacy Policy
    And I submit the registration form
    Then I should see a confirmation message
    And I should be logged into my new account
