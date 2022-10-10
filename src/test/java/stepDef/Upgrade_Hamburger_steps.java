package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Garage_Hamburger_page;
import pageObject.CSE_Registration_SignIn_page;
import pageObject.Upgrade_Registration_SignIn_page;

public class Upgrade_Hamburger_steps {
    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Garage_Hamburger_page CSEH;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    public Upgrade_Hamburger_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSEH = context.getPageObjectManager().csEcomHamburgerpage();
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
    }
    @And("the Upgrade user clicks the Hamburger icon")
    public void theUpgradeUserClicksTheHamburgerIcon() {
        CSEH.cseGarageOpenHamburgerMenu();
    }
    @When("the Upgrade user clicks the close button in the Hamburger menu")
    public void theUpgradeUserClicksTheCloseButtonInTheHamburgerMenu() {
        CSEH.cseGarageHamburgerMenuClose();
    }
    @When("the Upgrade user clicks the {string} link")
    public void theUpgradeUserClicksTheLinkInTheMyGarageMenu(String link) {
        CSEH.cseMyGarageClickHamburgerLinks(link);
    }
    @Then("the Upgrade user should see the home page")
    public void theUpgradeUserShouldSeeTheHomePage() {
        Upgrade_SignIn.upWelcomeBackHomePageVerify();
    }
    @Then("the Upgrade user sees all the hamburger links")
    public void theUpgradeUserSeesAllTheHamburgerLinks() {
            CSEH.cseGarageHamburgerLinkText("Home");
            CSEH.cseGarageHamburgerLinkText("My Garage");
            Upgrade_SignIn.HamburgerShopNewLinkText("Shop New");
            CSEH.cseGarageHamburgerLinkText("Value Trade");
            CSEH.cseGarageHamburgerLinkText("Sign Out");
    }
}