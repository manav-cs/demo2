package stepDef;

import base.GenericFunctions;
import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_Pin_steps {

    TestContext testContext;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_Pin_page UpPin;
    public Upgrade_Pin_steps(TestContext context) {
        testContext = context;
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        UpPin = context.getPageObjectManager().getUpgrade_pin_page();
    }


    @When("a valid prospect's PIN is passed on the URL")
    public void aValidProspectSPINIsPassedOnTheURL() {
        UpPin.upPinOnUrl();
        UpPin.gotoUpgradePinUrl("?pin="+ GlobalTestData.UPGRADE_PIN_INFO[0][0]);
    }

    @Then("the Upgrade user's information is present on the home page")
    public void theUserSInformationIsPresentOnTheHomePage() {
        UpPin.upVerifyValidPinInfoHomePage();
    }

    @When("the {string} button is clicked")
    public void theButtonIsClicked(String buttonName) {
        GenericFunctions.clickButtonByText(buttonName);
    }

    @Then("the verify identity page is present")
    public void theVerifyIdentityPageIsPresent() {
        UpPin.upVerifyIdentityHeader();
    }

    @When("an invalid prospect's PIN is passed on the URL")
    public void anInvalidProspectSPINIsPassedOnTheURL() {
        UpPin.gotoUpgradePinUrl("?pin=NOPIN");
    }

    @Then("the PIN error elements appear")
    public void thePINErrorElementsAppear() {
        UpPin.upVerifyBadPinHomePage("PIN not found, please try again.");
    }

    @Then("the wrong PIN length error message appears")
    public void theWrongPINLengthErrorMessageAppears() {
        UpPin.upVerifyBadPinHomePage("PIN must be 5 characters in length.");
        UpPin.upVerifyScrollOffsetPin();
    }

    @When("the no PIN prospect parameter is passed on the URL as true")
    public void theNoPINProspectParameterIsPassedOnTheURLasTrue() {
        UpPin.gotoUpgradePinUrl("?noPinProspect=true");
    }

    @Then("the no PIN prospect page is present without a PIN field")
    public void theNoPINProspectPageIsPresentWithoutAPINField() {
        UpPin.upVerifyNoPinProspectPage();
    }

    @Then("the user is on the create login page")
    public void theUserIsOnTheCreateLoginPage() {
        UpPin.upVerifyHeaderCreateLoginPage();
    }

    @When("the Get Started button below the welcome message is clicked")
    public void theGetStartedButtonBelowTheWelcomeMessageIsClicked() {
        UpPin.upVerifyNoPinProspectStartButton();
    }

    @When("the no PIN prospect parameter is passed on the URL as null")
    public void theNoPINProspectParameterIsPassedOnTheURLAsNull() {
        UpPin.gotoUpgradePinUrl("?noPinProspect=");
    }

    @When("the no PIN prospect parameter is passed on the URL as false")
    public void theNoPINProspectParameterIsPassedOnTheURLAsFalse() {
        UpPin.gotoUpgradePinUrl("?noPinProspect=false");
    }

    @Then("the Upgrade user can submit a valid PIN in the PIN field")
    public void theUpgradeUserCanSubmitAValidPINInThePINField() {
        UpPin.upVerifySubmitPinFromField();
        UpPin.upVerifySubmitGoButtonForPinField();
        UpPin.upVerifyIdentityHeader();
    }

    @Then("the user is not logged off")
    public void theUserIsNotLoggedOff() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSEH.cseMyGarageClickHamburgerLinks("My Garage");
        UpPin.upVerifyHeaderUsersGarage();
    }

    @And("a valid PIN is entered into the PIN field")
    public void aValidPINIsEnteredIntoThePINField() {
        UpPin.upVerifySubmitPinFromField();
    }

    @And("the PIN is reset for future use")
    public void thePINIsResetForFutureUse() {
        UpPin.updatePinUsedColumn();
    }

    @Then("the user sees the No Pin Available page")
    public void theUserSeesTheNoPinAvailablePage() {
        UpPin.upVerifyNoPinPassedHeader();
    }

    @When("the Upgrade user selects a contact method of {string}")
    public void theUpUserSelectsAContactMethodOf(String contactType) {
        UpPin.upMfaMenuEmail(contactType);
    }

    @And("the mfa is submitted")
    public void theMfaIsSubmitted() {
        UpPin.upSubmitMfa();
    }

    @Then("the Upgrade user is on the PIN welcome page")
    public void theUpUserIsOnThePINWelcomePage() {
        UpPin.upPinWelcomePage();
    }
}
