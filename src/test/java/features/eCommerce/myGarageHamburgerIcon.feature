Feature: CarSaver eCommerce (CSE) My Garage Hamburger Icon functionality

  Background:
    Given the CSE user navigates to the home page
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user signs in with a valid credentials
    And the CSE user clicks the Hamburger icon

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the hamburger icon displays appropriate links when clicked
    Then the "Home" link is present in the hamburger menu
    And the "My Garage" link is present in the hamburger menu
    And the "Value Trade" link is present in the hamburger menu
    #And the "Insure" link is present in the hamburger menu
    And the "Sign Out" link is present in the hamburger menu

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the Close icon closes the hamburger display
    When the CSE user clicks the close button in the Hamburger menu
    Then the hamburger menu closes

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the Home link takes the user to the Home page
    When the CSE user clicks the "Home" link in the My Garage menu
    Then the CSE user should see the home page
    When the CSE user clicks the Hamburger icon
    Then the CSE user sees all the hamburger links

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the My Garage link takes the user to the My Garage page
    When the CSE user clicks the "My Garage" link in the My Garage menu
    Then the CSE user should see the My Garage message

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the Value Trade link takes the user to the Choose Trade Option page
    When the CSE user clicks the "Value Trade" link in the My Garage menu
    Then the user should see the Choose Trade Option page
    When the CSE user clicks the Hamburger icon
    Then the CSE user sees all the hamburger links

  #@CSE @CSE_garage @CSE_hamburger @regression @smoke
  #Scenario: Ensure the Insure link takes the user to the Insure page
#    When the CSE user clicks the "Insure" link in the My Garage menu
#    Then the CSE user should see the Insure page
   # When the CSE user clicks the Hamburger icon
    #Then the CSE user sees all the hamburger links

  @CSE @CSE_garage @CSE_hamburger @regression @smoke
  Scenario: Ensure the Sign Out button logs the user out
    When the CSE user clicks the "Sign Out" link in the My Garage menu
    Then the CSE user should see the home page
    When the CSE user clicks the Hamburger icon
    Then the "Home" link is present in the hamburger menu