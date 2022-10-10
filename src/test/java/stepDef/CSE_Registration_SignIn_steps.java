package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Address_page;
import pageObject.CSE_Garage_Hamburger_page;
import pageObject.CSE_Registration_SignIn_page;
import pageObject.Upgrade_Registration_SignIn_page;

import static base.GlobalTestData.*;

public class CSE_Registration_SignIn_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    public CSE_Registration_SignIn_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
    }
    @Given("the NE user navigates to the home page")
    public void userInNissanECommerceHomePage(){
        GenericFunctions.hardWait(3000);
    }
    @Given("the CSE user navigates to the home page")
    public void theUserNavigatesToTheCarSaverCSEHomePage(){
        GenericFunctions.hardWait(3000);
    }

    @And("the CSE user clicks on the {string} link from the top nav")
    public void theCseUserClicksOnTheLinkFromTheTopNav(String linkName) {
        CSE.clickOnSignInHereLink(linkName);
    }

    @And("the NE user clicks on the {string} link from the top nav")
    public void theNeUserClicksOnTheLinkFromTheTopNav(String linkName) {
        CSE.clickOnSignInHereLink(linkName);
    }

    @And("the NE user clicks on {string} link")
    public void userNeClicksOnClickHereToRegisterLink (String linkText){
        CSE.clickOnLink(linkText);
    }

    @And("the NE user enters valid information and accepts the terms under the Registration Form")
    public void theNeUserEntersValidInformationUnderTheRegistrationForm() {
        CSE.cseRegiFormEnterFirstName();
        CSE.cseRegiFormEnterLastName();
        CSE.cseRegiFormAddress();
        CSE.cseRegiFormZipcode();
        CSE.cseRegiFormMobile();
        CSE.cseRegiFormEnterEmail();
        CSE.cseRegiFormPassword();
        CSE.cseRegiFormTermCheckbox();
    }

    @When("the NE user clicks on the Submit button")
    public void theNeUserClicksOnTheSubmitButton() {
        CSE.cseRegiFromSubmitButton();
    }

    @Then("the NE user should see the SUCCESS message")
    public void theNeUserShouldSeeTheSUCCESSMessage() {
        CSE.cseRegiFromSuccessMsgVerify();
    }

    @Given("the NE user creates an sso profile")
    public void createNewSSOAccountInNE() {
        CSE.clickOnSignInHereLink();
        CSE.clickOnClickHereToRegisterLink("Click here to register.");
        CSE.cseRegiFormEnterFirstName();
        CSE.cseRegiFormEnterLastName();
        CSE.cseRegiFormAddress();
        CSE.cseRegiFormZipcode();
        CSE.cseRegiFormMobile();
        CSE.cseRegiFormEnterEmail();
        CSE.cseRegiFormPassword();
        CSE.cseRegiFormTermCheckbox();
        CSE.cseRegiFromSubmitButton();
        CSE.cseRegiFromSuccessMsgVerify();
        CSE.clickOnGoToLoginPageFromSuccessPage();
    }

    @Given("the CSE user creates a profile")
    public void createNewCseAccount() {
        CSE.clickOnSignInHereLink();
        CSE.clickOnClickHereToRegisterLink("Create an Account");
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
        CSE.verifyInMyGarage();
    }

    @And("the NE user can enter their credentials")
    public void theNeUserCanEnterTheirEmailAndPassword() {
        CSE.cseEnterLoginCredentials(ECOM_REGISTRATION_EMAIL,ECOM_REGISTRATION_PASSWORD);
    }

    @And("the NE user clicks on the {string} button")
    public void theNeUserClicksOnLoginButton(String linkName) {
        CSE.cseClickNextButton();
    }

    @Then("the CSE user should see the My Garage message")
    public void theCseUserShouldSeeTheMyGarageMessage() {
        CSE.cseSignInMyGarageVerify();
    }

    @Then("the NE user should see the My Garage message")
    public void theNeUserShouldSeeTheMyGarageMessage() {
        CSE.cseSignInMyGarageVerify();
    }

    @And("the NE user enters a valid email address")
    public void theNeUserEntersAValidEmailAddress() {
        CSE.neEnterValidEmail();
    }

    @And("the NE user enters a valid password")
    public void theNeUserEntersAValidPassword() {
        CSE.neEnterValidPassword();
    }

    @Then("the NE user should see the {string} message")
    public void theNeUserShouldSeeTheMessage(String invalidCredentialsMsg) {
        CSE.cseVerifyInvalidCredentialMsg(invalidCredentialsMsg);
    }

    @And("the NE user enters an invalid email address")
    public void theNeUserEntersAnInvalidEmailAddress() {
        CSE.neEnterInvalidEmail();
    }

    @And("the NE user enters an invalid password")
    public void theUserEntersAnInvalidPassword() {
        CSE.neEnterInvalidPassword();
    }

    @And("the CSE user clicks on the {string} link")
    public void theCseUserClicksOnLink(String linkName) {
        CSE.cseClickCreateAnAccount_non_sso(linkName);
    }

    @And("the CSE user fills out the Get Started form and clicks Next")
    public void theCseUserEntersValidInformationUnderTheGetStartedFormInCSE() {
        CSE.cseEnterFirstName();
        CSE.cseEnterLastName();
        CSE.cseEnterPrimaryPhoneNumber();
        CSE.cseEnterEmail();
        CSE.cseEnterPassword();
        CSE.cseEnterConfirmPassword();
        CSE.cseClickNextButton();
    }

    @And("the CSE user fills out the Home Address and clicks Next")
    public void theCseUserFillOutTheHomeAddressInCSEAndClickNext() {
        CSE.cseEnterHomeAddress();
        CSE.cseEnterCity();
        CSE.cseSelectState();
        CSE.cseEnterZipcode();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
    }

    @When("the user clicks on the Use the address as entered button from modal")
    public void theUserClicksOnTheButtonFromTheModal() {
        CSE.cseClickUseTheAddressAsEnteredButton();
    }

    @Given("a new CSE user creates a non-sso profile")
    public void aNewCseUserCreatesANonSsoProfile() {
        CSE.clickOnSignInHereLink();
        CSE.cseClickCreateAnAccountLink();
        CSE.cseEnterFirstName();
        CSE.cseEnterLastName();
        CSE.cseEnterPrimaryPhoneNumber();
        CSE.cseEnterEmail();
        CSE.cseEnterPassword();
        CSE.cseEnterConfirmPassword();
        CSE.cseClickNextButton();
        CSE.cseEnterHomeAddress();
        CSE.cseEnterCity();
        CSE.cseSelectState();
        CSE.cseEnterZipcode();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
    }

    @And("the CSE user signs out")
    public void cseUserSignsOut() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseLogoutFromMyGarageLink();
    }

    @And("the CSE user can enter their credentials")
    public void theCseUserCanEnterTheirCredentials() {
        CSE.cseEnterValidCredentialsToLogin();
    }

    @When("the CSE user clicks on the {string} button")
    public void theCseUserClicksOnTheButton(String buttonName){
        CSE.cseClickSignInButton(buttonName);
    }

    @And("the CSE user enters a valid email address")
    public void theCseUserEntersAValidEmailAddress() {
        CSE.cseEnterValidEmail();
    }

    @And("the CSE user enters a valid password")
    public void theCseUserEntersAValidPassword() {
        CSE.cseEnterValidPassword();
    }

    @And("the CSE user enters an invalid email address")
    public void theCseUserEntersAnInvalidEmailAddress() {
        CSE.cseEnterInvalidEmail();
    }

    @And("the CSE user enters an invalid password")
    public void theCseUserEntersAnInvalidPassword() {
        CSE.cseEnterInvalidPassword();
    }

    @Then("the CSE user should see the {string} message")
    public void theCseUserShouldSeeTheMessage(String errorMessage) {
        CSE.cseVerifyErrorMsgWhenUserEnterInvalidCredentials(errorMessage);
    }

    @When("the CSE user fills out the Home Address with a vague street")
    public void theCseUserFillsOutTheHomeAddressWithAVagueStreet() {
        CSE.cseEnterHomeVagueAddress();
        CSE.cseEnterCity();
        CSE.cseSelectState();
        CSE.cseEnterZipcode();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
    }

    @And("the CSE user address matches the selected address")
    public void theCseUserAddressMatchesTheSelectedAddress() {
        CSEG.clickGarageNavOption("My Address");
        CSEG.garageUpdateAddressStreet(ECOM_REGISTRATION_ADDRESS);
    }

    @And("the CSE user signs in with a valid credentials")
    public void theCseUserSignsInWithAValidLoginInCSE() {
        CSE.cseEnterValidEmail();
        CSE.cseEnterValidPassword();
        CSE.cseClickSignInButton("Sign In");
    }

    @Then("the CSE user should see the home page")
    public void theCseUserShouldSeeTheHomePage() {
        CSE.cseHomePageSignedOut();
    }

    @When("the CSE user clicks {string} in the hamburger menu")
    public void theCseUserClicksInTheHamburgerMenu(String link) {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks(link);
    }

    @When("the CSE user clicks Sign Out in the hamburger menu")
    public void theCSEUserClicksSignOutInTheHamburgerMenu() {
        Upgrade_SignIn.upHamburgerBtn();
        Upgrade_SignIn.upSignOut();
    }
}
