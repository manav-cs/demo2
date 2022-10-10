package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CSE_Recently_Viewed_page extends GenericFunctions {

    Faker faker = new Faker();
    WebDriver driver;
    Actions actions;

    public CSE_Recently_Viewed_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }

    /*All the locators goes here*/
    @FindBy(how = How.XPATH, using = "//div[@class='header']")
    public WebElement cseSaveDealConfHeader;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='No, thanks']")
    public WebElement cseSaveDealConfirmNoThanks;
    @FindBy(how = How.XPATH, using = "//a[text()='Recently Viewed Vehicles']")
    public WebElement cseRecentViewedVehiclesSectionActive;
    @FindBy(how = How.XPATH, using = "(//button[@title='remove'])[1]")
    public WebElement cseRecentViewedVehiclesRemoveButton1;
    @FindBy(how = How.XPATH, using = "(//button[@title='remove'])[2]")
    public WebElement cseRecentViewedVehiclesRemoveButton2;
    @FindBy(how = How.XPATH, using = "//div[text()=' No Recent Vehicles Found! ']")
    public WebElement cseRecentViewedVehicleNoRecentText;
    @FindBy(how = How.XPATH, using = "//small[text()=' Check back in after you do some browsing. ']")
    public WebElement cseRecentViewedVehicleCheckBackText;
    @FindBy(how = How.XPATH, using = "//div[@class='menu-btn d-flex']")
    public WebElement cseHamburgerMenuIcon;
    @FindBy(how = How.XPATH, using = "//div[@class='menu-popover']")
    public WebElement cseHamburgerMenuPresent;
    /*Vehicle 1 info*/
    @FindBy(how = How.XPATH, using = "(//strong[@class='vehicle-name'])[1]")
    public WebElement cseRecentViewedVehicleMakeModel1;
    @FindBy(how = How.XPATH, using = "(//strong[contains(@class,'sale-price')])[1]")
    public WebElement cseRecentViewedVehicleSalePrice1;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'stock-type')])[1]")
    public WebElement cseRecentViewedVehicleStockType1;
    @FindBy(how = How.XPATH, using = "(//span[text()='Mileage:']//following-sibling::span)[1]")
    public WebElement cseRecentViewedVehicleMileage1;
    @FindBy(how = How.XPATH, using = "(//span[text()='Exterior Color:']//following-sibling::span)[1]")
    public WebElement cseRecentViewedVehicleColor1;
    @FindBy(how = How.XPATH, using = "(//span[text()='Dealer:']//following-sibling::span)[1]")
    public WebElement cseRecentViewedDealer1;

    /*Vehicle 2 info*/
    @FindBy(how = How.XPATH, using = "(//strong[@class='vehicle-name'])[2]")
    public WebElement cseRecentViewedVehicleMakeModel2;
    @FindBy(how = How.XPATH, using = "(//strong[contains(@class,'sale-price')])[2]")
    public WebElement cseRecentViewedVehicleSalePrice2;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'stock-type')])[2]")
    public WebElement cseRecentViewedVehicleStockType2;
    @FindBy(how = How.XPATH, using = "(//span[text()='Mileage:']//following-sibling::span)[2]")
    public WebElement cseRecentViewedVehicleMileage2;
    @FindBy(how = How.XPATH, using = "(//span[text()='Exterior Color:']//following-sibling::span)[2]")
    public WebElement cseRecentViewedVehicleColor2;
    @FindBy(how = How.XPATH, using = "(//span[text()='Dealer:']//following-sibling::span)[2]")
    public WebElement cseRecentViewedDealer2;

    /*Saved Vehicle info*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'truncate')]//strong")
    public WebElement cseMyGarageSavedDealsCarInformation;
    @FindBy(how = How.XPATH, using = "//span[@class='sale-price']")
    public WebElement cseMyGarageSavedDealsSalePrice;
    @FindBy(how = How.XPATH, using = "//div[@class='dealer-name']")
    public WebElement cseMyGarageDealerName;


    /* All functions go here */
    public void cseSaveDealConfirmationModal(){
        waitForElementToBeVisible(cseSaveDealConfHeader);
        Assert.assertEquals(cseSaveDealConfHeader.getText().trim(),"Would you like to save this deal?","The header for the Save Deal confirmation modal is incorrect: ");
    }

    public void cseSaveDealConfirmationNoThanks() {
        cseSaveDealConfirmNoThanks.click();
    }

    public void cseSaveDealConfirmationModalGone(){
        waitForElementToBeInVisible(cseSaveDealConfHeader);
    }

    public void cseVerifyRecentlyViewedVehiclesSection() {
        cseRecentViewedVehiclesSectionActive.click();
        Assert.assertEquals(cseRecentViewedVehiclesSectionActive.getAttribute("class"),"nav-link active","The Recently Viewed Vehicles section is not visible: ");
    }

    public void cseRemove1stVehicleFromRecentlyViewed() {
        cseRecentViewedVehiclesRemoveButton1.click();
    }

    public void cseFirstRecentlyViewedVehicleGone() {
        waitForElementToBeInVisible(cseRecentViewedVehicleMakeModel1);
    }

    public void cseRecentlyViewedNoVehicles() {
        GenericFunctions.isElementPresent(cseRecentViewedVehicleNoRecentText);
        GenericFunctions.isElementPresent(cseRecentViewedVehicleCheckBackText);
    }

    //vi.vin,vi.make,vi.model,vi.year,vi.trim,d.name,d.dealer_id from vehicle_inventory
    public void cseRecentlyViewedVehicle1() {
        GlobalTestData.OLD_VEHICLE_INFO = GlobalTestData.SQL_QUERY; //For use when adding a second vehicle
        Assert.assertTrue(cseRecentViewedVehicleMakeModel1.getText().contains(GlobalTestData.OLD_VEHICLE_INFO[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]),"The year and make of the first vehicle is incorrect on the recently viewed vehicles page. Expected "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+": ");
        // until NE-689 fixed Assert.assertEquals(cseRecentViewedVehicleSalePrice1.getText().trim(),GlobalTestData.CSE_BUY_HOME_PRICE_1,"The Sale Price on the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleStockType1.getText().trim().toLowerCase(),GlobalTestData.CSE_STOCK_TYPE_1.toLowerCase(),"The Stock Type for the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleColor1.getText().trim(), GlobalTestData.CSE_DEAL_PAGE_VEHICLE_COLOR_1,"The exterior color of the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedDealer1.getText().trim(),GlobalTestData.OLD_VEHICLE_INFO[0][5],"The dealer name is incorrect on the first recently viewed vehicle: ");
    }

    public void cseRecentlyViewedVehicle2() {
        /*Newest viewed vehicle in slot 1 on page*/
        Assert.assertTrue(cseRecentViewedVehicleMakeModel1.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]),"The year and make of the first vehicle is incorrect on the recently viewed vehicles page. Expected "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+": ");
        // until NE-689 fixed Assert.assertEquals(cseRecentViewedVehicleSalePrice1.getText().trim(),GlobalTestData.CSE_BUY_HOME_PRICE_2,"The Sale Price on the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleStockType1.getText().trim(),GlobalTestData.CSE_STOCK_TYPE_2.toUpperCase(),"The Stock Type for the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleColor1.getText().trim(), GlobalTestData.CSE_DEAL_PAGE_VEHICLE_COLOR_2,"The exterior color of the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedDealer1.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"The dealer name is incorrect on the first recently viewed vehicle: ");
    }

    public void cseRecentlyViewedVehicleRemainingVehicle(){
        Assert.assertTrue(cseRecentViewedVehicleMakeModel1.getText().contains(GlobalTestData.OLD_VEHICLE_INFO[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]),"The year and make of the first vehicle is incorrect on the recently viewed vehicles page. Expected "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+": ");
        // until NE-689 fixed Assert.assertEquals(cseRecentViewedVehicleSalePrice1.getText().trim(),GlobalTestData.CSE_BUY_HOME_PRICE_1,"The Sale Price on the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleStockType1.getText().trim(),GlobalTestData.CSE_STOCK_TYPE_1.toUpperCase(),"The Stock Type for the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedVehicleColor1.getText().trim(), GlobalTestData.CSE_DEAL_PAGE_VEHICLE_COLOR_1,"The exterior color of the first recently viewed vehicle is incorrect: ");
        Assert.assertEquals(cseRecentViewedDealer1.getText().trim(),GlobalTestData.OLD_VEHICLE_INFO[0][5],"The dealer name is incorrect on the first recently viewed vehicle: ");
    }

    public void cseRecentlyViewedVehicleNoSecondVehicle(){
        Assert.assertFalse(GenericFunctions.isElementPresent(cseRecentViewedVehicleMakeModel2),"A second vehicle is present on the recently viewed vehicles page when there should only be one vehicle: ");
    }

    public void cseHamburgerIconNoWait(){
        cseHamburgerMenuIcon.click();
    }

    public void cseMyGarageSavedDealsPreviouslyViewedVehicle() {
        Assert.assertTrue(cseMyGarageSavedDealsCarInformation.getText().contains(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.OLD_VEHICLE_INFO[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]),"Vehicle information is incorrect. Expected "+GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.OLD_VEHICLE_INFO[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]+": ");
        // until NE-689 fixed Assert.assertTrue(cseMyGarageSavedDealsSalePrice.getText().contains(GlobalTestData.CSE_BUY_HOME_PRICE_1),"The vehicle sale price is incorrect on the Garage Saved Deals page. Expected "+GlobalTestData.CSE_BUY_HOME_PRICE_1+": ");
        Assert.assertEquals(cseMyGarageDealerName.getText().trim(),GlobalTestData.OLD_VEHICLE_INFO[0][5],"The dealer name is incorrect on the Garage Saved Deals page: ");
    }


}
