Feature: CarSaver eCommerce (CSE) user can finalize a deal

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page to buy a vehicle
    And the CSE user creates a new account
    And the offers ready modal appears
    And the deal page is present

  @CSE @CSE_garage @CSE_dealFinalize @regression @smoke
  Scenario: Ensure user can finalize a lease deal
    When the CSE user switches to the Lease tab
    And the user clicks the Apply For Credit button
    Then the Get Approved page is present
    And the Get Approved page is populated correctly
    When the CSE user fills out and submits the Get Started Page
    And the Employment Information is submitted
    And the Vehicle Information is submitted
    Then the Account Setup page appears
    When a positive loan decision is made
    Then the CSE user is on the Lease Options page
    When the CSE user submits the Lease Options
    And the CSE user submits the Sign & Drive page
    Then the CSE user is on the Order Confirmation page
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the leased vehicle is present under Saved Deals

  @CSE @CSE_garage @CSE_dealFinalize @regression @smoke
  Scenario: Ensure user can finalize a finance deal
    When the CSE user switches to the Finance tab
    And the user clicks the Apply For Credit button
    Then the Get Approved page is present
    And the Get Approved finance page is populated correctly
    When the CSE user fills out and submits the Get Started Page
    And the Employment Information is submitted
    And the Vehicle Finance Information is submitted
    Then the Account Setup page appears
    When a positive loan decision is made
    Then the CSE user is on the Finance Options page
    When the CSE user submits the Financing Options
    And the CSE user submits the Sign & Drive page
    Then the CSE user is on the Order Confirmation page
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the financed vehicle is present under Saved Deals

  @CSE @CSE_garage @CSE_dealFinalize @regression
  Scenario: Ensure user can go back to the deal page and return to the approval page
    When the CSE user switches to the Lease tab
    And the user clicks the Apply For Credit button
    Then the Get Approved page is present
    When the user clicks the Back to Deal button
    Then the deal page is present with the saved button
    When the user clicks the Apply For Credit button
    Then the Get Approved page is present
