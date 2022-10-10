package stepDef;

import base.GenericFunctions;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CSE_Deal_Contact_Dealer_page;
import pageObject.CSE_Registration_SignIn_page;

public class CSE_Deal_Contact_dealer_steps {


    TestContext testContext;
    CSE_Registration_SignIn_page CSE;
    CSE_Deal_Contact_Dealer_page CSECD;

    public CSE_Deal_Contact_dealer_steps(TestContext context) {
        testContext = context;
        CSE = context.getPageObjectManager().getCsEcommercePage();
        CSECD = context.getPageObjectManager().getCsEcomContactDealer_page();
    }


    @When("the CSE user clicks on the {string} deal button")
    public void theCSEUserClicksOnTheDealButton(String buttonName) {
        CSECD.cseDealPageActiveTabButtonClick(buttonName);
    }

    @Then("the sign-in modal appears")
    public void theSignInModalAppears() {
        CSECD.cseDealPageSignInModalPresent();
    }

    @When("the CSE user closes the sign-in modal")
    public void theCSEUserClosesTheSignInModal() {
        CSECD.cseDealPageSignInModalClose();
    }

    @Then("the CSE user is on the Contact Dealer page")
    public void theCSEUserIsOnTheContactDealerPage() {
        CSECD.cseContactDealerPage();
    }

    @And("the vehicle information is present")
    public void theVehicleInformationIsPresent() {
        CSECD.cseContactDealerPageVehicleInfo();
    }

    @And("the dealer name is present")
    public void theDealerNameIsPresent() {
        CSECD.cseContactDealerDealerName();
    }

    @When("the CSE user selects option {string} from the Contact Dealer drop down")
    public void theCseUserMakesASelectionFromTheContactDealerDropDown(String menu) {
        CSECD.cseContactDealerDropDownFunctionality(menu);
    }

    @Then("the Vehicle Availability Text Area contains the default text")
    public void theVehicleAvailabilityTextAreaContainsTheDefaultText() {
        CSECD.cseContactDealerTextAreaDefaultVehicleAvailability();
    }

    @When("the CSE user adds additional text to the text field")
    public void theCSEUserAddsAdditionalTextToTheTextField() {
        CSECD.cseContactDealerTextAreaAddText(" Contact Dealer Automation Text.");
    }

    @And("the CSE user clicks the Send button")
    public void theCSEUserClicksTheSendButton() {
        GenericFunctions.clickButtonByText("Send");
    }

    @And("the text area is disabled")
    public void theTextAreaIsDisabled() {
        CSECD.cseContacDealerTextAreaDisabled();
    }

    @When("the CSE user select \"([^\"]*)\"$ from the Contact Dealer drop down")
    public void theCSEUserSelectMenuOptionFromTheContactDealerDropDown(String menu) {
        CSECD.cseContactDealerDropDownFunctionality(menu);
    }

    @Then("the Text Area contains the default text \"([^\"]*)\"$")
    public void theTextAreaContainsTheDefaultText(String defaultText) {
        CSECD.cseContactDealerTextAreaDefault(defaultText);
    }

    @Then("the CSE user is on the contact dealer confirmation page")
    public void theCSEUserIsOnTheContactDealerConfirmationPage() {
        CSECD.cseContactDealerConfirmationPage();
    }

    @When("the CSE user clicks View Certificate")
    public void theCSEUserClicksViewCertificate() {
        GenericFunctions.clickButtonByText("View Certificate");
    }

    @Then("the contact dealer certificate page is present")
    public void theContactDealerCertificatePageIsPresent() {
        CSECD.cseContactDealerConfirmationViewCertificate();
    }

    @And("the CSE user sees the saved deal")
    public void theCSEUserSeesTheSavedDeal() {
        CSECD.cseContactDealerSavedDealAfterContact();
    }

    @And("the vehicle and dealer information is retrieved")
    public void theVehicleAndDealerInformationIsRetrieved() {
        CSECD.cseDealPageRetrieveDealerAndVehicleInfo();
    }

    @When("the CSE user selects {string} from the Contact Dealer drop down")
    public void theCSEUserSelectsFromTheContactDealerDropDown(String menu) {
        CSECD.cseContactDealerDropDownFunctionality(menu);
    }
}
