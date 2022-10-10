package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_Password_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Appointments_page Upgrade_Appointment;
    Upgrade_Password_page Upgrade_Password;
    CSE_Garage_Password_page CSEP;
    CSE_Garage_Hamburger_page CSEH;

    public Upgrade_Password_steps (TestContext context) {
        testContext = context;
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Password = context.getPageObjectManager().getUpgrade_Password_page();
        CSEP = context.getPageObjectManager().csCsGarageMyPasswordPage();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
    }
    @And("the Upgrade user accesses My Password via the hamburger link")
    public void theUpgradeUserAccessesMyPasswordViaTheHamburgerLink() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        Upgrade_Password.upMyGaragePasswordBtn();
    }
    @And("the Upgrade user should be on the Update Password page")
    public void theUpgradeUserShouldBeOnTheUpdatePasswordPage() {
        CSEP.cseGarageMyPasswordHeader();
    }
    @When("the Upgrade user clicks on Update the button")
    public void theUpgradeUserClicksOnUpdateTheButton() {
        CSEP.cseGarageUpdatePasswordButton();
    }
    @Then("the Upgrade user should see the error message {string}")
    public void theUpgradeUserShouldSeeTheErrorMessage(String readMessage) {
        CSEP.cseGaragePasswordErrorMessage(readMessage);
    }
    @When("the Upgrade user enters the old password in the old password field")
    public void theUpgradeUserEntersTheOldPasswordInTheOldPasswordField() {
        CSEP.cseGarageOldPasswordUpdate();
    }
    @And("the Upgrade user enters the new password in the new password field")
    public void theUpgradeUserEntersTheNewPasswordInTheNewPasswordField() {
        CSEP.cseGarageNewPasswordUpdate();
    }
    @And("the Upgrade user clicks the Update button to update the password")
    public void theUpgradeUserClicksTheUpdateButtonToUpdateThePassword() {
        CSEP.cseGarageUpdatePasswordButton();
    }
    @And("the Upgrade user logs out")
    public void theUpgradeUserLogsOut() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Sign Out");
    }
    @When("the Upgrade user logs in with the updated credentials")
    public void theUpgradeUserLogsInWithTheUpdatedCredentials() {
        CSE.clickOnSignInHereLink("Sign in here");
        CSEP.cseLoginWithEmail();
        CSEP.cseEnterUpdatePassword();
        CSE.cseClickSignInButton("Sign In");
    }
    @Then("the Upgrade user should see the My Garage message")
    public void theUpgradeUserShouldSeeTheMyGarageMessage() {
        CSE.cseSignInMyGarageVerify();
    }
}
