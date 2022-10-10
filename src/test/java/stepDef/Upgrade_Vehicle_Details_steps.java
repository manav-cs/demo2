package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;
import static base.GenericFunctions.hardWait;

public class Upgrade_Vehicle_Details_steps {
    TestContext testContext;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Appointments_page Upgrade_Appointment;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    Upgrade_Contact_Dealer_page Upgrade_ContactDealer;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Saved_Deals_page CSESD;
    Upgrade_Vehicle_Details_page Upgrade_VehicleDetails;
    Upgrade_Finalize_Purchase_page Upgrade_Finance;
    CSE_Garage_Hamburger_page CSEH;

    public Upgrade_Vehicle_Details_steps(TestContext context) {
        testContext = context;
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        Upgrade_ContactDealer = context.getPageObjectManager().getUpgrade_Contact_Dealer_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        Upgrade_VehicleDetails = context.getPageObjectManager().getUpgrade_Vehicle_Details_page();
        Upgrade_Finance = context.getPageObjectManager().getUpgrade_Finalize_Purchase_page();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
    }
    @When("the Upgrade user clicks on shop new cars to navigate to the vehicle details page")
    public void theUpgradeUserClicksOnShopNewCarsToNavigateToTheVehicleDetailsPage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
    }
    @Then("the vehicle details page is present")
    public void theVehicleDetailsPageIsPresent() {
        Upgrade_VehicleDetails.upVehicleDetailsPagePresent();
    }
    @And("the Upgrade user clicks on the next button to apply for credit")
    public void theUpgradeUserClicksOnTheNextButtonToApplyForCredit() {
        Upgrade_VehicleDetails.upVehicleDetailsNextBtn();
        Upgrade_Finance.upApplyForCreditBtn2();
    }
    @And("the Upgrade user clicks on all specs & features")
    public void theUpgradeUserClicksOnEditDealButtonToNameTheDeal() {
        Upgrade_VehicleDetails.upSpecsFeatures();
    }
    @And("the Upgrade user clicks on the new search button")
    public void theUpgradeUserClicksOnNewSearchButton() {
        Upgrade_VehicleDetails.upNewSearchBtn();
    }
    @When("the Upgrade user selects a new vehicle to view details")
    public void theUpgradeUserSelectsANewVehicleToViewDetails() {
        Upgrade_VehicleDetails.upCar2();
    }
    @And("the Upgrade user clicks on you may also like")
    public void theUpgradeUserClicksOnYouMayAlsoLike() {
        Upgrade_VehicleDetails.upYouMayLikeBtn();
    }
    @When("the Upgrade user selects another vehicle under you may also like")
    public void theUpgradeUserSelectsAnotherVehicleUnderYouMayLike() {
        Upgrade_VehicleDetails.upCar1VehicleDetailPage();
    }
}