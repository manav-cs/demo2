package managers;

import org.openqa.selenium.WebDriver;
import stepDef.Hook;

public class DriverManager {

    private WebDriver driver;
    private Hook hook;

    public WebDriver getDriver() throws InterruptedException {
        hook = new Hook();
        driver = hook.getDriver();
        return driver;
    }

}
