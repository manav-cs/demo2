package stepDef;

import cucumber.TestContext;
import pageObject.CSE_Garage_Hamburger_page;
import pageObject.CSE_Garage_MyAccount_page;
import pageObject.CSE_Garage_Address_page;
import pageObject.CSE_Registration_SignIn_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CSE_Garage_MyAccount_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Hamburger_page CSEH;
    CSE_Garage_MyAccount_page CSMyAC;

    public CSE_Garage_MyAccount_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        CSMyAC = context.getPageObjectManager().getCsEcomGarageMyAccount();
    }

    @Then("the CSE user lands on Update Account page")
    public void theCseUserShouldBeOnTheUpdateAccountPage() {
        CSMyAC.garageMyAccountHeader();
    }


    @And("the CSE user should see the account info they entered during registration")
    public void theCseUserShouldSeeTheAccountInfoTheyEnteredDuringRegistration() {
        CSMyAC.garageMyAccountFirstNameField();
        CSMyAC.garageMyAccountLastNameField();
        CSMyAC.garageMyAccountPhoneField();
        CSMyAC.garageMyAccountEmailField();
    }

    @And("the CSE user enters valid account information to update")
    public void theCseUserEntersValidAccountInformationToUpdate() {
        CSMyAC.garageMyAccountFirstNameFieldChange();
        CSMyAC.garageMyAccountLastNameFieldChange();
        CSMyAC.garageMyAccountPhoneFieldChange();
        CSMyAC.garageMyAccountEmailFieldChange();
    }

    @When("the CSE user clicks on the Update button under My Account")
    public void theCseUserClicksOnTheUpdateButtonUnderMyAccount() {
        CSMyAC.garageMyAccountUpdateButton();
    }

    @Then("the CSE user should see the newly updated account info")
    public void theCseUserShouldSeeTheNewlyUpdatedAccountInfo() {
        CSMyAC.garageMyAccountFirstNameFieldUpdated();
        CSMyAC.garageMyAccountLastNameFieldUpdated();
        CSMyAC.garageMyAccountPhoneFieldUpdated();
        CSMyAC.garageMyAccountEmailFieldUpdated();
        CSMyAC.garageMyAccountSmsVerifyCheckBox(false);
    }

    @And("the CSE user enables Send me text messages checkbox")
    public void theCseUserEnablesSendMeTextMessagesCheckbox() {
        CSMyAC.garageMyAccountSmsCheckBox();
    }

    @Then("the CSE user should see the SMS check box selected")
    public void theCseUserShouldSeeTheSMSCheckBoxSelected() {
        CSMyAC.garageMyAccountSmsVerifyCheckBox(true);
    }

    @Then("the CSE user {string} field should see {string}")
    public void theCseUserShouldSee(String id,String error) {
        CSMyAC.garageMyAccountErrorMessages(id,error);
    }

    @And("the CSE user updates account info without a first name")
    public void theCseUserUpdatesAccountInfoWithoutAFirstName() {
        CSMyAC.garageMyAccountBlankName("firstName");
    }

    @And("the CSE user updates account info without last name")
    public void theCseUserUpdatesAccountInfoWithoutLastName() {
        CSMyAC.garageMyAccountBlankName("lastName");
    }

    @And("the CSE user updates account info without phone")
    public void theCseUserUpdatesAccountInfoWithoutPhone() {
        CSMyAC.garageMyAccountBlankName("phoneNumber");
    }

    @And("the CSE user updates account info without email")
    public void theCSEUserUpdatesAccountInfoWithoutEmail() {
        CSMyAC.garageMyAccountBlankName("email");
    }

    @And("the user updates account info with \"([^\"]*)\"$")
    public void theUserUpdatesAccountInfoWithInvalidEmailFormat(String email) {
        CSMyAC.garageMyAccountBadEmail(email);
    }

    @And("the CSE user remembers the old email")
    public void theCseUserRemembersTheOldEmail() {
        CSMyAC.garageRememberOldEmail();
    }

    @And("the CSE user logs out")
    public void theCseUserLogsOut() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSEG.clickGarageNavOption("Sign Out");
    }

    @And("the CSE user logs in and goes to my account")
    public void theCseUserLogsInAndGoesToMyAccount(){
        CSE.clickOnSignInHereLink("Sign in here");
        CSE.cseEnterValidEmail();
        CSE.cseEnterValidPassword();
        CSE.cseClickSignInButton("Sign In");
        CSEG.clickGarageNavOption("My Account");
    }

    @And("the CSE user updates account info with an email that already exists")
    public void theCseUserUpdatesAccountInfoWithAnEmailThatAlreadyExists() {
        CSMyAC.garageUpdateOldEmail();
    }

    @And("the CSE user updates account information with \"([^\"]*)\"$")
    public void theCseUserUpdatesAccountInformationWithInvalidEmailFormat(String email) {
        CSMyAC.garageUpdateEmailToInvalidFormat(email);
    }
}
