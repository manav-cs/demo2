Feature: CarSaver eCommerce (CSE) My Garage Account functionality

  Background:
    Given the CSE user navigates to the home page
    And the CSE user creates a profile
    And the CSE user clicks on the "My Account" link from the left nav

  @CSE @CSE_garage @CSE_account @regression @smoke
  Scenario: Ensure CSE account info entered during registration shows up in My Garage Update Account
    When the CSE user lands on Update Account page
    Then the CSE user should see the account info they entered during registration

  @CSE @CSE_garage @CSE_account @regression @smoke
  Scenario: Ensure the CSE user is able to update existing account info from the My Garage Update Account
    And the CSE user enters valid account information to update
    When the CSE user clicks on the Update button under My Account
    Then the CSE user should see the newly updated account info

  @CSE @CSE_garage @CSE_account @regression
  Scenario: Ensure the CSE user able to update account info with Send me Text messages checkbox enable
    And the CSE user enters valid account information to update
    And the CSE user enables Send me text messages checkbox
    When the CSE user clicks on the Update button under My Account
    Then the CSE user should see the SMS check box selected

  @CSE @CSE_garage @CSE_account @regression
  Scenario: Ensure the CSE user should not able to update the account without the first name
    And the CSE user updates account info without a first name
    When the CSE user clicks on the Update button under My Account
    Then the CSE user "first name" field should see "First Name is required"

  @CSE @CSE_garage @CSE_account @regression
  Scenario: Ensure the CSE user should not able to update the account without a last name
    And the CSE user updates account info without last name
    When the CSE user clicks on the Update button under My Account
    Then the CSE user "last name" field should see "Last Name is required"

  @CSE @CSE_garage @CSE_account @regression
  Scenario: Ensure the CSE user should not able to update the account without a phone
    And the CSE user updates account info without phone
    When the CSE user clicks on the Update button under My Account
    Then the CSE user "phone" field should see "Phone Number is required"

  @CSE @CSE_garage @CSE_account @regression
  Scenario: Ensure the CSE user should not able to update the account without email
    And the CSE user updates account info without email
    And the CSE user clicks on the Update button under My Account
    Then the CSE user "email" field should see "Email is required"

  @CSE @CSE_garage @CSE_account @regression @smoke
  Scenario Outline: Ensure the CSE user should not able to update the account with an invalid email format
    And the CSE user updates account information with "<Invalid email format>"
    When the CSE user clicks on the Update button under My Account
    Then the CSE user "email" field should see "Email is not valid"
    Examples:
      | Invalid email format |
      | test123@             |
      | test123@gmail.       |
      | test123              |