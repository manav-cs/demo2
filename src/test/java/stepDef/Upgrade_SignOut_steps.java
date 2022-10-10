package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObject.CSE_Registration_SignIn_page;
import pageObject.Upgrade_Appointments_page;
import pageObject.Upgrade_Registration_SignIn_page;

public class Upgrade_SignOut_steps {
    TestContext testContext;
    Upgrade_Registration_SignIn_page Upgrade_SignIn;
    Upgrade_Appointments_page Upgrade_Appointment;
    public Upgrade_SignOut_steps(TestContext context) {
        testContext = context;
        Upgrade_SignIn = context.getPageObjectManager().getUpgrade_page();
        Upgrade_Appointment = context.getPageObjectManager().getUpgrade_Appointments_page();
    }
    @When("the Upgrade user clicks on the {string} link from the left nav")
    public void theUpgradeUserClicksOnTheLinkFromTheLeftNav(String garageSignOut) {
        Upgrade_SignIn.clickupSignOutGrage(garageSignOut);
    }
}