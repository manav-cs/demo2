Feature: Atlas (Admin panel) Sign-In Feature

  Background:
    Given the atlas user navigates to the home page

  @atlas @atlas_login @TC-1686 @regression @smoke
  Scenario: Ensure atlas dealer user can successfully logout
    And the atlas dealer user logs in with valid credentials
    When the atlas user clicks on the Logout icon
    Then the atlas user should be logout and see the following "Sign in to Atlas" message

  @atlas @atlas_login @TC-1686 @regression @smoke
  Scenario: Ensure atlas program user can successfully logout
    And the atlas program user logs in with valid credentials
    When the atlas user clicks on the Logout icon
    Then the atlas user should be logout and see the following "Sign in to Atlas" message

  @atlas @atlas_login @TC-1436 @regression @smoke
  Scenario: Ensure atlas dealer user can successfully login
    And the atlas dealer user enters valid credentials
    When the atlas user clicks on the "Login" button
    Then the atlas user should be login and see the following "Welcome to Atlas!" message

  @atlas @atlas_login @TC-1436 @regression @smoke
  Scenario: Ensure atlas program user can successfully login
    And the atlas program user enters valid credentials
    When the atlas user clicks on the "Login" button
    Then the atlas user should be login and see the following "Welcome to Atlas!" message

  @atlas @atlas_login @TC-1441 @regression @smoke
  Scenario: Ensure atlas dealer user can not able to log in with an invalid credential
    And the atlas user enters invalid credentials
    When the atlas user clicks on the "Login" button
    Then the atlas user should see the following "No account found for this email and password." message