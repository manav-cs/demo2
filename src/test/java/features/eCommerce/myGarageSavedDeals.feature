Feature: CarSaver eCommerce (CSE) user can save deals to My Garage

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page for a vehicle
    When the CSE user clicks the Save button on the deal page
    And the CSE user clicks Create an Account
    And the CSE user creates a new account from the Deal page
    And the CSE user submits personal finance information
    And the offers ready modal appears
    Then the deal page is present

  @CSE @CSE_garage @CSE_mySaved @regression
  Scenario: Ensure user can save a deal under a brand new user
    When the CSE user clicks the Save button on the deal page
    Then the Deal Name modal appears
    When the Deal Name modal is canceled
    Then the deal page is present
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user is on the Saved Deals page in My Garage
    And the recently saved deal is present
    When the CSE user clicks the View Deal button
    Then the deal page is present with the saved button

  @CSE @CSE_garage @CSE_mySaved @regression @smoke
  Scenario: Ensure user can alter a saved deal
    When the CSE user saves a deal
    And the CSE user clicks the View Deal button
    And the CSE user changes the check box selection
    And the CSE user changes the down payment for finance to "1234"
    And the CSE user clicks save and confirms the save
    And the CSE user goes to My Garage
    And the recently saved deal is present
    And the CSE user clicks the View Deal button
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_mySaved @regression
  Scenario: Ensure user can delete a deal
    When the CSE user saves a deal
    And the CSE user deletes the saved deal
    Then the saved deal is no longer present