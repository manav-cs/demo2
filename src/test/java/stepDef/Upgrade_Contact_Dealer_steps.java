package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_Contact_Dealer_steps {
    TestContext testContext;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Appointments_page Upgrade_Appointment;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    Upgrade_Contact_Dealer_page Upgrade_ContactDealer;
    Upgrade_Recently_Viewed_page Upgrade_RecentlyViewed;
    CSE_Garage_Saved_Deals_page CSESD;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    public Upgrade_Contact_Dealer_steps(TestContext context) {
        testContext = context;
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        Upgrade_RecentlyViewed = context.getPageObjectManager().getUpgrade_Recently_Viewed_page();
        Upgrade_ContactDealer = context.getPageObjectManager().getUpgrade_Contact_Dealer_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
    }
    @And("the Upgrade user clicks on shop new cars to navigate to the offer details page")
    public void theUpgradeUserClicksOnShopNewCarsToNavigateToOfferDetailsPage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Shop New");
        Upgrade_Appointment.upPopUp1();
        Upgrade_Appointment.upCar1();
        Upgrade_Appointment.upPopUp2();
        Upgrade_Appointment.upOfferDetails();
        Upgrade_SavedDeals.upUserIncomeBirthYearInfo();
        Upgrade_SavedDeals.upOfferCloseBtn();
    }
    @And("the Upgrade user clicks on contact dealer")
    public void theUpgradeUserClicksOnContactDealer() {
        Upgrade_ContactDealer.upContactDealerBtn();
    }
    @When("the Upgrade user selects pricing with a message to contact the dealer")
    public void theUpgradeUserSelectsPricingWithMessageToContactDealer() {
        Upgrade_ContactDealer.upSelectPricing();
        Upgrade_ContactDealer.upClearDealName();
        Upgrade_Appointment.upSendBtn();
    }
    @Then("the Upgrade user receives the certificate and verifies the certificate")
    public void theUpgradeUserReceivesTheCertificateAndVerifiesTheCertificate() {
        Upgrade_ContactDealer.upVerifyCertificateNumber();
        Upgrade_ContactDealer.upViewCertificateBtn();
        Upgrade_ContactDealer.upVerifyCertificate();
    }
    @And("the Upgrade user verifies vehicle is saved in the saved vehicle section")
    public void theUpgradeUserVerifiesVehicleIsSavedInTheSavedVehicleSection() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
        Upgrade_Appointment.upVerifyMyGarage();
        //Upgrade_RecentlyViewed.upVerifySavedDeals();
    }
    @When("the Upgrade user selects vehicle availability with a message to contact the dealer")
    public void theUpgradeUserSelectsVehicleAvailabilityWithAMessageToContactTheDealer() {
        Upgrade_ContactDealer.upSelectVehicleAvailability();
        Upgrade_Appointment.upSendBtn();
    }
    @When("the Upgrade user selects financing with a message to contact the dealer")
    public void theUpgradeUserSelectsFinancingWithAMessageToContactTheDealer() {
        Upgrade_ContactDealer.upSelectFinancing();
        Upgrade_Appointment.upSendBtn();
    }
    @When("the Upgrade user selects my trade-in with a message to contact the dealer")
    public void theUpgradeUserSelectsMyTradeInWithAMessageToContactTheDealer() {
        Upgrade_ContactDealer.upSelectContactDealerTradeIn();
        Upgrade_Appointment.upSendBtn();
    }
    @When("the Upgrade user selects reserving this vehicle with a message to contact the dealer")
    public void theUpgradeUserSelectsReservingThisVehicleWithAMessageToContactTheDealer() {
        Upgrade_ContactDealer.upSelectReservingThisVehicle();
        Upgrade_Appointment.upSendBtn();
    }
    @When("the Upgrade user selects other with a message to contact the dealer")
    public void theUpgradeUserSelectsOtherWithAMessageToContactTheDealer() {
        Upgrade_ContactDealer.upSelectOther();
        Upgrade_Appointment.upSendBtn();
    }
    @When("the Upgrade user clicks on the contact us button")
    public void theUpgradeUserClicksOnTheContactUsButton() {
        Upgrade_ContactDealer.upContactUsBtn();
    }
    @Then("The Upgrade user verifies the contact us number")
    public void theUpgradeUserVerifiesTheContactUsNumber() {
        Upgrade_ContactDealer.upVerifyContactUsNumber();
    }
}