package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
public class Upgrade_Contact_Dealer_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    WebDriverWait wait;

    public Upgrade_Contact_Dealer_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "(//span[contains(text(),'Contact Dealer')])[1]")
    public WebElement upContactDealerBtnLoc;
    @FindBy(how = How.ID, using = "question-type")
    public WebElement upSelectPricingLOC;
    @FindBy(how = How.XPATH, using = "//textarea[@id='dealer-questions']")
    public WebElement upMessageToDealerLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='hero-overlay']//div[2]//div[1]//div[2]/div/span[1]")
    public WebElement upVerifyCertificateNumberLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='View Certificate']/parent::*")
    public WebElement upViewCertificateBtnLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='confirmation-page']/div[3]/div[2]/div/div[1]")
    public WebElement upCustomerNameLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='confirmation-page']/div[3]/div[2]//div[2]/div[1]/div")
    public WebElement upCustomerAddressLoc;
    @FindBy(how = How.XPATH, using = "//div[@id='confirmation-page']/div[3]/div[2]/div/div[2]/div[2]/div[2]")
    public WebElement upCustomerPhoneNumberLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='confirmation-page']/div[3]/div[2]//div[2]/div[2]/div[1]")
    public WebElement upCustomerEmailLoc;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Contact Us')]")
    public WebElement upContactUsBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'(844) 651-0761')]")
    public WebElement upVerifyContactUsNumberLoc;

    /** Page function **/
    public void upContactDealerBtn() {
        waitForElementToBeVisible(upContactDealerBtnLoc);
        upContactDealerBtnLoc.click();
    }
    public void upSelectPricing() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(1);
    }
    public void upSelectVehicleAvailability() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(2);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("Is this vehicle avaliable?");
    }
    public void upSelectFinancing() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(3);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("Is 0% APR avaliable for this vehicle?");
    }
    public void upSelectContactDealerTradeIn() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(4);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("Is this the best offer for my trade-in?");
    }
    public void upSelectReservingThisVehicle() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(5);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("I want to reserve this vehicle.");
    }
    public void upSelectOther() {
        select = new Select(upSelectPricingLOC);
        select.selectByIndex(6);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("What other special financing is available?");
    }
    public void upClearDealName() {
        waitForElementToBeVisible(upMessageToDealerLoc);
        upMessageToDealerLoc.click();
        upMessageToDealerLoc.clear();
        upMessageToDealerLoc.sendKeys("Do you do price matching?");
    }
    public void upViewCertificateBtn() {
        waitForElementToBeVisible(upViewCertificateBtnLoc);
        upViewCertificateBtnLoc.click();
    }
    public void upVerifyCertificateNumber() {
        Assert.assertEquals(upVerifyCertificateNumberLoc.getText().trim(), "Certificate #:", "Recent Vehicles Found");
    }
    public void upVerifyCertificate() {
        hardWait(10000);
        Assert.assertEquals(upCustomerNameLoc.getText().trim().toLowerCase(),GlobalTestData.ECOM_REGISTRATION_FIRST_NAME.toLowerCase()+" "+GlobalTestData.ECOM_REGISTRATION_LAST_NAME.toLowerCase());
        Assert.assertEquals(upCustomerAddressLoc.getText().trim(),GlobalTestData.ECOM_REGISTRATION_ADDRESS+", "+GlobalTestData.ECOM_REGISTRATION_CITY+", "+GlobalTestData.ECOM_REGISTRATION_STATE+", "+GlobalTestData.ECOM_REGISTRATION_ZIPCODE);
        Assert.assertEquals(upCustomerPhoneNumberLoc.getText().trim(),"Phone: " + GlobalTestData.ECOM_REGISTRATION_MOBILE_FORMATTED);
        Assert.assertEquals(upCustomerEmailLoc.getText().trim(),"Email: " + GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase());
    }
    public void upContactUsBtn() {
        waitForElementToBeVisible(upContactUsBtnLoc);
        upContactUsBtnLoc.click();
    }
    public void upVerifyContactUsNumber() {
        Assert.assertEquals(upVerifyContactUsNumberLoc.getText().trim(),"(844) 651-0761", "Recent Vehicles Found");
    }
}