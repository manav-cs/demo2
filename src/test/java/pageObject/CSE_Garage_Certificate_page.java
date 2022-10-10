package pageObject;

import base.GenericFunctions;
import base.GlobalTestData;
import gherkin.lexer.Gl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CSE_Garage_Certificate_page extends GenericFunctions {

    WebDriver driver;

    public CSE_Garage_Certificate_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Page Locators */
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'customer-name')]")
    public WebElement cseGarageCertificateUserName;
    @FindBy(how = How.XPATH, using = "//div[@class='address']")
    public WebElement cseGarageCertificateAddress;
    @FindBy(how = How.XPATH, using = "//span[text()='Email:']//following-sibling::span")
    public WebElement cseGarageCertificateEmail;
    @FindBy(how = How.XPATH, using = "//span[text()='Phone:']//following-sibling::span")
    public WebElement cseGarageCertificatePhone;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'confirmation-id')]")
    public WebElement cseGarageCertificateNumber;


    /* Page Functions */
    public void cseGarageCertificatePageHeader(){
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText().trim(), GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+"'s "+GlobalTestData.SQL_QUERY[0][3]+" "+GlobalTestData.SQL_QUERY[0][1]+" "+GlobalTestData.SQL_QUERY[0][2],"The user's name and vehicle information on the certificate page is incorrect: ");
    }

    public void cseGarageCertificateBasicInfo() {
        Assert.assertEquals(cseGarageCertificateUserName.getText().trim(),GlobalTestData.ECOM_REGISTRATION_FIRST_NAME+" "+GlobalTestData.ECOM_REGISTRATION_LAST_NAME,"");
        Assert.assertEquals(cseGarageCertificateAddress.getText().trim(), GlobalTestData.ECOM_REGISTRATION_ADDRESS+", "+GlobalTestData.ECOM_REGISTRATION_CITY+", "+GlobalTestData.ECOM_REGISTRATION_STATE+", "+GlobalTestData.ECOM_REGISTRATION_ZIPCODE,"The user's address on the certificate page is incorrect: ");
        Assert.assertEquals(cseGarageCertificateEmail.getText().trim(),GlobalTestData.ECOM_REGISTRATION_EMAIL.toLowerCase(),"User email is incorrect on the certificate page: ");
        Assert.assertEquals(cseGarageCertificatePhone.getText().trim(),GlobalTestData.ECOM_REGISTRATION_MOBILE_FORMATTED,"User phone is incorrect on the certificate page: ");
        String [] strUrl = driver.getCurrentUrl().split("/");
        Assert.assertEquals(cseGarageCertificateNumber.getText().trim(),"Certificate #: "+strUrl[strUrl.length-1],"The Certificate Number on the certificate page is incorrect: ");
    }

}
