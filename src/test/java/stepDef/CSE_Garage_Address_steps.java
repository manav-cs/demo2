package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Address_page;
import pageObject.CSE_Registration_SignIn_page;
import static base.GlobalTestData.*;

public class CSE_Garage_Address_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;

    public CSE_Garage_Address_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
    }

    @When("the CSE user clicks on the {string} link from the left nav")
    public void theCseUserClicksOnTheLinkFromTheLeftNav(String link) {
        CSEG.clickGarageNavOption(link);
    }

    @Then("the CSE user should be on Update Address page")
    public void theCseUserShouldSeeInUpdateAddressPage() {
        CSEG.garageUpdateAddressVerify();
    }

    @And("the CSE user should see the address they entered during registration")
    public void theCseUserShouldSeeTheAddressTheyEnteredDuringRegistration() {
        CSEG.garageUpdateAddressStreet(ECOM_REGISTRATION_ADDRESS);
        CSEG.garageUpdateAddressCity(ECOM_REGISTRATION_CITY);
        CSEG.garageUpdateAddressState(ECOM_REGISTRATION_STATE);
        CSEG.garageUpdateAddressZip(ECOM_REGISTRATION_ZIPCODE);
    }

    @When("the CSE user clicks on the Update button under My Address")
    public void theCseUserClicksOnButtonInMyAddress() {
        CSEG.garageMyAccountUpdateButton();
    }

    @And("the CSE user enters a valid address to update")
    public void theCseUserEntersValidAddressToUpdate() {
        CSEG.garageChangeAddressField(ECOM_ADDRESS_LOGIN_STREET_UPDATE);
        CSEG.garageChangeCityField(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageChangeStateField(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageChangeZipField(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }

    @And("the CSE user enters an invalid address to update")
    public void theCseUserEntersInvalidAddressToUpdate() {
        CSEG.garageChangeAddressField(" ");
        CSEG.garageChangeCityField(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageChangeStateField(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageChangeZipField(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }
    @Then("the CSE user should see the newly updated address")
    public void theCseCseUserShouldSeeTheNewlyUpdatedAddress() {
        CSEG.garageUpdateAddressStreet(ECOM_ADDRESS_LOGIN_STREET_UPDATE);
        CSEG.garageUpdateAddressCity(ECOM_ADDRESS_LOGIN_CITY_UPDATE);
        CSEG.garageUpdateAddressState(ECOM_ADDRESS_LOGIN_STATE_UPDATE);
        CSEG.garageUpdateAddressZip(ECOM_ADDRESS_LOGIN_ZIP_UPDATE);
    }

    @Then("the CSE user should see the {string} error message")
    public void theCseUserShouldSeeTheErrorMessage(String errorMsg) {
        CSEG.garageUpdateAddressErrorMessage(errorMsg);
    }
    @Then("the CSE Confirm Address modal appears")
    public void theCseConfirmAddressModalAppears() {
        CSEG.garageConfirmAddressModal();
    }

    @When("the CSE user selects the suggested address")
    public void theCseUserSelectsTheSuggestedAddress() {
        GenericFunctions.clickButtonByText("Select");
    }

}
