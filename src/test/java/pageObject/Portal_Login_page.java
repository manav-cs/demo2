package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Portal_Login_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;
    public Portal_Login_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }
    // All the locators goes here
    @FindBy(how = How.ID, using = "remind-later")
    public WebElement portalClickRemindMeLaterButtonFromPopUp;
    @FindBy(how = How.ID, using = "email")
    public WebElement portalLoginEmailLoc;
    @FindBy(how = How.ID, using = "password")
    public WebElement portalLoginPasswordLoc;
    @FindBy(how = How.ID, using = "loginBtn")
    public WebElement portalLoginButtonLoc;
    @FindBy(how = How.CSS, using = "p")
    public WebElement portalVerifyLoginSuccessLoc;
    @FindBy(how = How.CSS, using = "div.alert.alert-danger")
    public WebElement portalVerifyLoginUnsuccessfulLoc;
    @FindBy(how = How.CSS, using = "#navbar-right-logout")
    public WebElement portalLogoutButtonLLoc;

    // All the functions goes here
    public void portalClickRemindMeLaterFromInitialModal(){
        waitForElementToBeClickable(portalClickRemindMeLaterButtonFromPopUp);
        portalClickRemindMeLaterButtonFromPopUp.click();
    }
    public void portalEnterEmailAddress(String email){
        portalLoginEmailLoc.sendKeys(email);
    }
    public void portalEnterPassword(String password){
        portalLoginPasswordLoc.sendKeys(password);
    }
    public void portalClickLoginButton(){
        portalLoginButtonLoc.click();
    }
    public void portalVerifyLoginSuccessMessage(String expMessage) {
        waitForElementToBeVisible(portalVerifyLoginSuccessLoc);
        boolean isDisplayed = portalVerifyLoginSuccessLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = portalVerifyLoginSuccessLoc.getText();
            Assert.assertTrue(actMessage.contains(expMessage),
                    " ==> Found "+ actMessage + " instead of "+ expMessage);
        } else {
            Assert.fail("User was not able login to the Portal!");
        }
    }

    public void portalVerifyLoginUnsuccessfulMessage(String expMessage){
        waitForElementToBeVisible(portalVerifyLoginUnsuccessfulLoc);
        boolean isDisplayed = portalVerifyLoginUnsuccessfulLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = portalVerifyLoginUnsuccessfulLoc.getText();
            System.out.println("====>> "+ actMessage);
            Assert.assertTrue(actMessage.contains(expMessage),
                    " ==> Found "+ actMessage + " instead of "+ expMessage);
        } else {
            Assert.fail("User was able login to the Portal with Invalid credentials!");
        }
    }
    public void portalClickLogoutButton(){
        waitForElementToBeClickable(portalLogoutButtonLLoc);
        portalLogoutButtonLLoc.click();
    }
    public void portalVerifyLogoutSuccessMessage(String expMessage){
        waitForElementToBeVisible(portalVerifyLoginUnsuccessfulLoc);
        boolean isDisplayed = portalVerifyLoginUnsuccessfulLoc.isDisplayed();
        if (isDisplayed){
            String actMessage = portalVerifyLoginUnsuccessfulLoc.getText();
            System.out.println("====>> "+ actMessage);
            Assert.assertEquals(actMessage, expMessage);
        } else {
            Assert.fail("User was NOT able logout from Portal!");
        }
    }

}













