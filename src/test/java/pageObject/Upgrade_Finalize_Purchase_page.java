package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Upgrade_Finalize_Purchase_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    WebDriverWait wait;

    public Upgrade_Finalize_Purchase_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='Apply For Credit']")
    public WebElement upApplyForCreditBtnLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='vehicle-card col-sm-12 col-md-5']//button[normalize-space()='Apply For Credit']")
    public WebElement upApplyForCreditBtn2Loc;
    @FindBy(how = How.ID, using = "ctl00_mainContent_BtnCSSContinue_btnCSSPostback")
    public WebElement upGetApprovedLoanContinueBtnLoc;
    @FindBy(how = How.XPATH, using = "//div[normalize-space()='AUTHORIZATION']")
    public WebElement upGetApprovedLoanAccountSetupHeaderLoc;

    /** Page function **/
    public void upApplyForCreditBtn(){
        waitForElementToBeVisible(upApplyForCreditBtnLoc);
        upApplyForCreditBtnLoc.click();
    }
    public void upApplyForCreditBtn2(){
        waitForElementToBeVisible(upApplyForCreditBtn2Loc);
        upApplyForCreditBtn2Loc.click();
        hardWait(10000);
    }
    public void upSubmitGetApprovedVehicleInfo(){
        upGetApprovedLoanContinueBtnLoc.click();
        driver.switchTo().defaultContent();
        hardWait(1000);
        driver.switchTo().frame(0);
        waitForElementToBeVisible(upGetApprovedLoanAccountSetupHeaderLoc);
    }
}
