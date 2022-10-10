package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Atlas_Login_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;
    public Atlas_Login_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }
    // All the locators goes here
    @FindBy(how = How.NAME, using = "username")
    public WebElement atlasLoginEmailLoc;
    @FindBy(how = How.NAME, using = "password")
    public WebElement atlasLoginPasswordLoc;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement atlasLoginButtonLoc;
    @FindBy(how = How.XPATH, using = "//h1")
    public WebElement atlasWelcomeMsgLoc;
    @FindBy(how = How.XPATH, using = "//i")
    public WebElement atlasLogoutIconLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='No account found for this email and password.']/parent::*")
    public WebElement atlasInvalidCredentialsLoc;


    // All the functions goes here
    public void atlasEnterEmailAddress(String email){
        atlasLoginEmailLoc.sendKeys(email);
    }
    public void atlasEnterPassword(String password){
        atlasLoginPasswordLoc.sendKeys(password);
    }
    public void atlasClickLoginButton(String buttonName ){
        GenericFunctions.jsClick(driver.findElement(By.xpath("//*[contains(text(),'"+buttonName+"')]")));
    }
    public void atlasClickLoginButton( ){
        atlasLoginButtonLoc.click();
    }
    public void atlasVerifyLoginSuccessMessage(String expMessage){
        waitForElementToBeVisible(atlasWelcomeMsgLoc);
        boolean isDisplayed = atlasWelcomeMsgLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = atlasWelcomeMsgLoc.getText();
            Assert.assertEquals(actMessage, expMessage);
        } else {
            Assert.fail("User was NOT able login into Atlas! ===> BUG");
        }
    }
    public void atlasClickLogoutIcon( ){
        atlasLogoutIconLoc.click();
    }

    public void atlasVerifyLoginScreenMessage(String expMessage){
        waitForElementToBeVisible(atlasWelcomeMsgLoc);
        boolean isDisplayed = atlasWelcomeMsgLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = atlasWelcomeMsgLoc.getText();
            Assert.assertEquals(actMessage, expMessage);
        } else {
            Assert.fail("User was NOT able Logout from Atlas! ===> BUG");
        }
    }

    public void atlasVerifyInvalidCredentialsMessage(String expMessage){
        waitForElementToBeVisible(atlasInvalidCredentialsLoc);
        boolean isDisplayed = atlasInvalidCredentialsLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = atlasInvalidCredentialsLoc.getText();
            Assert.assertEquals(actMessage, expMessage);
        } else {
            Assert.fail("User was able to login with invalid credentials in Atlas! ===> BUG");
        }
    }

}













