package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Upgrade_Recently_Viewed_page extends GenericFunctions {
    WebDriver driver;
    WebDriverWait wait;

    public Upgrade_Recently_Viewed_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//*[@id='__BVID__44']/div/div/div[1]")
    public WebElement upVerifyNoVehicleLoc;
    @FindBy(how = How.XPATH, using = "//div[@class='tab-pane active']//button[normalize-space()='View Deal']")
    public WebElement upVerifyViewDealLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='__BVID__44']//div[2]//div/div[2]")
    public WebElement upVerifyStockTypeLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='__BVID__44']//div[1]/div[2]/div[2]/div/div[3]")
    public WebElement upVerifyMilageLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='__BVID__44']//div[1]//div[2]//div[4]")
    public WebElement upVerifyColorLoc;
    @FindBy(how = How.XPATH, using = "//*[@id='__BVID__44']//div[1]/div[2]//div[5]")
    public WebElement upVerifyDealerLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Recently Viewed Vehicles')]")
    public WebElement upRecentlyViewedVehicleBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Saved Deals')]")
    public WebElement upVerifySavedDealsLoc;
    @FindBy(how = How.XPATH, using = "//button[@title='remove']")
    public WebElement upMyGarageDeleteDealIconLoc;


    /** Page function **/
    public void upVerifyNoVehicle() {
        Assert.assertEquals(upVerifyNoVehicleLoc.getText().trim(), "No Recent Vehicles Found!\n" + "Check back in after you do some browsing.", "Recent Vehicles Found");
    }
    public void upVerifyViewDeal() {
        Assert.assertEquals(upVerifyViewDealLoc.getText().trim(), "View Deal", "No Recent Vehicles Found");
    }
    public void upVerifyStockType() {
        Assert.assertEquals(upVerifyStockTypeLoc.getText().trim(), "Stock Type:\n" + "NEW", "Recent Vehicles Found");
    }
    public void upVerifyMilage() {
        Assert.assertEquals(upVerifyMilageLoc.getText().trim(), "Mileage:\n" + "0", "Recent Vehicles Found");
    }
    public void upVerifyColor() {
        Assert.assertEquals(upVerifyColorLoc.getText().trim(), "Exterior Color:\n" + "Other", "Recent Vehicles Found");
    }
    public void upVerifyDealer() {
        Assert.assertEquals(upVerifyDealerLoc.getText().trim(), "Dealer:\n" + "Coral Springs Nissan", "Recent Vehicles Found");
    }
    public void upRecentlyViewedVehicleBtn() {
        waitForElementToBeVisible(upRecentlyViewedVehicleBtnLoc);
        upRecentlyViewedVehicleBtnLoc.click();
    }
    public void upVerifySavedDeals(){
        waitForElementToBeVisible(upVerifySavedDealsLoc);
        Assert.assertEquals(upVerifySavedDealsLoc.getText().trim(),"Saved Deals (1)","Saved Deals link on My Garage page ");
    }
    public void upMyGarageDeleteDealIcon(){
        waitForElementToBeVisible(upMyGarageDeleteDealIconLoc);
        upMyGarageDeleteDealIconLoc.click();
    }
}
