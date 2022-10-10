package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Recently_Viewed_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Appointments_page CSEA;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Hamburger_page CSEH;
    CSE_My_Trades_page CSEMT;
    CSE_Garage_Saved_Deals_page CSESD;
    CSE_Recently_Viewed_page CSEV;

    public CSE_Recently_Viewed_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEA = context.getPageObjectManager().getCsEcomGarageAppointments();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        CSEV = context.getPageObjectManager().getCseRecentViewed();
    }

    @And("the Save Deal confirmation modal appears")
    public void theSaveDealConfirmationModalAppears() {
        CSEV.cseSaveDealConfirmationModal();
    }

    @Then("the Save Deal confirmation modal vanishes")
    public void theSaveDealConfirmationModalVanishes() {
        CSEV.cseSaveDealConfirmationModalGone();
    }

    @Then("the recently viewed vehicles page is present")
    public void theRecentlyViewedVehiclesPageIsPresent() {
        CSEV.cseVerifyRecentlyViewedVehiclesSection();
    }

    @And("the CSE user stores a vehicle under Recently Viewed Vehicles")
    public void theCseUserStoresAVehicleUnderRecentlyViewedVehicles() {
        CSEV.cseHamburgerIconNoWait();
        CSEV.cseSaveDealConfirmationModal();
        CSEV.cseSaveDealConfirmationNoThanks();
        CSEV.cseSaveDealConfirmationModalGone();
        CSESD.cseDealInformation();
        GenericFunctions.clickLinkByText("My Garage");
        CSEV.cseVerifyRecentlyViewedVehiclesSection();
    }

    @When("the user deletes the first vehicle from recently viewed vehicles")
    public void theUserDeletesTheFirstVehicleFromRecentlyViewedVehicles() {
        CSEV.cseRemove1stVehicleFromRecentlyViewed();
    }

    @Then("the first vehicle is no longer present")
    public void theFirstVehicleIsNoLongerPresent() {
        CSEV.cseFirstRecentlyViewedVehicleGone();
    }

    @And("no vehicles are present under Recently Viewed Vehicles")
    public void noVehiclesArePresentUnderRecentlyViewedVehicles() {
        CSEV.cseRecentlyViewedNoVehicles();
    }

    @And("the CSE user can see the most recently viewed vehicle")
    public void theCSEUserCanSeeTheMostRecentlyViewedVehicle() {
        CSEV.cseRecentlyViewedVehicle1();
    }

    @And("the CSE user can see both recently viewed vehicle")
    public void theCSEUserCanSeeBothRecentlyViewedVehicle() {
        CSEV.cseRecentlyViewedVehicle2();
    }

    @Then("the CSE user can see the remaining vehicle")
    public void theCSEUserCanSeeTheRemainingVehicle() {
        CSEV.cseRecentlyViewedVehicleRemainingVehicle();
    }

    @And("there are no other vehicles present")
    public void thereAreNoOtherVehiclesPresent() {
        CSEV.cseRecentlyViewedVehicleNoSecondVehicle();
    }

    @And("the CSE user creates a new account")
    public void theCseUserCreatesANewAccount() {
        CSE.clickOnSignInHereLink("Sign in here");
        CSE.cseClickCreateAnAccount_non_sso("Create an Account");
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
        CSEMT.cseChooseTradeOptionNoTrade();
        CSEMT.cseTradeInVerifyYourInfoIfPresent();
    }

    @When("the CSE user clicks the Hamburger menu")
    public void theCSEUserClicksTheHamburgerMenu() {
        CSEV.cseHamburgerIconNoWait();
    }

    @And("the CSE user signs in from deal page")
    public void theCSEUserSignsInFromDealPage() {
        CSE.clickOnSignInHereLink("Sign in here");
        CSE.cseEnterRegisteredEmail();
        CSE.cseRegiFormPassword();
        CSE.cseClickSignInButton("Sign In");
    }

    @And("the CSE user sees the previous viewed vehicle saved")
    public void theCSEUserSeesThePreviousViewedVehicleSaved() {
        CSEV.cseMyGarageSavedDealsPreviouslyViewedVehicle();
    }

    @And("the CSE user stores a second vehicle under Recently Viewed Vehicles")
    public void theCSEUserStoresASecondVehicleUnderRecentlyViewedVehicles() {
        CSEV.cseHamburgerIconNoWait();
        CSEV.cseSaveDealConfirmationModal();
        GenericFunctions.clickLinkByText("No, thanks");
        CSEV.cseSaveDealConfirmationModalGone();
        CSESD.cseDealInformation();
        GenericFunctions.clickLinkByText("My Garage");
    }
}
