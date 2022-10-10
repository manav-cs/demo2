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

public class CSE_Garage_Password_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public CSE_Garage_Password_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Update Password']")
    public WebElement cseGarageMyPasswordHeader;
    @FindBy(how = How.XPATH, using = "//label[@for='old-password']")
    public WebElement cseGarageOldPasswordLabel;
    @FindBy(how = How.ID, using = "old-password")
    public WebElement cseGarageOldPasswordField;
    @FindBy(how = How.XPATH, using = "//label[@for='password']")
    public WebElement cseGarageNewPasswordLabel;
    @FindBy(how = How.ID_OR_NAME, using = "password")
    public WebElement cseGarageNewPasswordField;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'mt-4')]//button")
    public WebElement cseGarageUpdatePassword;
    @FindBy(how = How.ID, using = "email")
    public WebElement cseGarageEmailLogin;

    /** Page Functions **/
    public void cseGarageMyPasswordHeader() {
        waitForElementToBeVisible(cseGarageMyPasswordHeader);
        waitForElementToBeVisible(cseGarageOldPasswordLabel);
        Assert.assertEquals(cseGarageOldPasswordLabel.getText().trim(),"Old Password*","Old Password field is labeled incorrectly: ");
        Assert.assertEquals(cseGarageNewPasswordLabel.getText().trim(),"New Password*","New Password field is labeled incorrectly: ");
    }

    public void cseGarageUpdatePasswordButton(){
        cseGarageUpdatePassword.click();
    }

    public void cseGaragePasswordErrorMessage(String msg) {
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='invalid-feedback' and normalize-space()='"+msg+"']"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    public void cseGarageOldPasswordUpdate(){
        cseGarageOldPasswordField.clear();
        cseGarageOldPasswordField.sendKeys(GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }

    public void cseGarageNewPasswordUpdate(){
        GlobalTestData.ECOM_LOGIN_PASSWORD = GlobalTestData.ECOM_REGISTRATION_PASSWORD+"update";
        cseGarageNewPasswordField.clear();
        cseGarageNewPasswordField.sendKeys(GlobalTestData.ECOM_LOGIN_PASSWORD);
    }

    public void cseLoginWithEmail(){
        cseGarageEmailLogin.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL);
    }

    public void cseEnterUpdatePassword(){
        cseGarageNewPasswordField.sendKeys(GlobalTestData.ECOM_LOGIN_PASSWORD);
    }

}
