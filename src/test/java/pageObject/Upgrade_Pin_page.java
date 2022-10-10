package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepDef.Hook;

import static stepDef.Hook.scenario;

public class Upgrade_Pin_page extends GenericFunctions {
    WebDriver driver;

    public Upgrade_Pin_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*Page Locators*/
    @FindBy(how = How.XPATH, using = "//h2[contains(@class,'value-prop')]")
    public WebElement upgradeHeader;
    @FindBy(how = How.ID, using = "pin-label")
    public WebElement upgradePinLabel;
    @FindBy(how = How.ID, using = "pin-message")
    public WebElement upgradePinMessage;
    @FindBy(how = How.XPATH, using = "//h1[contains(@class,'title-text')]")
    public WebElement upgradeVerifyIdentityHeader;
    @FindBy(how = How.ID, using = "pin")
    public WebElement upgradeHomePagePinField;
    @FindBy(how = How.XPATH, using = "//*[@id='pin-invalid-feedback']")
    public WebElement upgradeHomePagePinErrorMesage;
    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Get Started']")
    public WebElement upgradeCreateLoginHeader;
    @FindBy(how = How.XPATH, using = "//a[contains(@class,'get-started')]")
    public WebElement upgradeNoProspectGetStartedButton;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement upgradePinFieldGoButton;
    @FindBy(how = How.ID, using = "no-pin-prospect-label")
    public WebElement upgradeNoProspectTrueHeader;
    @FindBy(how = How.ID, using = "contactOption")
    public WebElement upgradeMfaDropDownMenu;
    @FindBy(how = How.ID, using = "mfaCode")
    public WebElement upgradeMfaInputField;
    @FindBy(how = How.XPATH, using = "//h1[contains(@class,'title-text')]")
    public WebElement upgradeHelloWelcomeHeader;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Welcome to your personalized upgrade website!']")
    public WebElement upgradeHelloWelcomeSubheader;

    /*Garage elements*/
    @FindBy(how = How.XPATH, using = "//h1[contains(@class,'page-title')]")
    public WebElement upGetApprovedHeader;


    /*Page Functions*/
    public void upPinOnUrl(){
        /*Get campaign from database*/
        String[] campName = Hook.url.split("//");
        GenericFunctions.dbSql(1,1,"select id from campaigns where domain='"+campName[1]+"';");
        System.out.println("Campaign is: "+campName[1]);
        String campId = GlobalTestData.SQL_QUERY[0][0];
        /*Get PIN from table and put into its own array*/
        GenericFunctions.dbSql(1,4,"select pin,first_name,last_name,email from upgrade_prospects where campaign_id='"+campId+"' and pin_expiration_date is null and pin_used='false' order by random() limit 1;");
        GlobalTestData.UPGRADE_PIN_INFO = new String[1][GlobalTestData.SQL_QUERY.length];
        System.arraycopy(GlobalTestData.SQL_QUERY,0,GlobalTestData.UPGRADE_PIN_INFO,0,GlobalTestData.SQL_QUERY.length);
        System.out.println("PIN for testing: "+GlobalTestData.UPGRADE_PIN_INFO[0][0]);
        scenario.log("PIN for testing: "+GlobalTestData.UPGRADE_PIN_INFO[0][0]);
    }

    public void updatePinUsedColumn(){
        GenericFunctions.dbSql(1, 1, "update upgrade_prospects set pin_used='false',mfa=null,mfa_used='false' where pin='" + GlobalTestData.UPGRADE_PIN_INFO[0][0] + "'");
    }

    public void gotoUpgradePinUrl(String pinParam){
        driver.get(Hook.url+pinParam);
        waitForElementToBeVisible(upgradeHeader);
    }

    public void upVerifyValidPinInfoHomePage(){
        Assert.assertEquals(upgradePinLabel.getText().trim(),"Hello, "+GlobalTestData.UPGRADE_PIN_INFO[0][1]+"!","The user's first name for pin "+GlobalTestData.UPGRADE_PIN_INFO[0][0]+" is incorrect on the home page");
        Assert.assertEquals(upgradePinMessage.getText().trim(),"Welcome to your personal vehicle upgrade website.","The sub-header beneath the user's name is incorrect: ");
    }

    public void upVerifyIdentityHeader(){
        waitForElementToBeVisible(upgradeVerifyIdentityHeader);
        Assert.assertEquals(upgradeVerifyIdentityHeader.getText().trim(),"Let's verify your identity.","The verify identity page header is incorrect: ");
    }

    public void upVerifyBadPinHomePage(String errorMsg){
        Assert.assertTrue(upgradeHomePagePinField.getAttribute("class").contains("is-invalid"),"The PIN field is not displaying error conditions when it should: ");
        Assert.assertEquals(upgradeHomePagePinErrorMesage.getText().trim(),errorMsg,"The PIN error message is incorrect. Should be: ");
    }
    public void upVerifyScrollOffsetPin(){
        hardWait(1000);
        JavascriptExecutor j = (JavascriptExecutor) driver;
        long v = (long) j.executeScript("return window.pageYOffset;");
        Assert.assertTrue(v>155 & v<163,"The page did not scroll properly after clicking PIN button. Position was "+v+" but expected around 158: ");
        System.out.println("Scroll position after clicking Get Started: "+v);
    }

    public void upVerifyNoPinProspectPage(){
        Assert.assertFalse(GenericFunctions.isElementPresent(upgradeHomePagePinField),"The PIN field is present when it should not be: ");
        Assert.assertEquals(upgradeNoProspectTrueHeader.getText().trim(),"Welcome to your personal vehicle upgrade website.","The sub-header beneath the user's name is incorrect: ");
    }

    public void upVerifyHeaderCreateLoginPage(){
        waitForElementToBeVisible(upgradeCreateLoginHeader);
        Assert.assertEquals(upgradeCreateLoginHeader.getText().trim(),"Get Started","The create login page does not have the proper header text: ");
    }

    public void upVerifyNoPinProspectStartButton(){
        upgradeNoProspectGetStartedButton.click();
    }

    public void upVerifySubmitPinFromField(){
        upPinOnUrl();
        upgradeHomePagePinField.sendKeys(GlobalTestData.UPGRADE_PIN_INFO[0][0]);
    }

    public void upVerifySubmitGoButtonForPinField(){
        upgradePinFieldGoButton.click();
    }

    public void upVerifyHeaderUsersGarage(){
        Assert.assertTrue(upGetApprovedHeader.getText().contains("Garage"),"The user's garage is not present: ");
    }

    public void upVerifyNoPinPassedHeader(){
        Assert.assertEquals(upgradePinLabel.getText().trim(),"Enter your PIN to get started.");
    }

    public void upMfaMenuEmail(String contactType){
        Select select = new Select(upgradeMfaDropDownMenu);
        select.selectByValue(contactType);
    }

    public void upSubmitMfa(){
        waitForElementToBeVisible(upgradeMfaInputField);
        GenericFunctions.dbSql(1,1,"select mfa from upgrade_prospects where pin='"+GlobalTestData.UPGRADE_PIN_INFO[0][0]+"';");
        upgradeMfaInputField.sendKeys(GlobalTestData.SQL_QUERY[0][0]);
        GenericFunctions.clickButtonByText("Go");
    }

    public void upPinWelcomePage(){
        waitForElementToBeVisible(upgradeHelloWelcomeSubheader);
        Assert.assertEquals(upgradeHelloWelcomeHeader.getText().trim(),"Hello "+GlobalTestData.UPGRADE_PIN_INFO[0][1]+"!","The welcome header after submitting correct MFA is incorrect: ");
    }
}
