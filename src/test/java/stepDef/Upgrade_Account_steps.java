package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Address_page;
import pageObject.CSE_Garage_MyAccount_page;
import pageObject.CSE_Registration_SignIn_page;
import pageObject.Upgrade_Account_page;

public class Upgrade_Account_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_MyAccount_page CSMyAC;
    Upgrade_Account_page Upgrade_Account;

    public Upgrade_Account_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSMyAC = context.getPageObjectManager().getCsEcomGarageMyAccount();
        Upgrade_Account = context.getPageObjectManager().getUpgrade_Account_page();
    }
    @When("the Upgrade user land Update Account page")
    public void theUpgradeUserShouldBeOnTheUpdateAccountPage(){
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountHeader();
    }
    @Then("the Upgrade user should see the account info they entered during registration")
    public void theUpgradeUserShouldSeeTheAccountInfoTheyEnteredDuringRegistration() {
        CSMyAC.garageMyAccountFirstNameField();
        CSMyAC.garageMyAccountLastNameField();
        CSMyAC.garageMyAccountPhoneField();
        CSMyAC.garageMyAccountEmailField();
    }
    @And("the Upgrade user enters valid account information to update")
    public void theUpgradeUserEntersValidAccountInformationToUpdate() {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountFirstNameFieldChange();
        CSMyAC.garageMyAccountLastNameFieldChange();
        CSMyAC.garageMyAccountPhoneFieldChange();
        CSMyAC.garageMyAccountEmailFieldChange();
    }
    @When("the Upgrade user clicks on the Update button under My Account")
    public void theUpgradeUserClicksOnTheUpdateButtonUnderMyAccount() {
        CSMyAC.garageMyAccountUpdateButton();
    }
    @Then("the Upgrade user should see the newly updated account info")
    public void theUpgradeUserShouldSeeTheNewlyUpdatedAccountInfo() {
        CSMyAC.garageMyAccountFirstNameFieldUpdated();
        CSMyAC.garageMyAccountLastNameFieldUpdated();
        CSMyAC.garageMyAccountPhoneFieldUpdated();
        CSMyAC.garageMyAccountEmailFieldUpdated();
        CSMyAC.garageMyAccountSmsVerifyCheckBox(false);
    }
    @And("the Upgrade user enables Send me text messages checkbox")
    public void theUpgradeUserEnablesSendMeTextMessagesCheckbox() {
        CSMyAC.garageMyAccountSmsCheckBox();
    }
    @Then("the Upgrade user should see the SMS check box selected")
    public void theUpgradeUserShouldSeeTheSMSCheckBoxSelected() {
        CSMyAC.garageMyAccountSmsVerifyCheckBox(true);
    }
    @And("the Upgrade user updates account info without a first name")
    public void theUpgradeUserUpdatesAccountInfoWithoutAFirstName() {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountBlankName("firstName");
    }
    @Then("the Upgrade user {string} field should see {string}")
    public void theUpgradeUserFieldShouldSee(String id,String error) {
        CSMyAC.garageMyAccountErrorMessages(id,error);
    }
    @And("the Upgrade user updates account info without last name")
    public void theUpgradeUserUpdatesAccountInfoWithoutLastName() {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountBlankName("lastName");
    }
    @And("the Upgrade user updates account info without phone")
    public void theUpgradeUserUpdatesAccountInfoWithoutPhone() {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountBlankName("phoneNumber");
    }
    @And("the Upgrade user updates account info without email")
    public void theUpgradeUserUpdatesAccountInfoWithoutEmail() {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageMyAccountBlankName("email");
    }
    @And("the Upgrade user updates account information with \"([^\"]*)\"$")
    public void theUpgradeUserUpdatesAccountInformationWith(String email) {
        Upgrade_Account.upMyGarageAccountBtn();
        CSMyAC.garageUpdateEmailToInvalidFormat(email);
    }
}