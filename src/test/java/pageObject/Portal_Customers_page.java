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

public class Portal_Customers_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;
    public Portal_Customers_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }
    // All the locators goes here
    @FindBy(how = How.XPATH, using = "//input[@data-cs='email']")
    public WebElement portalCustomerEmailSearchLoc;
    @FindBy(how = How.XPATH, using = "//input[@data-cs='name']")
    public WebElement portalCustomerFullNameSearchLoc;
    @FindBy(how = How.XPATH, using = "//*/text()[normalize-space(.)='TRUE']/parent::*")
    public WebElement portalCustomerEnabledIsTrueLoc;



    // All the functions goes here
    public void portalCustomersMainNavClick(String linkText){
        GenericFunctions.jsClick(driver.findElement(By.xpath("//*[normalize-space(text())='"+linkText+"']")));
    }
    public void portalCustomersSearchButton(String buttonText){
        GenericFunctions.jsClick(driver.findElement(By.xpath("(//*[normalize-space(text()) and normalize-space(.)='"+buttonText+"'])[2]/following::button[1]")));
    }
    public void portalCustomerSearchByEmail(String email){
        portalCustomerEmailSearchLoc.sendKeys(email);
    }
    public void portalCustomerSearchByFullName(String fullName){
        portalCustomerFullNameSearchLoc.sendKeys(fullName);
    }

    public void portalCustomerInfoVerify(String exp){
        String actLocator = "//*/text()[normalize-space(.)='"+exp+"']/parent::*";
        boolean isDisplayed = driver.findElement(By.xpath(actLocator)).isDisplayed();
        if (isDisplayed){
            String act = driver.findElement(By.xpath(actLocator)).getText();
            System.out.println("Act is ==>: " + act + " | Exp is ==> " + exp );
            Assert.assertTrue(act.contains(exp),
                    " ==> Found "+ act + " instead of "+ exp);
        } else {
            Assert.fail("Customer city verification failed");
        }
    }


}













