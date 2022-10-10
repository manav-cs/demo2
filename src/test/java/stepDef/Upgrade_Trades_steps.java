package stepDef;

import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_Trades_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Address_page CSEG;
    CSE_My_Trades_page CSEMT;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Trades_page Upgrade_Trades;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_Appointments_page Upgrade_Appointment;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    CSE_Garage_Saved_Deals_page CSESD;

    public Upgrade_Trades_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Trades = context.getPageObjectManager().getUpgrade_Trades_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
    }

    @When("the Upgrade user clicks on value trade via the hamburger menu")
    public void theUpgradeUserClicksOnValueTradeViaHamburgerMenu() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Value Trade");
    }

    @Then("the Upgrade user lands on to choose a trade option page")
    public void theUpgradeUserLandsOnChooseATradeOptionPage() {
        Upgrade_SignIn.verifyChooseTradeOption();
    }

    @And("the Upgrade user click on the {string} link from my garage")
    public void theUpgradeUserClickOnTheLinkFromMyGarage(String myTrades) {
        CSEG.clickGarageNavOption(myTrades);
    }

    @And("the Upgrade user clicks on the {string} link from my garage")
    public void theUpgradeUserClicksOnTheLinkFromMyGarage(String myTrades) {
        CSEG.clickGarageNavOption(myTrades);
        CSEMT.cseGarageMyTradeAddTradeButton();
        CSEMT.cseGarageMyTradeClickTradeACar();
    }

    @When("the Upgrade user clicks the Add Trade button from my garage")
    public void theUpgradeUserClicksTheAddTradeButtonFromMyGarage() {
        CSEMT.cseGarageMyTradeAddTradeButton();
    }

    @And("the Upgrade user clicks Trade A Car")
    public void theUpgradeUserClicksTradeACar() {
        CSEMT.cseGarageMyTradeClickTradeACar();
    }

    @And("the Upgrade user submits a VIN")
    public void theUpgradeUserSubmitsAVIN() {
        CSEMT.cseGarageTradeInEnterYourVin();
    }

    @And("the Upgrade user submits vehicle information")
    public void theUpgradeUserSubmitsVehicleInformation() {
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
    }

    @And("the Upgrade user submits vehicle features")
    public void theUpgradeUserSubmitsVehicleFeatures() {
        CSEMT.cseGarageTradeInVehicleFeatures();
    }

    @And("the Upgrade user confirms the vehicle condition")
    public void theUpgradeUserConfirmsTheVehicleCondition() {
        CSEMT.cseGarageTradeInVehicleCondition();
    }

    @And("the Upgrade user's information is submitted")
    public void theUpgradeUserSInformationIsSubmitted() {
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
    }

    @And("the Upgrade user's current payment information is submitted")
    public void theUpgradeUserSCurrentPaymentInformationIsSubmitted() {
        CSEMT.cseGarageTradeInCurrentPayment();
    }

    @And("the Upgrade user's Finance Company is submitted")
    public void theUpgradeUserSFinanceCompanyIsSubmitted() {
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
    }

    @When("the Upgrade user continues with the estimated payoff")
    public void theUpgradeUserContinuesWithTheEstimatedPayoff() {
        CSEMT.cseGarageTradeInAdditionalInfoNeeded();
    }

    @Then("the Upgrade user is on the Trade Offer Details page")
    public void theUpgradeUserIsOnTheTradeOfferDetailsPage() {
        CSEMT.cseGarageTradeInOfferVehicleDetails();
    }

    @And("the Upgrade user can see the Offer information")
    public void theUpgradeUserCanSeeTheOfferInformation() {
        CSEMT.cseGarageTradeInOfferDetails();
        CSEMT.cseGarageTradeInOfferBasic();
        CSEMT.cseGarageTradeInOfferFeatures();
        CSEMT.cseGarageTradeInOfferHistory();
        CSEMT.cseGarageTradeInOfferPayOff();
    }

    @Then("the Upgrade user clicks on the view offers button")
    public void theUpgradeUserClicksOnViewOffersButton() {
        Upgrade_Trades.ViewOfferButton();
    }

    @And("the Upgrade user submits a Trade-In Vehicle")
    public void theUpgradeUserSubmitsATradeInVehicle() {
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

    @When("the Upgrade user returns to My Trades")
    public void theUpgradeUserReturnsToMyTrades() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSEH.cseMyGarageClickHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Trades");
    }

    @And("the Upgrade user clicks on view offers")
    public void theUpgradeUserClicksOnViewOffers() {
        CSEMT.cseGarageTradeInMyTradeViewOffers();
    }

    @Then("the Upgrade user can see the offer price")
    public void theUpgradeUserCanSeeTheOfferPrice() {
        CSEMT.cseGarageTradeInMyTradeViewOffersInfo();
    }

    @When("the Upgrade user clicks on the Vehicle Details link")
    public void theUpgradeUserClicksOnTheVehicleDetailsLink() {
        CSEMT.cseGarageTradeInMyTradeGoToTradeOfferPage();
    }

    @And("the Upgrade user clicks on the view vehicles button for the upgrade")
    public void theUpgradeUserClicksOnViewVehiclesButtonAndClicksOnTheVehicleForUpgrade() {
        Upgrade_Trades.ViewVehicleBtn();
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
    }

    @When("the Upgrade user clicks on the vehicle details after returning to my trades page")
    public void theUpgradeUserReturnsToMyTradesPage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSEH.cseMyGarageClickHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Trades");
        Upgrade_Trades.VehicleDetailsBtn();
    }

    @And("the Upgrade user clicks on continues with the estimated payoff")
    public void theUpgradeUserClicksOnContinuesWithTheEstimatedPayoff() {
        Upgrade_Trades.ContinueWithPayoffBtn();
    }

    @And("the Upgrade user sees the Choose Trade Option page after clicking Add Trade button")
    public void theUpgradeUserSeesTheChooseTradeOptionPageAfterClickingAddTradeButton() {
        CSEMT.cseGarageTradeInMyTradeBackUpOldVehicleInfo();
        CSEMT.cseGarageMyTradeClickAddATrade();
    }

    @And("the Upgrade user sees the previous vehicle listed on the Choose Trade Option page")
    public void theUpgradeUserSeesThePreviousVehicleListedOnTheChooseTradeOptionPage() {
        CSEMT.cseGarageTradeInChooseTradeOptionOldVehicle();
    }

    @And("the Upgrade user submits another Trade-In Vehicle")
    public void theUpgradeUserSubmitsAnotherTradeInVehicle() {
        CSEMT.cseGarageTradeInChooseTradeOptionAddTrade();
        theUpgradeUserSubmitsATradeInVehicle();
    }

    @And("the Upgrade user clicks on enter payoff information button")
    public void theUpgradeUserClicksOnEnterPayoffInformationButton() {
        Upgrade_Trades.PayoffInfoBtn();
    }

    @And("the Upgrade user submits all payoff information")
    public void theUpgradeUserSubmitsAllPayoffInformation() {
        Upgrade_Trades.PaymentType();
        Upgrade_Trades.PayoffAmount();
        Upgrade_Trades.MonthlyPayment();
        Upgrade_Trades.PayoffCalender();
        Upgrade_Trades.PayoffDate();
        Upgrade_Trades.RemainingPayment();
        CSE.cseClickNextButton();
    }

    @And("the Upgrade user clicks the Return a Lease button")
    public void theUpgradeUserClicksTheReturnALeaseButton() {
        Upgrade_Trades.ReturnLeaseBtn();
    }

    @And("the Upgrade user clicks on the {string} link")
    public void theUpgradeUserClicksOnTheLink(String myTrades) {
        CSEG.clickGarageNavOption(myTrades);
    }

    @And("the Upgrade user submits lease vehicle information")
    public void theUpgradeUserSubmitsLeaseVehicleInformation() {
        CSEMT.cseVerifyLeaseVehicleInfo();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
    }

    @And("the Upgrade user submits a lease vehicle trade-in")
    public void theUpgradeUserSubmitsALeaseVehicleTradeIn() {
        CSEMT.cseChooseTradeOptionClickReturnLease();
        CSEMT.cseGarageTradeInEnterYourVin();
        CSEMT.cseVerifyLeaseVehicleInfo();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
        CSEMT.cseGarageTradeInCurrentPayment();
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
        CSEMT.cseTradeInLeaseOptionPayment();
    }

    @And("the Upgrade user views the vehicle after returning to my trades page")
    public void theUpgradeUserViewsToVehicleAfterReturningToMyTradesPage() {
        Upgrade_Trades.ViewVehicleBtn();
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
        CSEH.cseGarageOpenHamburgerMenu();
        CSEH.cseMyGarageClickHamburgerLinks("My Garage");
        CSEG.clickGarageNavOption("My Trades");
    }

    @And("the Upgrade user clicks the Complete Trade Offer button")
    public void theUpgradeUserClicksTheCompleteTradeOfferButton() {
        CSEMT.cseCompleteTradeOfferButton();
    }

    @And("the Upgrade user re-submits all vehicle information")
    public void theUpgradeUserResubmitAllVehicleInformation() {
        CSEMT.cseVerifyVehicleInformationHeader();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseVehicleSubmitButton();
        CSEMT.cseGarageTradeInVehicleFeatures();
        CSEMT.cseGarageTradeInVehicleCondition();
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
        CSEMT.cseGarageTradeInCurrentPayment();
        CSEMT.cseGarageTradeInCurrentPaymentFinance();
        CSEMT.cseTradeInLeaseOptionPayment();
        CSEG.clickGarageNavOption("My Trades");
    }

    @Then("the Upgrade user can see Incomplete as the offer price")
    public void theUpgradeUserCanSeeIncompleteAsTheOfferPrice() {
        CSEMT.cseTradeInLeaseOptionOfferIncomplete();
    }

    @Then("the Upgrade user can see the offer price no longer says Incomplete")
    public void theUpgradeUserCanSeeTheOfferPriceNoLongerSaysIncomplete() {
        CSEMT.cseTradeInLeaseOptionOfferNotIncomplete();
    }

    @And("the Upgrade user clicks to add a trade on the deal page")
    public void theUpgradeUserClicksOnAddATradeOnDealPage() {
        Upgrade_Trades.upAddTradeBtn();
        CSEMT.cseGarageMyTradeClickTradeACar();
    }

    @And("the Upgrade user submits a Trade-In Vehicle the deal")
    public void theUpgradeUserSubmitsATradeInVehicleTheDeal() {
        CSEMT.cseGarageTradeInEnterYourVin();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrim();
        CSEMT.cseGarageTradeInEnterVehicleInfoTrans();
        CSEMT.cseGarageTradeInEnterVehicleInfoColor();
        CSEMT.cseGarageTradeInEnterVehicleInfoMiles();
        CSEMT.cseGarageTradeInVehicleFeatures();
        CSEMT.cseGarageTradeInVehicleCondition();
        CSEMT.cseGarageTradeInVehicleTradeInUserInfo();
        CSEMT.cseGarageTradeInCurrentPayment();
        Upgrade_Trades.upTradeInCurrentPaymentFinance();
        CSEMT.cseTradeInLeaseOptionPayment();
    }

    @Then("the Upgrade user switches to the Finance tab")
    public void theUpgradeUserSwitchToFinanceTab() {
        CSESD.cseDealSwitchToFinanceTab();
    }

    @Then("the Upgrade user is presented with the trade vehicle")
    public void theUpgradeUserIsPresentedWithTheTradeVehicle() {
        Upgrade_Trades.upContinueFinanceOption(GlobalTestData.CSE_TRADE_OFFER_AMOUNT);
    }

    @And("the Upgrade user clicks on the change trade link")
    public void theUpgradeUserClicksOnChangeTradeLink() {
        Upgrade_Trades.upChangeTradeBtn();
        Upgrade_Trades.upAddTradeBtn2();
    }

    @When("the Upgrade user clicks on change trade to add no trade")
    public void theUpgradeUserClicksOnChangeTradeToAddNoTrade() {
        Upgrade_Trades.upChangeTradeBtn();
        Upgrade_Trades.upNoTradeBtn();
    }

    @Then("the Upgrade user verifies no trade vehicle has been added")
    public void theUpgradeUserVerifiesNoTradeVehicleHasBeenAdded() {
        Upgrade_Trades.upVerifyNoTradeAddedInDealPage();
    }
}
