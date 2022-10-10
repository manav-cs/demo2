package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static stepDef.Hook.scenario;

public class CSE_Garage_Appointments_page extends GenericFunctions {

    WebDriver driver;
    WebDriverWait wait;

    public CSE_Garage_Appointments_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* Page Locators */
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement cseDealPageEstimatedPaymentAmount;
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
    @FindBy(how = How.XPATH, using = "(//button[normalize-space()='Test Drive'])[1]")
    public WebElement cseDealPageTestDriveButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn mt-2')]")
    public WebElement cseDealPageTestDriveCreateAccountButton;
    /*Schedule Test Drive page*/
    @FindBy(how = How.XPATH, using = "//h1[contains(normalize-space(),'Schedule Test Drive')]")
    public WebElement cseScheduleTestDriveHeader;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'ymm-title')]")
    public WebElement cseScheduleTestDriveVehicleInfo;
    @FindBy(how = How.XPATH, using = "//span[@class='vin']")
    public WebElement cseScheduleTestDriveVin;
    @FindBy(how = How.XPATH, using = "//div[@class='dealer-name']")
    public WebElement cseScheduleTestDriveDealer;
    @FindBy(how = How.XPATH, using = "//div[text()=' When would you like to drive your ']//strong")
    public WebElement cseScheduleTestDriveWhenText;
    @FindBy(how = How.XPATH, using = "//span[@class='value']")
    public WebElement cseScheduleTestDriveDealerDistanceMiles;
    @FindBy(how = How.ID, using = "appointment-date__value_")
    public WebElement cseScheduleTestDriveDayField;
    @FindBy(how = How.ID, using = "appointment-date__dialog_")
    public WebElement cseScheduleTestDriveDayPopUp;
    @FindBy(how = How.XPATH, using = "//button[@title='Next month']")
    public WebElement cseScheduleTestCalendarNextMonth;
    @FindBy(how = How.XPATH, using = "//button[@title='Previous month']")
    public WebElement cseScheduleTestCalendarPreviousMonth;
    @FindBy(how = How.ID, using = "appointment-time-select")
    public WebElement cseScheduleTestDriveTime;
    @FindBy(how = How.XPATH, using = "//textarea[@title='Schedule Test Drive Question']")
    public WebElement cseScheduleTestQuestionBox;
    /*Schedule Drive confirmation page*/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Thank You.']")
    public WebElement cseScheduleTestConfirmationHeader;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Thank You.']")
    public WebElement cseScheduleTestConfirmationNumber;
    /*My Appointments My Garage */
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'appointment-date-time-dealer')]//span)[1]")
    public WebElement cseMyGarageAppointDate;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'dealer-name')]")
    public WebElement cseMyGarageAppointDealerName;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'appointment-vehicle')]//following-sibling::strong")
    public WebElement cseMyGarageAppointCarInfo;
    @FindBy(how = How.XPATH, using = "//a[@aria-label='Edit Appointment']")
    public WebElement cseMyGarageAppointmentEditLink;
    @FindBy(how = How.XPATH, using = "//span[text()=' View Details ']//parent::button")
    public WebElement cseMyGarageAppointmentViewDetails;

    /* Page Functions */
    public void cseGarageAppointDealerPage() {
        /*Retrieve vehicle information from DB*/
        String year = getCurrentYear();
        int thisYear = Integer.parseInt(year);
        int lastYear = Integer.parseInt(year)-1;

        GenericFunctions.dbSql(1,7,"select vi.vin,vi.make,vi.model,vi.year,vi.trim,d.name,d.dealer_id from vehicle_inventory vi LEFT JOIN dealers d on vi.dealer_id=d.id where vi.active = 'true' and vi.in_inventory='true' and vi.year in ('"+thisYear+"','"+lastYear+"') and vi.stock_type='NEW' and vi.internet_price > 0 and d.id in ('55c521b6-fc5e-47e3-bb10-ba14fe545308','b9c1c697-d17e-4cdc-a82c-a84d1f4d7157','cf16175f-1526-4fb6-8598-2fee65e6a2ff','500f87d74af4b50002000027') order by random() limit 1");
        System.out.println("Vin used for testing: "+GlobalTestData.SQL_QUERY[0][0]);
        scenario.log("VIN used for testing: "+GlobalTestData.SQL_QUERY[0][0]);
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

    public void cseGarageAppointDealerPageBuy() {
        /*Retrieve vehicle information from DB*/
        String year = getCurrentYear();
        int thisYear = Integer.parseInt(year);
        int lastYear = Integer.parseInt(year)-1;
        GenericFunctions.dbSql(1,7,"select vi.vin,vi.make,vi.model,vi.year,vi.trim,d.name,d.dealer_id from vehicle_inventory vi LEFT JOIN dealers d on vi.dealer_id=d.id where vi.active = 'true' and vi.in_inventory='true' and vi.year in ('"+thisYear+"','"+lastYear+"') and vi.stock_type='NEW' and vi.internet_price > 0 and vi.in_transit='false' and vi.vin not like 'JTHCA%' and d.id in ('500f87d74af4b50002000027') order by random() limit 1");
        System.out.println("Vin being used for testing: "+GlobalTestData.SQL_QUERY[0][0]);
        scenario.log("Vin being used for testing: "+GlobalTestData.SQL_QUERY[0][0]);
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

    public void cseGarageAppointTestDrive(){
        cseDealPageTestDriveButton.click();
        waitForElementToBeClickable(cseDealPageTestDriveCreateAccountButton);
    }

    public void cseGarageAppointCreateAccountButton() {
        cseDealPageTestDriveCreateAccountButton.click();
    }

    public void cseGarageAppointScheduleTestDrivePage() {
        waitForElementToBeVisible(cseScheduleTestDriveHeader);
        Assert.assertEquals(cseScheduleTestDriveVehicleInfo.getText().trim(),GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2],"Car information is not present on Schedule Test Drive page: ");
        Assert.assertEquals(cseScheduleTestDriveVin.getText().trim(),"VIN: "+GlobalTestData.SQL_QUERY[0][0], "The VIN is not present on the Schedule Test Drive page: ");
        Assert.assertEquals(cseScheduleTestDriveDealer.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"The Dealer Name is not present on the Schedule Test Drive page: ");
        String [] Distance = cseScheduleTestDriveDealerDistanceMiles.getText().trim().split(" ");
        Assert.assertEquals(Distance[1],"Miles","The 'Miles' text for Distance from Dealer is not present: ");
        Assert.assertFalse(Distance[0].isEmpty(),"There is no distance from the dealer on the Schedule Test Drive page: ");
        Assert.assertTrue(cseScheduleTestDriveWhenText.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2]),"The text 'When would you like to drive your "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2]+" ?' is incorrect: ");
    }

    public void cseGarageAppointScheduleTestDrive(int future) {
        cseScheduleTestDriveDayField.click();
        wait.until(ExpectedConditions.attributeToBe(cseScheduleTestDriveDayPopUp,"class","dropdown-menu show"));
        /*Determine date to be entered based on the number passed in*/
        GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = getDate(future);
        System.out.println();
        System.out.println("Date before formatting: "+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE);
        System.out.println();
        GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.replace("/0","/");
        if(GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.startsWith("0")){
            GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.substring(1);
            System.out.println("After removing first zero: "+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE);
        }
        /*If the chosen date is not visible, click the next-month icon*/
        if(!GenericFunctions.isElementPresent(driver.findElement(By.xpath("//div[@aria-label='"+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE+"']")))){
            cseScheduleTestCalendarNextMonth.click();
        }
        driver.findElement(By.xpath("//div[@aria-label='"+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE+"']")).click();
        /*Select a time*/
        Select select = new Select(cseScheduleTestDriveTime);
        select.selectByIndex(2);
        GlobalTestData.SCHEDULE_TEST_DRIVE_TIME = cseScheduleTestDriveTime.getAttribute("value").toLowerCase();
        /*Enter text in the question field*/
        cseScheduleTestQuestionBox.sendKeys("Automation test drive days in future: "+future);
        /*Submit form*/
        GenericFunctions.clickButtonByText("Send");
        waitForElementToBeVisible(cseScheduleTestConfirmationHeader);
    }

    public void cseGarageAppointScheduleTestDriveInPast() {
        cseScheduleTestDriveDayField.click();
        wait.until(ExpectedConditions.attributeToBe(cseScheduleTestDriveDayPopUp,"class","dropdown-menu show"));
        /*Determine date to be entered based on the number passed in*/
        GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = getDate(-1);
        System.out.println();
        System.out.println("Date before formatting: "+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE);
        System.out.println();
        GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.replace("/0","/");
        if(GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.startsWith("0")){
            GlobalTestData.SCHEDULE_TEST_DRIVE_DATE = GlobalTestData.SCHEDULE_TEST_DRIVE_DATE.substring(1);
            System.out.println("After removing first zero: "+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE);
        }
    }

    public void cseGarageAppointScheduleTestDriveInPastAssert(){
        /*If the chosen date is not visible*/
        if(!GenericFunctions.isElementPresent(driver.findElement(By.xpath("//div[@aria-label='"+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE+"']")))){
            cseScheduleTestCalendarPreviousMonth.click();
            Assert.assertFalse(GenericFunctions.isElementPresent(driver.findElement(By.xpath("//div[@aria-label='" + GlobalTestData.SCHEDULE_TEST_DRIVE_DATE + "']"))), "No date in the past is available to set an appointment: ");
        }
        driver.findElement(By.xpath("//div[@aria-label='"+GlobalTestData.SCHEDULE_TEST_DRIVE_DATE+"']")).click();
        Assert.assertEquals(cseScheduleTestDriveDayPopUp.getAttribute("class"),"dropdown-menu show","Calendar pop up on Schedule Test Drive closed after clicking day in the past: ");
    }

    public void cseGarageAppointScheduleTestDriveConfirmation() {
        Assert.assertEquals(cseScheduleTestDriveVehicleInfo.getText().trim(),GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2],"Car information is not present on Schedule Test Drive page: ");
        Assert.assertEquals(cseScheduleTestDriveVin.getText().trim(),"VIN: "+GlobalTestData.SQL_QUERY[0][0], "The VIN is not present on the Schedule Test Drive page: ");
        /*Remember the confirmation number*/
        GlobalTestData.SCHEDULE_TEST_DRIVE_CONF_NUMBER = cseScheduleTestConfirmationNumber.getText().trim();
    }

    public void cseGarageAppointmentSectionInfo() {
        /*Vehicle info in appointment section*/
        Assert.assertEquals(cseMyGarageAppointCarInfo.getText().trim(),GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2],"The appointment car information is incorrect: ");
        /*Verify Appointment data*/
        GlobalTestData.SCHEDULE_TEST_DRIVE_LONG_DATE = getDayOfWeek(1)+", "+fullDate(GlobalTestData.SCHEDULE_TEST_DRIVE_DATE);
        Assert.assertEquals(cseMyGarageAppointDate.getText().trim(),GlobalTestData.SCHEDULE_TEST_DRIVE_LONG_DATE,"The Appointment date in the Appointments section in My Garage is incorrect: ");
        //Commented out until lwe can set a specific time zone throughout
        //Assert.assertEquals(cseMyGarageAppointTime.getText().trim(),GlobalTestData.SCHEDULE_TEST_DRIVE_TIME,"The appointment time in the Appointments section in My Garage is incorrect: ");
        Assert.assertEquals(cseMyGarageAppointDealerName.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"The Dealer Name listed in the Appointments section in My Garage is incorrect: ");
    }

    public void cseVerifyLandedOnGoogleMap() {
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String GoogleMapPage= it.next();
        driver.switchTo().window(GoogleMapPage);
        Assert.assertTrue(driver.getTitle().contains("Your location to"),"Google maps did not open when clicking Get Directions: ");
    }

    public void cseEditAppointment() {
        cseMyGarageAppointmentEditLink.click();
    }

    public void cseViewDetailsButton() {
        waitForElementToBeVisible(cseMyGarageAppointmentViewDetails);
        cseMyGarageAppointmentViewDetails.click();
    }
}
