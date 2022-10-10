package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CSE_Deal_Contact_Dealer_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;

    public CSE_Deal_Contact_Dealer_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }

    /*Page Locators*/
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Contact Dealer']")
    public WebElement cseDealPageGetTradeOfferButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'navbar-brand')]//span")
    public WebElement cseDealPageDealerNameInHeader;
    @FindBy(how = How.XPATH, using = "//h1[@class='ymm']")
    public WebElement cseDealPageVehicleInfo;
    @FindBy(how = How.XPATH, using = "//span[@class='vin']")
    public WebElement cseDealPageVehicleVin;
    /*Sign In Modal locators*/
    @FindBy(how = How.ID, using = "create-account-modal___BV_modal_content_")
    public WebElement cseDealSignInModal;
    @FindBy(how = How.XPATH, using = "//div[@class='title mb-1']")
    public WebElement cseDealSignInModalHeader;
    @FindBy(how = How.XPATH, using = "//button[@aria-label='Close']")
    public WebElement cseDealSignInModalCloseIcon;
    /*Contact Dealer page*/
    @FindBy(how = How.XPATH, using = "//h1[text()='Contact Dealer']")
    public WebElement cseContactDealerHeader;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'ymm')]")
    public WebElement cseContactDealerVehicleInfo;
    @FindBy(how = How.XPATH, using = "//span[@class='trim']")
    public WebElement cseContactDealerVehicleTrim;
    @FindBy(how = How.XPATH, using = "//div[@class='dealer-name']")
    public WebElement cseContactDealerDealerName;
    @FindBy(how = How.ID, using = "dealer-questions")
    public WebElement cseContactDealerTextArea;
    @FindBy(how = How.ID, using = "question-type")
    public WebElement cseContactDealerQuestionDropDown;
    /*Contact Dealer Confirmation page*/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Thank You.']")
    public WebElement cseContactDealerConfirmationHeader;
    @FindBy(how = How.XPATH, using = "//div[@class='confirmation pt-2']")
    public WebElement cseContactDealerCertId;
    /*Certificate page*/
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'confirmation-id')]")
    public WebElement cseContactDealerCertificateId;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'purchase-ymm')]")
    public WebElement cseContactDealerCertificateVehicleInfo;
    @FindBy(how = How.XPATH, using = "//div[text()=' VIN: ']//span")
    public WebElement cseContactDealerCertificateVin;
    /*Saved Deals page*/
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Garage')]")
    public WebElement cseContactDealerSavedDealHeader;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'mr-auto')]//strong")
    public WebElement cseContactDealerSavedDealVehicleInfo;



    /*Page Functions*/
    public void cseDealPageActiveTabButtonClick(String buttonName){
        driver.findElement(By.xpath("//div[@class='tab-pane active']//button[normalize-space()='"+buttonName+"']")).click();
    }

    public void cseDealPageSignInModalPresent() {
        waitForElementToBeVisible(cseDealSignInModal);
        Assert.assertEquals(cseDealSignInModalHeader.getText().trim(),"BUY@HOME BENEFITS","The Sign In modal's header is incorrect: ");
    }

    public void cseDealPageSignInModalClose() {
        cseDealSignInModalCloseIcon.click();
        waitForElementToBeInVisible(cseDealSignInModal);
    }

    public void cseDealPageRetrieveDealerAndVehicleInfo() {
        GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO = GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2];
    }

    public void cseContactDealerPage() {
        waitForElementToBeVisible(cseContactDealerHeader);
    }

    public void cseContactDealerPageVehicleInfo(){
        Assert.assertEquals(cseContactDealerVehicleInfo.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO,"The vehicle information on the contact dealer page is incorrect: ");
        Assert.assertEquals(cseDealPageVehicleVin.getText().trim(),"VIN: "+GlobalTestData.SQL_QUERY[0][0],"The vehicle VIN on the contact dealer page is incorrect: ");
    }

    public void cseContactDealerDealerName(){
        Assert.assertEquals(cseContactDealerDealerName.getText().trim(),GlobalTestData.SQL_QUERY[0][5],"The Dealer name on the contact dealer page is incorrect: ");
    }

    public void cseContactDealerDropDownFunctionality(String dropdownOption){
        Select select = new Select(cseContactDealerQuestionDropDown);
        select.selectByVisibleText(dropdownOption);
        Assert.assertFalse(cseContactDealerTextArea.getAttribute("value").isEmpty(),"The Text Area is still disabled after selecing an option in the Question About dropdown: ");
    }

    public void cseContacDealerTextAreaDisabled(){
        Assert.assertEquals(cseContactDealerTextArea.getAttribute("disabled"),"true","The Text Area is not disabled prior to selecting an option in the Question About dropdown: ");
    }

    public void cseContactDealerTextAreaDefaultVehicleAvailability(){
        Assert.assertEquals(cseContactDealerTextArea.getAttribute("value"),"I’d like to know if the New "+GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO+" "+cseContactDealerVehicleTrim.getText().trim()+" you have listed on your site is still available.","The Vehicle Availability default text is incorrect: ");
    }

    public void cseContactDealerTextAreaAddText(String textAdd){
        cseContactDealerTextArea.sendKeys(" "+textAdd);
    }

    public void cseContactDealerTextAreaDefault(String textArea){
        Assert.assertEquals(cseContactDealerTextArea.getAttribute("value").trim(),textArea,"The Vehicle Availability default text is incorrect: ");
    }

    public void cseContactDealerConfirmationPage(){
        waitForElementToBeVisible(cseContactDealerConfirmationHeader);
        Assert.assertEquals(cseContactDealerVehicleInfo.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO,"The vehicle information on the Contact Dealer Confirmation page is incorrect: ");
        Assert.assertEquals(cseDealPageVehicleVin.getText().trim(),"VIN: "+GlobalTestData.SQL_QUERY[0][0],"The vehicle VIN on the contact dealer confirmation page is incorrect: ");
        String[] certId = cseContactDealerCertId.getText().trim().split(" ");
        String[] certIdUrl = getCurrentUrl().split("/");
        Assert.assertEquals(certId[2],certIdUrl[4],"The certificate number on the contact dealer confirmation page is incorrect: ");
    }

    public void cseContactDealerConfirmationViewCertificate(){
        waitForElementToBeVisible(cseContactDealerCertificateId);
        String[] certIdUrl = getCurrentUrl().split("/");
        Assert.assertEquals(cseContactDealerCertificateId.getText().trim(),"Certificate #: "+certIdUrl[4],"The Certificate ID on the Certificate page after contacting the dealer is incorrect: ");
        Assert.assertEquals(cseContactDealerCertificateVehicleInfo.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO,"The vehicle information on the certificate page after contacting the dealer is incorrect: ");
        Assert.assertEquals(cseContactDealerCertificateVin.getText().trim(),GlobalTestData.SQL_QUERY[0][0],"The VIN is incorrect on the certificate page after contacting the dealer: ");
    }

    public void cseContactDealerSavedDealAfterContact() {
        waitForElementToBeVisible(cseContactDealerSavedDealHeader);
        Assert.assertEquals(cseContactDealerSavedDealVehicleInfo.getText().trim(),GlobalTestData.CSE_DEAL_PAGE_VEHICLE_INFO,"Vehicle information is incorrect after saving a deal after contacting the dealer: ");
    }
}
