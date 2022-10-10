package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Garage_MyAppointments_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Appointments_page CSEA;
    CSE_Garage_Certificate_page CSEC;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Appointments_page Upgrade_Appointment;

    public CSE_Garage_MyAppointments_steps(TestContext context) {
        testContext = context;
        CSEC = context.getPageObjectManager().getCsEcomGarageCertificate();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEA = context.getPageObjectManager().getCsEcomGarageAppointments();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
    }

    @And("the CSE user goes to the deal page for a vehicle")
    public void theCSEUserGoesToTheDealPageForAVehicle() {
        CSEA.cseGarageAppointDealerPage();
    }

    @When("the CSE user clicks the Test Drive button")
    public void theUserClicksTheTestDriveButton() {
        CSEA.cseGarageAppointTestDrive();
    }

    @And("the CSE user clicks Create an Account")
    public void theCSEUserClicksCreateAnAccount() {
        CSEA.cseGarageAppointCreateAccountButton();
    }

    @And("the CSE user creates a new account from the Deal page")
    public void theCSEUserClicksCreateAnAccountFromDealPage() {
        CSE.cseRegiFormEnterFirstName();
        CSE.cseRegiFormEnterLastName();
        CSE.cseRegiFormEnterEmail();
        CSE.cseEnterPrimaryPhoneNumber();
        CSE.cseRegiFormPassword();
        CSE.cseRegiFormConfirmPassword();
        CSE.cseClickNextButton();
        CSE.cseRegiFormAddress();
        CSE.cseRegiFormCity();
        CSE.cseRegiFormState();
        CSE.cseRegiFormZipcodeNonSso();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
    }

    @And("the CSE user is on the Schedule an Appointment page")
    public void theCSEUserSchedulesAnAppointment() {
        CSEA.cseGarageAppointScheduleTestDrivePage();
    }

    @When("the CSE user schedules a Test Drive")
    public void theCSEUserSchedulesATestDrive() {
        CSEA.cseGarageAppointScheduleTestDrive(1);
    }

    @Then("the test drive confirmation page is present")
    public void theTestDriveConfirmationPageIsPresent() {
        CSEA.cseGarageAppointScheduleTestDriveConfirmation();
    }

    @Then("the new appointment is present")
    public void theNewAppointmentIsPresent() {
        CSEA.cseGarageAppointmentSectionInfo();
    }

    @And("the CSE user creates a new appointment")
    public void theCSEUserCreatesANewAppointment() {
        CSEA.cseGarageAppointScheduleTestDrivePage();
        CSEA.cseGarageAppointScheduleTestDrive(1);
        CSEA.cseGarageAppointScheduleTestDriveConfirmation();
        Upgrade_SignIn.upHamburgerBtn();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Appointments");
        CSEA.cseGarageAppointmentSectionInfo();
    }

    @When("the CSE user clicks {string}")
    public void theCSEUserClicksLink(String link) {
        GenericFunctions.clickLinkByText(link);
    }

    @Then("the CSE user is on the certificate page")
    public void theCSEUserIsOnTheCertificatePage() {
        CSEC.cseGarageCertificatePageHeader();
        CSEC.cseGarageCertificateBasicInfo();
    }

    @And("the CSE user clicks Get Directions")
    public void theCSEUserClicksGetDirections() {
        Upgrade_Appointment.upGetDirectionBtn();
    }

    @And("the CSE user is on the google maps page")
    public void theCSEUserIsOnTheGoogleMapsPage() {
        CSEA.cseVerifyLandedOnGoogleMap();
    }

    @When("the CSE user edits the appointment")
    public void theCSEUserEditsTheAppointment() {
        CSEA.cseEditAppointment();
    }

    @And("the CSE user alters the appointment time")
    public void theCSEUserAltersTheAppointmentTime() {
        CSEA.cseGarageAppointScheduleTestDrivePage();
        CSEA.cseGarageAppointScheduleTestDrive(2);
        CSEA.cseGarageAppointScheduleTestDriveConfirmation();
        Upgrade_SignIn.upHamburgerBtn();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Appointment");
    }

    @When("the CSE user schedules a Test Drive in the past")
    public void theCSEUserSchedulesATestDriveInThePast() {
        CSEA.cseGarageAppointScheduleTestDriveInPast();
    }

    @Then("the appointment cannot be scheduled")
    public void theAppointmentCannotBeScheduled() {
        CSEA.cseGarageAppointScheduleTestDriveInPastAssert();
    }

    @When("the CSE user clicks View Details button")
    public void theCSEUserClicksButton() {
        CSEA.cseViewDetailsButton();
    }
}
