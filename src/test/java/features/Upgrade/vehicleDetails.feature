Feature: The Upgrade users can view all details on the vehicle details page

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    When the Upgrade user clicks on shop new cars to navigate to the vehicle details page
    Then the vehicle details page is present

  @UP @vehicle_Details @regression @smoke @BUG @U2-1060
  Scenario: Ensure the Upgrade user can apply for credit from the vehicle details page
    And the Upgrade user clicks on the next button to apply for credit
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

  @UP @vehicle_Details @regression @smoke
  Scenario: Ensure the Upgrade user can search for new vehicles to view details
    And the Upgrade user clicks on the new search button
    When the Upgrade user selects a new vehicle to view details
    Then the vehicle details page is present

  @UP @vehicle_Details @regression @smoke
  Scenario: Ensure the Upgrade user can select another vehicle you may also like from the vehicle details page
    And the Upgrade user clicks on you may also like
    When the Upgrade user selects another vehicle under you may also like
    Then the vehicle details page is present

  @UP @vehicle_Details @regression
  Scenario: Ensure the Upgrade user can view all specs & features from the vehicle details page
    And the Upgrade user clicks on all specs & features
    When the Upgrade user returns to recently viewed vehicles
    Then the Upgrade user can see the most recently viewed vehicle