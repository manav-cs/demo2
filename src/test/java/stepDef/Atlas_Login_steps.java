package stepDef;

import base.GenericFunctions;
import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Atlas_Login_page;
import pageObject.Portal_Login_page;

public class Atlas_Login_steps {
    TestContext testContext;
    Atlas_Login_page ATLAS;

    public Atlas_Login_steps(TestContext context) {
        testContext = context;
        ATLAS = context.getPageObjectManager().getAtlas_login_page();
    }

    @Given("the atlas user navigates to the home page")
    public void theUserNavigatesToTheAtlasHomepage() {
        GenericFunctions.hardWait(1000);
    }

    @And("the atlas dealer user logs in with valid credentials")
    public void theAtlasDealerUserLogsInWithValidCredentials() {
        ATLAS.atlasEnterEmailAddress(GlobalTestData.ATLAS_DEALER_EMAIL);
        ATLAS.atlasEnterPassword(GlobalTestData.ATLAS_DEALER_PASSWORD);
        ATLAS.atlasClickLoginButton();
        ATLAS.atlasVerifyLoginSuccessMessage("Welcome to Atlas!");
    }

    @When("the atlas user clicks on the Logout icon")
    public void theAtlasUserClicksOnTheLogoutButton() {
        ATLAS.atlasClickLogoutIcon();
    }

    @Then("the atlas user should be logout and see the following {string} message")
    public void theAtlasUserShouldBeLogoutAndSeeFollowingMessage(String msg) {
        ATLAS.atlasVerifyLoginScreenMessage(msg);
    }

    @And("the atlas program user logs in with valid credentials")
    public void theAtlasProgramUserLogsInWithValidCredentials() {
        ATLAS.atlasEnterEmailAddress(GlobalTestData.ATLAS_PROGRAM_USER_EMAIL);
        ATLAS.atlasEnterPassword(GlobalTestData.ATLAS_PROGRAM_USER_PASSWORD);
        ATLAS.atlasClickLoginButton();
        ATLAS.atlasVerifyLoginSuccessMessage("Welcome to Atlas!");
    }

    @And("the atlas dealer user enters valid credentials")
    public void theAtlasDealerUserEntersValidCredentials() {
        ATLAS.atlasEnterEmailAddress(GlobalTestData.ATLAS_DEALER_EMAIL);
        ATLAS.atlasEnterPassword(GlobalTestData.ATLAS_DEALER_PASSWORD);
    }

    @When("the atlas user clicks on the {string} button")
    public void theAtlasUserClicksOnTheButton(String buttonName) {
        ATLAS.atlasClickLoginButton(buttonName);
    }

    @Then("the atlas user should be login and see the following {string} message")
    public void theAtlasUserShouldBeLoginAndSeeTheFollowingMessage(String message) {
        ATLAS.atlasVerifyLoginSuccessMessage(message);
    }

    @And("the atlas program user enters valid credentials")
    public void theAtlasProgramUserEntersValidCredentials() {
        ATLAS.atlasEnterEmailAddress(GlobalTestData.ATLAS_PROGRAM_USER_EMAIL);
        ATLAS.atlasEnterPassword(GlobalTestData.ATLAS_PROGRAM_USER_PASSWORD);
    }

    @And("the atlas user enters invalid credentials")
    public void theAtlasUserEntersInvalidCredentials() {
        ATLAS.atlasEnterEmailAddress("fakeDealerEmail911@gmail.com");
        ATLAS.atlasEnterPassword(GlobalTestData.ATLAS_DEALER_PASSWORD);
    }

    @Then("the atlas user should see the following {string} message")
    public void theAtlasUserShouldSeeTheFollowingMessage(String message) {
        ATLAS.atlasVerifyInvalidCredentialsMessage(message);
    }
}

