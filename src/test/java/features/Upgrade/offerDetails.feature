Feature: The Upgrade users can view all details on the offer details page

  Background:
    Given the Upgrade user navigates to the homepage
    When the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars to navigate to the offer details page

  @UP @Offer_Details @regression @smoke
  Scenario: Ensure the Upgrade user can go back to vehicle details
    And the Upgrade user switches to the Lease tab
    And the Upgrade user clicks on the vehicle details button from the top nav
    And the Upgrade user saves the deal to navigate back to the offer details page
    When the Upgrade user clicks on the vehicle details button from the right nav
    Then the vehicle details page is present

  @UP @Offer_Details @regression @smoke
  Scenario: Ensure the Upgrade user can get to trade value from the offer details page
    And the Upgrade user switches to the Cash tab
    And the Upgrade user clicks on the get trade value button
    And the Upgrade user clicks Trade A Car
    When the Upgrade user submits a Trade-In Vehicle the deal
    Then the Upgrade user is presented with the trade vehicle

  @UP @Offer_Details @regression @smoke
  Scenario: Ensure the Upgrade user can get financing from the offer details page
    And the Upgrade user switches to the Lease tab
    And the Upgrade user clicks on the get financing button
    And the Get Approved page is present
    When the Get Approved page is populated correctly
    Then the Upgrade user fills out and submits the Get Started Page
    And the Employment Information is submitted
    When the Upgrade user Vehicle Information is submitted
    Then the Account Setup page appears
    And a positive loan decision is made
    When the Upgrade user submits the Lease Options
    And the Upgrade user submits the Sign & Drive page
    Then the Upgrade user receives the certificate and verifies the certificate
    When the Upgrade user clicks on my garage from the hamburger menu
    Then the leased vehicle is present under Saved Deals

  @UP @Offer_Details @regression @smoke
  Scenario: Ensure the Upgrade user can verify disclaimers on the offer details page
    When the Upgrade user lands on the offer page
    Then the Upgrade user verifies all disclaimers exist