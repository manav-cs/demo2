package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Upgrade_Offer_Details_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    WebDriverWait wait;

    public Upgrade_Offer_Details_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'keyboard_arrow_left')]")
    public WebElement upVehicleDetailsTopNevLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Vehicle Details']")
    public WebElement upVehicleDetailsRightNevLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Get Trade Value']")
    public WebElement upGetTradeValueBtnLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Get Financing']")
    public WebElement upGetFinancingBtnLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='maincontent']//div[2]/div/div[2]/div/div[3]/div[1]")
    public WebElement upDisclaimer1Loc;
    @FindBy(how = How.XPATH, using = "//*[@id='maincontent']//div[2]/div/div[2]/div/div[3]/div[2]")
    public WebElement upDisclaimer2Loc;
    @FindBy(how = How.XPATH, using = "//*[@id='maincontent']//div[2]//div[3]/div[3]")
    public WebElement upDisclaimer3Loc;
    @FindBy(how = How.XPATH, using = "//*[@id='maincontent']//div[2]//div[3]/div[4]")
    public WebElement upDisclaimer4Loc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//span[@class='value']")
    public WebElement upDealPageDealValueLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='maincontent']//div[6]//h2")
    public WebElement upVerifyOfferDetailsPageLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Terms of Use')]")
    public WebElement upTermsOfUseLoc;
    @FindBy(how = How.XPATH, using = "//*[normalize-space(text()) and normalize-space(.)='Privacy Policy']")
    public WebElement upPrivacyPolicyLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Do Not Sell My Info'])[1]/preceding::a[2]")
    public WebElement upPrivacyPolicyLoginPageLoc;
    @FindBy(how = How.XPATH, using = "(//*[normalize-space(text()) and normalize-space(.)='California Privacy Policy'])")
    public WebElement upCaliforniaPrivacyPolicyLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Do Not Sell My Info')]")
    public WebElement upDoNotSellMyLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Terms'])[1]")
    public WebElement upTermLinkPageLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]")
    public WebElement upPrivacyPolicyLinkPageLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Terms of Service'])")
    public WebElement upTermServiceLinkPageLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Privacy Policy.')]")
    public WebElement upPrivacyLinkAccountPageLoc;



    /** Page function **/
    public void upVehicleDetailsTopNev(){
        waitForElementToBeVisible(upVehicleDetailsTopNevLoc);
        upVehicleDetailsTopNevLoc.click();
    }
    public void upVehicleDetailsRightNev(){
        waitForElementToBeVisible(upVehicleDetailsRightNevLoc);
        upVehicleDetailsRightNevLoc.click();
    }
    public void upGetTradeValueBtn(){
        waitForElementToBeVisible(upGetTradeValueBtnLoc);
        upGetTradeValueBtnLoc.click();
        hardWait(10000);
    }
    public void upGetFinancingBtn(){
        hardWait(10000);
        waitForElementToBeClickable(upGetFinancingBtnLoc);
        upGetFinancingBtnLoc.click();
        hardWait(10000);
    }
    public void upVerifyDisclaimer(){
        hardWait(10000);
        Assert.assertEquals(upDisclaimer1Loc.getText().trim(),"1 CarSaver and its affiliates do not buy automobiles or negotiate individual transactions. Trade in values communicated through this site are based upon information regarding vehicle specifications, mileage and/or condition provided by customer. Values may be adjusted based upon on-sight inspection of the vehicle by the dealer. Vehicle value may also be affected or the trade-in may be rejected in certain limited circumstances due to, among other things, vehicle history reports.","No Disclaimer Found");
        Assert.assertEquals(upDisclaimer2Loc.getText().trim(),"2 Shown for informational purposes only. Subject to final approval by Coral Springs Nissan.","No Disclaimer Found");
        Assert.assertEquals(upDisclaimer3Loc.getText().trim(),"3 Subject to final inspection. Actual lease balance may vary. All lease agreements will require a disposition fee in the amount of $395 with the exception of the following state specific regulations: WI($395 or 1 monthly payment, whichever is less), CO,IA,KS,ME,OK,WV,WY ($395 or 2 times the monthly payment, whichever is less), IN & SC ($395 or 3 times the monthly payment, whichever is less)","No Disclaimer Found");
        Assert.assertEquals(upDisclaimer4Loc.getText().trim(),"* Stipulations apply. Please check with the Certified Nissan dealer for complete details.","No Disclaimer Found");
    }
    public void upVerifyOfferDetailsPage() {
        hardWait(10000);
        Assert.assertEquals(upVerifyOfferDetailsPageLoc.getText().trim(), "Offer Details2", "Not Offer Details page");
    }
    public void upTermsOfUse(){
        waitForElementToBeClickable(upTermsOfUseLoc);
        upTermsOfUseLoc.click();
        Assert.assertEquals(driver.getTitle(), "Upgrade - Terms of Service");
    }
    public void upPrivacyPolicy(){
        waitForElementToBeClickable(upPrivacyPolicyLoc);
        upPrivacyPolicyLoc.click();
        Assert.assertEquals(driver.getTitle(), "Upgrade - Privacy Policy");
        hardWait(10000);
    }
    public void upPrivacyPolicyLoginPage(){
        waitForElementToBeClickable(upPrivacyPolicyLoginPageLoc);
        upPrivacyPolicyLoginPageLoc.click();
        Assert.assertEquals(driver.getTitle(), "Upgrade - Privacy Policy");
        hardWait(10000);
    }
    public void upCaliforniaPrivacyPolicy(){
        waitForElementToBeClickable(upCaliforniaPrivacyPolicyLoc);
        upCaliforniaPrivacyPolicyLoc.click();
        Assert.assertEquals(driver.getTitle(), "Upgrade - California Privacy Policy");
    }
    public void upDoNotSellMy(){
        waitForElementToBeClickable(upDoNotSellMyLoc);
        upDoNotSellMyLoc.click();
        Assert.assertEquals(driver.getTitle(), "Upgrade - California Privacy Policy");
    }
    public void upBackDealPage() {
        backPage();
    }
    public void upTermLinkPage(){
        upTermLinkPageLoc.click();
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String TermLinkPage= it.next();
        driver.switchTo().window(TermLinkPage);
        Assert.assertEquals(driver.getTitle(), "Upgrade - Terms of Service");
        driver.switchTo().window(TermLinkPage).close();
        driver.switchTo().window(UpGaragePageId);
    }
    public void upPrivacyPolicyLinkPage(){
        upPrivacyPolicyLinkPageLoc.click();
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String PolicyLinkPage= it.next();
        driver.switchTo().window(PolicyLinkPage);
        Assert.assertEquals(driver.getTitle(), "Upgrade - Privacy Policy");
        driver.switchTo().window(PolicyLinkPage).close();
        driver.switchTo().window(UpGaragePageId);
    }
    public void upTermServiceLinkPage(){
        upTermServiceLinkPageLoc.click();
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String TermServiceLinkPage= it.next();
        driver.switchTo().window(TermServiceLinkPage);
        Assert.assertEquals(driver.getTitle(), "Upgrade - Terms of Service");
        driver.switchTo().window(TermServiceLinkPage).close();
        driver.switchTo().window(UpGaragePageId);
    }
    public void upPrivacyLinkAccountPage(){
        upPrivacyLinkAccountPageLoc.click();
        Set<String> test = driver.getWindowHandles();
        Iterator<String> it= test.iterator();
        String UpGaragePageId= it.next();
        String PrivacyLinkAccountPage= it.next();
        driver.switchTo().window(PrivacyLinkAccountPage);
        Assert.assertEquals(driver.getTitle(), "Upgrade - Privacy Policy");
        driver.switchTo().window(PrivacyLinkAccountPage).close();
        driver.switchTo().window(UpGaragePageId);
    }

}