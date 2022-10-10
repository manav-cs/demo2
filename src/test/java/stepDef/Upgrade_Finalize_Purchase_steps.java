package stepDef;

import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.*;

public class Upgrade_Finalize_Purchase_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    CSE_Garage_Saved_Deals_page CSESD;
    Upgrade_Finalize_Purchase_page Upgrade_Finance;
    CSE_Get_Approved_page CSEGA;

    public Upgrade_Finalize_Purchase_steps (TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        Upgrade_Finance = context.getPageObjectManager().getUpgrade_Finalize_Purchase_page();
        CSEGA = context.getPageObjectManager().getGetApproved();
    }
    @And("the Upgrade user clicks on the Apply For Credit button")
    public void theUpgradeUserClicksOnTheApplyForCreditButton() {
        Upgrade_Finance.upApplyForCreditBtn();
        Upgrade_Finance.upApplyForCreditBtn2();
    }
    @And("the Upgrade user Vehicle Information is submitted")
    public void theUpgradeUserVehicleInformationIsSubmitted() {
        Upgrade_Finance.upSubmitGetApprovedVehicleInfo();
    }
    @When("the Upgrade user fills out and submits the Get Started Page")
    public void theUpgradeUserFillsOutAndSubmitsTheGetStartedPage() {
        CSEGA.cseSubmitGetApprovedInfo();
    }
    @Then("the Upgrade user submits the Lease Options")
    public void theUpgradeUserSubmitsTheLeaseOptions() {
        CSEGA.cseGetApprovedLeaseOptionsSubmit();
    }
    @And("the Upgrade user submits the Sign & Drive page")
    public void theUpgradeUserSubmitsTheSignDrivePage() {
        CSEGA.cseGetApprovedLeaseOptionsSignDrive();
    }
    @And("the Upgrade user clicks the Back to Deal button")
    public void theUpgradeUserClicksTheBackToDealButton() {
        CSEGA.cseGetApprovedBackToDeal();
    }
}
