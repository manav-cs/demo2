Feature: The Upgrade users can update my password information under my garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user accesses My Password via the hamburger link
    And the Upgrade user should be on the Update Password page

  @UP @UP_garage @myPassword @regression
  Scenario: Ensure the Upgrade user's old password and new password fields are required
    When the Upgrade user clicks on Update the button
    Then the Upgrade user should see the error message "Old Password is required"
    And the Upgrade user should see the error message "Password is required"

  @UP @UP_garage @myPassword @regression @smoke
  Scenario: Ensure when Upgrade is updating the password in My Garage it can be used for login
    When the Upgrade user enters the old password in the old password field
    And the Upgrade user enters the new password in the new password field
    And the Upgrade user clicks the Update button to update the password
    And the Upgrade user logs out
    When the Upgrade user logs in with the updated credentials
    Then the Upgrade user should see the My Garage message