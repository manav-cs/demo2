package pageObject;
import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Upgrade_Vehicle_Details_page extends GenericFunctions {
    WebDriver driver;
    Select select;
    Actions actions;
    WebDriverWait wait;

    public Upgrade_Vehicle_Details_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//div[contains(@id,'upgrade')]")
    public WebElement upVehicleDetailsPageLoc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
    public WebElement upVehicleDetailsNextBtnLoc;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'view specs & features')]")
    public WebElement upSpecsFeaturesBtnLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='You May Also Like'])[1]/preceding::*[name()='svg'][3]")
    public WebElement upPictureBtnLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='You May Also Like'])[1]/preceding::*[name()='svg'][2]")
    public WebElement upVideoBtnLoc;
    @FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='You May Also Like'])[1]/preceding::*[name()='svg'][1]")
    public WebElement up360BtnLoc;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'keyboard_arrow_left')]")
    public WebElement upNewSearchBtnLoc;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'vehicle-card')])[3]")
    public WebElement upCar2Loc;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'You May Also Like')]")
    public WebElement upYouMayLikeBtnLoc;
    @FindBy(how = How.XPATH, using = "(//a[contains(@class,'similarVehicleLink mb-1')])[3]")
    public WebElement upCar1VehicleDetailPageLoc;

    /** Page Functions **/
    public void upVehicleDetailsPagePresent(){
        waitForElementToBeVisible(upVehicleDetailsPageLoc);
        hardWait(1000);
    }
    public void upVehicleDetailsNextBtn(){
        waitForElementToBeClickable(upVehicleDetailsNextBtnLoc);
        upVehicleDetailsNextBtnLoc.click();
        hardWait(1000);
    }
    public void upSpecsFeatures(){
        waitForElementToBeClickable(upSpecsFeaturesBtnLoc);
        upSpecsFeaturesBtnLoc.click();
        hardWait(1000);
        waitForElementToBeClickable(upPictureBtnLoc);
        upPictureBtnLoc.click();
        hardWait(1000);
        waitForElementToBeClickable(upVideoBtnLoc);
        upVideoBtnLoc.click();
        waitForElementToBeClickable(up360BtnLoc);
        up360BtnLoc.click();
    }
    public void upNewSearchBtn(){
        waitForElementToBeClickable(upNewSearchBtnLoc);
        upNewSearchBtnLoc.click();
    }
    public void upCar2() {
        waitForElementToBeVisible(upCar2Loc);
        upCar2Loc.click();
    }
    public void upYouMayLikeBtn() {
        waitForElementToBeClickable(upYouMayLikeBtnLoc);
        upYouMayLikeBtnLoc.click();
    }
    public void upCar1VehicleDetailPage() {
        waitForElementToBeClickable(upCar1VehicleDetailPageLoc);
        upCar1VehicleDetailPageLoc.click();
    }
}