Feature: The Upgrade users can add vehicles to My Trades in My Garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure upgrade user lands on choose a trade option page from hamburger menu and my garage
    When the Upgrade user clicks on value trade via the hamburger menu
    Then the Upgrade user lands on to choose a trade option page
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user click on the "My Trades" link from my garage
    When the Upgrade user clicks the Add Trade button from my garage
    Then the Upgrade user lands on to choose a trade option page

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure a new user can add a trade-in vehicle via the hamburger menu
    And the Upgrade user clicks on value trade via the hamburger menu
    And the Upgrade user clicks Trade A Car
    And the Upgrade user submits a VIN
    And the Upgrade user submits vehicle information
    And the Upgrade user submits vehicle features
    And the Upgrade user confirms the vehicle condition
    And the Upgrade user's information is submitted
    And the Upgrade user's current payment information is submitted
    And the Upgrade user's Finance Company is submitted
    And the Upgrade user clicks on continues with the estimated payoff
    And the Upgrade user clicks on the view offers button
    And the Upgrade user clicks on the view vehicles button for the upgrade
    When the Upgrade user clicks on the vehicle details after returning to my trades page
    Then the Upgrade user is on the Trade Offer Details page

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure a new user can add a trade-in vehicle via my garage
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user clicks on the "My Trades" link from my garage
    And the Upgrade user submits a VIN
    And the Upgrade user submits vehicle information
    And the Upgrade user submits vehicle features
    And the Upgrade user confirms the vehicle condition
    And the Upgrade user's information is submitted
    And the Upgrade user's current payment information is submitted
    And the Upgrade user's Finance Company is submitted
    When the Upgrade user clicks on continues with the estimated payoff
    Then the Upgrade user is on the Trade Offer Details page

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure the Upgrade user can verify vehicle information on the My Trades page
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user clicks on the "My Trades" link from my garage
    And the Upgrade user submits a Trade-In Vehicle
    When the Upgrade user returns to My Trades
    Then the new trade-in vehicle is present on the My Trades page
    And the Upgrade user clicks on view offers
    And the Upgrade user can see the offer price

  @UP @UP_garage @myTrades @regression
  Scenario: Ensure the Upgrade user can verify the vehicle details link displays the Trade Offer Details page
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user clicks on the "My Trades" link from my garage
    And the Upgrade user submits a Trade-In Vehicle
    And the Upgrade user returns to My Trades
    When the Upgrade user clicks on the Vehicle Details link
    Then the Trade-Offer Details page is present

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure the Upgrade user can have more than one trade-in vehicle
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user clicks on the "My Trades" link from my garage
    And the Upgrade user submits a Trade-In Vehicle
    And the Upgrade user returns to My Trades
    And the Upgrade user sees the Choose Trade Option page after clicking Add Trade button
    And the Upgrade user sees the previous vehicle listed on the Choose Trade Option page
    And the Upgrade user submits another Trade-In Vehicle
    When the Upgrade user returns to My Trades
    Then the new trade-in vehicle is present on the My Trades page
    And the old trade-in vehicle is still present on the My Trades page

  @UP @UP_garage @myTrades @regression @smoke
  Scenario: Ensure a new user can add a trade-in vehicle via entering payoff information
    And the Upgrade user clicks on value trade via the hamburger menu
    And the Upgrade user clicks Trade A Car
    And the Upgrade user submits a VIN
    And the Upgrade user submits vehicle information
    And the Upgrade user submits vehicle features
    And the Upgrade user confirms the vehicle condition
    And the Upgrade user's information is submitted
    And the Upgrade user's current payment information is submitted
    And the Upgrade user's Finance Company is submitted
    And the Upgrade user clicks on enter payoff information button
    And the Upgrade user submits all payoff information
    And the Upgrade user clicks on the view offers button
    And the Upgrade user clicks on the view vehicles button for the upgrade
    When the Upgrade user clicks on the vehicle details after returning to my trades page
    Then the Upgrade user is on the Trade Offer Details page