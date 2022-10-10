package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
public class Upgrade_Trades_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    Actions actions;
    WebDriverWait wait;

    public Upgrade_Trades_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Value Trade')]")
    public WebElement HamburgerValueTradeButtonLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='View Offers']/parent::*")
    public WebElement ViewOfferButtonLoc;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Continue with estimated payoff*']")
    public WebElement ContinueWithPayoffBtnLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='View Vehicles']/parent::*")
    public WebElement ViewVehicleBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Vehicle Details')]")
    public WebElement VehicleDetailsBtnLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Enter payoff information')]")
    public WebElement PayoffInfoBtnLoc;
    @FindBy(how = How.ID, using = "finance-type-selection")
    public WebElement PaymentTypeLOC;
    @FindBy(how = How.XPATH, using = "//input[@id='payoffAmount']")
    public WebElement PayoffAmountLoc;
    @FindBy(how = How.XPATH, using = "//input[@id='monthlyPayment']")
    public WebElement MonthlyPaymentLoc;
    @FindBy(how = How.XPATH, using = "//input[@id='remainingPayments']")
    public WebElement RemainingPaymentLoc;
    @FindBy(how = How.XPATH, using = "//span[@class='btn border-0 rounded-circle text-nowrap btn-outline-light text-muted']")
    public WebElement PayoffDateLoc;
    @FindBy(how = How.ID, using = "payoff-date-good-thru__value_")
    public WebElement PayoffCalenderLoc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Return a Lease')]")
    public WebElement ReturnLeaseBtnLoc;
    @FindBy(how = How.ID, using = "lenderSelect")
    public WebElement upVerifyCurrentPaymentFinanceLoc;
    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'suggestions')]")
    public WebElement upVerifyCurrentPaymentFinanceCoSuggestLoc;
    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'suggestions')]//span[text()='TEST-NMAC-13672/N/A']")
    public WebElement upVerifyCurrentPaymentFinanceCoSuggestListOptionLoc;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement upSubmitButtonLoc;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Additional Information Needed']")
    public WebElement upVerifyCurrentPaymentAdditionalInfoNeededHeaderLoc;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Verify Current Payment']")
    public WebElement upVerifyCurrentPaymentHeaderLoc;
    @FindBy(how = How.XPATH, using = "//ul[contains(@id,'suggestions')]")
    public WebElement upVerifyCurrentPaymentFinanceCoSuggestListLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add a Trade')]")
    public WebElement upAddTradeBtnLoc;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Add a Trade')]")
    public WebElement upAddTradeBtn2Loc;
    @FindBy(how = How.XPATH, using = "//h1[text()='High Trade-In Value']")
    public WebElement upDealPageHighTradeInModalHeaderLoc;
    @FindBy(how = How.XPATH, using = "//button[text()='Continue with Finance']")
    public WebElement upDealPageHighTradeInModalContinueButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Net Cash Offer')]")
    public WebElement upDealPageMyTradeOfferAmountLoc;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Close')]")
    public WebElement upOfferCloseBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Change Trade')]")
    public WebElement upChangeTradeBtnLoc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'No Trade')]")
    public WebElement upNoTradeBtnLoc;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Do you have a trade in?')]")
    public WebElement upVerifyNoTradeAddedInDealPageLoc;

    /*Page Functions*/
    public void HamburgerValueTradeButton() {
        waitForElementToBeVisible(HamburgerValueTradeButtonLoc);
        HamburgerValueTradeButtonLoc.click();
    }
    public void ViewOfferButton() {
        waitForElementToBeClickable(ViewOfferButtonLoc);
        ViewOfferButtonLoc.click();
    }
    public void ContinueWithPayoffBtn() {
        waitForElementToBeClickable(ContinueWithPayoffBtnLoc);
        ContinueWithPayoffBtnLoc.click();
    }
    public void ViewVehicleBtn() {
        waitForElementToBeClickable(ViewVehicleBtnLoc);
        ViewVehicleBtnLoc.click();
    }
    public void VehicleDetailsBtn() {
        waitForElementToBeClickable(VehicleDetailsBtnLoc);
        VehicleDetailsBtnLoc.click();
    }
    public void PayoffInfoBtn() {
        waitForElementToBeClickable(PayoffInfoBtnLoc);
        PayoffInfoBtnLoc.click();
    }
    public void PaymentType() {
        select = new Select(PaymentTypeLOC);
        select.selectByIndex(1);
    }
    public void PayoffAmount() {
        PayoffAmountLoc.click();
        PayoffAmountLoc.sendKeys("5000");
    }
    public void MonthlyPayment() {
        MonthlyPaymentLoc.click();
        MonthlyPaymentLoc.sendKeys("335");
    }
    public void PayoffDate() {
        PayoffDateLoc.click();
    }
    public void RemainingPayment() {
        RemainingPaymentLoc.click();
        RemainingPaymentLoc.sendKeys("15");
    }
    public void PayoffCalender() {
        waitForElementToBeVisible(PayoffCalenderLoc);
        PayoffCalenderLoc.click();
    }
    public void ReturnLeaseBtn() {
        waitForElementToBeClickable(ReturnLeaseBtnLoc);
        ReturnLeaseBtnLoc.click();
    }
    public void upTradeInCurrentPaymentFinance() {
        upVerifyCurrentPaymentFinanceLoc.sendKeys("5");
        upVerifyCurrentPaymentFinanceLoc.click();
        waitForElementToBeVisible(upVerifyCurrentPaymentFinanceCoSuggestLoc);
        upVerifyCurrentPaymentFinanceCoSuggestListOptionLoc.click();
        waitForElementToBeVisible(upVerifyCurrentPaymentFinanceLoc);
        Assert.assertEquals(upVerifyCurrentPaymentFinanceLoc.getAttribute("value"), "TEST-NMAC-13672/N/A", "The wrong finance company was selected: ");
        upVerifyCurrentPaymentHeaderLoc.click();
        waitForElementToBeInVisible(upVerifyCurrentPaymentFinanceCoSuggestListLoc);
        waitForElementToBeVisible(upSubmitButtonLoc);
        upSubmitButtonLoc.click();
        waitForElementToBeVisible(upVerifyCurrentPaymentAdditionalInfoNeededHeaderLoc);
    }
    public void upAddTradeBtn() {
        waitForElementToBeClickable(upAddTradeBtnLoc);
        upAddTradeBtnLoc.click();
        hardWait(10000);
    }
    public void upAddTradeBtn2() {
        waitForElementToBeClickable(upAddTradeBtn2Loc);
        upAddTradeBtn2Loc.click();
    }
    public void upContinueFinanceOption(String tradeOffer) {
        hardWait(15000);
        if (GenericFunctions.isElementPresent(upDealPageHighTradeInModalHeaderLoc)) {
            GenericFunctions.clickButtonByText("Continue with Finance");
        }
        if (GenericFunctions.isElementPresent(upOfferCloseBtnLoc)) {
            upOfferCloseBtnLoc.click();
        }
        waitForElementToBeVisible(upDealPageMyTradeOfferAmountLoc);
        Assert.assertEquals(upDealPageMyTradeOfferAmountLoc.getText().trim(), "Net Cash Offer", "No Trade Value");
    }
    public void upChangeTradeBtn() {
        waitForElementToBeClickable(upChangeTradeBtnLoc);
        upChangeTradeBtnLoc.click();
    }
    public void upNoTradeBtn() {
        waitForElementToBeClickable(upNoTradeBtnLoc);
        upNoTradeBtnLoc.click();
    }
    public void upVerifyNoTradeAddedInDealPage() {
        waitForElementToBeVisible(upVerifyNoTradeAddedInDealPageLoc);
        Assert.assertEquals(upVerifyNoTradeAddedInDealPageLoc.getText().trim(), "Do you have a trade in?", "Trade Value");
    }
}