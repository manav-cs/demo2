package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

import static stepDef.Hook.scenario;

public class CSE_My_Trades_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public CSE_My_Trades_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* Page Locators */
    @FindBy(how = How.XPATH, using = "//span[text()='Add Trade']")
    public WebElement cseChooseTradeAddATradeButton;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Add Trade']")
    public WebElement cseMyGarageMyTradeButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'Complete Trade')]")
    public WebElement cseMyGarageTradeCompleteOffer;
    /*Vin page*/
    @FindBy(how = How.XPATH, using = "//h1[text()='Enter Your Vin']")
    public WebElement cseEnterVinHeader;
    @FindBy(how = How.ID, using = "vin")
    public WebElement cseEnterVinField;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement cseSubmitButton;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Verify Vehicle Information']")
    public WebElement cseVerifyVehicleInfoHeader;
    @FindBy(how = How.ID, using = "trim")
    public WebElement cseVerifyVehicleInfoTrimDropDown;
    @FindBy(how = How.ID, using = "transmission")
    public WebElement cseVerifyVehicleInfoTransDropDown;
    @FindBy(how = How.ID, using = "color")
    public WebElement cseVerifyVehicleInfoColorDropDown;
    @FindBy(how = How.ID, using = "mileage")
    public WebElement cseVerifyVehicleInfoMileageField;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Select Features']")
    public WebElement cseConfirmVehicleSelectFeaturesHeader;
    /**Vehicle Condition buttons**/
    @FindBy(how = How.XPATH, using = "//div[@title='Physical Condition']//span[text()='Excellent']")
    public WebElement cseVehicleConditionExcellent;
    @FindBy(how = How.XPATH, using = "//div[@title='Does your vehicle use key fobs? If so, how many do you have?']//span[text()='2+']")
    public WebElement cseVehicleFobs2;
    @FindBy(how = How.XPATH, using = "//div[@title='Are there any instrument warning lights on? (Check Engine, Service Soon, etc.)']//span[text()='No']")
    public WebElement cseWarnings;
    @FindBy(how = How.XPATH, using = "//div[@title='Does your vehicle need heat or A/C work?']//span[text()='No']")
    public WebElement cseHeatAcWork;
    @FindBy(how = How.XPATH, using = "//div[@title='Does your vehicle have an oil leak?']//span[text()='No']")
    public WebElement cseOilLeak;
    @FindBy(how = How.XPATH, using = "//div[@title='Are there dents, dings or hail damage on the vehicle? Rate the damage']//span[text()='None']")
    public WebElement cseDentsDamage;
    @FindBy(how = How.XPATH, using = "//div[@title='Are there any scratches, chips or dull paint on the vehicle? Rate the damage']//span[text()='None']")
    public WebElement cseScratchPaint;
    @FindBy(how = How.XPATH, using = "//div[@title='Does any tire have uneven wear?']//span[text()='No']")
    public WebElement cseTireWear;
    @FindBy(how = How.XPATH, using = "//div[@title='Are there any burns, stains, or tears in the seats? Rate the damage']//span[text()='None']")
    public WebElement cseSeats;
    @FindBy(how = How.XPATH, using = "//div[@title='Has the vehicle ever had frame damage?']//span[text()='No']")
    public WebElement cseFrameDamage;
    /**Verify User Information during trade in vehicle**/
    @FindBy(how = How.XPATH, using = "//h1[text()=' Verify Your Information']")
    public WebElement cseVerifyYourInformationHeader;
    @FindBy(how = How.ID, using = "monthly-income")
    public WebElement cseVerifyYourInformationMonthIncome;
    @FindBy(how = How.ID, using = "yearOfBirth")
    public WebElement cseVerifyYourInformationBirthYear;
    /**Trade In current payment page**/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Verify Current Payment']")
    public WebElement cseVerifyCurrentPaymentHeader;
    @FindBy(how = How.XPATH, using = "//span[@class='vin']")
    public WebElement cseVerifyCurrentPaymentCarVin;
    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    public WebElement cseVerifyCurrentPaymentCarInfo;
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='$335']")
    public WebElement cseVerifyCurrentPayment335button;
    @FindBy(how = How.ID, using = "lenderSelect")
    public WebElement cseVerifyCurrentPaymentFinanceCo;
    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'suggestions')]")
    public WebElement cseVerifyCurrentPaymentFinanceCoSuggestList;
    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'suggestions')]//span[text()='TEST-NMAC-13672/N/A']")
    public WebElement cseVerifyCurrentPaymentFinanceCoSuggestListOption;
    /**Additional Information needed**/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Additional Information Needed']")
    public WebElement cseVerifyCurrentPaymentAdditionalInfoNeededHeader;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Continue with estimated payoff*']")
    public WebElement cseVerifyCurrentPaymentAdditionalInfoNeededContinueButton;
    /**Trade-offer details**/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Your Trade-Offer Details']")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHeader;
    @FindBy(how = How.XPATH, using = "//span[@class='ymm']")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferCarInfo;
    @FindBy(how = How.XPATH, using = "//td[@data-label='Offer']//span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPrice;
    @FindBy(how = How.XPATH, using = "//td[@data-label='Expires']//span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferExpire;
    @FindBy(how = How.XPATH, using = "//td[contains(@data-label,'Where')]//span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferType;
    @FindBy(how = How.XPATH, using = "//td[@data-label='Where can I get this offer?']//span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferWhere;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Trim:']//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicTrim;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Exterior Color:']//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicColor;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Mileage:']//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicMiles;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='VIN:']//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicVin;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Condition:']//following-sibling::div//span[1]")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicCondition;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Transmission:']//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferBasicTrans;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'fobs?')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryFob;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'instrument')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryInstrWarn;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'heat or')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryHeatAc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'oil')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryOilLeak;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'dents')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryDents;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'chips')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryChips;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'tire')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryTires;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'burns')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryBurns;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'frame')]//following-sibling::span")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferHistoryFrame;
    @FindBy(how = How.XPATH, using = "//div[text()='Finance Type:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffFianceType;
    @FindBy(how = How.XPATH, using = "//div[text()='Payment Amount:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffPayAmount;
    @FindBy(how = How.XPATH, using = "//div[text()='Payments Remaining:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffPayRemain;
    @FindBy(how = How.XPATH, using = "//div[text()='Payoff Good Through:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffPayGoodThru;
    @FindBy(how = How.XPATH, using = "//div[text()='Payoff Amount:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffPayOffAmount;
    @FindBy(how = How.XPATH, using = "//div[text()='Payoff Method:']//following-sibling::div")
    public WebElement cseVerifyCurrentPaymentYourTradeOfferPayOffPayOffMethod;
    /**My Garage vehicle offers**/
    @FindBy(how = How.XPATH, using = "//div[contains(@id,'collapse-user-vehicle')]")
    public WebElement cseMyGarageMyTradeViewOfferSection;
    @FindBy(how = How.XPATH, using = "//td[@data-label='Offer']//span")
    public WebElement cseMyGarageMyTradeViewOfferPrice;
    @FindBy(how = How.XPATH, using = "//td[@data-label='Expires']//span")
    public WebElement cseMyGarageMyTradeViewOfferExpires;
    @FindBy(how = How.XPATH, using = "//td[contains(@data-label,'Where can')]//span")
    public WebElement cseMyGarageMyTradeViewOfferWhere;
    /*Chose Trade Option page*/
    @FindBy(how = How.XPATH, using = "//h1[contains(normalize-space(),'Choose Trade Option')]")
    public WebElement cseMyGarageHeader;
    @FindBy(how = How.XPATH, using = "//span[text()='Trade A Car']")
    public WebElement cseChooseTradeTradeACarButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Return a Lease']//parent::div")
    public WebElement cseChooseTradeReturnLease;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='No Trade']//parent::div//parent::div")
    public WebElement cseChooseTradeNoTrade;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='No Trade']//parent::div[contains(@class,'cta-button')]")
    public WebElement cseChooseTradeNoTradeButton;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Choose Trade Option']")
    public WebElement cseMyGarageMyTradeChooseTradeOptionHeader;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Add a Trade']")
    public WebElement cseMyGarageMyTradeChooseTradeOptionAddTrade;
    @FindBy(how = How.XPATH, using = "(//p[@class='card-text mb-auto text-center vehicle-description'])[1]")
    public WebElement cseMyGarageMyTradeChooseTradeOption1stOldVehicle;
    @FindBy(how = How.XPATH, using = "//a[@class='text-primary']")
    public WebElement cseMyGarageMyTradeChooseTradeOptionWhichOne;
    /*Verify Vehicle Info for lease vehicle*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'vehicle-img-title-block')]//span")
    public WebElement cseVerifyLeaseVehicleInfo;
    /*Choose Trade Option modal*/
    @FindBy(how = How.XPATH, using = "//h5")
    public WebElement cseVerifyLeaseTradeOptionModalHeader;
    @FindBy(how = How.XPATH, using = "//h2[text()='Trade a Car']//parent::div")
    public WebElement cseVerifyLeaseTradeOptionModalTradeCarText;
    @FindBy(how = How.XPATH, using = "//h2[text()='Return a Lease']//parent::div")
    public WebElement cseVerifyLeaseTradeOptionModalReturnLeaseText;
    @FindBy(how = How.XPATH, using = "//h2[text()='No Trade']//parent::div")
    public WebElement cseVerifyLeaseTradeOptionModalNoTradeText;


    /* Page Functions */
    public void findContainsTextOnPage(String text) {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]")).isDisplayed(),"The text" +text.trim()+" is not present: ");
    }

    public void findTextOnPageNormalized(String text) {
        Assert.assertEquals(driver.findElement(By.xpath("//*[normalize-space()='"+text+"']")).getText().trim(),text.trim(),"The text" +text.trim()+" is not present: ");
    }

    public void cseGarageMyTradeAddTradeButton() {
        cseMyGarageMyTradeButton.click();
        waitForElementToBeVisible(cseChooseTradeNoTradeButton);
    }

    public void cseGarageMyTradeClickTradeACar() {
        hardWait(500);
        cseChooseTradeTradeACarButton.click();
        waitForElementToBeVisible(cseEnterVinHeader);
    }

    public void cseGarageMyTradeClickAddATrade() {
        cseChooseTradeAddATradeButton.click();
        waitForElementToBeVisible(cseMyGarageMyTradeChooseTradeOptionHeader);
    }

    public void cseGarageTradeInEnterYourVin() {
        String year = getCurrentYear();
        int lastYear = Integer.parseInt(year)-1;
        GenericFunctions.dbSql(1,5,"select vin,make,model,year,trim from vehicle_inventory where active='true' and year='"+lastYear+"' and stock_type='USED' order by random() limit 1;");
        cseEnterVinField.clear();
        cseEnterVinField.sendKeys(GlobalTestData.SQL_QUERY[0][0]);
        System.out.println("VIN used for 1st vehicle: "+GlobalTestData.SQL_QUERY[0][0]);
        scenario.log("VIN used for 1st vehicle: "+GlobalTestData.SQL_QUERY[0][0]);
        cseSubmitButton.click();
        waitForElementToBeVisible(cseVerifyVehicleInfoHeader);
    }

    public void cseGarageTradeInEnterVehicleInfoTrim() {
        hardWait(500);
        Select trim = new Select(cseVerifyVehicleInfoTrimDropDown);
        System.out.println("The selected trim is: "+cseVerifyVehicleInfoTrimDropDown.getText().trim());
        if(cseVerifyVehicleInfoTrimDropDown.getText().trim().contains("Select Trim")){
            trim.selectByIndex(2);
            cseVerifyVehicleInfoHeader.click();
        }
        hardWait(2000);
        GlobalTestData.CSE_TRADE_IN_VEHICLE_TRIM =  cseVerifyVehicleInfoTrimDropDown.getAttribute("value").trim();
    }

    public void cseGarageTradeInEnterVehicleInfoTrans() {
        Select trans = new Select(cseVerifyVehicleInfoTransDropDown);
        trans.selectByIndex(1);
        cseVerifyVehicleInfoHeader.click();
        GlobalTestData.CSE_TRADE_IN_VEHICLE_TRANSMISSION =  cseVerifyVehicleInfoTransDropDown.getAttribute("value").trim();
        hardWait(500);
    }

    public void cseGarageTradeInEnterVehicleInfoColor() {
        Select color = new Select(cseVerifyVehicleInfoColorDropDown);
        cseVerifyVehicleInfoHeader.click();
        color.selectByIndex(2);
        GlobalTestData.CSE_TRADE_IN_VEHICLE_COLOR =  cseVerifyVehicleInfoColorDropDown.getAttribute("value").trim();
        hardWait(500);
    }

    public void cseGarageTradeInEnterVehicleInfoMiles() {
        GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES =  "5000";
        cseVerifyVehicleInfoMileageField.clear();
        hardWait(500);
        cseVerifyVehicleInfoMileageField.sendKeys(GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES);
        cseVerifyVehicleInfoHeader.click(); //clicking outside of mileage field to make comma appear
        GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES = cseVerifyVehicleInfoMileageField.getAttribute("value");
        Assert.assertEquals(GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES,"5,000","Vehicle Information field did not insert comma after thousands place: ");
        GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES = cseVerifyVehicleInfoMileageField.getAttribute("value");
        cseSubmitButton.click();
        hardWait(500);
    }

    public void cseGarageTradeInVehicleFeatures(){
        if(GenericFunctions.isElementPresent(cseConfirmVehicleSelectFeaturesHeader)) {
            List<WebElement> vehFeaturesWeb = driver.findElements(By.xpath("//label//span"));
            System.out.println();
            for(int x=0;x<vehFeaturesWeb.size();x++){
                GlobalTestData.VEHICLE_FEATURES.add(driver.findElement(By.xpath("(//label//span)["+(x+1)+"]")).getText().trim());
                System.out.println("Feature on page is: "+GlobalTestData.VEHICLE_FEATURES.get(x));
            }
            System.out.println();
            GenericFunctions.clickButtonByText("Next");
        }
    }

    public void cseGarageTradeInVehicleCondition() {
        cseVehicleConditionExcellent.click();
        cseVehicleFobs2.click();
        cseWarnings.click();
        cseHeatAcWork.click();
        cseOilLeak.click();
        cseDentsDamage.click();
        cseScratchPaint.click();
        cseTireWear.click();
        cseSeats.click();
        cseFrameDamage.click();
        cseSubmitButton.click();
        waitForElementToBeVisible(cseVerifyYourInformationHeader);
    }

    public void cseGarageTradeInVehicleTradeInUserInfo() {
        cseVerifyYourInformationMonthIncome.sendKeys("4790");
        cseVerifyYourInformationBirthYear.sendKeys("1983");
        cseSubmitButton.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentHeader);
    }

    public void cseGarageTradeInCurrentPayment() {
        String [] pageVin = cseVerifyCurrentPaymentCarVin.getText().trim().split(" ");
        String vehicleInfo = cseVerifyCurrentPaymentCarInfo.getText().trim();
        System.out.println("Vehicle info on Trade Offer page: "+vehicleInfo);
        Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][3]),"The vehicle year is incorrect on Current Payment page. Expected "+GlobalTestData.SQL_QUERY[0][1]+": ");
        //Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][1]),"The vehicle make is incorrect on Current Payment page. Expected "+GlobalTestData.SQL_QUERY[0][1]+": ");
        //Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][2]),"The vehicle model is incorrect on Current Payment page: ");
        Assert.assertEquals(pageVin[1],GlobalTestData.SQL_QUERY[0][0],"The VIN on Verify Current Payment page is incorrect: ");
        cseVerifyCurrentPayment335button.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentFinanceCo);
    }

    public void cseGarageTradeInCurrentPaymentFinance() {
        cseVerifyCurrentPaymentFinanceCo.sendKeys("5");
        cseVerifyCurrentPaymentFinanceCo.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentFinanceCoSuggestList);
        cseVerifyCurrentPaymentFinanceCoSuggestListOption.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentFinanceCo);
        Assert.assertEquals(cseVerifyCurrentPaymentFinanceCo.getAttribute("value"),"TEST-NMAC-13672/N/A","The wrong finance company was selected: ");
        waitForElementToBeVisible(cseSubmitButton);
        cseSubmitButton.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentAdditionalInfoNeededHeader);
    }

    public void cseGarageTradeInAdditionalInfoNeeded() {
        cseVerifyCurrentPaymentAdditionalInfoNeededContinueButton.click();
        waitForElementToBeVisible(cseVerifyCurrentPaymentYourTradeOfferHeader);
    }

    public void cseGarageTradeInOfferVehicleDetails() {
        String [] pageVin = cseVerifyCurrentPaymentCarVin.getText().trim().split(" ");
        String vehicleInfo = cseVerifyCurrentPaymentYourTradeOfferCarInfo.getText().trim();
        Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][3]),"The vehicle year is incorrect on the Trade Offers details page: ");
        Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][1]),"The vehicle make is incorrect on the Trade Offers details page: ");
        //Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][2]),"The vehicle model is incorrect on the Trade Offers details page: ");
        Assert.assertEquals(pageVin[1],GlobalTestData.SQL_QUERY[0][0],"The VIN on Verify Current Payment page is incorrect. Showing "+pageVin[1]+" but should show "+GlobalTestData.SQL_QUERY[0][0]+": ");
    }

    public void cseGarageTradeInOfferDetails() {
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferPrice.getText().trim().isEmpty(),"Estimated offer price is blank for trade-in vehicle: ");
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferExpire.getText().trim().isEmpty(),"Expiration date of trade-in offer is missing: ");
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferWhere.getText().trim().isEmpty(),"Where can I get this trade-in offer message is incorrect: ");
    }

    public void cseGarageTradeInOfferDetailsRetain() {
        GlobalTestData.CSE_TRADE_OFFER_AMOUNT = cseVerifyCurrentPaymentYourTradeOfferPrice.getText().trim();
        GlobalTestData.CSE_TRADE_OFFER_EXPIRES = cseVerifyCurrentPaymentYourTradeOfferExpire.getText().trim();
        GlobalTestData.CSE_TRADE_OFFER_TYPE =cseVerifyCurrentPaymentYourTradeOfferType.getText().trim();
    }

    public void cseGarageTradeInOfferBasic() {
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferBasicColor.getText().trim().toLowerCase(),GlobalTestData.CSE_TRADE_IN_VEHICLE_COLOR.toLowerCase(),"The vehicle color under Basic Information on Your Trade-Offer Details page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferBasicMiles.getText().trim(),GlobalTestData.CSE_TRADE_IN_VEHICLE_MILES,"The vehicle mileage under Basic Information on Your Trade-Offer Details page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferBasicVin.getText().trim(),GlobalTestData.SQL_QUERY[0][0],"The vehicle VIN under Basic Information on Your Trade-Offer Details page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferBasicCondition.getText().trim(),"Excellent","The vehicle Condition under Basic Information on Your Trade-Offer Details page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferBasicTrans.getText().trim(),GlobalTestData.CSE_TRADE_IN_VEHICLE_TRANSMISSION,"The vehicle Transmission under Basic Information on Your Trade-Offer Details page is incorrect: ");
    }

    public void cseGarageTradeInOfferFeatures() {
        if(!(GlobalTestData.VEHICLE_FEATURES.size() == 0)){
            int totalFeatures = GlobalTestData.VEHICLE_FEATURES.size();
            if(totalFeatures>15){
                totalFeatures=15;
            }
            for(int x=0;x<totalFeatures;x++){
                if(GenericFunctions.isElementPresent(driver.findElement(By.xpath("//div[@class='feature-list pl-2']//span["+(x+1)+"]")))){
                    Assert.assertEquals(driver.findElement(By.xpath("//div[@class='feature-list pl-2']//span["+(x+1)+"]")).getText().trim(), GlobalTestData.VEHICLE_FEATURES.get(x),"The feature "+GlobalTestData.VEHICLE_FEATURES.get(x)+" is not present on the Your Trade-Offer details page: ");
                }else{
                    System.out.println("Feature # "+x+" is not present: "+GlobalTestData.VEHICLE_FEATURES.get(x));
                }
            }
        }
    }

    public void cseGarageTradeInOfferHistory() {
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryFob.getText().trim(),"2+","The number of FOBs in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryInstrWarn.getText().trim(),"No","The instrument light warnings note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryHeatAc.getText().trim(),"No","The heat or A/C working note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryOilLeak.getText().trim(),"No","The oil leak note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryDents.getText().trim(),"None","The dents and dings note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryChips.getText().trim(),"None","The chips and scratches note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryTires.getText().trim(),"No","The chips and scratches note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryBurns.getText().trim(),"None","The burns and stains note in vehicle history is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferHistoryFrame.getText().trim(),"No","The frame damage note in vehicle history is incorrect: ");
    }

    public void cseGarageTradeInOfferPayOff() {
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferPayOffFianceType.getText().trim(),"Finance","The Finance Type under Pay Off Information on the Trade-In Offer page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferPayOffPayAmount.getText().trim(),"$335","The Payment Amount under Pay Off Information on the Trade-In Offer page is incorrect: ");
        Assert.assertEquals(cseVerifyCurrentPaymentYourTradeOfferPayOffPayRemain.getText().trim(),"3","The Payments Remaining under Pay Off Information on the Trade-In Offer page is incorrect: ");
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferPayOffPayGoodThru.getText().trim().isEmpty(),"The Payoff Good Through date under Pay Off Information on the Trade-In Offer page is incorrect: ");
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferPayOffPayOffAmount.getText().trim().isEmpty(),"The Payoff Amount under Pay Off Information on the Trade-In Offer page is incorrect: ");
        Assert.assertFalse(cseVerifyCurrentPaymentYourTradeOfferPayOffPayOffMethod.getText().trim().isEmpty(),"The Payoff Method under Pay Off Information on the Trade-In Offer page is incorrect: ");
    }

    public void cseGarageTradeInMyTradeInfo(String[][] CarInfo) {
        /*Search trade-in containing specific VIN*/
        WebElement VehicleVin = driver.findElement(By.xpath("//div[@class='d-flex align-items-center']//span[text()='VIN: "+CarInfo[0][0]+"']"));
        WebElement VehicleInfo = driver.findElement(By.xpath("//div[@class='d-flex align-items-center']//span[text()='VIN: "+CarInfo[0][0]+"']//preceding-sibling::strong"));
        System.out.println("Vehicle VIN on page: "+VehicleVin.getText().trim());
        System.out.println("Vehicle Info on page: "+VehicleInfo.getText().trim());
        /*Assert car info from array*/
        Assert.assertTrue(VehicleInfo.getText().contains(CarInfo[0][3]),"The year of the vehicle, "+CarInfo[0][3]+", is incorrect on the My Trade page: ");
        Assert.assertTrue(VehicleInfo.getText().contains(CarInfo[0][1]),"The make of the vehicle, "+CarInfo[0][1]+", is incorrect on the My Trade page: ");
        //Assert.assertTrue(VehicleInfo.getText().contains(CarInfo[0][2]),"The model of the vehicle, "+CarInfo[0][2]+", is incorrect on the My Trade page: ");
        Assert.assertEquals(VehicleVin.getText().trim(),"VIN: "+CarInfo[0][0],"The VIN of the vehicle, "+CarInfo[0][0]+", is incorrect on the My Trade page: ");
    }

    public void clickNormalLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    public void cseGarageTradeInMyTradeViewOffers(){
        clickNormalLink("View Offers");
        wait.until(ExpectedConditions.attributeToBe(cseMyGarageMyTradeViewOfferSection,"class","mt-2 collapse show"));
    }

    public void cseGarageTradeInMyTradeViewOffersInfo() {
        Assert.assertEquals(cseMyGarageMyTradeViewOfferPrice.getText().trim(),GlobalTestData.CSE_TRADE_OFFER_AMOUNT,"The Offer price on My Trades page does not match the price under Vehicle Details: ");
        Assert.assertEquals(cseMyGarageMyTradeViewOfferExpires.getText().trim(),GlobalTestData.CSE_TRADE_OFFER_EXPIRES,"The Offer date on My Trades page does not match the date under Vehicle Details: ");
        Assert.assertEquals(cseMyGarageMyTradeViewOfferWhere.getText().trim(),GlobalTestData.CSE_TRADE_OFFER_TYPE,"The 'Where can I get this offer' message on My Trades page is incorrect: ");
    }

    public void cseGarageTradeInMyTradeGoToTradeOfferPage() {
        clickNormalLink("Vehicle Details");
        waitForElementToBeVisible(cseVerifyCurrentPaymentCarVin);
    }

    public void cseGarageTradeInMyTradeBackUpOldVehicleInfo(){
        GlobalTestData.OLD_VEHICLE_INFO = GlobalTestData.SQL_QUERY;
    }

    public void cseGarageTradeInChooseTradeOptionOldVehicle(){
        Assert.assertTrue(cseMyGarageMyTradeChooseTradeOption1stOldVehicle.getText().contains(GlobalTestData.OLD_VEHICLE_INFO[0][3]+" "+GlobalTestData.OLD_VEHICLE_INFO[0][1]),"The previously added trade vehicle information is incorrect: ");
    }

    public void cseGarageTradeInChooseTradeOptionAddTrade(){
        cseMyGarageMyTradeChooseTradeOptionAddTrade.click();
    }

    public void cseChooseTradeOptionPage(){
        waitForElementToBeVisible(cseMyGarageHeader);
    }

    public void cseChooseTradeOptionClickReturnLease(){
        hardWait(500);
        cseChooseTradeReturnLease.click();
        waitForElementToBeVisible(cseEnterVinField);
    }

    public void cseVerifyLeaseVehicleInfo(){
        String vehicleInfo = cseVerifyLeaseVehicleInfo.getText().trim();
        Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][3]),"FAILED: Vehicle year on Vehicle Lease Verify Vehicle Information does not contain "+GlobalTestData.SQL_QUERY[0][3]+" when the page contains "+vehicleInfo+": ");
        Assert.assertTrue(vehicleInfo.contains(GlobalTestData.SQL_QUERY[0][1]),"FAILED: Vehicle make on Vehicle Lease Verify Vehicle Information does not contain "+GlobalTestData.SQL_QUERY[0][1]+" when the page contains "+vehicleInfo+": ");
    }

    public void cseCompleteTradeOfferButton() {
        cseMyGarageTradeCompleteOffer.click();
    }

    public void cseVerifyVehicleInformationHeader(){
        waitForElementToBeVisible(cseVerifyVehicleInfoHeader);
    }

    public void cseVehicleSubmitButton() {
        cseSubmitButton.click();
        hardWait(1000);
    }

    public void cseCompleteTradeOfferButtonNotPresent() {
        Assert.assertFalse(GenericFunctions.isElementPresent(cseMyGarageTradeCompleteOffer),"The Complete Vehicle Trade offer button is still present when it should not be: ");
    }

    public void cseChooseTradeOptionElementsVerified() {
        Assert.assertEquals(cseChooseTradeTradeACarButton.getText().trim(),"Trade A Car","The Trade A Car option is not present on the Choose Trade Option page: ");
        Assert.assertEquals(cseChooseTradeReturnLease.getText().trim(),"Return a Lease","The Return a Lease option is not present on the Choose Trade Option page: ");
        Assert.assertTrue(cseChooseTradeNoTrade.getText().contains("No Trade"),"The No Trade option is not present on the Choose Trade Option page: ");
    }

    public void cseChooseTradeOptionWhichOneLink() {
        cseMyGarageMyTradeChooseTradeOptionWhichOne.click();
    }

    public void cseChooseTradeOptionWhichOneModal() {
        waitForElementToBeVisible(cseVerifyLeaseTradeOptionModalHeader);
        Assert.assertEquals(cseVerifyLeaseTradeOptionModalHeader.getText().trim(),"Choose Trade Option","The Choose Trade Option modal header is incorrect: ");
        Assert.assertEquals(cseVerifyLeaseTradeOptionModalTradeCarText.getText().trim(),"Trade a Car\nChoose this option if your current vehicle IS NOT leased and you are planning to trade it in when you purchase your next vehicle.","The Trade a Car help text is incorrect in the Choose Trade Option help modal: ");
        Assert.assertEquals(cseVerifyLeaseTradeOptionModalReturnLeaseText.getText().trim(),"Return a Lease\nChoose this option if your current vehicle is a lease.","The Return a Lease help text is incorrect in the Choose Trade Option help modal: ");
        Assert.assertEquals(cseVerifyLeaseTradeOptionModalNoTradeText.getText().trim(),"No Trade\nChoose this option if you do not currently own a vehicle or if you plan on purchasing a vehicle without trading your current vehicle.","The No Trade help text is incorrect in the Choose Trade Option help modal: ");
    }

    public void cseChooseTradeOptionWhichOneCloseModal() {
        GenericFunctions.clickButtonByText("Next");
        waitForElementToBeInVisible(cseVerifyLeaseTradeOptionModalHeader);
    }

    public void cseChooseTradeOptionNoTrade() {
        waitForElementToBeVisible(cseMyGarageHeader);
        hardWait(1000);
        cseChooseTradeNoTrade.click();
    }

    public void cseTradeInLeaseOptionPayment() {
        cseVerifyCurrentPaymentAdditionalInfoNeededContinueButton.click();
    }

    public void cseTradeInLeaseOptionOfferIncomplete() {
        Assert.assertEquals(cseMyGarageMyTradeViewOfferPrice.getText().trim(),"Incomplete","The Offer price on My Trades page for lease vehicles does not say 'Incomplete': ");
    }

    public void cseTradeInLeaseOptionOfferNotIncomplete() {
        Assert.assertTrue(cseMyGarageMyTradeViewOfferPrice.getText().contains("$"),"The Offer price is not present after completing the lease vehicle submission. Seeing value of "+cseMyGarageMyTradeViewOfferPrice.getText()+": ");
    }

    public void cseTradeInVerifyYourInfoIfPresent() {
        if(GenericFunctions.isElementPresent(cseVerifyYourInformationHeader)){
            cseVerifyYourInformationMonthIncome.sendKeys("4790");
            cseVerifyYourInformationBirthYear.sendKeys("1983");
            cseSubmitButton.click();
        }
    }
    public void cseClickTradeButtonOnChooseTradeOption(){
        Actions actions = new Actions(driver);
        actions.moveToElement(cseChooseTradeNoTradeButton).click().build().perform();
        //cseChooseTradeNoTradeButton.click();
        waitForElementToBeVisible(cseVerifyYourInformationHeader);
    }
}