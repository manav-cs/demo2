package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class Upgrade_Down_Payment_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_SavedDeals_page Upgrade_SavedDeals;
    CSE_Garage_Saved_Deals_page CSESD;
    public Upgrade_Down_Payment_steps (TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SavedDeals = context.getPageObjectManager().getUpgrade_SavedDeals_page();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
    }
    @And("the Upgrade user notes the current finance information")
    public void theUpgradeUserNotesTheCurrentFinanceInformation() {
        CSESD.cseDealFinanceInformationSave();
        CSESD.cseStorePreSavedDealInfo();
    }
    @And("the Upgrade user changes the down payment for finance to {string}")
    public void theUpgradeUserChangesTheDownPaymentForFinanceTo(String amount) {
        CSESD.cseMyGarageSavedDealsAlterDownPayment(amount);
    }
    @Then("the Upgrade user verifies the finance information has updated")
    public void theUpgradeUserVerifiesTheFinanceInformationHasUpdated() {
        CSESD.cseVerifyUpdatedDownPaymentInfo();
    }
    @When("the Upgrade user clicks save and confirms the save")
    public void theUpgradeUserClicksSaveAndConfirmsTheSave() {
        CSESD.cseDealPageClickSave();
        CSESD.cseDealPageDealNameModalConfirm();
    }
    @And("the Upgrade user clicks the View Deal button")
    public void theUpgradeUserClicksTheViewDealButton() {
        CSESD.cseMyGarageSavedDealsViewDealClick();
    }
    @And("the Upgrade user refreshes the page")
    public void theUpgradeUserRefreshesThePage() {
        CSESD.cseRefreshDealPage();
    }
    @And("the Upgrade user notes the current lease information")
    public void theUpgradeUserNotesTheCurrentLeaseInformation() {
        CSESD.cseDealFinanceInformationSave();
        CSESD.cseStorePreSavedDealInfo();
    }
    @Then("the Upgrade user verifies the lease information has updated")
    public void theUpgradeUserVerifiesTheLeaseInformationHasUpdated() {
        CSESD.cseVerifyUpdatedDownPaymentInfo();
    }
    @And("the Upgrade user changes the down payment for lease to {string}")
    public void theUpgradeUserChangesTheDownPaymentForLeaseTo(String FixedAmount) {
        CSESD.cseMyGarageSavedDealsAlterDownPayment(FixedAmount);
    }
    @And("the Upgrade user goes to My Garage")
    public void theUpgradeUserGoesToMyGarage() {
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("Home");
        CSEH.cseGarageOpenHamburgerMenu();
        CSE.cseClickMyGarageHamburgerLinks("My Garage");
    }
}
