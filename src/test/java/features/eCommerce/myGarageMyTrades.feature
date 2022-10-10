Feature: CarSaver eCommerce (CSE) a user can add vehicles to My Trades in My Garage

  Background:
    Given the CSE user navigates to the home page
    And the CSE user creates a profile
    And the CSE user clicks on the "My Trades" link from the left nav
    And the user does not have any trade vehicles
    And the user clicks the Add Trade button
    And the user clicks Trade A Car

  @CSE @CSE_garage @CSE_myTrade @regression @smoke
  Scenario: Ensure a new user can add a trade-in vehicle
    And the user submits a VIN
    And the user submits vehicle information
    And the user submits vehicle features
    And the user confirms the vehicle condition
    And the user's information is submitted
    And the user's current payment information is submitted
    And the user's Finance Company is submitted
    When the user continues with the estimated payoff
    Then the user is on the Trade Offer Details page
    And the user can see the Offer information

  @CSE @CSE_garage @CSE_myTrade @regression
  Scenario: Ensure the user can verify vehicle information on the My Trades page
    And the user submits a Trade-In Vehicle
    When the user returns to My Trades
    Then the new trade-in vehicle is present on the My Trades page
    When the user clicks on view offers
    Then the user can see the offer price

  @CSE @CSE_garage @CSE_myTrade @regression
  Scenario: Ensure the user can verify the vehicle details link displays the Trade Offer Details page
    And the user submits a Trade-In Vehicle
    And the user returns to My Trades
    When the user clicks on the Vehicle Details link
    Then the Trade-Offer Details page is present

  @CSE @CSE_garage @CSE_myTrade @regression @smoke
  Scenario: Ensure the user can have more than one trade-in vehicle
    And the user submits a Trade-In Vehicle
    And the user returns to My Trades
    And the user sees the Choose Trade Option page after clicking Add Trade button
    And the user sees the previous vehicle listed on the Choose Trade Option page
    And the user submits another Trade-In Vehicle
    When the user returns to My Trades
    Then the new trade-in vehicle is present on the My Trades page
    And the old trade-in vehicle is still present on the My Trades page