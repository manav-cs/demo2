Feature: The Upgrade users can sign into account

  Background:
    Given the Upgrade user navigates to the homepage

  @UP @UP_signIn @regression @smoke
  Scenario: Ensure existing profile user can login in Upgrade
    And the Upgrade user creates a new profile
    And the Upgrade user signs out via the hamburger menu
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    When the Upgrade user login to the account
    Then the Upgrade user should see the Welcome Back Message along with hardcoded first name

  @UP @UP_signIn @regression @smoke
  Scenario: Ensure existing profile user can logout from Upgrade
    And the Upgrade user login to the account
    When the Upgrade user signs out via the hamburger menu
    Then the Upgrade user should successfully return to the homepage

  @UP @UP_signIn @regression @smoke
  Scenario: Ensure profile users are not able to sign in to their account with an invalid password using UP
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user enters a invalid email address
    And the Upgrade user enters an invalid password
    When the Upgrade user clicks on the "Sign In" button
    Then the Upgrade user should see the "The email address or password are not correct" message