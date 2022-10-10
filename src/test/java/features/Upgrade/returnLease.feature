Feature: The Upgrade users can return a lease

  Background:
    Given the Upgrade user navigates to the homepage
    When the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on value trade via the hamburger menu
    Then the Upgrade user lands on to choose a trade option page

  @UP @UP_garage @myTrades @return_Lease @regression @smoke
  Scenario: Ensure Upgrade user can return a leased vehicle via the hamburger menu
    When the Upgrade user clicks the Return a Lease button
    And the Upgrade user submits a VIN
    And the Upgrade user submits lease vehicle information
    And the Upgrade user's information is submitted
    And the Upgrade user's current payment information is submitted
    And the Upgrade user's Finance Company is submitted
    And the Upgrade user clicks on continues with the estimated payoff
    And the Upgrade user clicks on the view offers button
    And the Upgrade user clicks on the view vehicles button for the upgrade
    And the Upgrade user clicks on the vehicle details after returning to my trades page
    Then the Upgrade user can see Incomplete as the offer price

  @UP @UP_garage @myTrades @return_Lease @regression @smoke
  Scenario: Ensure Upgrade user can return a leased vehicle via entering payoff information
    When the Upgrade user clicks the Return a Lease button
    And the Upgrade user submits a VIN
    And the Upgrade user submits lease vehicle information
    And the Upgrade user's information is submitted
    And the Upgrade user's current payment information is submitted
    And the Upgrade user's Finance Company is submitted
    And the Upgrade user clicks on enter payoff information button
    And the Upgrade user submits all payoff information
    And the Upgrade user clicks on the view offers button
    And the Upgrade user clicks on the view vehicles button for the upgrade
    And the Upgrade user clicks on the vehicle details after returning to my trades page
    Then the Upgrade user can see Incomplete as the offer price

  @UP @UP_garage @myTrades @return_Lease @regression @smoke
  Scenario: Ensure Upgrade user can finish filling out leased vehicle information
    When the Upgrade user submits a lease vehicle trade-in
    And the Upgrade user clicks on the view offers button
    And the Upgrade user views the vehicle after returning to my trades page
    And the new trade-in vehicle is present on the My Trades page
    And the Upgrade user clicks the Complete Trade Offer button
    And the Upgrade user re-submits all vehicle information
    Then the new trade-in vehicle is present on the My Trades page
    And the Complete Trade Offer button is not present
    When the Upgrade user clicks on view offers
    Then the Upgrade user can see the offer price no longer says Incomplete