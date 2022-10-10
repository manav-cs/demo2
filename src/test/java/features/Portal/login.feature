Feature: Portal (Admin panel) Sign In Feature

  Background:
    Given the portal user navigates to the home page

  @portal @portal_login @TC-1687 @regression @smoke
  Scenario: Ensure portal admin user can successfully logout
    And the portal user logs in with valid credentials
    And the portal user clicks on the Logout button
    When the portal user clicks on Remind me later button
    Then the portal user should be logout with the following "You have been logged out." message

  @portal @portal_login @TC-1684 @regression @smoke
  Scenario: Ensure portal admin user can successfully login
    When the portal user logs in with valid credentials
    Then the portal user should be login with the following "Welcome to the CarSaver Portal" message

  @portal @portal_login @TC-1685 @regression @smoke
  Scenario: Ensure portal admin user can not successfully login with invalid credentials
    And the portal users enter invalid credentials
    And the portal user clicks on the Login button
    When the portal user clicks on Remind me later button
    Then the portal user should be able to see the validation message "Incorrect email and/or password"