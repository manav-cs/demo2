package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;
import static base.GlobalTestData.*;
import static base.GlobalTestData.ECOM_REGISTRATION_ZIPCODE;

public class Upgrade_Address_steps {
        TestContext testContext;
        CSE_Registration_SignIn_page CSE;
        CSE_Garage_Address_page CSEG;
        Upgrade_Registration_SignIn_page Upgrade_SignIn;
        Upgrade_Appointments_page Upgrade_Appointment;
        CSE_Garage_MyAccount_page CSMyAC;
        Upgrade_Account_page Upgrade_Account;
        Upgrade_Address_page Upgrade_Address;
        CSE_Garage_Hamburger_page CSEH;

        public Upgrade_Address_steps (TestContext context) {
            testContext = context;
            CSE = context.getPageObjectManager().getCsEcommercePage();
            CSEG = context.getPageObjectManager().getCsEcomGarage();
            CSMyAC = context.getPageObjectManager().getCsEcomGarageMyAccount();
            Upgrade_Account = context.getPageObjectManager().getUpgrade_Account_page();
            Upgrade_Address = context.getPageObjectManager().getUpgrade_Address_page();
            Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
            Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
            CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        }
    @And("the Upgrade user accesses My Address via the hamburger link")
    public void theUpgradeUserClicksOnTheLinkFromTheLeftNav() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        Upgrade_Address.upMyGarageAddressBtn();
    }
    @When("the Upgrade user lands on Update Address page")
    public void theUpgradeUserShouldBeOnTheUpdateAddressPage() {
        CSEG.garageUpdateAddressVerify();
    }
    @Then("the Upgrade user should see the address they entered during registration")
    public void theUpgradeUserShouldSeeTheAddressTheyEnteredDuringRegistration() {
        CSEG.garageUpdateAddressStreet(ECOM_REGISTRATION_ADDRESS);
        CSEG.garageUpdateAddressCity(ECOM_REGISTRATION_CITY);
        CSEG.garageUpdateAddressState(ECOM_REGISTRATION_STATE);
        CSEG.garageUpdateAddressZip(ECOM_REGISTRATION_ZIPCODE);
    }
    @And("the Upgrade user enters a valid address to update")
    public void theUpgradeUserEntersAValidAddressToUpdate() {
        CSEG.garageChangeAddressField(ECOM_ADDRESS_LOGIN_STREET_UPDATE);
        CSEG.garageChangeCityField(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageChangeStateField(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageChangeZipField(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }
    @When("the Upgrade user clicks on the Update button under My Address")
    public void theUpgradeUserClicksOnTheUpdateButtonUnderMyAddress() {
        CSEG.garageMyAccountUpdateButton();
    }
    @Then("the Upgrade user should see the newly updated address")
    public void theUpgradeUserShouldSeeTheNewlyUpdatedAddress() {
        CSEG.garageUpdateAddressStreet(ECOM_ADDRESS_LOGIN_STREET_UPDATE);
        CSEG.garageUpdateAddressCity(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageUpdateAddressState(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageUpdateAddressZip(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }
    @And("the Upgrade user enters an invalid address to update")
    public void theUpgradeUserEntersAnInvalidAddressToUpdate() {
        CSEG.garageChangeAddressField(" ");
        CSEG.garageChangeCityField(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageChangeStateField(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageChangeZipField(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }
    @Then("the Upgrade user should see the {string} error message")
    public void theUpgradeUserShouldSeeTheErrorMessage(String readMsg) {
        CSEG.garageUpdateAddressErrorMessage(readMsg);
    }
}
