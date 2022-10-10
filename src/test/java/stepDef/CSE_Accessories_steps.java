package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Accessories_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Appointments_page CSEA;
    CSE_Garage_Address_page CSEG;
    CSE_Garage_Hamburger_page CSEH;
    CSE_Garage_Saved_Deals_page CSESD;
    CSE_My_Trades_page CSEMT;
    CSE_Accessories_page CSEAsc;

    public CSE_Accessories_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEA = context.getPageObjectManager().getCsEcomGarageAppointments();
        CSEG = context.getPageObjectManager().getCsEcomGarage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        CSEMT = context.getPageObjectManager().getCsEcomMyTrades();
        CSESD = context.getPageObjectManager().getCseSavedDealsPage();
        CSEAsc = context.getPageObjectManager().getCSE_accessories_page();
    }

    @And("the CSE user clicks Back to Vehicle")
    public void theCSEUserClicksBackToVehicle() {
        CSEAsc.cseAccessoriesPageBackToVehicle();
    }

    @And("the CSE user adds an accessory")
    public void theCSEUserAddsAnAccessory() {
        CSESD.cseClickAddAccessoriesLinkUnderBuyHome();
        CSEAsc.cseAccessoriesPageHeader();
        CSEAsc.cseAccessoriesPageAddAccessory();
        CSEAsc.cseAccessoriesPageApplyToDealButton();
    }

    @When("the CSE user pulls up an accessories vehicle page")
    public void theCSEUserPullsUpAnAccessoriesVehiclePage() {
        CSEAsc.cseGarageAccessoriesDealerPage();
    }

    @And("the CSE user creates a new account to save the deal")
    public void theCSEUserCreatesANewAccountToSaveTheDeal() {
        CSESD.cseDealPageClickSave();
        CSEA.cseGarageAppointCreateAccountButton();
        CSE.cseRegiFormEnterFirstName();
        CSE.cseRegiFormEnterLastName();
        CSE.cseRegiFormEnterEmail();
        CSE.cseEnterPrimaryPhoneNumber();
        CSE.cseRegiFormPassword();
        CSE.cseRegiFormConfirmPassword();
        CSE.cseClickNextButton();
        CSE.cseRegiFormAddress();
        CSE.cseRegiFormCity();
        CSE.cseRegiFormState();
        CSE.cseRegiFormZipcodeNonSso();
        CSE.cseClickNextButtonFromEnterYourHomeAddress();
        CSEMT.cseChooseTradeOptionNoTrade();
        CSEMT.cseTradeInVerifyYourInfoIfPresent();
        CSESD.cseDealPageDealsReadyModal();
        CSESD.cseDealPageVehicleInfo();
    }
}
