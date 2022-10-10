package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Password_page;
import pageObject.CSE_Registration_SignIn_page;

public class CSE_Garage_MyPassword_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Password_page CSEP;

    public CSE_Garage_MyPassword_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEP = context.getPageObjectManager().csCsGarageMyPasswordPage();
    }

    @Then("the CSE user should be on the Update Password page")
    public void theCseUserShouldBeOnTheUpdatePasswordPage() {
        CSEP.cseGarageMyPasswordHeader();
    }

    @When("the CSE user clicks on Update the button")
    public void theCseUserClicksOnUpdateTheButton() {
        CSEP.cseGarageUpdatePasswordButton();
    }

    @Then("the CSE user should see the error message {string}")
    public void theCseUserShouldSeeTheErrorMessage(String message) {
        CSEP.cseGaragePasswordErrorMessage(message);
    }

    @When("the CSE user enters the old password in the old password field")
    public void theCseUserEntersTheOldPasswordInTheOldPasswordField() {
        CSEP.cseGarageOldPasswordUpdate();
    }

    @And("the CSE user enters the new password in the new password field")
    public void theCseUserEntersTheNewPasswordInTheNewPasswordField() {
        CSEP.cseGarageNewPasswordUpdate();
    }

    @And("the CSE user clicks the Update button to update the password")
    public void theCseUserClicksTheUpdateButtonToUpdateThePassword() {
        CSEP.cseGarageUpdatePasswordButton();
    }

    @When("the CSE user logs in with the updated credentials")
    public void theCseUserLogsInWithUpdatedCredentials() {
        CSE.clickOnSignInHereLink("Sign in here");
        CSEP.cseLoginWithEmail();
        CSEP.cseEnterUpdatePassword();
        CSE.cseClickSignInButton("Sign In");
    }
}
