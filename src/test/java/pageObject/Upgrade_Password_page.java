package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class Upgrade_Password_page extends GenericFunctions {
    WebDriver driver;
    Actions actions;
    Select select;
    WebDriverWait wait;

    public Upgrade_Password_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /** Page Locators **/
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'My Password')]")
    public WebElement upMyGaragePasswordBtnLoc;

    /** Page Functions **/
    public void upMyGaragePasswordBtn() {
        waitForElementToBeVisible(upMyGaragePasswordBtnLoc);
        upMyGaragePasswordBtnLoc.click();
    }

}
