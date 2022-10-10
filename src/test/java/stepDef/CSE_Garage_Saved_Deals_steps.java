package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Garage_Saved_Deals_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Appointments_page CSEA;
    CSE_Accessories_page CSEAsc;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Hamburger_page CSEH;
    CSE_Garage_Saved_Deals_page CSESD;
    CSE_My_Trades_page CSEMT;
    CSE_Recently_Viewed_page CSEV;

    public CSE_Garage_Saved_Deals_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEA = context.getPageObjectManager().getCsEcomGarageAppointments();
        CSEAsc = context.getPageObjectManager().getCSE_accessories_page();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        CSEV = context.getPageObjectManager().getCseRecentViewed();
    }

    @When("the CSE user clicks the Save button on the deal page")
    public void theCseUserClicksTheSaveButtonOnTheDealPage() {
        CSESD.cseDealPageClickSave();
    }

    @And("the CSE user submits personal finance information")
    public void theCSEUserSubmitsPersonalFinanceInformation() {
        CSEMT.cseChooseTradeOptionNoTrade();
        CSEMT.cseTradeInVerifyYourInfoIfPresent();
    }

    @Then("the offers ready modal appears")
    public void theOffersReadyModalAppears() {
        CSESD.cseDealPageDealsReadyModal();
    }

    @Then("the deal page is present")
    public void theDealPageIsPresent() {
        CSESD.cseDealPageVehicleInfo();
    }

    @Then("the Deal Name modal appears")
    public void theDealNameModalAppears() {
        CSESD.cseDealPageDealNameModal();
    }

    @When("the Deal Name modal is canceled")
    public void theDealNameModalIsCanceled() {
        CSESD.cseDealPageDealNameModalCancel();
    }

    @When("the CSE user clicks save and confirms the save")
    public void theCSEUserClicksSaveAndConfirmsTheSave() {
        CSESD.cseDealPageWaitForOkFlyOut();
        CSESD.cseDealPageClickSave();
        CSESD.cseDealPageDealNameModalConfirm();
    }

    @Then("the deal is marked as saved")
    public void theDealIsMarkedAsSaved() {
        CSESD.cseDealPageSavedDeal();
    }

    @Then("the CSE user is on the Saved Deals page in My Garage")
    public void theCseUserIsOnTheSavedDealsPageInMyGarage() {
        CSESD.cseMyGarageSavedDealsOptionText();
    }

    @And("the recently saved deal is present")
    public void theRecentlySavedDealIsPresent() {
        CSESD.cseMyGarageSavedDealsVehicleInfo();
    }

    @When("the CSE user clicks the View Deal button")
    public void theCseUserClicksTheViewDealButton() {
        CSESD.cseMyGarageSavedDealsViewDealClick();
    }

    @Then("the deal page is present with the saved button")
    public void theDealPageIsPresentWithTheSavedButton() {
        CSESD.cseDealPageVehicleInfoSavedButton();
    }

    @When("the CSE user saves a deal")
    public void theCSEUserSavesADeal() {
        CSESD.cseDealPageClickSave();
        CSESD.cseDealPageDealNameModal();
        CSESD.cseDealPageDealNameModalConfirm();
        CSESD.cseDealPageSavedDeal();
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        CSESD.cseMyGarageSavedDealsVehicleInfo();
    }

    @And("the CSE user changes the check box selection")
    public void theCSEUserChangesTheCheckBoxSelection() {
        CSESD.cseMyGarageSavedDealsAlterCheckBox();
    }

    @And("the CSE user changes the down payment for finance to {string}")
    public void theCSEUserChangesTheDownPaymentForFinance(String amount) {
        CSESD.cseMyGarageSavedDealsAlterDownPayment(amount);
    }

    @Then("the deal page still has the updated information")
    public void theDealPageStillHasTheUpdatedInformation() {
        CSESD.cseMyGarageSavedDealUpdateConfirm();
    }

    @And("the CSE user goes to My Garage")
    public void theCSEUserGoesToMyGarage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Home");
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
    }

    @When("the CSE user deletes the saved deal")
    public void theCSEUserDeletesTheSavedDeal() {
        CSESD.cseMyGarageSavedDealDeleteDeal();
    }

    @Then("the saved deal is no longer present")
    public void theSavedDealIsNoLongerPresent() {
        CSEG.clickGarageNavOption("Saved Deals");
        CSESD.cseMyGarageNoSavedDeals();
    }

    @And("the CSE user copies the deal information")
    public void theCSEUserCopiesTheDealInformation() {
        CSESD.cseDealInformation();
    }

    @And("the CSE user copies the second deal information")
    public void theCSEUserCopiesTheNdDealInformation() {
        CSESD.cseDealInformation2();
    }

    @When("the CSE user switches to the Finance tab")
    public void theCSEUserSwitchesToTheFinanceTab() {
        CSESD.cseDealSwitchToFinanceTab();
        CSESD.cseDealApplyForFinanceRememberDownPay();
    }

    @And("the CSE user notes the current finance information")
    public void theCSEUserNotesTheCurrentFinanceInformation() {
        CSESD.cseDealFinanceInformationSave();
        CSESD.cseStorePreSavedDealInfo();
    }

    @And("the CSE user verifies the finance information has updated")
    public void theCSEUserVerifiesTheFinanceInformationHasUpdated() {
        CSESD.cseVerifyUpdatedDownPaymentInfo();
    }

    @And("the CSE user refreshes the page")
    public void theCSEUserRefreshesThePage() {
        CSESD.cseRefreshDealPage();
    }

    @And("the CSE user switches to the Lease tab")
    public void theCSEUserSwitchesToTheLeaseTab() {
        CSESD.cseDealSwitchToLeaseTab();
    }

    @When("the CSE user switches to the Cash tab")
    public void theCSEUserSwitchesToTheCashTab() {
        CSESD.cseDealSwitchToCashTab();
    }

    @And("the CSE user notes the current lease information")
    public void theCSEUserNotesTheCurrentLeaseInformation() {
        CSESD.cseDealFinanceInformationSave();
        CSESD.cseStorePreSavedDealInfo();
    }

    @And("the CSE user changes the down payment for lease to {string}")
    public void theCSEUserChangesTheDownPaymentForLeaseTo(String amount) {
        CSESD.cseMyGarageSavedDealsAlterDownPayment(amount);
    }

    @And("the CSE user verifies the lease information has updated")
    public void theCSEUserVerifiesTheLeaseInformationHasUpdated() {
        CSESD.cseVerifyUpdatedDownPaymentInfo();
    }

    @Then("the list of deal options is ordered by month descending")
    public void theListOfDealOptionsIsOrderedByMonthDescending() {
        CSESD.cseDealCheckBoxOrder();
    }

    @And("the listed deal options do not repeat")
    public void theListOfDealOptionsDoNotRepeat() {
        CSESD.cseDealCheckBoxesNotRepeating();
    }

    @Then("the check box order does not change")
    public void theCheckBoxOrderDoesNotChange() {
        CSESD.cseDealVerifyCheckBoxOrder();
    }

    @And("the CSE user selects {string} in the Miles Per Year drop down")
    public void theCSEUserSelectsInTheMilesPerYearDropDown(String drop) {
        CSESD.cseDealerMilesPerYearDropDownSelection(drop);
    }

    @When("the CSE user logs in from the deal page")
    public void theCSEUserLogsInFromTheDealPage() {
        CSE.clickOnSignInHereLink("Sign in here");
        CSE.cseEnterValidEmail();
        CSE.cseEnterValidPassword();
        CSE.cseClickSignInButton("Sign In");
        CSESD.cseDealPageVehicleInfo();
    }

    @When("the CSE user updates the desired down payment with the same value")
    public void theCSEUserUpdatesTheDesiredDownPaymentWithTheSameValue() {
        CSESD.cseDealerRecalculateDealSameValue();
    }

    @When("the user clicks Add a Trade")
    public void theUserClicksAddATrade() {
        CSESD.cseDealPageAddATrade();
    }

    @And("the user clicks the Change Trade link")
    public void theUserClicksTheChangeTradeLink() {
        CSESD.cseDealChangeTradeLink();
    }

    @When("the user clicks the Change Trade button")
    public void theUserClicksTheChangeTradeButton() {
        CSESD.cseDealChangeTradeButton();
    }

    @Then("the user deal page displays no trade vehicle")
    public void theUserDealPageDisplaysNoTradeVehicle() {
        CSESD.cseDealNoTradeInVehicle();
    }

    @And("the user clicks the Apply For Credit button")
    public void theUserClicksTheApplyForCreditButton() {
        CSESD.cseDealApplyForCreditButton();
    }

    @And("the CSE user clicks the Add Accessories link under Buy @ Home")
    public void theCSEUserClicksTheAddAccessoriesLinkUnderBuyHome() {
        CSESD.cseClickAddAccessoriesLinkUnderBuyHome();
        CSEAsc.cseAccessoriesPageHeader();
    }

    @Then("the deal is saved")
    public void theDealIsSaved() {
        CSESD.cseAssertHeartSavedButton();
    }

    @When("the CSE user clicks the Add Accessories button")
    public void theCSEUserClicksTheAddAccessoriesButton() {
        CSESD.cseDealPageAccessoriesButton();
    }

    @When("the CSE user clicks the Add Accessories link under Offer Details")
    public void theCSEUserClicksTheAddAccessoriesLinkUnderOfferDetails() {
        CSESD.cseDealPageAccessoriesOfferLink();
    }

    @Then("the save button requests user to save changes")
    public void theSaveButtonRequestsUserToSaveChanges() {
        CSESD.cseAssertSaveChangesButton();
    }

    @And("the CSE user clicks the Edit Accessories link under Buy @ Home")
    public void theCSEUserClicksTheEditAccessoriesLinkUnderBuyHome() {
        CSESD.cseClickEditAccessoriesLinkUnderBuyHome();
        CSEAsc.cseAccessoriesPageHeader();
    }

    @When("the CSE user clicks the Edit Accessories button")
    public void theCSEUserClicksTheEditAccessoriesButton() {
        CSESD.cseDealPageEditAccessoriesButton();
        CSEAsc.cseAccessoriesPageHeader();
    }

    @When("the second monthly check box is selected")
    public void theSecondMonthlyCheckBoxIsSelected() {
        CSESD.cseDealPageClick2ndMonthlyCheckbox();
    }

    @And("the active tab is the {string} tab")
    public void theActiveTabIsThe(String tabName) {
        CSESD.cseDealPageVerifyActiveTab(tabName);
    }

    @And("the second monthly check box is still selected")
    public void theSecondMonthlyCheckBoxIsStillSelected() {
        CSESD.cseDealPage2ndMonthlyCheckBoxSelected();
    }

    @And("Miles Per Year still shows {string}")
    public void milesPerYearStillShows(String milesYear) {
        CSESD.cseDealPageVerifyMilesPerYearValue(milesYear);
    }

    @And("the down payment field reads {string}")
    public void theDownPaymentFieldReads(String dwnPay) {
        CSESD.cseDealPageVerifyDownPaymentAmount(dwnPay);
    }

    @When("a rebate of Active Military is selected")
    public void aRebateOfActiveMilitaryIsSelected() {
        CSESD.cseDealPageActiveRebatesClick();
        CSESD.cseDealPageActiveRebatesSelectMilitary();
    }

    @And("the Active Military rebate is still selected")
    public void theActiveMilitaryRebateIsStillSelected() {
        CSESD.cseDealPageConfirmFinanceModalClose();
        CSESD.cseDealPageActiveRebatesClick();
        CSESD.cseDealPageVerifyActiveRebateMilitarySelected();
    }

    @And("the user returns to My Garage without saving")
    public void theUserReturnsToMyGarageWithoutSaving() {
        CSEH.cseGarageOpenHamburgerMenuNoWait();
        CSEV.cseSaveDealConfirmationModal();
        GenericFunctions.clickLinkByText("No, thanks");
        CSEV.cseSaveDealConfirmationModalGone();
        GenericFunctions.clickLinkByText("My Garage");
    }

    @When("the CSE user refreshes saved deal page")
    public void theCSEUserRefreshesSavedDealPage() {
        CSESD.cseRefreshSavedDealsPage();
    }

    @Then("the CSE user sees the Saved Deals page in My Garage")
    public void theCSEUserSeesTheSavedDealsPageInMyGarage() {
        CSESD.cseSavedDealPageArrived();
    }

    @When("the CSE user returns to deal page")
    public void theCSEUserReturnsToDealPage() {
        CSESD.cseMyGarageViewDealClick();
    }

}
