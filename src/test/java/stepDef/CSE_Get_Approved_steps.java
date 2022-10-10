package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Address_page;
import pageObject.CSE_Garage_Appointments_page;
import pageObject.CSE_Get_Approved_page;
import pageObject.CSE_Registration_SignIn_page;

public class CSE_Get_Approved_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Appointments_page CSEA;
    CSE_Garage_Address_page CSEG;
    CSE_Get_Approved_page CSEGA;

    public CSE_Get_Approved_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEA = context.getPageObjectManager().getCsEcomGarageAppointments();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEGA = context.getPageObjectManager().getGetApproved();
    }

    @And("the user clicks the Back to Deal button")
    public void theUserClicksTheBackToDealButton() {
        CSEGA.cseGetApprovedBackToDeal();
    }

    @Then("the Get Approved page is present")
    public void theGetApprovedPageIsPresent() {
        CSEGA.cseGetApprovedPagePresent();
    }

    @And("the Get Approved page is populated correctly")
    public void theGetApprovedPageIsPopulatedCorrectly() {
        CSEGA.cseGetApprovedPagePresent();
        CSEGA.cseGetApprovedPageElements();
    }

    @And("the Get Approved finance page is populated correctly")
    public void theGetApprovedFinancePageIsPopulatedCorrectly() {
        CSEGA.cseGetApprovedPagePresent();
        CSEGA.cseGetApprovedPageFinanceElements();
    }

    @And("the CSE user goes to the deal page to buy a vehicle")
    public void theCSEUserGoesToTheDealPageToBuyAVehicle() {
        CSEA.cseGarageAppointDealerPageBuy();
    }

    @When("the CSE user fills out and submits the Get Started Page")
    public void theCSEUserFillsOutAndSubmitsTheGetStartedPage() {
        CSEGA.cseSubmitGetApprovedInfo();
    }

    @And("the Employment Information is submitted")
    public void theEmploymentInformationIsSubmitted() {
        CSEGA.cseSubmitGetApprovedEmployInfo();
    }

    @And("the Vehicle Information is submitted")
    public void theVehicleInformationIsSubmitted() {
        CSEGA.cseSubmitGetApprovedVehicleInfo();
    }

    @And("the Vehicle Finance Information is submitted")
    public void theVehicleFinanceInformationIsSubmitted() {
        CSEGA.cseSubmitGetApprovedFinanceVehicleInfo();
    }

    @And("the Account Setup page appears")
    public void theAccountSetupPageAppears() {
        CSEGA.cseSubmitGetApprovedAccountSetUp();
    }

    @When("a positive loan decision is made")
    public void aPositiveLoanDecisionIsMade() {
        CSEGA.cseSubmitGetApprovedGoodDecision();
    }

    @Then("the CSE user is on the Lease Options page")
    public void theCSEUserIsOnTheLeaseOptionsPage() {
        CSEGA.cseGetApprovedLeadeOptionsPage();
        CSEGA.waitForLeaseOptionsPage();
    }

    @Then("the CSE user is on the Finance Options page")
    public void theCSEUserIsOnTheFinanceOptionsPage() {
        CSEGA.cseGetApprovedLeadeOptionsPage();
        CSEGA.waitForFinanceOptionsPage();
    }

    @When("the CSE user submits the Lease Options")
    public void theCSEUserSubmitsTheLeaseOptions() {
        CSEGA.cseGetApprovedLeaseOptionsSubmit();
    }

    @When("the CSE user submits the Financing Options")
    public void theCSEUserSubmitsTheFinancingOptions() {
        CSEGA.cseGetApprovedLeaseOptionsSubmit();
    }

    @And("the CSE user submits the Sign & Drive page")
    public void theCSEUserSubmitsTheSignDrivePage() {
        CSEGA.cseGetApprovedLeaseOptionsSignDrive();
    }

    @Then("the CSE user is on the Order Confirmation page")
    public void theCSEUserIsOnTheOrderConfirmationPage() {
        CSEGA.cseGetApprovedConfirmationPage();
    }

    @Then("the leased vehicle is present under Saved Deals")
    public void theLeasedVehicleIsPresentUnderSavedDeals() {
        CSEGA.cseSavedDealsLeasedVehicle();
    }

    @Then("the financed vehicle is present under Saved Deals")
    public void theFinancedVehicleIsPresentUnderSavedDeals() {
        CSEGA.cseSavedDealsLeasedVehicle();
    }
}
