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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Objects;

import static stepDef.Hook.scenario;

public class CSE_Garage_MyAccount_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public CSE_Garage_MyAccount_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Update Account']")
    public WebElement neGarageMyAccountHeader;
    @FindBy(how = How.XPATH, using = "//label[@for='firstName']")
    public WebElement neGarageMyAccountNameLabel;
    @FindBy(how = How.ID, using = "firstName")
    public WebElement neGarageMyAccountFirstNameField;
    @FindBy(how = How.ID, using = "lastName")
    public WebElement neGarageMyAccountLastNameField;
    @FindBy(how = How.ID, using = "phoneNumber")
    public WebElement neGarageMyAccountPhoneField;
    @FindBy(how = How.ID, using = "email")
    public WebElement neGarageMyAccountEmailField;
    @FindBy(how = How.XPATH, using = "//label[@for='sms']")
    public WebElement neGarageMyAccountSmsCheckBox;
    @FindBy(how = How.ID, using = "sms")
    public WebElement neGarageMyAccountSmsChecked;
    @FindBy(how = How.CSS, using = "div[class='button-block d-flex justify-content-center align-items-center mb-2 mb-md-0'] button[type='submit']")
    public WebElement neGarageMyAccountUpdateButton;

    /** Page Functions **/
    public void garageMyAccountHeader(){
        waitForElementToBeVisible(neGarageMyAccountHeader);
        waitForElementToBeVisible(neGarageMyAccountNameLabel);
    }

    public void garageMyAccountFirstNameField() {
        Assert.assertEquals(neGarageMyAccountFirstNameField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_FIRST_NAME);
    }

    public void garageMyAccountLastNameField() {
        Assert.assertEquals(neGarageMyAccountLastNameField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
    }

    public void garageMyAccountPhoneField() {
        Assert.assertEquals(neGarageMyAccountPhoneField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_MOBILE_FORMATTED);
    }

    public void garageMyAccountEmailField() {
        Assert.assertEquals(neGarageMyAccountEmailField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase());
    }

    public void garageMyAccountFirstNameFieldChange() {
        GlobalTestData.ECOM_REGISTRATION_FIRST_NAME = GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+" Update";
        neGarageMyAccountFirstNameField.clear();
        neGarageMyAccountFirstNameField.sendKeys(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME);
    }

    public void garageMyAccountLastNameFieldChange() {
        GlobalTestData.ECOM_REGISTRATION_LAST_NAME = GlobalTestData.ECOM_REGISTRATION_LAST_NAME+" Update";
        neGarageMyAccountLastNameField.clear();
        neGarageMyAccountLastNameField.sendKeys(GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
    }

    public void garageMyAccountPhoneFieldChange() {
        GlobalTestData.ECOM_REGISTRATION_MOBILE = "(615) 567-4444";
        neGarageMyAccountPhoneField.clear();
        neGarageMyAccountPhoneField.sendKeys(GlobalTestData.ECOM_REGISTRATION_MOBILE_UPDATED);
    }

    public void garageMyAccountEmailFieldChange() {
        GlobalTestData.ECOM_REGISTRATION_EMAIL = "update"+GlobalTestData.ECOM_REGISTRATION_EMAIL;
        neGarageMyAccountEmailField.clear();
        neGarageMyAccountEmailField.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase());
    }

    public void garageMyAccountFirstNameFieldUpdated() {
        Assert.assertEquals(neGarageMyAccountFirstNameField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_FIRST_NAME);
    }

    public void garageMyAccountLastNameFieldUpdated() {
        Assert.assertEquals(neGarageMyAccountLastNameField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
    }

    public void garageMyAccountPhoneFieldUpdated() {
        Assert.assertEquals(neGarageMyAccountPhoneField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_MOBILE);
    }

    public void garageMyAccountEmailFieldUpdated() {
        Assert.assertEquals(neGarageMyAccountEmailField.getAttribute("value"), GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase());
    }

    public void garageMyAccountUpdateButton() {
        neGarageMyAccountUpdateButton.click();
    }

    public void garageMyAccountSmsCheckBox() {
        neGarageMyAccountSmsCheckBox.click();
    }

    public void garageMyAccountSmsVerifyCheckBox(boolean selected){
        if (selected){
            Assert.assertTrue(neGarageMyAccountSmsChecked.isSelected());
        }else{
            Assert.assertFalse(neGarageMyAccountSmsChecked.isSelected());
        }
    }

    public void garageMyAccountBlankName(String id) {
        driver.findElement(By.id(id)).clear();
        if(Objects.equals(id, "phoneNumber")){
            driver.findElement(By.id(id)).sendKeys(" ");
        }

    }

    public void garageMyAccountBadEmail(String email){
        neGarageMyAccountEmailField.clear();
        neGarageMyAccountEmailField.sendKeys(email);
    }

    public void garageMyAccountErrorMessages(String id,String message) {
        if (id.equals("email")) {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='email' and @aria-invalid='true']//following-sibling::div//div[contains(@class,'invalid-feedback')]")).getText().trim(), message, "The error message for " + id + "is incorrect: ");
        }else if(id.equalsIgnoreCase("first name")) {
            id = "firstName";
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='" + id + "' and @aria-invalid='true']//following-sibling::div[@class='invalid-feedback']")).getText().trim(), message, "The error message for " + id + "is incorrect: ");
        }else if (id.equalsIgnoreCase("last name")) {
            id = "lastName";
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='" + id + "' and @aria-invalid='true']//following-sibling::div[@class='invalid-feedback']")).getText().trim(), message, "The error message for " + id + "is incorrect: ");
        }else if(id.equalsIgnoreCase("phone")){
            id = "phoneNumber";
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='"+id+"' and @aria-required='true']//following-sibling::div[@class='invalid-feedback']")).getText().trim(),message,"The error message for "+id+ "is incorrect: ");
        }else{
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='"+id+"' and @aria-invalid='true']//following-sibling::div[@class='invalid-feedback']")).getText().trim(),message,"The error message for "+id+ "is incorrect: ");
        }
    }

    public void garageRememberOldEmail() {
        GlobalTestData.ECOM_REGISTRATION_OLD_EMAIL = GlobalTestData.ECOM_REGISTRATION_EMAIL;
    }

    public void garageUpdateOldEmail() {
        neGarageMyAccountEmailField.clear();
        neGarageMyAccountEmailField.sendKeys(GlobalTestData.ECOM_REGISTRATION_OLD_EMAIL.toLowerCase());
    }

    public void garageUpdateEmailToInvalidFormat(String email) {
        neGarageMyAccountEmailField.clear();
        neGarageMyAccountEmailField.sendKeys(email.toLowerCase());
        System.out.println("Email used: "+email);
        scenario.log("Email used: "+email);
    }

}
