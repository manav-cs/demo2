Feature: The Upgrade users can change a trade

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars to navigate to the offer details page
    Then the Upgrade user switches to the Finance tab

  @UP @change_Trade @regression @smoke
  Scenario: Ensure the Upgrade user can add a trade-in vehicle from the deal page
    And the Upgrade user clicks to add a trade on the deal page
    When the Upgrade user submits a Trade-In Vehicle the deal
    Then the Upgrade user is presented with the trade vehicle

  @UP @change_Trade @regression @smoke
  Scenario: Ensure the Upgrade user can change trade from the deal page
    And the Upgrade user clicks to add a trade on the deal page
    And the Upgrade user submits a Trade-In Vehicle the deal
    Then the Upgrade user is presented with the trade vehicle
    And the Upgrade user clicks on the change trade link
    When the Upgrade user submits a Trade-In Vehicle the deal
    Then the Upgrade user is presented with the trade vehicle

  @UP @change_Trade @regression
  Scenario: Ensure the Upgrade user can remove the trade from the deal page
    And the Upgrade user clicks to add a trade on the deal page
    And the Upgrade user submits a Trade-In Vehicle the deal
    And the Upgrade user is presented with the trade vehicle
    When the Upgrade user clicks on change trade to add no trade
    Then the Upgrade user verifies no trade vehicle has been added



