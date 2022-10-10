package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CSE_Get_Approved_page extends GenericFunctions {

    WebDriver driver;
    WebDriverWait wait;

    public CSE_Get_Approved_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*Deal Page locators*/
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement cseDealPageDealValue;
    /* Page Locators */
    @FindBy(how = How.XPATH, using = "//h1[contains(@class,'page-title')]")
    public WebElement cseGetApprovedHeader;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Back to Deal']")
    public WebElement cseGetApprovedBackToDealButton;
    /*Get Approved Getting Started iframe elements*/
    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Getting Started']")
    public WebElement cseGetApprovedLoanGettingStartedInfoHeader;
    @FindBy(how = How.ID, using = "ctl00_mainContent_GettingStarted1_loan_type")
    public WebElement cseGetApprovedLoanDropDown;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_first_name")
    public WebElement cseGetApprovedLoanFirstName;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_last_name")
    public WebElement cseGetApprovedLoanLastName;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_email")
    public WebElement cseGetApprovedLoanEmail;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_conf_email")
    public WebElement cseGetApprovedLoanEmail2;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_addr1")
    public WebElement cseGetApprovedLoanStreet;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_city")
    public WebElement cseGetApprovedLoanCity;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_state")
    public WebElement cseGetApprovedLoanState;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_zip")
    public WebElement cseGetApprovedLoanZip;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_elapsed_time_year")
    public WebElement cseGetApprovedLoanYears;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_elapsed_time_month")
    public WebElement cseGetApprovedLoanMonths;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_residence_status")
    public WebElement cseGetApprovedLoanResidentStatus;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Primaryapplicant1_Residencecurrent1_rc_monthly_payment")
    public WebElement cseGetApprovedLoanMonthlyAmount;
    @FindBy(how = How.ID, using = "ctl00_mainContent_BtnCSSContinue_btnCSSPostback")
    public WebElement cseGetApprovedLoanContinueButton;
    /*Employment Information iframe elements*/
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_cur_employment_status")
    public WebElement cseGetApprovedLoanEmployStatus;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_cur_occupation")
    public WebElement cseGetApprovedLoanOccupation;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_cur_emp_name")
    public WebElement cseGetApprovedLoanEmployer;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_work_phone")
    public WebElement cseGetApprovedLoanWorkPhone;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_ec_elapsed_time_year")
    public WebElement cseGetApprovedLoanWorkYears;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_ec_elapsed_time_month")
    public WebElement cseGetApprovedLoanWorkMonths;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Employercurrent1_cur_Income")
    public WebElement cseGetApprovedLoanWorkIncome;
    /*Vehicle Information iframe elements*/
    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Vehicle Information']")
    public WebElement cseGetApprovedLoanVehicleInfoHeader;

    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_new_used_N")
    public WebElement cseGetApprovedLoanVehicleType;
    @FindBy(how = How.XPATH, using = "//label[@for='ctl00_mainContent_Loanamountvehiclel1_pro_new_used_N']")
    public WebElement cseGetApprovedLoanVehicleTypeLabel;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_cash_down")
    public WebElement cseGetApprovedLoanFinanceDownPay;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_new_used_N")
    public WebElement cseGetApprovedLoanFinanceVehicleType;
    @FindBy(how = How.XPATH, using = "//label[@for='ctl00_mainContent_Loanamountvehiclep1_pro_new_used_N']")
    public WebElement cseGetApprovedLoanFinanceVehicleTypeLabel;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_year")
    public WebElement cseGetApprovedLoanVehicleYear;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_make")
    public WebElement cseGetApprovedLoanVehicleMake;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_model")
    public WebElement cseGetApprovedLoanVehicleModel;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_trim")
    public WebElement cseGetApprovedLoanVehicleTrim;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclel1_pro_trade_in_N")
    public WebElement cseGetApprovedLoanVehicleTradeIn;

    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_year")
    public WebElement cseGetApprovedFinanceLoanVehicleYear;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_make")
    public WebElement cseGetApprovedFinanceLoanVehicleMake;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_model")
    public WebElement cseGetApprovedFinanceLoanVehicleModel;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_trim")
    public WebElement cseGetApprovedFinanceLoanVehicleTrim;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Loanamountvehiclep1_pro_trade_in_N")
    public WebElement cseGetApprovedFinanceLoanVehicleTradeIn;

    /*Account Setup page*/
    @FindBy(how = How.XPATH, using = "//div[normalize-space()='AUTHORIZATION']")
    public WebElement cseGetApprovedLoanAccountSetupHeader;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Acctsetup1_dob")
    public WebElement cseGetApprovedLoanAccountSetupDateOfBirthField;
    @FindBy(how = How.ID, using = "ctl00_mainContent_Acctsetup1_ssn")
    public WebElement cseGetApprovedLoanAccountSetupSsnField;
    @FindBy(how = How.XPATH, using = "//iframe[contains(@src,'https://resources.hdf-application.com')]")
    public WebElement cseGetApprovedLoanAccountSetupDiscloseIframe;
    @FindBy(how = How.ID, using = "english")
    public WebElement cseGetApprovedLoanAccountSetupEnglishDisclose;
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'decision-generator')]")
    public WebElement cseGetApprovedLoanAccountSetupDecisionLink;
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'finance-options')]")
    public WebElement cseGetApprovedLoanAccountSetupJumpToOptions;
    /*Decision Generator*/
    @FindBy(how = How.XPATH, using = "//h1[text()='Decision Generator']")
    public WebElement cseGetApprovedLoanDecisionGenHeader;
    @FindBy(how = How.ID, using = "lender-select-1")
    public WebElement cseGetApprovedLoanLenderName;
    @FindBy(how = How.ID, using = "lender-approval-1")
    public WebElement cseGetApprovedLoanApprovedDropdown;
    @FindBy(how = How.ID, using = "cancel-label")
    public WebElement cseGetApprovedCancelLabel;
    /*Lease Options page*/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Lease Options']")
    public WebElement cseGetApproveLeaseOptions;
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Finance Options']")
    public WebElement cseGetApproveFinanceOptions;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'ymm-title')]")
    public WebElement cseGetApproveLeaseVehicleInfo;
    @FindBy(how = How.XPATH, using = "//span[@class='vin']")
    public WebElement cseGetApproveLeaseVehicleVin;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'finance-company')]")
    public WebElement cseGetApproveLeaseBankCheckBox;
    /*Sign & Drive page*/
    @FindBy(how = How.XPATH, using = "//h1[text()='Sign & Drive']")
    public WebElement cseGetApproveLeaseSignDriveHeader;
    @FindBy(how = How.ID, using = "firstName")
    public WebElement cseGetApproveLeaseSignDriveFirstName;
    @FindBy(how = How.ID, using = "lastName")
    public WebElement cseGetApproveLeaseSignDriveLastName;
    @FindBy(how = How.ID, using = "phoneNumber")
    public WebElement cseGetApproveLeaseSignDrivePhone;
    @FindBy(how = How.ID, using = "email")
    public WebElement cseGetApproveLeaseSignDriveEmail;
    @FindBy(how = How.XPATH, using = "//span[text()='Sign At Dealership']")
    public WebElement cseGetApproveLeaseSignDriveDealershipButton;
    @FindBy(how = How.XPATH, using = "//span[text()='Deliver It']")
    public WebElement cseGetApproveLeaseSignDriveDeliver;
    @FindBy(how = How.XPATH, using = "//div[@class='text-capitalize mb-1']")
    public WebElement cseGetApproveLeaseSignDriveDeliveryAddress;
    @FindBy(how = How.XPATH, using = "//div[text()=' Order Confirmed ']")
    public WebElement cseGetApproveLeaseOrderConfirmHeader;
    /*Certificate after vehicle sale*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'customer-name')]")
    public WebElement cseGetApproveLeaseOrderCertificateUserName;
    @FindBy(how = How.XPATH, using = "//div[@class='address']")
    public WebElement cseGetApproveLeaseOrderCertificateUserAddress;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'pending')]")
    public WebElement cseGetApproveLeaseOrderContractPending;


    /* Page Functions */
    public void cseGetApprovedPagePresent(){
        waitForElementToBeVisible(cseGetApprovedHeader);
    }
    public void cseGetApprovedBackToDeal() {
        cseGetApprovedBackToDealButton.click();
        waitForElementToBeVisible(cseDealPageDealValue);
    }

    public void cseGetApprovedPageElements() {
        /*Switch to iframe with form fields*/
        driver.switchTo().frame(0);
        /**/
        Assert.assertEquals(cseGetApprovedLoanDropDown.getText().trim(),"Lease Auto", "The Loan/Finance Type drop down is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanFirstName.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_FIRST_NAME,"The user's first name is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanLastName.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_LAST_NAME,"The user's last name is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanEmail.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase(),"The user's email is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanStreet.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_ADDRESS+",","The user's street address on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanCity.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_CITY,"The user's city on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanState.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_STATE,"The user's state on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanZip.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_ZIPCODE,"The user's ZIP code on the Get Approved form is incorrect: ");
    }

    public void cseGetApprovedPageFinanceElements() {
        /*Switch to iframe with form fields*/
        driver.switchTo().frame(0);
        /**/
        Assert.assertEquals(cseGetApprovedLoanDropDown.getText().trim(),"New or Used Auto (Dealer)", "The Loan/Finance Type drop down is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanFirstName.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_FIRST_NAME,"The user's first name is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanLastName.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_LAST_NAME,"The user's last name is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanEmail.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase(),"The user's email is not present in the Get Approved form: ");
        Assert.assertEquals(cseGetApprovedLoanStreet.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_ADDRESS+",","The user's street address on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanCity.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_CITY,"The user's city on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanState.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_STATE,"The user's state on the Get Approved form is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanZip.getAttribute("value").trim(), GlobalTestData.ECOM_REGISTRATION_ZIPCODE,"The user's ZIP code on the Get Approved form is incorrect: ");
    }

    public void cseSubmitGetApprovedInfo(){
        /*Confirm email*/
        cseGetApprovedLoanEmail2.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase());
        /*Time at residence*/
        cseGetApprovedLoanYears.sendKeys("5");
        cseGetApprovedLoanMonths.sendKeys("1");
        Select select = new Select(cseGetApprovedLoanResidentStatus);
        select.selectByVisibleText("Own");
        cseGetApprovedLoanMonthlyAmount.sendKeys("2000");
        cseGetApprovedLoanContinueButton.click();
    }

    public void cseSubmitGetApprovedEmployInfo(){
        driver.switchTo().defaultContent();
        hardWait(1000);
        driver.switchTo().frame(0);
        Select select = new Select(cseGetApprovedLoanEmployStatus);
        select.selectByVisibleText("Employed");
        cseGetApprovedLoanOccupation.sendKeys("Automation Tester");
        cseGetApprovedLoanEmployer.sendKeys("CarSaver");
        cseGetApprovedLoanWorkPhone.sendKeys("6155673525");
        Assert.assertEquals(cseGetApprovedLoanWorkPhone.getAttribute("value"),"615-567-3525","The Get Approved Employment Information form did not place dashes inside the phone number: ");
        cseGetApprovedLoanWorkYears.sendKeys("5");
        cseGetApprovedLoanWorkMonths.sendKeys("1");
        cseGetApprovedLoanWorkIncome.sendKeys("85000");
        Assert.assertEquals(cseGetApprovedLoanWorkIncome.getAttribute("value"),"85,000","The Get Approved Employment Information gross yearly income field did not input a comma within the amount entered: ");
        cseGetApprovedLoanContinueButton.click();
        waitForElementToBeVisible(cseGetApprovedLoanVehicleInfoHeader);
    }

    public void cseSubmitGetApprovedVehicleInfo(){
        Assert.assertEquals(cseGetApprovedLoanVehicleType.getAttribute("checked"),"true","The 'New' radio button on the vehicle information portion of Get Approved is not selected: ");
        Assert.assertEquals(cseGetApprovedLoanVehicleTypeLabel.getText().trim(),"New","The 'New' radio button on the vehicle information portion of Get Approved is not labeled correctly: ");
        Assert.assertEquals(cseGetApprovedLoanVehicleYear.getAttribute("value"),GlobalTestData.SQL_QUERY[0][3],"The vehicle year on the Vehicle Information portion of Get Approved is incorrect: ");
        Assert.assertEquals(cseGetApprovedLoanVehicleMake.getText().trim(),GlobalTestData.SQL_QUERY[0][1],"The vehicle make on the Vehicle Information portion of Get Approved is incorrect: ");
        Assert.assertFalse(cseGetApprovedLoanVehicleModel.getAttribute("value").isEmpty(),"The vehicle model on the Vehicle Information portion of Get Approved is empty: ");
        Assert.assertFalse(cseGetApprovedLoanVehicleTrim.getAttribute("value").isEmpty(),"The vehicle trim on the Vehicle Information portion of Get Approved is empty: ");
        Assert.assertEquals(cseGetApprovedLoanVehicleTradeIn.getAttribute("value"),"N","The Trade-In vehicle radio button on the Vehicle Information portion of Get Approved is not 'N': ");
        Assert.assertEquals(cseGetApprovedLoanVehicleTradeIn.getAttribute("checked"),"true","The Trade-In vehicle radio button on the Vehicle Information portion of Get Approved is not selected: ");
        cseGetApprovedLoanContinueButton.click();
        driver.switchTo().defaultContent();
        hardWait(1000);
        driver.switchTo().frame(0);
        waitForElementToBeVisible(cseGetApprovedLoanAccountSetupHeader);
    }

    public void cseSubmitGetApprovedFinanceVehicleInfo(){
        Assert.assertEquals(cseGetApprovedLoanFinanceDownPay.getAttribute("value").trim(),GlobalTestData.CSE_DOWN_PAYMENT_VALUE.trim().replace("$","").replace(" ","".replace(",","")),"The Down Payment amount is incorrect on the Gat Approved application: ");
        Assert.assertEquals(cseGetApprovedLoanFinanceVehicleType.getAttribute("checked"),"true","The 'New' radio button on the vehicle information portion of Get Approved is not selected: ");
        Assert.assertEquals(cseGetApprovedLoanFinanceVehicleTypeLabel.getText().trim(),"New","The 'New' radio button on the vehicle information portion of Get Approved is not labeled correctly: ");
        Assert.assertEquals(cseGetApprovedFinanceLoanVehicleYear.getAttribute("value"),GlobalTestData.SQL_QUERY[0][3],"The vehicle year on the Vehicle Information portion of Get Approved is incorrect: ");
        Assert.assertEquals(cseGetApprovedFinanceLoanVehicleMake.getText().trim(),GlobalTestData.SQL_QUERY[0][1],"The vehicle make on the Vehicle Information portion of Get Approved is incorrect: ");
        Assert.assertFalse(cseGetApprovedFinanceLoanVehicleModel.getAttribute("value").isEmpty(),"The vehicle model on the Vehicle Information portion of Get Approved is empty: ");
        Assert.assertFalse(cseGetApprovedFinanceLoanVehicleTrim.getAttribute("value").isEmpty(),"The vehicle trim on the Vehicle Information portion of Get Approved is empty: ");
        Assert.assertEquals(cseGetApprovedFinanceLoanVehicleTradeIn.getAttribute("value"),"N","The Trade-In vehicle radio button on the Vehicle Information portion of Get Approved is not 'N': ");
        Assert.assertEquals(cseGetApprovedFinanceLoanVehicleTradeIn.getAttribute("checked"),"true","The Trade-In vehicle radio button on the Vehicle Information portion of Get Approved is not selected: ");
        cseGetApprovedLoanContinueButton.click();
        driver.switchTo().defaultContent();
        hardWait(1000);
        driver.switchTo().frame(0);
        waitForElementToBeVisible(cseGetApprovedLoanAccountSetupHeader);
    }

    public void cseSubmitGetApprovedAccountSetUp(){
        driver.switchTo().frame(cseGetApprovedLoanAccountSetupDiscloseIframe);
        Assert.assertTrue(cseGetApprovedLoanAccountSetupEnglishDisclose.getText().contains("Last Updated: 03/06/2018"),"The English disclosure text is incorrect: ");
    }

    public void cseSubmitGetApprovedGoodDecision() {
        /*Switch back to regular window*/
        driver.switchTo().defaultContent();
        hardWait(1000);
        cseGetApprovedLoanAccountSetupDecisionLink.click();
        ArrayList<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(1));
        waitForElementToBeVisible(cseGetApprovedLoanDecisionGenHeader);
        Select lender = new Select(cseGetApprovedLoanLenderName);
        lender.selectByVisibleText("Chase");
        Select approve = new Select(cseGetApprovedLoanApprovedDropdown);
        approve.selectByVisibleText("Approved");
        GenericFunctions.clickButtonByText("Generate Decisions");
        waitForElementToBeVisible(cseGetApprovedCancelLabel);
        driver.close();
        driver.switchTo().window(win.get(0));
        cseGetApprovedLoanAccountSetupJumpToOptions.click();
    }

    public void waitForLeaseOptionsPage(){
        waitForElementToBeVisible(cseGetApproveLeaseOptions);
    }

    public void waitForFinanceOptionsPage(){
        waitForElementToBeVisible(cseGetApproveFinanceOptions);
    }

    public void cseGetApprovedLeadeOptionsPage() {
        Assert.assertTrue(cseGetApproveLeaseVehicleInfo.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"The vehicle information on the lease options page is incorrect: ");
        Assert.assertEquals(cseGetApproveLeaseVehicleVin.getText().trim(),"VIN: "+GlobalTestData.SQL_QUERY[0][0],"The VIN on the Lease Options page is incorrect: ");
        Assert.assertEquals(cseGetApproveLeaseBankCheckBox.getText().trim(),"Chase","The financial institution on the Lease Options page is incorrect: ");
    }

    public void cseGetApprovedLeaseOptionsSubmit() {
        cseGetApproveLeaseBankCheckBox.click();
        GenericFunctions.clickButtonByText("Next");
        waitForElementToBeVisible(cseGetApproveLeaseSignDriveHeader);
    }

    public void cseGetApprovedLeaseOptionsSignDrive() {
        Assert.assertEquals(cseGetApproveLeaseSignDriveFirstName.getAttribute("value").toLowerCase(),GlobalTestData.ECOM_REGISTRATION_FIRST_NAME.toLowerCase(),"The User first name on Sign & Drive is incorrect: ");
        Assert.assertEquals(cseGetApproveLeaseSignDriveLastName.getAttribute("value").toLowerCase(),GlobalTestData.ECOM_REGISTRATION_LAST_NAME.toLowerCase(),"The User last name on Sign & Drive is incorrect: ");
        Assert.assertEquals(cseGetApproveLeaseSignDrivePhone.getAttribute("value"),GlobalTestData.ECOM_REGISTRATION_MOBILE_FORMATTED,"The User phone on Sign & Drive is incorrect: ");
        Assert.assertEquals(cseGetApproveLeaseSignDriveEmail.getAttribute("value").toLowerCase(),GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase(),"The User email on Sign & Drive is incorrect: ");
        cseGetApproveLeaseSignDriveDealershipButton.click();
        cseGetApproveLeaseSignDriveDeliver.click();
        Assert.assertEquals(cseGetApproveLeaseSignDriveDeliveryAddress.getText().trim(),GlobalTestData.ECOM_REGISTRATION_ADDRESS+"\n" +GlobalTestData.ECOM_REGISTRATION_CITY+", "+GlobalTestData.ECOM_REGISTRATION_STATE+" "+GlobalTestData.ECOM_REGISTRATION_ZIPCODE,"The delivery address on the Sign & Drive page is incorrect: ");
        GenericFunctions.clickButtonByText("Next");
        waitForElementToBeVisible(cseGetApproveLeaseOrderConfirmHeader);
    }

    public void cseGetApprovedConfirmationPage() {
        Assert.assertTrue(cseGetApproveLeaseVehicleInfo.getText().contains(GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]),"The vehicle information on the confirmation page is incorrect: ");
        GenericFunctions.clickButtonByText("View Certificate");
        waitForElementToBeVisible(cseGetApproveLeaseOrderCertificateUserName);
        Assert.assertEquals(cseGetApproveLeaseOrderCertificateUserName.getText().trim().toLowerCase(),GlobalTestData.ECOM_REGISTRATION_FIRST_NAME.toLowerCase()+" "+GlobalTestData.ECOM_REGISTRATION_LAST_NAME.toLowerCase());
        Assert.assertEquals(cseGetApproveLeaseOrderCertificateUserAddress.getText().trim(),GlobalTestData.ECOM_REGISTRATION_ADDRESS+", "+GlobalTestData.ECOM_REGISTRATION_CITY+", "+GlobalTestData.ECOM_REGISTRATION_STATE+", "+GlobalTestData.ECOM_REGISTRATION_ZIPCODE);
    }

    public void cseSavedDealsLeasedVehicle() {
        Assert.assertEquals(cseGetApproveLeaseOrderContractPending.getText().trim(),"Contract Pending","The Contract Pending text is not present on the Saved Deals page: ");
    }
}
