package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_SavedDeals_steps {
    TestContext testContext;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    CSE_Garage_Saved_Deals_page CSESD;
    CSE_Garage_Address_page CSEG;
    CSE_My_Trades_page CSEMT;
    Upgrade_Appointments_page Upgrade_Appointment;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    CSE_Garage_Hamburger_page CSEH;
    CSE_Registration_SignIn_page CSE;

    public Upgrade_SavedDeals_steps(TestContext context) {
        testContext = context;
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
    }
    @When("the Upgrade clicks on the Saved Deals page button")
    public void theUpgradeClicksOnTheSavedDealsButton() {
        Upgrade_SavedDeals.upSavedDealsPageBtn();
    }
    @Then("the Upgrade user doesn't see any vehicle in the Saved Deals")
    public void theUpgradeUserLandsOnTheSavedDealsPage() {
        Upgrade_SavedDeals.upSavedDealsPage();
    }
    @And("the Upgrade user clicks on the Save button")
    public void theUpgradeUserClicksOnTheSaveButton() {
        Upgrade_SavedDeals.upSaveBtn();
    }
    @And("the Upgrade user clicks on my garage to navigate back to the Saved Deals page")
    public void theUpgradeUserClicksOnMyGarageToNavigateBackToSavedDealsPage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        Upgrade_SavedDeals.upSavedDealsPageBtn();
    }
    @And("the Upgrade user verifies the saved vehicle")
    public void theUpgradeUserVerifiesTheSavedVehicle() {
        CSESD.cseMyGarageSavedDealsOptionText();
        Upgrade_SavedDeals.upNewVerify();
        Upgrade_SavedDeals.upVerifyDealNameInSavedDeals();
    }
    @When("the Upgrade user clicks on the View Deal button")
    public void theUpgradeUserClicksOnTheViewDealButton() {
        Upgrade_SavedDeals.upViewDealBtn();
        Upgrade_SavedDeals.upUserIncomeBirthYearInfo();
        Upgrade_SavedDeals.upOfferCloseBtn();
        Upgrade_Appointment.upVerifyDealName();
    }
    @Then("the Upgrade user lands on the Deal page")
    public void theUpgradeUserLandsOnTheDealPage() {
        Upgrade_SavedDeals.upDealPageVehicleInfo();
    }
    @And("the Upgrade user clicks on shop new cars to select a vehicle to save")
    public void theUpgradeUserClicksOnShopNewCarsToSelectsAVehicleToSave() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
    }
    @Then("the Upgrade user confirms to save the vehicle")
    public void theUpgradeUserConfirmsToSaveVehicle() {
        Upgrade_SavedDeals.upClearDealName();
        Upgrade_Appointment.upDealName();
        Upgrade_Appointment.upConfirmBtn();
        Upgrade_SavedDeals.upPopUp3();
    }
    @And("the Upgrade user clicks on shop new cars to select another vehicle to save")
    public void theUpgradeUserClicksOnShopNewCarsToSelectAnotherVehicleToSave() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_SavedDeals.upCar2();
        Upgrade_SavedDeals.upSaveBtn();
        Upgrade_SavedDeals.upClearDealName();
        Upgrade_Appointment.upDealName();
        Upgrade_Appointment.upConfirmBtn();
    }
    @Then("the Upgrade user verifies multiple saved deals")
    public void theUpgradeUserVerifiesMultipleSavedDeals() {
        Upgrade_SavedDeals.upDealPageSaveBtn();
        Upgrade_SavedDeals.upNewVerify();
        Upgrade_SavedDeals.upVerifyDealNameInSavedDeals();
    }
    @And("the Upgrade user changes the mileage per year")
    public void theUpgradeUserChangesTheMileagePerYear() {
        CSESD.cseMyGarageSavedDealsAlterCheckBox();
        CSESD.cseMyGarageSavedDealsAlterDownPayment("1234");
    }
    @And("the Upgrade user clicks on the Save Changes button")
    public void theUpgradeUserClicksOnTheSaveChangesButton() {
        CSESD.cseDealPageClickSave();
        CSESD.cseDealPageDealNameModalConfirm();
    }
    @And("the Upgrade user shop new cars to save and confirm deal")
    public void theUpgradeUserClicksOnTheSaveButtonToConfirmSave() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
        Upgrade_SavedDeals.upSaveBtn();
        Upgrade_SavedDeals.upClearDealName();
        Upgrade_Appointment.upDealName();
        Upgrade_Appointment.upConfirmBtn();
        Upgrade_SavedDeals.upPopUp3();
    }
    @And("the Upgrade user verifies the saved vehicle to clicks on the View Deal button")
    public void theUpgradeUserVerifiesTheSavedVehicleToClicksOnTheViewDealButton() {
        CSESD.cseMyGarageSavedDealsOptionText();
        Upgrade_SavedDeals.upNewVerify();
        Upgrade_SavedDeals.upViewDealBtn();
        Upgrade_SavedDeals.upUserIncomeBirthYearInfo();
        Upgrade_SavedDeals.upOfferCloseBtn();
    }
    @When("the Upgrade user deletes the saved deal")
    public void theUpgradeUserDeletesTheSavedDeal() {
        CSESD.cseMyGarageSavedDealDeleteDeal();
    }
    @Then("the Upgrade user is no longer present with a saved deal")
    public void theUpgradeUserIsNoLongerPresentWithASavedDeal() {
        CSEG.clickGarageNavOption("Saved Deals");
        Upgrade_SavedDeals.upSavedDealsPage();
    }
    @When("the Upgrade user clicks on my garage to navigate to Saved Deal page")
    public void theUpgradeUserClicksOnMyGarageToNavigateToSavedDealPage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        Upgrade_SavedDeals.upViewDealBtn();
        Upgrade_Appointment.upVerifyDealName();
    }
    @When("the Upgrade user updates the desired down payment with the same value")
    public void theUpgradeUserUpdatesTheDesiredDownPaymentWithTheSameValue() {
        CSESD.cseDealerRecalculateDealSameValue();
    }

    @And("the Upgrade user switches to the Lease tab")
    public void theUpgradeUserSwitchesToTheLeaseTab() {
        CSESD.cseDealSwitchToLeaseTab();
    }
    @When("the Upgrade user switches to the Cash tab")
    public void theUpgradeUserSwitchesToTheCashTab() {
        CSESD.cseDealSwitchToCashTab();
    }

    @And("the Upgrade user goes to the deal page for a new car")
    public void theUpgradeUserGoesToTheDealPageForANewCar() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
        Upgrade_Appointment.upOfferDetails();
        CSEMT.cseTradeInVerifyYourInfoIfPresent();
        CSESD.cseDealPageDealsReadyModal();
        Upgrade_SavedDeals.upDealPagePresent();
    }
}