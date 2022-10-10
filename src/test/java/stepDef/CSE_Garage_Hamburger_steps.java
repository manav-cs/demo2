package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class CSE_Garage_Hamburger_steps {

    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    public CSE_Garage_Hamburger_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
    }

    @And("the CSE user clicks the Hamburger icon")
    public void theCSEUserClicksTheHamburgerIcon() {
        CSEH.cseGarageOpenHamburgerMenu();
    }

    @Then("the {string} link is present in the hamburger menu")
    public void theLinkIsPresentInHamburgerMenu(String link) {
        CSEH.cseGarageHamburgerLinkText(link);
    }

    @When("the CSE user clicks the close button in the Hamburger menu")
    public void theUserClicksTheCloseButtonInTheHamburgerMenu() {
        CSEH.cseGarageHamburgerMenuClose();
    }

    @Then("the hamburger menu closes")
    public void theHamburgerMenuCloses() {
        CSEH.cseGarageHamburgerMenuIsClosed();
    }

    @When("the CSE user clicks the {string} link in the My Garage menu")
    public void theUserClicksTheLinkInTheMyGarageMenu(String link) {
        CSEH.cseMyGarageClickHamburgerLinks(link);
    }

    @Then("the CSE user sees all the hamburger links")
    public void theUserSeesAllTheHamburgerLinks() {
        CSEH.cseGarageHamburgerLinkText("Home");
        CSEH.cseGarageHamburgerLinkText("My Garage");
        CSEH.cseGarageHamburgerLinkText("Value Trade");
        //CSEH.cseGarageHamburgerLinkText("Insure");
        CSEH.cseGarageHamburgerLinkText("Sign Out");
    }

    @Then("the CSE user should see the Insure page")
    public void theCSEUserShouldSeeTheInsurePage() {
        CSEH.cseGarageHamburgerInsurePageHeader();
    }
}
