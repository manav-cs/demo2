Feature: CarSaver eCommerce (CSE) a user can create test drive appointments

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page for a vehicle
    And the CSE user clicks the Test Drive button
    And the CSE user clicks Create an Account
    And the CSE user creates a new account from the Deal page

  @CSE @CSE_garage @CSE_myAppointment @regression @smoke
  Scenario: Ensure the user can create an appointment for a new vehicle
    And the CSE user is on the Schedule an Appointment page
    When the CSE user schedules a Test Drive
    Then the test drive confirmation page is present
    When the CSE user clicks "My Garage" in the hamburger menu
    And the CSE user clicks on the "My Appointments" link from the left nav
    Then the new appointment is present

  @CSE @CSE_garage @CSE_myAppointment @regression
  Scenario: Ensure the user can see appointment vehicle details
    And the CSE user creates a new appointment
    When the CSE user clicks View Details button
    Then the CSE user is on the certificate page

  @CSE @CSE_garage @CSE_myAppointment @regression
  Scenario: Ensure the user can Get Directions for an appointment
    And the CSE user creates a new appointment
    When the CSE user clicks Get Directions
    Then the CSE user is on the google maps page

  @CSE @CSE_garage @CSE_myAppointment @regression
  Scenario: Ensure the user cannot create an appointment in the past
    And the CSE user is on the Schedule an Appointment page
    When the CSE user schedules a Test Drive in the past
    Then the appointment cannot be scheduled