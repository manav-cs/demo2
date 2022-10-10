Feature: CarSaver eCommerce (CSE) My Garage Change Password functionality

  Background:
    Given the CSE user navigates to the home page
    And the CSE user creates a profile
    When the CSE user clicks on the "My Password" link from the left nav
    Then the CSE user should be on the Update Password page

  @CSE @CSE_garage @CSE_password @regression
  Scenario: Ensure the CSE user's old password and new password fields are required
    When the CSE user clicks on Update the button
    Then the CSE user should see the error message "Old Password is required"
    And the CSE user should see the error message "Password is required"

  @CSE @CSE_garage @CSE_password @regression @smoke
  Scenario: Ensure when CSE is updating password in My Garage it can be used for login
    When the CSE user enters the old password in the old password field
    And the CSE user enters the new password in the new password field
    And the CSE user clicks the Update button to update the password
    And the CSE user logs out
    When the CSE user logs in with the updated credentials
    Then the CSE user should see the My Garage message