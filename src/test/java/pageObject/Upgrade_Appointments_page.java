package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class Upgrade_Appointments_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    Actions actions;
    public Upgrade_Appointments_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }
    // All the locators goes here
    @FindBy(how = How.XPATH, using = "//div[@id='maincontent']/div/div[2]/div/h1")
    public WebElement upVerifyMyGarageLoc;
    @FindBy(how = How.XPATH, using = "//button[2]/span/div/div[2]")
    public WebElement upClickMyGarageLoc;
    @FindBy(how = How.ID, using = "__BVID__46___BV_tab_button__")
    public WebElement upClickMyAppointmentsLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='appointment-content-section ml-sm-3 mt-3 mt-sm-0']/div[1]/div[1]")
    public WebElement verifyNoAppointmentsLoc;
    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'OK')])[2]")
    public WebElement upPopUp1Loc;
    @FindBy(how = How.XPATH, using = "(//div[contains(text(),'OK')])[1]")
    public WebElement upPopUp2Loc;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'vehicle-card')])[1]")
    public WebElement upCar1Loc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Offer Details')]")
    public WebElement upOfferDetailsLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Test Drive']")
    public WebElement upTestDriveLoc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'My Garage')]")
    public WebElement upMyGarageHamburgerBtnLoc;
    @FindBy(how = How.ID, using = "appointment-date__value_")
    public WebElement upCalenderClickLoc;
    @FindBy(how = How.XPATH, using = "//span[@class='btn border-0 rounded-circle text-nowrap btn-outline-light text-dark font-weight-bold']")
    public WebElement upDateClickLoc;
    @FindBy(how = How.ID, using = "appointment-time-select")
    public WebElement upAppointmentTimeLOC;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-block']")
    public WebElement upSendBtnLOC;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Get Directions']/parent::*")
    public WebElement upGetDirectionBtnLoc;
    @FindBy(how = How.XPATH, using = "//button[2]")
    public WebElement upViewDetailsBtnLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Copy Deal')]")
    public WebElement upCopyDealBtnLoc;
    @FindBy(how = How.XPATH, using = "//*[@class='pb-4 px-5']/input")
    public WebElement upDealNameLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm')]")
    public WebElement upConfirmBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[@id='__BVID__40___BV_tab_button__']")
    public WebElement upMySavedDealsBtnLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='This is my deal']/parent::*")
    public WebElement upVerifyYourInfoPageLoc;

    // All the functions goes here
    public void upVerifyMyGarage() {
        waitForElementToBeVisible(upVerifyMyGarageLoc);
        boolean isDisplayed = upVerifyMyGarageLoc.isDisplayed();
        if (isDisplayed) {
            String act = upVerifyMyGarageLoc.getText();
            String exp = GlobalTestData.ECOM_REGISTRATION_FIRST_NAME + "'s " + "Garage";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("No Deal");
        }
    }
    public void upClickMyGarage() {
        waitForElementToBeVisible(upClickMyGarageLoc);
        upClickMyGarageLoc.click();
    }
    public void upClickMyAppointments() {
        waitForElementToBeVisible(upClickMyAppointmentsLoc);
        upClickMyAppointmentsLoc.click();
    }
    public void verifyNoAppointments() {
        waitForElementToBeVisible(verifyNoAppointmentsLoc);
        boolean isDisplayed = verifyNoAppointmentsLoc.isDisplayed();
        if (isDisplayed) {
            String act = verifyNoAppointmentsLoc.getText();
            String exp = "No Appointments Found!\n" +
                    "Check back in after you schedule an appointment.";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("Appointment Booked");
        }
    }
    public void upPopUp1() {
        waitForElementToBeClickable(upPopUp1Loc);
        upPopUp1Loc.click();
        hardWait(3000);
    }
    public void upPopUp2() {
        waitForElementToBeVisible(upPopUp2Loc);
        upPopUp2Loc.click();
        hardWait(3000);
    }
    public void upCar1() {
        waitForElementToBeVisible(upCar1Loc);
        upCar1Loc.click();
    }
    public void upOfferDetails() {
        hardWait(10000);
        waitForElementToBeClickable(upOfferDetailsLoc);
        upOfferDetailsLoc.click();
    }
    public void upTestDrive() {
        waitForElementToBeVisible(upTestDriveLoc);
        upTestDriveLoc.click();
        hardWait(10000);
    }
    public void upMyGarageHamburgerBtn() {
        waitForElementToBeVisible(upMyGarageHamburgerBtnLoc);
        upMyGarageHamburgerBtnLoc.click();
    }
    public void upCalenderClick() {
        waitForElementToBeVisible(upCalenderClickLoc);
        upCalenderClickLoc.click();
    }
    public void upAppointmentDate() {
       waitForElementToBeVisible(upDateClickLoc);
       upDateClickLoc.click();
    }
    public void upAppointmentTime() {
        select = new Select(upAppointmentTimeLOC);
        select.selectByIndex(1);
    }
    public void upSendBtn(){upSendBtnLOC.click();
    }
    public void upGetDirectionBtn() {
        waitForElementToBeVisible(upGetDirectionBtnLoc);
        upGetDirectionBtnLoc.click();
        hardWait(1000);
    }
    public void upVerifyLandedOnGoogleMap() {
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String GoogleMapPage= it.next();
        driver.switchTo().window(GoogleMapPage);
        Assert.assertEquals(driver.getTitle(), "Your location to 9350 W Atlantic Blvd, Coral Springs, FL 33071 - Google Maps");
    }
    public void upViewDetailsBtn() {
        waitForElementToBeVisible(upViewDetailsBtnLoc);
        upViewDetailsBtnLoc.click();
    }
    public void upCopyDealBtn() {
    waitForElementToBeVisible(upCopyDealBtnLoc);
        upCopyDealBtnLoc.click();
    }
    public void upDealName() {
        waitForElementToBeVisible(upDealNameLoc);
        upDealNameLoc.sendKeys("This is my deal");
    }
    public void upConfirmBtn() {
        waitForElementToBeVisible(upConfirmBtnLoc);
        upConfirmBtnLoc.click();
    }
    public void upVerifyDealName() {
        waitForElementToBeVisible(upVerifyYourInfoPageLoc);
        boolean isDisplayed = upVerifyYourInfoPageLoc.isDisplayed();
        if (isDisplayed) {
            String act = upVerifyYourInfoPageLoc.getText();
            String exp = "This is my deal edit";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("No Deal");
        }
    }
    public void upMySavedDealsBtn() {
        waitForElementToBeVisible(upMySavedDealsBtnLoc);
        upMySavedDealsBtnLoc.click();
    }
}