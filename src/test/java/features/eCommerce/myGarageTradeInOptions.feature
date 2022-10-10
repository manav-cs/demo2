Feature: CarSaver eCommerce (CSE) verifying the Choose Trade Option page accessed via My Garage

  Background:
    Given the CSE user navigates to the home page
    And the CSE user creates a profile
    When the CSE user clicks "Value Trade" in the hamburger menu
    Then the CSE user is on the Choose Trade Option page

  @CSE @CSE_garage @CSE_myLease @regression @smoke
  Scenario: Ensure CSE user can return a leased vehicle
    When the user clicks the Return a Lease icon
    And the user submits a VIN
    And the user submits lease vehicle information
    And the user's information is submitted
    And the user's current payment information is submitted
    And the user's Finance Company is submitted
    And the user continues with the estimated lease payoff
    Then the new trade-in vehicle is present on the My Trades page
    When the user clicks on view offers
    Then the user can see Incomplete as the offer price

  @CSE @CSE_garage @CSE_myLease @regression
  Scenario: Ensure CSE user can finish filling out lease vehicle information
    When the user submits a lease vehicle trade in
    And the new trade-in vehicle is present on the My Trades page
    And the user clicks the Complete Trade Offer button
    And the user submits transmission and color vehicle information
    And the user submits vehicle features
    And the user confirms the vehicle condition
    And the user's information is submitted
    And the user's current payment information is submitted
    And the user's Finance Company is submitted
    And the user continues with the estimated lease payoff
    Then the new trade-in vehicle is present on the My Trades page
    And the Complete Trade Offer button is not present
    When the user clicks on view offers
    Then the user can see the offer price no longer says Incomplete

  @CSE @CSE_garage @CSE_myLease @regression @smoke
  Scenario: Ensure when CSE user chooses the No Trade option no vehicle is added
    And the user sees the Trade Option buttons
    When the user clicks the Which Option link
    Then the user sees the Choose Trade Options help modal
    When the user closes the Choose Trade Options help modal
    And the user clicks the No Trade option
    And submit the user's financial information if necessary
    And the CSE user clicks on the "My Trades" link from the left nav
    Then the user does not have any trade vehicles
    When the CSE user clicks "Value Trade" in the hamburger menu
    And the CSE user is on the Choose Trade Option page
    And the user clicks the No Trade option
    Then the user does not have any trade vehicles