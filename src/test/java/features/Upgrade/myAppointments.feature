Feature: The Upgrade users can schedule a test drive and verify my appointment information under my garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav

  @UP @UP_garage @myAppointments @regression
  Scenario: Ensure the Upgrade user is able to navigate to My Appointments
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on my garage from the hamburger menu
    When the Upgrade user clicks on my appointments link from the left nev in Upgrade
    Then the Upgrade user should verify no appointment found message

  @UP @UP_garage @myAppointments @regression @smoke
  Scenario: Ensure the user can schedule a test drive and verify appointments
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars via the hamburger menu
    When the Upgrade user selects vehicle and schedules test drive
    Then the Upgrade user should verify appointment is scheduled

  @UP @UP_garage @myAppointments @regression @smoke
  Scenario: Ensure the user can get directions from my appointments
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on my appointments link from the left nev
    When the Upgrade user clicks on get directions link from my appointments
    Then the Upgrade user should be navigated to google map page

  @UP @UP_garage @myAppointments @regression @smoke
  Scenario: Ensure the user can view details from my appointments
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on my appointments link from the left nev
    When the Upgrade user clicks on view details link on my appointments
    Then the Upgrade user copy deal and saves the deal