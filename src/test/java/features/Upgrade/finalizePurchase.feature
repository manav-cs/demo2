Feature: The Upgrade users can finalize the purchase

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars to navigate to the offer details page

  @UP @finalize_Purchase @regression @smoke
  Scenario: Ensure the Upgrade user can finalize a lease purchase
    And the Upgrade user switches to the Lease tab
    And the Upgrade user clicks on the Apply For Credit button
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

  @UP @finalize_Purchase @regression @smoke
  Scenario: Ensure the Upgrade user can finalize a finance purchase
    And the Upgrade user switches to the Finance tab
    And the Upgrade user clicks on the Apply For Credit button
    And the Get Approved page is present
    When the Get Approved finance page is populated correctly
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

  @UP @finalize_Purchase @regression
  Scenario: Ensure the Upgrade user can go back to the deal page and return to the approval page
    And the Upgrade user switches to the Lease tab
    When the Upgrade user clicks on the Apply For Credit button
    Then the Get Approved page is present
    And the Upgrade user clicks the Back to Deal button
    When the Upgrade user clicks on the Apply For Credit button
    Then the Get Approved page is present
