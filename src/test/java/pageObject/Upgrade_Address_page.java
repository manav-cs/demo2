package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Upgrade_Address_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public Upgrade_Address_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'My Address')]")
    public WebElement upMyGarageAddressBtnLoc;

    /** Page Functions **/
    public void upMyGarageAddressBtn() {
        waitForElementToBeVisible(upMyGarageAddressBtnLoc);
        upMyGarageAddressBtnLoc.click();
    }
}
