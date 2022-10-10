package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Upgrade_SavedDeals_page extends GenericFunctions {
    WebDriver driver;
    WebDriverWait wait;

    public Upgrade_SavedDeals_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//a[@id='__BVID__40___BV_tab_button__']")
    public WebElement upSavedDealsPageBtnLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'save')]")
    public WebElement upSaveBtnLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='No Deals Found!']/parent::*")
    public WebElement upSavedDealsPageLoc;
    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'OK')])")
    public WebElement upPopUp3Loc;
    @FindBy(how = How.XPATH, using = "(//button[contains(@aria-label,'View Deal')])[1]")
    public WebElement upViewDealBtnLoc;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Close')]")
    public WebElement upOfferCloseBtnLoc;
    @FindBy(how = How.ID, using = "monthly-income")
    public WebElement upVerifyYourInformationMonthIncomeLoc;
    @FindBy(how = How.ID, using = "yearOfBirth")
    public WebElement upVerifyYourInformationBirthYearLoc;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement upSubmitButtonLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement upDealPageDealValueLoc;
    @FindBy(how = How.XPATH, using = "(//div[text()='OK'])[1]")
    public WebElement upDealPageOkBtnLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'save-btn')]")
    public WebElement upDealPageSaveBtnLoc;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'new')]")
    public WebElement upNewVerifyLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='This is my deal']/parent::*")
    public WebElement upVerifyDealNameInSavedDealsLoc;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'vehicle-card')])[7]")
    public WebElement upCar2Loc;
    @FindBy(how = How.XPATH, using = "//a[contains(.,'Saved Deals')]")
    public WebElement upMyGarageSavedDealLoc;
    @FindBy(how = How.XPATH, using = "//div[@id='save-deal-modal___BV_modal_body_']/div/input")
    public WebElement upClearDealNameLoc;

    /** Page Functions **/
    public void upSavedDealsPageBtn() {
        waitForElementToBeVisible(upSavedDealsPageBtnLoc);
        upSavedDealsPageBtnLoc.click();
    }
    public void upSavedDealsPage() {
        waitForElementToBeVisible(upSavedDealsPageLoc);
        boolean isDisplayed = upSavedDealsPageLoc.isDisplayed();
        if (isDisplayed) {
            String act = upSavedDealsPageLoc.getText();
            String exp = "No Deals Found!" + "\n"+ "Check back in once you made a deal!";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("Deal Found");
        }
    }
    public void upSaveBtn() {
        waitForElementToBeVisible(upSaveBtnLoc);
        upSaveBtnLoc.click();
    }
    public void upPopUp3() {
        waitForElementToBeClickable(upPopUp3Loc);
        upPopUp3Loc.click();
        hardWait(3000);
    }
    public void upViewDealBtn() {
        waitForElementToBeVisible(upViewDealBtnLoc);
        upViewDealBtnLoc.click();
    }
    public void upOfferCloseBtn() {
        waitForElementToBeClickable(upOfferCloseBtnLoc);
        upOfferCloseBtnLoc.click();
    }
    public void upClearDealName() {
        waitForElementToBeVisible(upClearDealNameLoc);
        upClearDealNameLoc.click();
        upClearDealNameLoc.clear();
    }
    public void upUserIncomeBirthYearInfo() {
        upVerifyYourInformationMonthIncomeLoc.sendKeys("2800");
        upVerifyYourInformationBirthYearLoc.sendKeys("1983");
        upSubmitButtonLoc.click();
    }
    public void upDealPageVehicleInfo(){
        waitForElementToBeVisible(upDealPageDealValueLoc);
        if(GenericFunctions.isElementPresent(upDealPageOkBtnLoc)){
            upDealPageOkBtnLoc.click();
        }
        Assert.assertEquals(upDealPageSaveBtnLoc.getText().trim(),"favorite\nSaved","The save button is not labeled correctly on the Deal Page: ");
    }
    public void upVerifyDealNameInSavedDeals() {
        waitForElementToBeVisible(upVerifyDealNameInSavedDealsLoc);
        boolean isDisplayed = upVerifyDealNameInSavedDealsLoc.isDisplayed();
        if (isDisplayed) {
            String act = upVerifyDealNameInSavedDealsLoc.getText();
            String exp = "This is my deal";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("No Deal");
        }
    }
    public void upNewVerify(){
        Assert.assertEquals(upNewVerifyLoc.getText().trim(),"New","used");
    }
    public void upCar2() {
        waitForElementToBeVisible(upCar2Loc);
        upCar2Loc.click();
    }
    public void upDealPageSaveBtn(){
        Assert.assertEquals(upMyGarageSavedDealLoc.getText().trim(),"Saved Deals (2)","Saved Deals link on My Garage page");
    }
    public void upDealPagePresent(){
        waitForElementToBeVisible(upDealPageDealValueLoc);
        if(GenericFunctions.isElementPresent(upDealPageOkBtnLoc)){
            upDealPageOkBtnLoc.click();
        }
        Assert.assertEquals(upDealPageSaveBtnLoc.getText().trim(),"favorite\nSave","The save button is not labeled correctly on the Deal Page: ");
    }
}