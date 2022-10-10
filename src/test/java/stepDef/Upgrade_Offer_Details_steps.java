package stepDef;

import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.*;

public class Upgrade_Offer_Details_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    CSE_Garage_Saved_Deals_page CSESD;
    Upgrade_Finalize_Purchase_page Upgrade_Finance;
    CSE_Get_Approved_page CSEGA;
    Upgrade_Offer_Details_page Upgrade_OfferDetails;
    Upgrade_Appointments_page Upgrade_Appointment;

    public Upgrade_Offer_Details_steps (TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        Upgrade_Finance = context.getPageObjectManager().getUpgrade_Finalize_Purchase_page();
        CSEGA = context.getPageObjectManager().getGetApproved();
        Upgrade_OfferDetails = context.getPageObjectManager().getUpgrade_Offer_Details_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
    }
    @And("the Upgrade user clicks on the vehicle details button from the top nav")
    public void theUpgradeUserClicksOnTheVehicleDetailsButtonFromTheTopNav() {
        Upgrade_OfferDetails.upVehicleDetailsTopNev();
    }
    @And("the Upgrade user saves the deal to navigate back to the offer details page")
    public void theUpgradeUserSavesTheDealToNavigateBackToTheOfferDetailsPage() {
        Upgrade_SavedDeals.upSaveBtn();
        Upgrade_SavedDeals.upClearDealName();
        Upgrade_Appointment.upDealName();
        Upgrade_Appointment.upConfirmBtn();
        Upgrade_Appointment.upOfferDetails();
    }
    @When("the Upgrade user clicks on the vehicle details button from the right nav")
    public void theUpgradeUserClicksOnTheVehicleDetailsButtonFromTheRightNav() {
        Upgrade_OfferDetails.upVehicleDetailsRightNev();
    }
    @And("the Upgrade user clicks on the get trade value button")
    public void theUpgradeUserClicksOnTheGetTradeValueButton() {
        Upgrade_OfferDetails.upGetTradeValueBtn();
    }
    @And("the Upgrade user clicks on the get financing button")
    public void theUpgradeUserClicksOnTheGetFinancingButton() {
        Upgrade_OfferDetails.upGetFinancingBtn();
    }
    @When("the Upgrade user lands on the offer page")
    public void theUpgradeUserLandsOnTheOfferPage() {
        Upgrade_OfferDetails.upVerifyOfferDetailsPage();
    }
    @Then("the Upgrade user verifies all disclaimers exist")
    public void theUpgradeUserVerifiesAllDisclaimersExist() {
        Upgrade_OfferDetails.upVerifyDisclaimer();
    }
    @And("the Upgrade user clicks on the Terms of Use link")
    public void theUpgradeUserClicksOnTheTermsOfUseLink() {
        Upgrade_OfferDetails.upTermsOfUse();
        Upgrade_OfferDetails.upBackDealPage();
    }
    @And("the Upgrade user clicks on the Privacy Policy link")
    public void theUpgradeUserClicksOnThePrivacyPolicyLink() {
        Upgrade_OfferDetails.upPrivacyPolicy();
        Upgrade_OfferDetails.upBackDealPage();
    }
    @And("the Upgrade user clicks on the California Privacy Policy link")
    public void theUpgradeUserClicksOnTheCaliforniaPrivacyPolicyLink() {
        Upgrade_OfferDetails.upCaliforniaPrivacyPolicy();
        Upgrade_OfferDetails.upBackDealPage();
    }
    @And("the Upgrade user clicks on the Do Not Sell My Info link")
    public void theUpgradeUserClicksOnTheDoNotSellMyInfoLink() {
        Upgrade_OfferDetails.upDoNotSellMy();
    }
    @When("the Upgrade user clicks on the back button")
    public void theUpgradeUserClicksOnTheBackButton() {
        Upgrade_OfferDetails.upBackDealPage();
    }
    @Then("the Upgrade user verifies all footer links on the login page")
    public void theUpgradeUserVerifiesAllFooterLinkOnLoginPage() {
        Upgrade_OfferDetails.upTermsOfUse();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upPrivacyPolicyLoginPage();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upCaliforniaPrivacyPolicy();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upDoNotSellMy();
        Upgrade_OfferDetails.upBackDealPage();
    }
    @And("the Upgrade user clicks on the Terms link page")
    public void theUpgradeUserClicksOnTheTermsLinkPage() {
        Upgrade_OfferDetails.upTermLinkPage();
    }
    @When("the Upgrade user clicks on the Privacy Policy link page")
    public void theUpgradeUserClicksOnThePrivacyPolicyLinkPage() {
        Upgrade_OfferDetails.upPrivacyPolicyLinkPage();
    }
    @And("the Upgrade user clicks on the Terms of Service Privacy Policy link page")
    public void theUpgradeUserClicksOnTheTermsOfServiceLinkPage() {
        Upgrade_OfferDetails.upTermServiceLinkPage();
        Upgrade_OfferDetails.upPrivacyLinkAccountPage();
    }

    @Then("the Upgrade user verifies all footer links")
    public void theUpgradeUserVerifiesAllFooterLinksOnTheGetStartedPage() {
        Upgrade_OfferDetails.upTermsOfUse();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upPrivacyPolicyLoginPage();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upCaliforniaPrivacyPolicy();
        Upgrade_OfferDetails.upBackDealPage();
        Upgrade_OfferDetails.upDoNotSellMy();
        Upgrade_OfferDetails.upBackDealPage();
    }
    @And("the Upgrade user clicks on the shop new button")
    public void theUpgradeUserClicksOnShopNewButton() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
    }
    @And("the Upgrade user selects a vehicle to navigate to the vehicle details page")
    public void theUpgradeUserSelectsAVehicleToNavigateToVehicleDetailsPage() {
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
    }
    @When("the Upgrade user clicks on the offer details button")
    public void theUpgradeUserClicksOnTheOfferDetailsButton() {
        Upgrade_Appointment.upOfferDetails();
        Upgrade_SavedDeals.upUserIncomeBirthYearInfo();
        Upgrade_SavedDeals.upOfferCloseBtn();
    }
}