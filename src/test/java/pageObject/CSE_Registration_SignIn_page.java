package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static stepDef.Hook.scenario;

public class CSE_Registration_SignIn_page extends GenericFunctions {

    Faker faker = new Faker();
    WebDriver driver;
    Actions actions;

    public CSE_Registration_SignIn_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }

    /*All the locators goes here*/
    @FindBy(how = How.LINK_TEXT, using = "Sign in here")
    public WebElement cseSignInHereLink;
    @FindBy(how = How.ID_OR_NAME, using = "firstName")
    public WebElement cseRegiFirstNameLoc;
    @FindBy(how = How.ID_OR_NAME, using = "lastName")
    public WebElement cseRegiLastNameLoc;
    @FindBy(how = How.ID_OR_NAME, using = "address")
    public WebElement cseRegiAddressLoc;
    @FindBy(how = How.ID_OR_NAME, using = "zip")
    public WebElement cseRegiZipLoc;
    @FindBy(how = How.ID, using = "zipCode")
    public WebElement cseRegiZipcodeNonSsoLoc;
    @FindBy(how = How.ID_OR_NAME, using = "city")
    public WebElement cseRegiCityLoc;
    @FindBy(how = How.ID_OR_NAME, using = "state")
    public WebElement cseRegiStateLoc;
    @FindBy(how = How.ID_OR_NAME, using = "mobile")
    public WebElement cseRegiMobileLoc;
    @FindBy(how = How.ID_OR_NAME, using = "phoneNumber")
    public WebElement cseRegiPhoneLoc;
    @FindBy(how = How.ID_OR_NAME, using = "email")
    public WebElement cseRegiEmailLoc;
    @FindBy(how = How.ID_OR_NAME, using = "password")
    public WebElement cseRegiPasswordLoc;
    @FindBy(how = How.XPATH, using = "//input[@class='emailTxtBox form-control']")
    public WebElement neEmailField;
    @FindBy(how = How.ID, using = "passwordConfirmation")
    public WebElement cseRegiPasswordConfirmLoc;
    @FindBy(how = How.NAME, using = "terms-checkbox")
    public WebElement cseRegiTermsCheckboxLoc;
    @FindBy(how = How.ID, using = "registerButton")
    public WebElement cseRegiSubmitBtnLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='SUCCESS!']/parent::*")
    public WebElement cseRegiSuccessMsgLoc;
    @FindBy(how = How.XPATH, using = " (//*[text()= 'GO TO LOGIN PAGE'])[1]")
    public WebElement cseGoToLoginPageButtonLoc;
    @FindBy(how = How.ID_OR_NAME, using = "userName")
    public WebElement cseLoginEnterEmailLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='My Garage']/parent::*")
    public WebElement cseSignInMyGarageVerifyLoc;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Create an Account']")
    public WebElement cseRegiCreateAnAccountLoc;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement cseRegiNextButtonLoc;
    @FindBy(how = How.ID, using = "zipCode")
    public WebElement cseRegiZipCodeLoc;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Next']//parent::button")
    public WebElement cseRegiNextBtnFromEnterYourHomeLocationPageLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='Use the address as entered']/parent::*")
    public WebElement cseRegiUserTehAddressAsEnteredLoc;
    @FindBy(how = How.LINK_TEXT, using = "Sign Out")
    public WebElement cseMyGarageSignOutLoc;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'mb-1')]//following-sibling::p")
    public WebElement cseHomePageBuyHomeSubHeader;
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Garage')]")
    public WebElement cseMyGarageHeader;

    // All the functions goes here
    public void verifyInMyGarage(){
        waitForElementToBeVisible(cseMyGarageHeader);
    }
    public void clickOnSignInHereLink() {
        cseSignInHereLink.click();
    }
    public void clickOnSignInHereLink(String linkName) {
        //GenericFunctions.jsClick(driver.findElement(By.xpath("(//*[text()= '"+linkName+"'])")));
        GenericFunctions.clickLinkByText(linkName);
    }
    public void clickOnClickHereToRegisterLink(String linkText) {
         //GenericFunctions.jsClick(driver.findElement(By.xpath("//*[normalize-space(text())='"+linkText+"']")));
        GenericFunctions.clickLinkByText(linkText);
    }
    public void clickOnLink(String linkText) {
        //GenericFunctions.jsClick(driver.findElement(By.xpath("//*[normalize-space(text())='"+linkText+"']")));
        GenericFunctions.clickLinkByText(linkText);
    }
    public void cseRegiFormEnterFirstName() {
        GlobalTestData.ECOM_REGISTRATION_FIRST_NAME = faker.name().firstName().replaceAll("[^a-zA-Z0-9]", "");
        cseRegiFirstNameLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME);
    }
    public void cseRegiFormEnterLastName() {
        GlobalTestData.ECOM_REGISTRATION_LAST_NAME = faker.name().lastName().replaceAll("[^a-zA-Z0-9]", "");
        cseRegiLastNameLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
    }
    public void cseRegiFormAddress() {
        cseRegiAddressLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_ADDRESS);
    }
    public void cseRegiFormZipcode() {
        cseRegiZipLoc.clear();
        cseRegiZipLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_ZIPCODE);
    }
    public void cseRegiFormZipcodeNonSso() {
        cseRegiZipcodeNonSsoLoc.clear();
        cseRegiZipcodeNonSsoLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_ZIPCODE);
    }
    public void cseRegiFormCity() {
        cseRegiCityLoc.clear();
        cseRegiCityLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_CITY);
    }
    public void cseRegiFormState() {
        Select state = new Select (cseRegiStateLoc);
        state.selectByValue(GlobalTestData.ECOM_REGISTRATION_STATE);
    }
    public void cseRegiFormMobile() {
        cseRegiMobileLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_MOBILE);
    }

    public void cseRegiFormEnterEmail() {
        String getFName = GlobalTestData.ECOM_REGISTRATION_FIRST_NAME;
        String getLName = GlobalTestData.ECOM_REGISTRATION_LAST_NAME;
        String getRandomNumber = faker.number().digits(5);
        String fullEmail = getFName+"."+getLName+getRandomNumber+"@carsaver-qa.com";
        GlobalTestData.ECOM_REGISTRATION_EMAIL = fullEmail;
        cseRegiEmailLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL);
    }
    public void cseRegiFormPassword() {
        cseRegiPasswordLoc.sendKeys( GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }
    public void cseRegiFormConfirmPassword() {
        cseRegiPasswordConfirmLoc.sendKeys( GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }
    public void cseRegiFormTermCheckbox(){
        cseRegiTermsCheckboxLoc.click();
    }
    public void cseRegiFromSubmitButton(){
        cseRegiSubmitBtnLoc.click();
    }
    public void cseRegiFromSuccessMsgVerify(){
        boolean isDisplayed = cseRegiSuccessMsgLoc.isDisplayed();
        if (isDisplayed){
            String act = cseRegiSuccessMsgLoc.getText();
            System.out.println("act: "+act);
            String exp = "SUCCESS!";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able to create an new profile!");
        }
    }

    public void clickOnGoToLoginPageFromSuccessPage() {
        cseGoToLoginPageButtonLoc.click();
    }

    public void cseEnterLoginCredentials(String login,String pwd){
        cseLoginEnterEmailLoc.sendKeys(login);
        cseRegiPasswordLoc.sendKeys(pwd);
    }
    public void clickOnLoginButton(String linkName){
        GenericFunctions.jsClick(driver.findElement(By.xpath("(//*[text()= '"+linkName+"'])")));
    }

    public void cseSignInMyGarageVerify(){
        boolean isDisplayed = cseSignInMyGarageVerifyLoc.isDisplayed();
        if (isDisplayed){
            String act = cseSignInMyGarageVerifyLoc.getText();
            System.out.println("act: "+act);
            String exp = "My Garage";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was not able login to the system!");
        }
    }
    public void neEnterValidPassword(){
        cseRegiPasswordLoc.sendKeys(GlobalTestData.ECOM_LOGIN_PASSWORD);
    }
    public void neEnterInvalidPassword(){
        cseRegiPasswordLoc.sendKeys("FakePas$word123");
    }
    public void cseVerifyInvalidCredentialMsg(String msgName){
        waitForElementToBeVisible(driver.findElement(By.xpath("(//*[normalize-space()= '"+msgName+"'])")));
        String act = driver.findElement(By.xpath("(//*[normalize-space()= '"+msgName+"'])")).getText();
        System.out.println("act: "+act);
        Assert.assertEquals(act, msgName,"User was able login to the system, BUG - Report It NOW!");
    }

    // Non SSO - Using CarSaver
    public void cseClickCreateAnAccountLink(){
        cseRegiCreateAnAccountLoc.click();
    }
    public void cseClickCreateAnAccount_non_sso(String linkName) {
        GenericFunctions.jsClick(driver.findElement(By.xpath("//a[contains(text(),'"+linkName+"')]")));
    }
    public void cseEnterFirstName(){
        GlobalTestData.ECOM_REGISTRATION_FIRST_NAME = faker.name().firstName().replaceAll("[^a-zA-Z0-9]", "");
        cseRegiFirstNameLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_FIRST_NAME);
    }
    public void cseEnterLastName(){
        GlobalTestData.ECOM_REGISTRATION_LAST_NAME = faker.name().lastName().replaceAll("[^a-zA-Z0-9]", "");
        cseRegiLastNameLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_LAST_NAME);
    }
    public void cseEnterPrimaryPhoneNumber(){
        cseRegiPhoneLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_MOBILE );
    }
    public void cseEnterEmail(){
        String getFName = GlobalTestData.ECOM_REGISTRATION_FIRST_NAME;
        String getLName = GlobalTestData.ECOM_REGISTRATION_LAST_NAME;
        String getRandomNumber = faker.number().digits(5);
        String fullEmail = getFName+"."+getLName+getRandomNumber+"@carsaver-qa.com";
        GlobalTestData.ECOM_REGISTRATION_EMAIL = fullEmail;
        cseRegiEmailLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL);
        scenario.log("Email created: "+GlobalTestData.ECOM_REGISTRATION_EMAIL);
    }
    public void cseEnterPassword(){
        cseRegiPasswordLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }
    public void cseEnterConfirmPassword(){
        cseRegiPasswordConfirmLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }
    public void cseClickNextButton(){
        cseRegiNextButtonLoc.click();
    }
    public void cseEnterHomeAddress(){
        waitForElementToBeVisible(cseRegiAddressLoc);
        cseRegiAddressLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_ADDRESS);
    }
    public void cseEnterHomeVagueAddress(){
        cseRegiAddressLoc.sendKeys(GlobalTestData.ECOM_ADDRESS_STREET_VAGUE);
    }

    public void cseEnterCity(){
        cseRegiCityLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_CITY);
    }
    public void cseSelectState(){
         Select state = new Select (cseRegiStateLoc);
        state.selectByValue(GlobalTestData.ECOM_REGISTRATION_STATE);
    }
    public void cseEnterZipcode(){
        cseRegiZipCodeLoc.clear();
        cseRegiZipCodeLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_ZIPCODE);
    }
    public void cseClickNextButtonFromEnterYourHomeAddress(){
        cseRegiNextBtnFromEnterYourHomeLocationPageLoc.click();
    }
    public void cseClickUseTheAddressAsEnteredButton(){
        cseRegiUserTehAddressAsEnteredLoc.click();
    }
    public void cseLogoutFromMyGarageLink(){
        cseMyGarageSignOutLoc.click();
    }
    public void cseEnterValidCredentialsToLogin(){
        cseRegiEmailLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL);
        cseRegiPasswordLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_PASSWORD);
    }
    public void cseClickSignInButton(String buttonName) {
        GenericFunctions.jsClick(driver.findElement(By.xpath("//*[contains(text(),'"+buttonName+"')]")));
        GenericFunctions.waitForPageToLoadCompletely();
        GenericFunctions.hardWait(1500);
    }
    public void cseEnterValidEmail(){
        cseRegiEmailLoc.sendKeys(GlobalTestData.CSE_NON_SSO_LOGIN_EMAIL);
    }
    public void cseEnterRegisteredEmail(){
        cseRegiEmailLoc.sendKeys(GlobalTestData.ECOM_REGISTRATION_EMAIL);
    }
    public void neEnterValidEmail(){
        cseLoginEnterEmailLoc.sendKeys(GlobalTestData.ECOM_LOGIN_EMAIL);
    }
    public void cseEnterValidPassword(){
        cseRegiPasswordLoc.sendKeys(GlobalTestData.CSE_NON_SSO_LOGIN_PASSWORD);
    }
    public void neEnterInvalidEmail(){
        neEmailField.sendKeys("InvalidNonSSOCSEEMAI32L@gmail.com");
    }
    public void cseEnterInvalidEmail(){
        cseRegiEmailLoc.sendKeys("InvalidNonSSOCSEEMAI32L@gmail.com");
    }
    public void cseEnterInvalidPassword(){
        cseRegiPasswordLoc.sendKeys("InvalidNonSSOCSEPas$1");
    }
    public void cseVerifyErrorMsgWhenUserEnterInvalidCredentials(String errorMsg){
        boolean isDisplayed = driver.findElement(By.xpath("//*/text()[normalize-space(.)='"+errorMsg+"']/parent::*")).isDisplayed();
        if (isDisplayed){
            String act = driver.findElement(By.xpath("//*/text()[normalize-space(.)='"+errorMsg+"']/parent::*")).getText();
            System.out.println("act: "+act);
            String exp = "The email address or password are not correct";
            Assert.assertEquals(act, exp);
        } else {
            Assert.fail("User was able login to the system with invalid credentials, BUG - Report It NOW!");
        }
    }
    public void cseHomePageSignedOut(){
        waitForElementToBeVisible(cseHomePageBuyHomeSubHeader);
        Assert.assertEquals(cseHomePageBuyHomeSubHeader.getText().trim(),"Explore every aspect of your vehicle purchase – at your own pace and convenience.");
    }

    public void cseClickMyGarageHamburgerLinks(String Link) {
        driver.findElement(By.xpath("//a[@class='menu-link']//span[text()='"+Link+"']")).click();
    }

}
