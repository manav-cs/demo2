package stepDef;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.CarSaverSearch_page;

public class CarSaverSearch_steps {

    TestContext testContext;
    CarSaverSearch_page SEARCH;

    public CarSaverSearch_steps(TestContext context) {
        testContext = context;
        SEARCH = context.getPageObjectManager().getSearchPage();
    }


    @Given("User is able to click on search button")
    public void searchWithoutSelectingAnything() {
        SEARCH.clickOnSearchButton();
    }


}
