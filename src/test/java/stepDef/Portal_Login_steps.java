package stepDef;

import base.GenericFunctions;
import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Portal_Login_page;

public class Portal_Login_steps {
    TestContext testContext;
    Portal_Login_page PORTAL;

    public Portal_Login_steps(TestContext context) {
        testContext = context;
        PORTAL = context.getPageObjectManager().getPortal_login_page();
    }
    @Given("the portal user navigates to the home page")
    public void theUserNavigatesToThePortalHomePage(){
        GenericFunctions.hardWait(3000);
        PORTAL.portalClickRemindMeLaterFromInitialModal();
        GenericFunctions.hardWait(3000);
    }
    @When("the portal user logs in with valid credentials")
    public void thePortalUserLogsInWithValidCredentials() {
        PORTAL.portalEnterEmailAddress(GlobalTestData.PORTAL_ADMIN_EMAIL);
        PORTAL.portalEnterPassword(GlobalTestData.PORTAL_ADMIN_PASSWORD);
        PORTAL.portalClickLoginButton();
    }
    @Then("the portal user should be login with the following {string} message")
    public void thePortalUserShouldBeAbleToSeeTheMessage(String message) {
        PORTAL.portalVerifyLoginSuccessMessage(message);
    }

    @And("the portal users enter invalid credentials")
    public void thePortalUsersEnterInvalidCredentials() {
        PORTAL.portalEnterEmailAddress("fakePortalEmail@automation.com");
        PORTAL.portalEnterPassword("fakePassword$!23");
    }

    @When("the portal user clicks on the Login button")
    public void thePortalUserClicksOnTheButton() {
        PORTAL.portalClickLoginButton();
    }

    @Then("the portal user should be able to see the validation message {string}")
    public void thePortalUserShouldBeAbleToSeeTheValidationMessage(String message) {
        PORTAL.portalVerifyLoginUnsuccessfulMessage(message);
    }

    @When("the portal user clicks on Remind me later button")
    public void thePortalUserClicksOnButton() {
        PORTAL.portalClickRemindMeLaterFromInitialModal();
    }

    @When("the portal user clicks on the Logout button")
    public void thePortalUserClicksOnLogoutButton() {
        PORTAL.portalClickLogoutButton();
    }

    @When("the portal user should be logout with the following {string} message")
    public void thePortalUserShouldBeLogoutWithFollowingMessage(String message) {
        PORTAL.portalVerifyLogoutSuccessMessage(message);
    }

    @And("the portal admin user logs into the portal after the upgrade account creation is done")
    public void thePortalAdminUserNavigatesToPortalHomepage() {
        GenericFunctions.openUrl(GlobalTestData.PORTAL_BASE_URL);
        GenericFunctions.hardWait(3000);
        PORTAL.portalClickRemindMeLaterFromInitialModal();
        GenericFunctions.hardWait(3000);
        PORTAL.portalEnterEmailAddress(GlobalTestData.PORTAL_ADMIN_EMAIL);
        PORTAL.portalEnterPassword(GlobalTestData.PORTAL_ADMIN_PASSWORD);
        PORTAL.portalClickLoginButton();
    }
}

