package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import gherkin.lexer.Gl;
import net.bytebuddy.description.type.TypeList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static stepDef.Hook.scenario;

public class CSE_Garage_Saved_Deals_page extends GenericFunctions {

    WebDriver driver;
    WebDriverWait wait;

    public CSE_Garage_Saved_Deals_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* Page Locators */
    @FindBy(how = How.XPATH, using = "//h1[@class='ymm']")
    public WebElement cseDealPageHeader;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'payment-tabs')]//a[text()='Finance']")
    public WebElement cseDealPageFinanceTabLink;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'payment-tabs')]//a[text()='Lease']")
    public WebElement cseDealPageLeaseTabLink;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'payment-tabs')]//a[text()='Cash']")
    public WebElement cseDealPageCashTabLink;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'payment-tabs')]//a[@aria-selected='true']")
    public WebElement cseDealPageActiveTab;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement cseDealPageDealValue;
    @FindBy(how = How.XPATH, using = "(//div[text()='OK'])[1]")
    public WebElement cseDealPageOkButton;
    /*Vehicle details and pricing (on the left)*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'stock')]")
    public WebElement cseDealPageStockType;
    @FindBy(how = How.XPATH, using = "//span[@class='total mr-2']")
    public WebElement cseDealPageDealBuyHomePrice;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'exterior')]")
    public WebElement cseDealPageDealVehicleExteriorColor;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'title-bar')]//a[@class='total']")
    public WebElement cseDealPageBuyHomeAccessoriesLink;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'line-item')]//a[@class='total']")
    public WebElement cseDealPageBuyHomeAccessoriesOfferDetailsLink;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Edit Accessories']")
    public WebElement cseDealPageBuyHomeEditAccessoriesOfferDetailsLink;

    /*Finance deal page*/
    @FindBy(how = How.XPATH, using = "//span[@class='brand-name ml-2']")
    public WebElement cseDealPageDealerName;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'custom-checkbox')])[1]")
    public WebElement cseDealPage1stCheckBox1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'custom-checkbox')]//input)[1]")
    public WebElement cseDealPage1stCheckBoxChecked1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'d-flex flex-row')])[1]")
    public WebElement cseDealPage1stCheckBoxLabel1;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'custom-checkbox')])[2]")
    public WebElement cseDealPage1stCheckBox2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'custom-checkbox')]//input)[2]")
    public WebElement cseDealPage1stCheckBoxChecked2;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'d-flex flex-row')])[2]")
    public WebElement cseDealPage1stCheckBoxLabel2;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//input[@class='cash-down form-control']")
    public WebElement cseDealPageFinanceDownPayment;
    @FindBy(how = How.XPATH, using = "(//button[text()=' Recalculate '])[1]")
    public WebElement cseDealPageFinanceRecalculateButton;
    public String cseDealPageCheckBoxItems = "//div[@class='tab-pane active']//div[contains(@class,'list-group-item')]";
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[normalize-space()='Add Accessories']")
    public WebElement cseDealPageAddAccessoriesButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[normalize-space()='Edit Accessories']")
    public WebElement cseDealPageEditAccessoriesButton;
    /*Lease Deal info*/
    @FindBy(how = How.ID, using = "miles")
    public WebElement cseDealPageLeaseMilesPerYear;
    @FindBy(how = How.XPATH, using = "(//span[text()=' Change Trade ']//parent::button)[1]")
    public WebElement cseDealPageFinanceChangeTradeButton;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Apply For Credit']")
    public WebElement cseDealPageFinanceApplyCreditButton;
    /*Offers Ready Modal*/
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'save-btn')]")
    public WebElement cseDealPageSaveButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn mt-2')]")
    public WebElement cseDealPageCreateAccountButton;
    @FindBy(how = How.XPATH, using = "//h5//span[normalize-space()='Offers Ready']")
    public WebElement cseDealPageOffersReadyModalHeader;
    @FindBy(how = How.XPATH, using = "//h6//span")
    public WebElement cseDealPageOffersReadyModalSubHeader;
    @FindBy(how = How.XPATH, using = "(//div[@class='step-text'])[1]")
    public WebElement cseDealPageOffersReadyModalStepOneText;
    @FindBy(how = How.XPATH, using = "(//div[@class='step-text'])[2]")
    public WebElement cseDealPageOffersReadyModalStepTwoText;
    @FindBy(how = How.XPATH, using = "(//div[@class='step-text'])[3]")
    public WebElement cseDealPageOffersReadyModalStepThreeText;
    @FindBy(how = How.XPATH, using = "//button[text()='Close']")
    public WebElement cseDealPageOffersReadyModalCloseButton;
    /*Deal Name modal*/
    @FindBy(how = How.XPATH, using = "//h5")
    public WebElement cseDealPageSaveDealModalHeader;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Deal name']")
    public WebElement cseDealPageSaveDealModalField;
    /*My Garage elements*/
    @FindBy(how = How.XPATH, using = "//a[contains(.,'Saved Deals')]")
    public WebElement cseMyGarageSavedDealsLink;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'truncate')]//strong")
    public WebElement cseMyGarageSavedDealsCarInformation;
    @FindBy(how = How.XPATH, using = "//div[@class='payment mb-1']")
    public WebElement cseMyGarageSavedDealsCarValue;
    @FindBy(how = How.XPATH, using = "//div[@class='sale-price mb-1']")
    public WebElement cseMyGarageSavedDealsSalePrice;
    @FindBy(how = How.XPATH, using = "//div[@class='dealer-name']")
    public WebElement cseMyGarageDealerName;
    @FindBy(how = How.XPATH, using = "(//button[contains(@aria-label,'View Deal')])[1]")
    public WebElement cseMyGarageViewDealButton;
    @FindBy(how = How.XPATH, using = "//button[@title='remove']")
    public WebElement cseMyGarageDeleteDealIcon;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'recent')]//div[contains(@class,'message')]")
    public WebElement cseMyGarageNoRecentVehiclesText;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'deal')]//div[contains(@class,'message')]")
    public WebElement cseMyGarageNoSavedDealsText;
    /*Change tab form elements*/
    @FindBy(how = How.XPATH, using = "//button[text()='Confirm']")
    public WebElement cseDealPageConfirmTabChangeButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ok-btn']")
    public WebElement cseDealPageOkFlyoutButton;
    /*My Trade Vehicle section on Deal Page*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'trade-block')]//div[@class='trade-title']")
    public WebElement cseDealPageMyTradeSection;
    @FindBy(how = How.XPATH, using = "//div[@class='label' and text()='Trade Offer']")
    public WebElement cseDealPageMyTradeOfferAmountLabel;
    @FindBy(how = How.XPATH, using = "//div[text()='Trade Offer']//following-sibling::div")
    public WebElement cseDealPageMyTradeOfferAmount;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'btn add-trade-btn')]")
    public WebElement cseDealPageAddATradeButton;
    @FindBy(how = How.XPATH, using = "//a[text()='Change Trade']")
    public WebElement cseDealPageChangeTradeLink;
    /*My Trade section on Dealer page--no trade in vehicle*/
    @FindBy(how = How.XPATH, using = "//h2[text()='Do you have a trade in?']")
    public WebElement cseDealPageNoTradeInHeader;
    @FindBy(how = How.XPATH, using = "//p[contains(@class,'msg')]")
    public WebElement cseDealPageNoTradeInTradeOfferText;
    /*High Trade-In Value modal*/
    @FindBy(how = How.XPATH, using = "//h1[text()='High Trade-In Value']")
    public WebElement cseDealPageHighTradeInModalHeader;
    /*Value Trade In page header*/
    @FindBy(how = How.XPATH, using = "//h1[text()='Choose Trade Option']")
    public WebElement cseValueTradeInPageHeader;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'card-body')]//span)[1]")
    public WebElement cseValueTradeInPage1stVehicleCard;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'card-body')]//span)[2]")
    public WebElement cseValueTradeInPage2ndVehicleCard;
    @FindBy(how = How.XPATH, using = "//span[text()='No Trade']")
    public WebElement cseValueTradeInPageNoTrade;
    /*Get Approved page*/
    @FindBy(how = How.XPATH, using = "//h1[contains(@class,'page-title')]")
    public WebElement cseGetApprovedHeader;
    /*Deal page*/
    @FindBy(how = How.XPATH, using = "//input[@aria-label='Desired Down Payment -Finance down payment']")
    public WebElement cseGetApprovedDealDownPay;
    /*Available Rebates elements*/
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='+ Add additional special rebates & incentives']")
    public WebElement cseDealActiveRebatesLink;
    @FindBy(how = How.XPATH, using = "//h5[@class='modal-title']")
    public WebElement cseDealActiveRebatesModalHeader;
    @FindBy(how = How.XPATH, using = "//input[@value='MILITARY']")
    public WebElement cseDealActiveRebatesModalMilitaryRadioButton;
    @FindBy(how = How.XPATH, using = "//input[@value='MILITARY']//following-sibling::label")
    public WebElement cseDealActiveRebatesModalMilitaryRadioButtonLabel;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Saved Deals (1)']")
    public WebElement cseGarageSavedDealsLink;
    @FindBy(how = How.XPATH, using = "//img[@alt='nissan']")
    public WebElement cseDealPageNissanLogo;


    /* Page functions */
    public void cseDealPageClickSave(){
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
        cseDealPageSaveButton.click();
        hardWait(1000);
    }

    public void cseDealPageDealsReadyModal() {
        waitForElementToBeVisible(cseDealPageOffersReadyModalHeader);
        Assert.assertEquals(cseDealPageOffersReadyModalHeader.getText().trim(),"Offers Ready"," The Offers Ready modal header is incorrect: ");
        Assert.assertEquals(cseDealPageOffersReadyModalSubHeader.getText().trim(),"Your profile has been saved to your garage","The Offers Ready modal subheader is incorrect: ");
        Assert.assertEquals(cseDealPageOffersReadyModalStepOneText.getText().trim(),"Credit History Confirmed","The first step text is incorrect: ");
        Assert.assertEquals(cseDealPageOffersReadyModalStepTwoText.getText().trim(),"Rebates & Incentives Applied","The second step text is incorrect: ");
        Assert.assertEquals(cseDealPageOffersReadyModalStepThreeText.getText().trim(),"Payment Options Calculated","The third step text is incorrect: ");
        cseDealPageOffersReadyModalCloseButton.click();
    }

    public void cseDealPageVehicleInfo(){
        Actions actions = new Actions(driver);
        if(GenericFunctions.isElementPresent(cseValueTradeInPageNoTrade)){
            cseValueTradeInPageNoTrade.click();
        }
        if(GenericFunctions.isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
            actions.moveToElement(cseDealPageNissanLogo).click().build().perform();
        }
        waitForElementToBeVisible(cseDealPageDealValue);
        if(GenericFunctions.isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
            actions.moveToElement(cseDealPageNissanLogo).click().build().perform();
        }
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSave","The save button is not labeled correctly on the Deal Page: ");
        Assert.assertTrue(cseDealPageHeader.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"The year and make are not correct on the Deal Page: ");
    }

    public void cseDealPageVehicleInfoSavedButton(){
        waitForElementToBeVisible(cseDealPageDealValue);
        if(GenericFunctions.isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(cseDealPageNissanLogo).click().build().perform();
        }
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSaved","The save button is not labeled correctly on the Deal Page: ");
        Assert.assertTrue(cseDealPageHeader.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"The year and make are not correct on the Deal Page: ");
    }

    public void cseDealPageDealNameModal() {
        waitForElementToBeVisible(cseDealPageSaveDealModalHeader);
        Assert.assertEquals(cseDealPageSaveDealModalHeader.getText().trim(),"Give this deal a name","The Save Deal modal header is incorrect: ");
        Assert.assertTrue(cseDealPageSaveDealModalField.getAttribute("value").contains(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"The contents of the Deal Name field are inaccurate: ");
    }

    public void cseDealPageDealNameModalCancel() {
        GenericFunctions.clickButtonByText("Cancel");
        waitForElementToBeInVisible(cseDealPageSaveDealModalHeader);
    }

    public void cseDealPageDealNameModalConfirm() {
        if(GenericFunctions.isElementPresent(cseDealPageSaveDealModalHeader)){
            GenericFunctions.clickButtonByText("Confirm");
            waitForElementToBeInVisible(cseDealPageSaveDealModalHeader);
        }
        if(GenericFunctions.isElementPresent(cseDealPageOkFlyoutButton)){
            cseDealPageOkFlyoutButton.click();
        }
    }

    public void cseDealPageSavedDeal(){
        waitForElementToBeVisible(cseDealPageDealValue);
        if(GenericFunctions.isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(cseDealPageNissanLogo).click().build().perform();
        }
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSaved","The save button is not labeled as Saved after saving a deal: ");
        Assert.assertTrue(cseDealPageSaveButton.getAttribute("class").contains("disabled-button"),"The save button is not disabled after saving a deal: ");
        Assert.assertEquals(cseDealPageDealerName.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"Dealer name on the dealer page is incorrect: ");
        /*Save deal value found under tabs*/
        GlobalTestData.CSE_DEAL_VALUE = cseDealPageDealValue.getText().trim();
        /*Save BUY@Home price*/
        GlobalTestData.CSE_BUY_HOME_PRICE = cseDealPageDealBuyHomePrice.getText().trim();
    }

    public void cseMyGarageSavedDealsOptionText(){
        Assert.assertEquals(cseMyGarageSavedDealsLink.getText().trim(),"Saved Deals (1)","Saved Deals link on My Garage page ");
    }

    public void cseMyGarageSavedDealsVehicleInfo() {
        Assert.assertTrue(cseMyGarageSavedDealsCarInformation.getText().contains(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"Vehicle information is incorrect. Expected "+GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+": ");
        if(GenericFunctions.isElementPresent(cseMyGarageSavedDealsCarValue)){
            Assert.assertTrue(cseMyGarageSavedDealsCarValue.getText().contains(GlobalTestData.CSE_DEAL_VALUE),"The vehicle value per month price is incorrect on the Garage Saved Deals page. Expected "+GlobalTestData.CSE_DEAL_VALUE+": ");
        }else {
            System.out.println("There was no Value/per month price for vin: "+GlobalTestData.SQL_QUERY[0][0]);
            scenario.log("There was no Value/per month price for vin: "+GlobalTestData.SQL_QUERY[0][0]);
        }
        Assert.assertTrue(cseMyGarageSavedDealsSalePrice.getText().contains(GlobalTestData.CSE_BUY_HOME_PRICE),"The vehicle sale price is incorrect on the Garage Saved Deals page. Expected "+GlobalTestData.CSE_BUY_HOME_PRICE+": ");
        Assert.assertEquals(cseMyGarageDealerName.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"The dealer name is incorrect on the Garage Saved Deals page: ");
    }

    public void cseMyGarageSavedDealsViewDealClick() {
        hardWait(2000);
        cseMyGarageViewDealButton.click();
        waitForElementToBeVisible(cseDealPageDealValue,40);
    }

    public void cseMyGarageSavedDealsAlterCheckBox() {
        /*Click Finance tab*/
        cseDealSwitchToFinanceTab();
        cseDealPage1stCheckBox2.click();
        waitForElementToBeVisible(cseDealPageDealValue);
        Assert.assertFalse(cseDealPage1stCheckBoxChecked1.isSelected(),"The first check box is selected and should not be: ");
        Assert.assertTrue(cseDealPage1stCheckBoxChecked2.isSelected(),"The second check box is not selected: ");
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSave Changes","The save button is not labeled correctly after altering a deal: ");
    }

    public void cseMyGarageSavedDealsAlterDownPayment(String amount) {
        cseDealPageFinanceDownPayment.clear();
        cseDealPageFinanceDownPayment.sendKeys(amount);
        cseDealPageFinanceRecalculateButton.click();
        waitForElementToBeVisible(cseDealPageDealValue);
        /*Store deal value found under tabs*/
        GlobalTestData.CSE_DEAL_VALUE = cseDealPageDealValue.getText().trim();
        /*Store BUY@Home price*/
        GlobalTestData.CSE_BUY_HOME_PRICE = cseDealPageDealBuyHomePrice.getText().trim();
        /*Store down payment value*/
        GlobalTestData.CSE_DOWN_PAYMENT_VALUE = cseDealPageFinanceDownPayment.getAttribute("value");
        /*Store check box information*/
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST = cseDealPage1stCheckBoxLabel1.getText().trim();
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND = cseDealPage1stCheckBoxLabel2.getText().trim();
    }

    public void cseMyGarageSavedDealUpdateConfirm(){
        waitForElementToBeVisible(cseDealPageDealValue);
        Assert.assertEquals(cseDealPageDealBuyHomePrice.getText().trim(),GlobalTestData.CSE_BUY_HOME_PRICE,"The updated Home Price is not correct on the deal page: ");
        Assert.assertEquals(cseDealPageDealValue.getText().trim(),GlobalTestData.CSE_DEAL_VALUE,"The updated deal value is incorrect: ");
        Assert.assertEquals(cseDealPage1stCheckBoxLabel1.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST,"The 1st check box information is incorrect after going back to the deal page: ");
        Assert.assertEquals(cseDealPage1stCheckBoxLabel2.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND,"The 2nd check box information is incorrect after going back to the deal page: ");
        Assert.assertEquals(cseDealPageFinanceDownPayment.getAttribute("value"),GlobalTestData.CSE_DOWN_PAYMENT_VALUE,"The down payment is incorrect after going back to the updated deal page: ");
    }

    public void cseMyGarageSavedDealDeleteDeal(){
        cseMyGarageDeleteDealIcon.click();
        waitForElementToBeVisible(cseMyGarageNoRecentVehiclesText);
    }

    public void cseMyGarageNoSavedDeals() {
        waitForElementToBeVisible(cseMyGarageNoSavedDealsText);
        Assert.assertEquals(cseMyGarageNoSavedDealsText.getText().trim(),"No Deals Found!\n" +
                "Check back in once you made a deal!","The no deals text is not present onn Saved Deals page: ");
    }

    public void cseDealInformation() {
        /*Save BUY@Home price*/
        waitForElementToBeVisible(cseDealPageDealValue);
        GlobalTestData.CSE_BUY_HOME_PRICE_1 = cseDealPageDealBuyHomePrice.getText().trim();
        /*Stock Type*/
        GlobalTestData.CSE_STOCK_TYPE_1 = cseDealPageStockType.getText().trim();
        /*Exterior Color*/
        String[] carColor = cseDealPageDealVehicleExteriorColor.getText().split(":");
        GlobalTestData.CSE_DEAL_PAGE_VEHICLE_COLOR_1 = carColor[1].trim();
    }

    public void cseDealInformation2() {
        /*Save BUY@Home price*/
        waitForElementToBeVisible(cseDealPageDealValue);
        GlobalTestData.CSE_BUY_HOME_PRICE_2 = cseDealPageDealBuyHomePrice.getText().trim();
        /*Stock Type*/
        GlobalTestData.CSE_STOCK_TYPE_2 = cseDealPageStockType.getText().trim();
        /*Exterior Color*/
        String[] carColor = cseDealPageDealVehicleExteriorColor.getText().split(":");
        GlobalTestData.CSE_DEAL_PAGE_VEHICLE_COLOR_2 = carColor[1].trim();
    }

    public void cseDealSwitchToFinanceTab() {
        cseDealPageFinanceTabLink.click();
        hardWait(1000);
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
        cseDealPageDealerName.click();
        hardWait(1000);
        if(GenericFunctions.isElementPresent(cseDealPageOkFlyoutButton)){
            cseDealPageOkFlyoutButton.click();
        }
    }

    public void cseDealSwitchToLeaseTab() {
        waitForElementToBeVisible(cseDealPageLeaseTabLink);
        cseDealPageLeaseTabLink.click();
        hardWait(1000);
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
        if(GenericFunctions.isElementPresent(cseDealPageOkFlyoutButton)){
            cseDealPageOkFlyoutButton.click();
        }
    }

    public void cseDealSwitchToCashTab() {
        cseDealPageCashTabLink.click();
        hardWait(1000);
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
        if(GenericFunctions.isElementPresent(cseDealPageOkFlyoutButton)){
            cseDealPageOkFlyoutButton.click();
        }
    }

    public void cseDealFinanceInformationSave() {
        GlobalTestData.CSE_DEAL_VALUE = cseDealPageDealValue.getText().trim();
        GlobalTestData.CSE_DOWN_PAYMENT_VALUE = cseDealPageFinanceDownPayment.getAttribute("value");
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST = cseDealPage1stCheckBoxLabel1.getText().trim();
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND = cseDealPage1stCheckBoxLabel2.getText().trim();
    }

    public void cseStorePreSavedDealInfo() {
        GlobalTestData.CSE_DEAL_VALUE_ORIG = GlobalTestData.CSE_DEAL_VALUE;
        GlobalTestData.CSE_DOWN_PAYMENT_VALUE_ORIG = GlobalTestData.CSE_DOWN_PAYMENT_VALUE;
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST_ORIG = GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST;
        GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND_ORIG = GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND;
    }

    public void cseVerifyUpdatedDownPaymentInfo() {
        Assert.assertNotEquals(GlobalTestData.CSE_DEAL_VALUE_ORIG, cseDealPageDealValue.getText().trim(), "The Deal Value information did not update correctly after updating down payment: ");
        Assert.assertNotEquals(GlobalTestData.CSE_DOWN_PAYMENT_VALUE_ORIG, cseDealPageFinanceDownPayment.getAttribute("value"), "The Down Payment box did not update correctly after updating down payment: ");
        Assert.assertNotEquals(GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST_ORIG, cseDealPage1stCheckBoxLabel1.getText().trim(), "The 1st check box information did not update correctly after updating down payment: ");
        Assert.assertNotEquals(GlobalTestData.CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND_ORIG, cseDealPage1stCheckBoxLabel2.getText().trim(), "The 2nd check box information did not update correctly after updating down payment: ");
    }
    public void cseRefreshDealPage() {
        refreshPage();
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseTradeInVehicleOnDealPage(String[][] tradeVeh,String tradeOffer) {
        if(GenericFunctions.isElementPresent(cseDealPageHighTradeInModalHeader)){
            GenericFunctions.clickButtonByText("Continue with Finance");
        }
        waitForElementToBeVisible(cseDealPageMyTradeOfferAmountLabel);
        if(!cseDealPageMyTradeSection.getText().isEmpty()){
            Assert.assertTrue(cseDealPageMyTradeSection.getText().contains(tradeVeh[0][3]+" "+tradeVeh[0][1]),"The Trade Offer Amount is incorrect on the deal page. Expected "+tradeVeh[0][3]+" "+tradeVeh[0][1]+" but found "+cseDealPageMyTradeSection.getText()+": ");
        }
        Assert.assertEquals(cseDealPageMyTradeOfferAmount.getText().trim(),tradeOffer,"The trade offer on the deal page does not match what is in the vehicle details: ");

    }
    public void cseDealCheckBoxOrder() {
        List<WebElement> boxes = driver.findElements(By.xpath(cseDealPageCheckBoxItems));
        GlobalTestData.checkBoxes = new String[boxes.size()];
        for(int y = 0;y< boxes.size();y++){
            GlobalTestData.checkBoxes[y] = boxes.get(y).getText().trim().replace("\n"," ");
        }
        for(int x = 1;x<GlobalTestData.checkBoxes.length;x++){
            String[] monthCheck = GlobalTestData.checkBoxes[x].split(" ");
            String[] prevMonthCheck = GlobalTestData.checkBoxes[x-1].split(" ");
            if(Integer.parseInt(monthCheck[0])>=Integer.parseInt(prevMonthCheck[0])){
                Assert.fail("The deal page check boxes are not ordered properly. Seeing +"+GlobalTestData.checkBoxes[x]+" vs. previous "+GlobalTestData.checkBoxes[x-1]+": ");
                break;
            }
        }
    }
    public void cseDealCheckBoxesNotRepeating() {
        String[] dupCheckBoxes = new String[GlobalTestData.checkBoxes.length];
        System.arraycopy(GlobalTestData.checkBoxes,0,dupCheckBoxes,0,GlobalTestData.checkBoxes.length);
        Arrays.sort(dupCheckBoxes);
        for(int x = 1;x<dupCheckBoxes.length;x++){
            String[] monthCheck = dupCheckBoxes[x].split(" ");
            String[] prevMonthCheck = dupCheckBoxes[x-1].split(" ");
            String monthCheckTotal = monthCheck[1]+monthCheck[2]+monthCheck[3];
            String prevMonthCheckTotal = prevMonthCheck[1]+prevMonthCheck[2]+prevMonthCheck[3];
            if(Objects.equals(monthCheckTotal, prevMonthCheckTotal)){
                Assert.fail("There are duplicate check boxes on the deals page: "+monthCheckTotal+" vs. prev. month "+prevMonthCheckTotal);
                break;
            }
        }
    }

    public void cseDealVerifyCheckBoxOrder() {
        List<WebElement> boxes = driver.findElements(By.xpath(cseDealPageCheckBoxItems));
        String[] NewBoxes = new String[boxes.size()];
        for(int y = 0;y< boxes.size();y++){
            NewBoxes[y] = boxes.get(y).getText().trim().replace("\n"," ");
        }
        for(int x = 0;x<NewBoxes.length;x++){
            if(!NewBoxes[x].equals(GlobalTestData.checkBoxes[x])){
                Assert.fail("The deal page check boxes are not ordered properly. Before changing page info: "+ GlobalTestData.checkBoxes[x]+" vs. after: "+NewBoxes[x]+": ");
                break;
            }
        }
    }

    public void cseDealerMilesPerYearDropDownSelection(String drop) {
        Select select = new Select(cseDealPageLeaseMilesPerYear);
        select.selectByVisibleText(drop);
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseDealerRecalculateDealSameValue() {
        String amount = cseDealPageFinanceDownPayment.getAttribute("value");
        cseDealPageFinanceDownPayment.clear();
        cseDealPageFinanceDownPayment.sendKeys(amount);
        cseDealPageFinanceRecalculateButton.click();
        waitForElementToBeVisible(cseDealPageDealValue);
    }


    public void cseDealPageAddATrade(){
        cseDealPageAddATradeButton.click();
        waitForElementToBeVisible(cseValueTradeInPageHeader);
    }

    public void cseDealSelectTradeVehicle(){
        cseValueTradeInPage1stVehicleCard.click();
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseDealChangeTradeLink(){
        cseDealPageChangeTradeLink.click();
        waitForElementToBeVisible(cseValueTradeInPageHeader);
    }

    public void cseDealChangeTradeButton(){
        cseDealPageFinanceChangeTradeButton.click();
        waitForElementToBeVisible(cseValueTradeInPageHeader);
    }

    public void cseDealChoosePreviousTradeVehicle(){
        cseValueTradeInPage2ndVehicleCard.click();
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseDealNoTradeInVehicle(){
        waitForElementToBeVisible(cseDealPageNoTradeInHeader);
        Assert.assertEquals(cseDealPageAddATradeButton.getText().trim(),"Add a Trade","The Add a Trade button under My Trade is labeled incorrectly: ");
        Assert.assertEquals(cseDealPageNoTradeInTradeOfferText.getText().trim(),"Get a real-time offer on your current vehicle and save up to 30 minutes at the dealership.","Text when no trade vehicle is present on the deal page is incorrect: ");
    }

    public void cseDealApplyForCreditButton(){
        if(isElementPresent(cseDealPageOkFlyoutButton)){
            cseDealPageOkFlyoutButton.click();
        }
        cseDealPageFinanceApplyCreditButton.click();
        waitForElementToBeVisible(cseGetApprovedHeader);
    }

    public void cseDealApplyForFinanceRememberDownPay(){
        GlobalTestData.CSE_DOWN_PAYMENT_VALUE = cseGetApprovedDealDownPay.getAttribute("value").trim().replace("$","").replace(",","");
    }

    public void cseClickAddAccessoriesLinkUnderBuyHome(){
        cseDealPageBuyHomeAccessoriesLink.click();
    }

    public void cseAssertHeartSavedButton(){
        waitForElementToBeVisible(cseDealPageDealValue);
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSaved","The save button is not labeled correctly on the Deal Page: ");
    }

    public void cseAssertSaveChangesButton(){
        waitForElementToBeVisible(cseDealPageDealValue);
        Assert.assertEquals(cseDealPageSaveButton.getText().trim(),"favorite\nSave Changes","The save button is not labeled correctly: ");
    }

    public void cseDealPageAccessoriesButton() {
        cseDealPageAddAccessoriesButton.click();
    }

    public void cseDealPageAccessoriesOfferLink(){
        cseDealPageBuyHomeAccessoriesOfferDetailsLink.click();
    }

    public void cseClickEditAccessoriesLinkUnderBuyHome(){
        cseDealPageBuyHomeEditAccessoriesOfferDetailsLink.click();
    }

    public void cseDealPageEditAccessoriesButton(){
        cseDealPageEditAccessoriesButton.click();
    }

    public void cseDealPageClick2ndMonthlyCheckbox(){
        cseDealPage1stCheckBox2.click();
        waitForElementToBeVisible(cseDealPageDealValue);
        Assert.assertTrue(cseDealPage1stCheckBoxChecked2.isSelected(),"The second check box is not selected: ");
    }

    public void cseDealPageVerifyActiveTab(String tabName){
        Assert.assertEquals(cseDealPageActiveTab.getText().trim(),tabName,"The wrong tab is selected: ");
    }

    public void cseDealPage2ndMonthlyCheckBoxSelected(){
        Assert.assertTrue(cseDealPage1stCheckBoxChecked2.isSelected(),"The second check box is not selected: ");
    }

    public void cseDealPageVerifyMilesPerYearValue(String milesYear){
        Select select = new Select(cseDealPageLeaseMilesPerYear);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(),milesYear,"The Miles Per Year value is incorrect: ");
    }

    public void cseDealPageVerifyDownPaymentAmount(String amount){
        Assert.assertEquals(cseDealPageFinanceDownPayment.getAttribute("value"),amount,"The down payment amount is incorrect: ");
    }

    public void cseDealPageActiveRebatesClick() {
        cseDealActiveRebatesLink.click();
        waitForElementToBeVisible(cseDealActiveRebatesModalHeader);
    }

    public void cseDealPageActiveRebatesSelectMilitary() {
        cseDealActiveRebatesModalMilitaryRadioButtonLabel.click();
        hardWait(500);
        GenericFunctions.clickButtonByText("Confirm");
        if(cseDealActiveRebatesModalHeader.getText().trim().equals("Changing Applied Incentives")){
            GenericFunctions.clickButtonByText("Confirm");
        }
        waitForElementToBeInVisible(cseDealActiveRebatesModalHeader);
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseDealPageVerifyActiveRebateMilitarySelected(){
        Assert.assertTrue(cseDealActiveRebatesModalMilitaryRadioButton.isSelected(),"The military radio button for Available Rebates is not selected: ");
    }

    public void cseDealPageConfirmFinanceModalClose(){
        if(GenericFunctions.isElementPresent(cseDealPageConfirmTabChangeButton)){
            cseDealPageConfirmTabChangeButton.click();
            hardWait(1000);
        }
    }
    public void cseRefreshSavedDealsPage() {
        refreshPage();
        waitForElementToBeVisible(cseMyGarageSavedDealsLink);
    }

    public void cseSavedDealPageArrived(){
        waitForElementToBeVisible(cseMyGarageViewDealButton);
    }

    public void cseMyGarageViewDealClick() {
        cseGarageSavedDealsLink.click();
        hardWait(2000);
        cseMyGarageViewDealButton.click();
        waitForElementToBeVisible(cseDealPageDealValue,60);
    }
    public void cseDealPageWaitForOkFlyOut(){
        if(GenericFunctions.isElementPresent(cseDealPageOkButton)){
            cseDealPageOkButton.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(cseDealPageNissanLogo).click().build().perform();
        }
    }
}
