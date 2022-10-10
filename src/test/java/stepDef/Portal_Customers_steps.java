package stepDef;

import base.GenericFunctions;
import base.GlobalTestData;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Portal_Customers_page;


public class Portal_Customers_steps {
    TestContext testContext;
    Portal_Customers_page PORTAL_CUSTOMERS;

    public Portal_Customers_steps(TestContext context) {
        testContext = context;
        PORTAL_CUSTOMERS = context.getPageObjectManager().getPortal_customers_page();
    }
    @And("the portal admin user clicks on the {string} link")
    public void thePortalAdminUserClicksOnTheCustomersButton(String customersLink) {
        PORTAL_CUSTOMERS.portalCustomersMainNavClick(customersLink);
    }

    @When("the portal admin user clicks on the {string} button")
    public void thePortalAdminUserClicksOnTheButton(String searchButton) {
        PORTAL_CUSTOMERS.portalCustomersSearchButton(searchButton);
    }

    @And("the portal admin user enters the newly created email address into the email search box")
    public void thePortalAdminUserEnterTheNewlyCreatedEmailAddressIntoEmailSearchBox() {
        PORTAL_CUSTOMERS.portalCustomerSearchByEmail(GlobalTestData.ECOM_REGISTRATION_EMAIL);
        GenericFunctions.hardWait(1500);
    }
    @And("the portal admin user enters the newly created customer's full name into the name search box")
    public void thePortalAdminUserEntersTheNewlyCreatedCustomerFullNameIntoNameSearchBox() {
        PORTAL_CUSTOMERS.portalCustomerSearchByFullName(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+" "+GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
        GenericFunctions.hardWait(1500);
    }
    @Then("the portal admin user should be able to verify the newly created customer info")
    public void thePortalAdminUserShouldBeAbleToVerifyNewlyCreatedCustomersInfo() {
        PORTAL_CUSTOMERS.portalCustomerInfoVerify("TRUE");
        PORTAL_CUSTOMERS.portalCustomerInfoVerify(GlobalTestData.ECOM_REGISTRATION_CITY);
        PORTAL_CUSTOMERS.portalCustomerInfoVerify(GlobalTestData.ECOM_REGISTRATION_STATE);
    }
}

