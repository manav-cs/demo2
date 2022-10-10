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

public class CSE_Garage_Hamburger_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;

    public CSE_Garage_Hamburger_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }
    @FindBy(how = How.XPATH, using = "//div[@class='menu-btn d-flex']//button//i")
    public WebElement cseHamburgerMenuIcon;
    @FindBy(how = How.XPATH, using = "//div[@class='menu-popover']")
    public WebElement cseHamburgerMenuPopUp;
    @FindBy(how = How.XPATH, using = "//div[@class='x-icon']")
    public WebElement cseHamburgerMenuPopUpClose;
    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    public WebElement cseMyGarageInsurePageHeader;


    public void cseGarageOpenHamburgerMenu(){
        waitForElementToBeVisible(cseHamburgerMenuIcon);
        hardWait(1000);
        cseHamburgerMenuIcon.click();
        GenericFunctions.waitForElementToBeVisible(cseHamburgerMenuPopUp);
    }
    public void cseGarageOpenHamburgerMenuNoWait(){
        cseHamburgerMenuIcon.click();
    }

    public void cseGarageHamburgerLinkText(String linkText){
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='menu-popover']//span[text()='"+linkText+"']")).getText().trim(),linkText,"The "+linkText+" link in the Hamburger menu is incorrect: ");
    }
    public void cseMyGarageClickHamburgerLinks(String Link) {
        driver.findElement(By.xpath("//a[@class='menu-link']//span[text()='"+Link+"']")).click();
    }
    public void cseGarageHamburgerMenuClose(){
        cseHamburgerMenuPopUpClose.click();
    }
    public void cseGarageHamburgerMenuIsClosed(){
        GenericFunctions.waitForElementToBeInVisible(cseHamburgerMenuPopUp);
    }
    public void cseGarageHamburgerInsurePageHeader(){
        Assert.assertEquals(cseMyGarageInsurePageHeader.getText().trim(),"Get Special Discounts on Liberty Mutual Insurance Through CarSaver","Insure page header is incorrect: ");
    }

}
