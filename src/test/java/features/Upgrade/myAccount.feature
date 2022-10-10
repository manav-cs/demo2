Feature: The Upgrade users can update my account information under my garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on my garage from the hamburger menu

  @UP @UP_garage @myAccount @regression @smoke
  Scenario: Ensure Upgrade account info entered during registration shows up in My Garage Update Account
    When the Upgrade user land Update Account page
    Then the Upgrade user should see the account info they entered during registration

  @UP @UP_garage @myAccount @regression @smoke
  Scenario: Ensure the Upgrade user can update existing account info from the My Garage Update Account
    And the Upgrade user enters valid account information to update
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user should see the newly updated account info

  @UP @UP_garage @myAccount @regression
  Scenario: Ensure the Upgrade user can update account info with Send me Text messages checkbox enable
    And the Upgrade user enters valid account information to update
    And the Upgrade user enables Send me text messages checkbox
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user should see the SMS check box selected

  @UP @UP_garage @myAccount @regression
  Scenario: Ensure the Upgrade user should not be able to update the account without the first name
    And the Upgrade user updates account info without a first name
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user "first name" field should see "First Name is required"

  @UP @UP_garage @myAccount @regression
  Scenario: Ensure the Upgrade user should not be able to update the account without a last name
    And the Upgrade user updates account info without last name
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user "last name" field should see "Last Name is required"

  @UP @UP_garage @myAccount @regression
  Scenario: Ensure the Upgrade user should not be able to update the account without a phone
    And the Upgrade user updates account info without phone
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user "phone" field should see "Phone Number is required"

  @UP @UP_garage @myAccount @regression
  Scenario: Ensure the Upgrade user should not able to update the account without email
    And the Upgrade user updates account info without email
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user "email" field should see "Email is required"

  @UP @UP_garage @myAccount @regression @smoke
  Scenario Outline: Ensure the Upgrade user should not be able to update the account with an invalid email format
    And the Upgrade user updates account information with "<Invalid email format>"
    When the Upgrade user clicks on the Update button under My Account
    Then the Upgrade user "email" field should see "Email is not valid"
    Examples:
      | Invalid email format |
      | test12345@           |
      | test1233@gmail.      |
      | test1231             |