package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CSE_Garage_Address_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;
    Select select;
    WebDriverWait wait;

    public CSE_Garage_Address_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//h1[text()='Update Address']")
    public WebElement neGarageAddressHeader;
    @FindBy(how = How.XPATH, using = "//label[@for='address']")
    public WebElement neGarageAddressStreetFldLbl;
    @FindBy(how = How.ID, using = "address")
    public WebElement neGarageAddressStreet;
    @FindBy(how = How.ID, using = "city")
    public WebElement neGarageAddressCity;
    @FindBy(how = How.ID, using = "state")
    public WebElement neGarageAddressState;
    @FindBy(how = How.ID, using = "zipCode")
    public WebElement neGarageAddressZip;
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    public WebElement neGarageMyAddressUpdateButton;
    @FindBy(how = How.XPATH, using = "//h5")
    public WebElement neConfirmAddressModalHeader;

    /** Page Functions **/
    public void clickGarageNavOption(String linkName) {
        hardWait(500);
        driver.findElement(By.xpath("//ul[@role='tablist']//a[normalize-space(text())='"+linkName+"']")).click();
    }

    public void garageUpdateAddressStreet(String address){
        Assert.assertEquals(neGarageAddressStreet.getAttribute("value"),address,"Stored address for Automation login user is incorrect: ");
    }
    
    public void garageUpdateAddressCity(String city){
        Assert.assertEquals(neGarageAddressCity.getAttribute("value"),city,"Stored city for Automation login user is incorrect: ");
    }
    
    public void garageUpdateAddressState(String state){
        Assert.assertEquals(neGarageAddressState.getAttribute("value"),state,"Stored state for Automation login user is incorrect: ");
    }
    
    public void garageUpdateAddressZip(String zip){
        Assert.assertEquals(neGarageAddressZip.getAttribute("value"),zip,"Stored zip for Automation login user is incorrect: ");
    }

    public void garageChangeAddressField(String newStreet){
        neGarageAddressStreet.clear();
        neGarageAddressStreet.sendKeys(newStreet);
    }
    
    public void garageChangeCityField(String newCity){
        neGarageAddressCity.clear();
        neGarageAddressCity.sendKeys(newCity);
    }
    
    public void garageChangeStateField(String newState){
        select = new Select(neGarageAddressState);
        select.selectByValue(newState);
    }
    
    public void garageChangeZipField(String newZip){
        neGarageAddressZip.clear();
        neGarageAddressZip.sendKeys(newZip);
    }
    
    public void garageMyAccountUpdateButton(){
        neGarageMyAddressUpdateButton.click();
    }
    
    public void garageUpdateAddressVerify() {
        waitForElementToBeVisible(neGarageAddressHeader);
        waitForElementToBeVisible(neGarageAddressStreetFldLbl);
        Assert.assertEquals(neGarageAddressHeader.getText().trim(),"Update Address","The Update Address header is not correct, BUG! ");
    }
    
    public void garageUpdateAddressErrorMessage(String errorMessage) {
        WebElement error = driver.findElement(By.xpath("//div[@class='invalid-feedback' and normalize-space(text())='"+errorMessage+"']"));
        Assert.assertEquals(error.getText().trim(),errorMessage,errorMessage+" error message is incorrect, BUG! ");
    }
    
    public void garageConfirmAddressModal(){
        waitForElementToBeVisible(neConfirmAddressModalHeader);
    }

}
