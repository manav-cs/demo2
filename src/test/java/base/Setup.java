package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.time.Duration;

public class Setup {
    public WebDriver driver;
    public static DesiredCapabilities caps = new DesiredCapabilities();

    public WebDriver initDriver(String driverType) {
        if (driverType.equalsIgnoreCase("ch")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //options.setHeadless(true);
            options.addArguments("--incognito");
            options.addArguments("--test-type");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--log-level=3");
            options.addArguments("--output=/dev/null");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(options);
        } else if (driverType.equalsIgnoreCase("ff")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            caps.setCapability("marionette", true);
            caps.setCapability("moz:firefoxOptions", options);
            driver = new FirefoxDriver(options);
        } else if (driverType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setCapability("InPrivate", true);
            driver = new EdgeDriver(options);
        } else if (driverType.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
            caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
            caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            driver = new InternetExplorerDriver(options);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ((JavascriptExecutor) driver).executeScript("window.confirm = function(msg) { return true; }");
        return driver;
    }

}
