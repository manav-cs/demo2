Feature: CarSaver eCommerce (CSE) user can contact a dealer

  Background:
    Given the CSE user navigates to the home page
    When the CSE user goes to the deal page for a vehicle
    And the vehicle and dealer information is retrieved

  @CSE @CSE_garage @CSE_contactDealer @regression
  Scenario: Ensure user is asked to sign in or create an account when attempting to contact a dealer
    And the CSE user clicks on the "Get Trade Offer" deal button
    Then the sign-in modal appears
    When the CSE user closes the sign-in modal
    And the CSE user clicks on the "Get Pre-approved" deal button
    Then the sign-in modal appears
    When the CSE user closes the sign-in modal
    And the CSE user clicks on the "Contact Dealer" deal button
    Then the sign-in modal appears
    When the CSE user closes the sign-in modal
    And the CSE user clicks on the "Test Drive" deal button
    Then the sign-in modal appears
    When the CSE user closes the sign-in modal
    And the CSE user clicks on the "Get Personalized Payments" deal button
    Then the sign-in modal appears

  @CSE @CSE_garage @CSE_contactDealer @regression
  Scenario Outline: Ensure the different options on the Contact Dealer page
    And the CSE user clicks on the "Contact Dealer" deal button
    And the CSE user clicks Create an Account
    And the CSE user creates a new account from the Deal page
    Then the CSE user is on the Contact Dealer page
    And the vehicle information is present
    And the dealer name is present
    And the text area is disabled
    When the CSE user selects "Vehicle Availability" from the Contact Dealer drop down
    Then the Vehicle Availability Text Area contains the default text
    When the CSE user selects option "<menu option>" from the Contact Dealer drop down
    Then the Text Area contains the default text "<default text>"
    Examples:
      | menu option | default text |
      | Pricing                | I have a question about the pricing on this vehicle.    |
      | Financing              | I have a question about financing.                      |
      | My Trade In            | I have a question about the car I plan to trade-in.     |
      | Reserving This Vehicle | I have a question about reserving this vehicle.         |
      | Other       | I have a few questions. Will you please give me a call? |

  @CSE @CSE_garage @CSE_contactDealer @regression @smoke
  Scenario: Ensure user is asked to sign in or create an account when attempting to contact a dealer
    And the CSE user clicks on the "Contact Dealer" deal button
    And the CSE user clicks Create an Account
    And the CSE user creates a new account from the Deal page
    Then the CSE user is on the Contact Dealer page
    And the vehicle information is present
    And the dealer name is present
    And the text area is disabled
    When the CSE user selects "Vehicle Availability" from the Contact Dealer drop down
    Then the Vehicle Availability Text Area contains the default text
    When the CSE user adds additional text to the text field
    And the CSE user clicks the Send button
    Then the CSE user is on the contact dealer confirmation page
    When the CSE user clicks View Certificate
    Then the contact dealer certificate page is present
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user is on the Saved Deals page in My Garage
    And the CSE user sees the saved deal