Feature: The Upgrade users can save deals under my garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile

  @UP @UP_garage @saved_Deals @regression @smoke
  Scenario: Ensure the Upgrade user doesn't see any vehicle in the saved deals after creating a new account
    When the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade clicks on the Saved Deals page button
    Then the Upgrade user doesn't see any vehicle in the Saved Deals

  @UP @UP_garage @saved_Deals @regression @smoke
  Scenario: Ensure the Upgrade user can save a deal
    When the Upgrade user clicks on shop new cars to select a vehicle to save
    And the Upgrade user clicks on the Save button
    Then the Upgrade user confirms to save the vehicle
    When the Upgrade user clicks on my garage to navigate back to the Saved Deals page
    Then the Upgrade user verifies the saved vehicle
    When the Upgrade user clicks on the View Deal button
    Then the Upgrade user lands on the Deal page

  @UP @UP_garage @saved_Deals @regression @smoke
  Scenario: Ensure the Upgrade user can save multiple deals
    When the Upgrade user clicks on shop new cars to select a vehicle to save
    And the Upgrade user clicks on the Save button
    Then the Upgrade user confirms to save the vehicle
    When the Upgrade user clicks on shop new cars to select another vehicle to save
    And the Upgrade user clicks on my garage to navigate back to the Saved Deals page
    Then the Upgrade user verifies multiple saved deals

  @UP @UP_garage @saved_Deals @regression @smoke
  Scenario: Ensure the Upgrade user can add changes to the saved deals
    When the Upgrade user shop new cars to save and confirm deal
    And the Upgrade user clicks on my garage to navigate back to the Saved Deals page
    Then the Upgrade user verifies the saved vehicle to clicks on the View Deal button
    When the Upgrade user changes the mileage per year
    And the Upgrade user clicks on the Save Changes button
    And the Upgrade user clicks on my garage to navigate to Saved Deal page
    Then the Upgrade user lands on the Deal page

  @UP @UP_garage @saved_Deals @regression @smoke
  Scenario: Ensure Upgrade user can delete a deal
    When the Upgrade user shop new cars to save and confirm deal
    And the Upgrade user clicks on my garage to navigate back to the Saved Deals page
    And the Upgrade user deletes the saved deal
    Then the Upgrade user is no longer present with a saved deal