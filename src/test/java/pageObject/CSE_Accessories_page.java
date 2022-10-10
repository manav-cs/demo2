package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static stepDef.Hook.scenario;

public class CSE_Accessories_page extends GenericFunctions {

    WebDriver driver;

    public CSE_Accessories_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*Page elements*/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Add Accessories']")
    public WebElement cseAccessoriesPageHeader;
    @FindBy(how = How.XPATH, using = "(//article//button)[1]")
    public WebElement cseAccessories1stAccessoryAddButton;
    @FindBy(how = How.XPATH, using = "//div[@class='accessory-row']")
    public WebElement cseAccessories1stAddedAccessory;
    /*Deal page*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'button-block')]//span[text()=' Estimate Payments ']")
    public WebElement cseDealPageEstimatePaymentButton;
    @FindBy(how = How.XPATH, using = "//h5[text()='Estimate Payments*']")
    public WebElement cseDealEstimatePaymentsModalHeader;
    @FindBy(how = How.XPATH, using = "//span[text()='Excellent (740+)']//parent::label")
    public WebElement cseDealEstimatePaymentsExcellentRadioButton;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement cseDealEstimatePaymentsNextButton;
    @FindBy(how = How.XPATH, using = "//p[@class='m-0']")
    public WebElement cseDealPageOkButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement cseDealPageEstimatedPaymentAmount;

    /*Page functions*/

    public void cseGarageAccessoriesDealerPage() {
        /*Retrieve vehicle information from DB*/
        String year = getCurrentYear();
        int thisYear = Integer.parseInt(year);
        int lastYear = Integer.parseInt(year)-1;

        GenericFunctions.dbSql(1,7,"select vi.vin,vi.make,vi.model,vi.year,vi.trim,d.name,d.dealer_id from vehicle_inventory vi LEFT JOIN dealers d on vi.dealer_id=d.id where vi.vin in('5N1BT3AA1NC681831','1N6ED1CL8NN661188','5N1BT3BB7NC680075') order by random() limit 1");
        System.out.println("Vin used for testing: "+ GlobalTestData.SQL_QUERY[0][0]);
        scenario.log("Vin used for testing: "+ GlobalTestData.SQL_QUERY[0][0]);
        /*Go to deal page using dealer id and vin*/
        driver.get("https://nissan-cs.beta.carsaver.com/profile/get-started?dealerId="+GlobalTestData.SQL_QUERY[0][6]+"&vin="+GlobalTestData.SQL_QUERY[0][0]);
        waitForElementToBeVisible(cseDealPageEstimatePaymentButton);
        cseDealPageEstimatePaymentButton.click();
        if(GenericFunctions.isElementPresent(cseDealEstimatePaymentsModalHeader)){
            waitForElementToBeVisible(cseDealEstimatePaymentsExcellentRadioButton);
            cseDealEstimatePaymentsExcellentRadioButton.click();
            hardWait(100);
            cseDealEstimatePaymentsExcellentRadioButton.click();
            hardWait(1000);
            cseDealEstimatePaymentsNextButton.click();
        }
        if(isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
        }
        waitForElementToBeVisible(cseDealPageEstimatedPaymentAmount);
    }

    public void cseAccessoriesPageHeader(){
        waitForElementToBeVisible(cseAccessoriesPageHeader);
    }

    public void cseAccessoriesPageBackToVehicle(){
        GenericFunctions.clickButtonByText("Back To Vehicle");
    }

    public void cseAccessoriesPageApplyToDealButton(){
        GenericFunctions.clickButtonByText("Apply to My Deal");
    }

    public void cseAccessoriesPageAddAccessory() {
        cseAccessories1stAccessoryAddButton.click();
        waitForElementToBeVisible(cseAccessories1stAddedAccessory);
    }

}
