package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Hamburger_page;
import pageObject.CSE_Registration_SignIn_page;
import pageObject.Upgrade_Registration_SignIn_page;
public class Upgrade_Registration_SignIn_steps {
    TestContext testContext;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;

    public Upgrade_Registration_SignIn_steps(TestContext context) {
        testContext = context;
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();

    }

    @Given("the Upgrade user navigates to the homepage")
    public void theUserNavigatesToTheUpgradeHomePage()throws InterruptedException {
        GenericFunctions.hardWait(1000);
    }
    @And("the Upgrade user clicks on {string} link")
    public void theUserClicksOnTheLink(String linksText){Upgrade_SignIn.clickOnClickHereToRegisterLink(linksText);
    }
    @Then("the Upgrade user should see the Choose Trade Option page")
    public void theUserShouldSeeTheChooseTradeOptionPage(){Upgrade_SignIn.verifyChooseTradeOption();
    }
    @And("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress(){Upgrade_SignIn.upLoginEnterEmail();
    }
    @And("the user enters a valid password")
    public void theUserEntersAValidPassword(){Upgrade_SignIn.upEnterValidPassword();
    }
    @When("the Upgrade user clicks on the {string} button")
    public void theUserClicksOnTheButtonInUP(String buttonName){
        CSE.cseClickSignInButton(buttonName);
    }
    @And("the Upgrade user enters a invalid email address")
    public void theUserEntersAInvalidEmailAddressInUP(){Upgrade_SignIn.upEnterInvalidEmail();
    }
    @And("the Upgrade user enters an invalid password")
    public void theUserEntersAnInvalidPasswordInUP(){Upgrade_SignIn.upEnterInvalidPassword();
    }
    @Then("the Upgrade user should see the Welcome Back Message along with hardcoded first name")
    public void theUserShouldSeeTheWelcomeBackPageWithHardCodedFirstName() {
        Upgrade_SignIn.UpWelcomeBackPageWithHardCodeFirstName();
    }
    @And("the Upgrade user fills out the Get Started form in UP and clicks Next")
    public void theUserEntersValidInformationUnderTheGetStartedFormInUP() {
        CSE.cseEnterFirstName();
        CSE.cseEnterLastName();
        CSE.cseEnterPrimaryPhoneNumber();
        CSE.cseEnterEmail();
        CSE.cseEnterPassword();
        CSE.cseEnterConfirmPassword();
        CSE.cseClickNextButton();
    }
    @And("the Upgrade user fills out the Home Address in UP and clicks Next")
    public void theUserFillOutTheHomeAddressInUPAndClickNext() {
        CSE.cseEnterHomeAddress();
        CSE.cseEnterCity();
        CSE.cseSelectState();
        CSE.cseEnterZipcode();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
        Upgrade_SignIn.verifyChooseTradeOption();
    }
    @And("the Upgrade user creates a new profile")
    public void theUserCreatesAnNewProfileInUP() {
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
        Upgrade_SignIn.upNextAddressBtn();
        Upgrade_SignIn.verifyChooseTradeOption();
    }
    @And("the Upgrade user signs out via the hamburger menu")
    public void userSignsOutFromTheUP() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Sign Out");
    }
    @Then("the Upgrade user should see the Welcome Back Message")
    public void theUserShouldSeeTheWelcomeBackMessage(){Upgrade_SignIn.upWelcomeBackPageForNewProfile();
    }
    @Then("the Upgrade user should successfully return to the homepage")
    public void theUserShouldReturnsToUpgradeHomepage(){Upgrade_SignIn.upHomePageVerify();
    }
    @And("the Upgrade user clicks on shop new cars via the hamburger menu")
    public void theUserClicksOnShopNewCarsButton() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
    }
    @And("the Upgrade user clicks on the {string} link from the top nav")
    public void theUpgradeUserClicksOnTheLinkFromTheTopNav(String linkName) {
        CSE.clickOnSignInHereLink(linkName);
    }
    @Then("the Upgrade user should see the {string} message")
    public void theUpgradeUserShouldSeeTheMessage(String errorMessage) {
        CSE.cseVerifyErrorMsgWhenUserEnterInvalidCredentials(errorMessage);
    }
    @And("the Upgrade user can enter their credentials")
    public void theUpgradeUserCanEnterTheirCredentials() {
        CSE.cseEnterValidCredentialsToLogin();
    }
}