package stepDef;

import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Garage_My_Trades_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_My_Trades_page CSEMT;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    CSE_Garage_Hamburger_page CSEH;

    public CSE_Garage_My_Trades_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
    }

    @Then("the user does not have any trade vehicles")
    public void theUserDoesNotHaveAnyTradeVehicles() {
        CSEG.clickGarageNavOption("My Trades");
        CSEMT.findContainsTextOnPage("No Trades Found!");
        CSEMT.findTextOnPageNormalized("Check back in after you submit a trade in.");
    }

    @When("the user clicks the Add Trade button")
    public void theUserClicksTheAddTradeButton() {
        CSEMT.cseGarageMyTradeAddTradeButton();
    }

    @And("the user clicks Trade A Car")
    public void theUserClicksTradeAVehicle() {
        CSEMT.cseGarageMyTradeClickTradeACar();
    }

    @And("the user submits a VIN")
    public void theUserSubmitsAVin() {
        CSEMT.cseGarageTradeInEnterYourVin();
    }

    @And("the user submits vehicle information")
    public void theUserSubmitsVehicleInformation() {
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
    }

    @And("the user's information is submitted")
    public void theUserSInformationIsSubmitted() {
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
    }

    @And("the user's current payment information is submitted")
    public void theUserSCurrentPaymentInfoIsSubmitted() {
        CSEMT.cseGarageTradeInCurrentPayment();
    }

    @And("the user submits vehicle features")
    public void theUserSubmitsVehicleFeatures() {
        CSEMT.cseGarageTradeInVehicleFeatures();
    }

    @And("the user confirms the vehicle condition")
    public void theUserConfirmsTheVehicleCondition() {
        CSEMT.cseGarageTradeInVehicleCondition();
    }

    @And("the user's Finance Company is submitted")
    public void theUserSFinanceCompanyIsSubmitted() {
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
    }

    @And("the user continues with the estimated payoff")
    public void theUserContinuesWithEstimatedPayoff() {
        CSEMT.cseGarageTradeInAdditionalInfoNeeded();
    }

    @Then("the user is on the Trade Offer Details page")
    public void theUserIsOnTheTradeOfferDetailsPage() {
        CSEMT.cseGarageTradeInOfferVehicleDetails();
    }

    @And("the user can see the Offer information")
    public void theUserCanSeeTheOfferInformation() {
        CSEMT.cseGarageTradeInOfferDetails();
        CSEMT.cseGarageTradeInOfferBasic();
        CSEMT.cseGarageTradeInOfferFeatures();
        CSEMT.cseGarageTradeInOfferHistory();
        CSEMT.cseGarageTradeInOfferPayOff();
    }

    @And("the user submits a Trade-In Vehicle")
    public void theUserSubmitsATradeInVehicle() {
        CSEMT.cseGarageTradeInEnterYourVin();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
        CSEMT.cseGarageTradeInVehicleFeatures();
        CSEMT.cseGarageTradeInVehicleCondition();
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
        CSEMT.cseGarageTradeInCurrentPayment();
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
        CSEMT.cseGarageTradeInAdditionalInfoNeeded();
        CSEMT.cseGarageTradeInOfferVehicleDetails();
        CSEMT.cseGarageTradeInOfferDetailsRetain();
    }

    @And("the user returns to My Trades")
    public void theUserReturnsToMyTrades() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSEH.cseMyGarageClickHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Trades");
    }

    @And("the user sees the Choose Trade Option page after clicking Add Trade button")
    public void theUserSubmitsASecondTradeInVehicle() {
        CSEMT.cseGarageTradeInMyTradeBackUpOldVehicleInfo();
        CSEMT.cseGarageMyTradeClickAddATrade();
    }

    @And("the user submits another Trade-In Vehicle")
    public void theUserSubmitsAnotherTradeInVehicle() {
        CSEMT.cseGarageTradeInChooseTradeOptionAddTrade();
        theUserSubmitsATradeInVehicle();
    }

    @Then("the new trade-in vehicle is present on the My Trades page")
    public void theNewTradeInVehicleIsPresentOnTheMyTrades() {
        CSEMT.cseGarageTradeInMyTradeInfo(GlobalTestData.SQL_QUERY);
    }

    @And("the old trade-in vehicle is still present on the My Trades page")
    public void theOldTradeInVehicleIsStillPresentOnTheMyTradesPage() {
        CSEMT.cseGarageTradeInMyTradeInfo(GlobalTestData.OLD_VEHICLE_INFO);
    }

    @When("the user clicks on view offers")
    public void theUserClicksOnViewOffers() {
        CSEMT.cseGarageTradeInMyTradeViewOffers();
    }

    @Then("the user can see the offer price")
    public void theUserCanSeeTheOfferPrice() {
        CSEMT.cseGarageTradeInMyTradeViewOffersInfo();
    }

    @When("the user clicks on the Vehicle Details link")
    public void theUserClicksOnVehicleDetailsLink() {
        CSEMT.cseGarageTradeInMyTradeGoToTradeOfferPage();
    }

    @Then("the Trade-Offer Details page is present")
    public void theTradeOfferDetailsPageIsPresent() {
        CSEMT.cseGarageTradeInOfferVehicleDetails();
    }

    @And("the user sees the previous vehicle listed on the Choose Trade Option page")
    public void theUserSeesThePreviousVehicleListedOnTheChooseTradeOptionPage() {
        CSEMT.cseGarageTradeInChooseTradeOptionOldVehicle();
    }

    @Then("the CSE user is on the Choose Trade Option page")
    public void theCSEUserIsOnTheChooseTradeOptionPage() {
        CSEMT.cseChooseTradeOptionPage();
    }

    @When("the user clicks the Return a Lease icon")
    public void theUserClicksTheReturnALeaseIcon() {
        CSEMT.cseChooseTradeOptionClickReturnLease();
    }

    @And("the user submits lease vehicle information")
    public void theUserSubmitsLeaseVehicleInformation() {
        CSEMT.cseVerifyLeaseVehicleInfo();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
    }

    @When("the user submits a lease vehicle trade in")
    public void theUserSubmitsALeaseVehicleTradeIn() {
        CSEMT.cseChooseTradeOptionClickReturnLease();
        CSEMT.cseGarageTradeInEnterYourVin();
        CSEMT.cseVerifyLeaseVehicleInfo();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
        CSEMT.cseGarageTradeInCurrentPayment();
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
        CSEMT.cseTradeInLeaseOptionPayment();
        CSEG.clickGarageNavOption("My Trades");
    }

    @When("the user clicks the Complete Trade Offer button")
    public void theUserClicksTheCompleteTradeOfferButton() {
        CSEMT.cseCompleteTradeOfferButton();
    }

    @And("the user submits transmission and color vehicle information")
    public void theUserSubmitsTransmissionAndColorVehicleInformation() {
        CSEMT.cseVerifyVehicleInformationHeader();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseVehicleSubmitButton();
    }

    @And("the Complete Trade Offer button is not present")
    public void theCompleteTradeOfferButtonIsNotPresent() {
        CSEMT.cseCompleteTradeOfferButtonNotPresent();
    }

    @And("the user sees the Trade Option buttons")
    public void theUserSeesTheTradeOptionButtons() {
        CSEMT.cseChooseTradeOptionElementsVerified();

    }

    @When("the user clicks the Which Option link")
    public void theUserClicksTheWhichOptionLink() {
        CSEMT.cseChooseTradeOptionWhichOneLink();
    }

    @Then("the user sees the Choose Trade Options help modal")
    public void theUserSeesTheChooseTradeOptionsHelpModal() {
        CSEMT.cseChooseTradeOptionWhichOneModal();
    }

    @When("the user closes the Choose Trade Options help modal")
    public void theUserClosesTheChooseTradeOptionsHelpModal() {
        CSEMT.cseChooseTradeOptionWhichOneCloseModal();
    }

    @And("the user clicks the No Trade option")
    public void theUserClicksTheNoTradeOption() {
        CSEMT.cseChooseTradeOptionNoTrade();
    }

    @When("the user continues with the estimated lease payoff")
    public void theUserContinuesWithTheEstimatedLeasePayoff() {
        CSEMT.cseTradeInLeaseOptionPayment();
        CSEG.clickGarageNavOption("My Trades");
    }

    @Then("the user can see Incomplete as the offer price")
    public void theUserCanSeeIncompleteAsTheOfferPrice() {
        CSEMT.cseTradeInLeaseOptionOfferIncomplete();
    }

    @Then("the user can see the offer price no longer says Incomplete")
    public void theUserCanSeeTheOfferPriceNoLongerSaysIncomplete() {
        CSEMT.cseTradeInLeaseOptionOfferNotIncomplete();
    }

    @And("submit the user's financial information if necessary")
    public void submitTheUserSFinancialInformationIfNecessary() {
        CSEMT.cseTradeInVerifyYourInfoIfPresent();
    }

    @And("the user clicks No Trade")
    public void theUserClicksNoTrade() {
        CSEMT.cseClickTradeButtonOnChooseTradeOption();
    }
}