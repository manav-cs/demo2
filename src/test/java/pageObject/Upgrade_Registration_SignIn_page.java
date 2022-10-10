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
import org.testng.Assert;
public class Upgrade_Registration_SignIn_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;

    public Upgrade_Registration_SignIn_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }

    // All the locators goes here
    @FindBy(how = How.ID, using = "email")
    public WebElement upLoginEnterEmailLoc;
    @FindBy(how = How.ID, using = "password")
    public WebElement upLoginEnterPasswordLoc;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Choose Trade Option')]")
    public WebElement upChoseTradeOptionTextLoc;
    @FindBy(how = How.XPATH, using = "//h1//span")
    public WebElement welcomeBackPageLoc;
    @FindBy(how = How.XPATH, using = "//a[@aria-label='Open the menu']")
    public WebElement upHamburgerBtnLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Sign Out']/parent::*")
    public WebElement upSignOutLoc;
    @FindBy(how = How.ID, using = "pin-label")
    public WebElement upHomePagePinTextLoc;
    @FindBy(how = How.ID, using = "pin-label")
    public WebElement WelcomeBackHomePageLoc;
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Next']")
    public WebElement upNextAddressBtnLoc;


    // All the functions goes here
    public void clickOnClickHereToRegisterLink(String linksText) {
        GenericFunctions.jsClick(driver.findElement(By.xpath("//a[normalize-space()='" + linksText + "']")));
    }

    public void verifyChooseTradeOption() {
        waitForElementToBeVisible(upChoseTradeOptionTextLoc);
        boolean isDisplayed = upChoseTradeOptionTextLoc.isDisplayed();
        if (isDisplayed) {
            String act = upChoseTradeOptionTextLoc.getText();
            String exp = "Choose Trade Option";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able login to the Upgrade!");
        }
    }

    public void upLoginEnterEmail() {
        upLoginEnterEmailLoc.sendKeys(GlobalTestData.UPGRADE_EXISTING_PROFILE_EMAIL);
    }

    public void upEnterValidPassword() {
        upLoginEnterPasswordLoc.sendKeys(GlobalTestData.UPGRADE_EXISTING_PROFILE_PASSWORD);
    }

    public void upEnterInvalidEmail() {
        upLoginEnterEmailLoc.sendKeys("fakeEmailThatDoesNotExist@test.com");
    }

    public void upEnterInvalidPassword() {
        upLoginEnterPasswordLoc.sendKeys("FakePas$word123");
    }

    public void upWelcomeBackPageForNewProfile() {
        boolean isDisplayed = welcomeBackPageLoc.isDisplayed();
        if (isDisplayed) {
            String act = welcomeBackPageLoc.getText();
            String exp = "Welcome Back " + GlobalTestData.ECOM_REGISTRATION_FIRST_NAME + "!";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able to create an new profile!");
        }
    }
    public void upHomePageVerify() {
        boolean isDisplayed = upHomePagePinTextLoc.isDisplayed();
        if (isDisplayed) {
            String act = upHomePagePinTextLoc.getText();
            String exp = "Enter your PIN to get started.";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able Sign Out!");
        }
    }
    public void upWelcomeBackHomePageVerify() {
        boolean isDisplayed = WelcomeBackHomePageLoc.isDisplayed();
        if (isDisplayed) {
            String act = WelcomeBackHomePageLoc.getText();
            String exp = "Welcome Back!";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able Sign Out!");
        }
    }
    public void UpWelcomeBackPageWithHardCodeFirstName() {
        waitForElementToBeVisible(welcomeBackPageLoc);
        boolean isDisplayed = welcomeBackPageLoc.isDisplayed();
        if (isDisplayed) {
            String act = welcomeBackPageLoc.getText();
            System.out.println("======> act: " + act);
            String exp = "Welcome Back " + GlobalTestData.UPGRADE_EXISTING_FIRST_NAME + "!";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able to create an new profile!");
        }
    }
    public void upHamburgerBtn() {
        waitForElementToBeVisible(upHamburgerBtnLoc);
        upHamburgerBtnLoc.click();
    }
    public void upSignOut() {
        waitForElementToBeVisible(upSignOutLoc);
        upSignOutLoc.click();
    }
    public void clickupSignOutGrage(String linkName) {
        driver.findElement(By.xpath("//ul[@role='tablist']//a[normalize-space(text())='" + linkName + "']")).click();
    }
    public void HamburgerShopNewLinkText(String linkText) {
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='menu-link']//span[text()='" + linkText + "']")).getText().trim(), linkText, "The " + linkText + " link in the Hamburger menu is incorrect: ");
    }
    public void upNextAddressBtn(){
        waitForElementToBeVisible(upNextAddressBtnLoc);
        upNextAddressBtnLoc.click();
    }
}