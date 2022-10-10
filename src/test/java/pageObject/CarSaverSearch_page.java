package pageObject;

import base.GenericFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarSaverSearch_page extends GenericFunctions {

    WebDriver driver;
    Actions actions;

    public CarSaverSearch_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(this.driver);
    }

    @FindBy(how = How.XPATH, using = "//div[3]/button")
    public WebElement searchButton;

    public void clickOnSearchButton() {
        searchButton.click();
    }

}
