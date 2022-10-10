package stepDef;

import base.GenericFunctions;
import base.GlobalTestData;
import base.Setup;
import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.util.Strings;
import report.CustomLogFilter;


public class Hook {
    public static String url;
    public static String baseURL = System.getProperty("env");
    public String browserType = System.getProperty("browser");
    Logger logger = LoggerFactory.getLogger(Hook.class);
    WebDriver driver;
    Setup setup;
    TestContext testContext;

    // Embed Request and Response in Cucumber JVM Report
    public static RequestSpecification request;
    public static Scenario scenario;
    public static Filter logFilter;

    @Before
    public void before(Scenario scenario) {
        Hook.scenario = scenario;
        logFilter = new CustomLogFilter();
        request = RestAssured.with();
    }

    public Hook() {}
    public Hook(TestContext context) {
        testContext = context;
    }

    public WebDriver getDriver() {
        initialize();
        databaseConnection();
        return driver;
    }

    public void initialize() {
        setup = new Setup();
        if (Strings.isNullOrEmpty(browserType)) {
            browserType = "ch";
        }
        if (Strings.isNullOrEmpty(baseURL)) {
            baseURL = "stage_up";
        }
        driver = setup.initDriver(browserType);
        switch (baseURL) {
            case "stage_cse":
                url = "https://nissan-cs.beta.carsaver.com";
                GlobalTestData.CSE_NON_SSO_LOGIN_EMAIL = "hasanyc@hotmail.com";
                GlobalTestData.CSE_NON_SSO_LOGIN_PASSWORD = "Test1234";
                break;
            case "stage_ne":
                url = "https://nissan-ecommerce.beta.carsaver.com";
                GlobalTestData.ECOM_LOGIN_EMAIL = "hasanyc@hotmail.com";
                GlobalTestData.ECOM_LOGIN_PASSWORD = "Test1234";
                break;
            case "stage_up":
                url = "https://qa-upgrade.beta.carsaver.com";
                GlobalTestData.UPGRADE_EXISTING_PROFILE_EMAIL = "TEST1234@carsaver-qa.com";
                GlobalTestData.UPGRADE_EXISTING_PROFILE_PASSWORD = "Test$1234";
                GlobalTestData.UPGRADE_EXISTING_FIRST_NAME= "HASAN";
                GlobalTestData.PORTAL_BASE_URL = "https://portal-beta.carsaver.com";
                GlobalTestData.PORTAL_ADMIN_EMAIL = "adminuser@carsaver.com";
                GlobalTestData.PORTAL_ADMIN_PASSWORD = "carsaver";
                break;
            case "stage_portal":
                url = "https://portal-beta.carsaver.com";
                GlobalTestData.PORTAL_ADMIN_EMAIL = "adminuser@carsaver.com";
                GlobalTestData.PORTAL_ADMIN_PASSWORD = "carsaver";
                break;
            case "stage_atlas":
                url = "https://atlas.beta.carsaver.com";
                GlobalTestData.ATLAS_DEALER_EMAIL = "dealeruser@carsaver.com";
                GlobalTestData.ATLAS_DEALER_PASSWORD = "carsaver";
                GlobalTestData.ATLAS_PROGRAM_USER_EMAIL = "upgradeprogramusertest@carsaver-qa.com";
                GlobalTestData.ATLAS_PROGRAM_USER_PASSWORD = "123456";
                break;
        }
        logger.info("Test Started");
        driver.get(url);
    }

    public void initialize_data_API() {
        if (Strings.isNullOrEmpty(baseURL)) {
            baseURL = "prod_carSaver";
        }
        switch (baseURL) {
            case "stage_carSaver":
                GlobalTestData.carSaver_API_baseURL = "https://api.staging.carsaver.com";
                break;
            case "prod_carSaver":
                GlobalTestData.carSaver_API_baseURL = "https://api.carsaver.com";
                break;
        }
        logger.info("API Started");
    }

    public void databaseConnection() {
        String[] DbEnv = baseURL.split("_");
        switch (DbEnv[0]) {
            case "stage":
                GlobalTestData.DB_DRIVER = "org.postgresql.Driver";
                GlobalTestData.DB_USER = "qa_automation";
                GlobalTestData.DB_PWD = "5bSD_j5Gki";
                GlobalTestData.DB_URL = "jdbc:postgresql://carsaver-beta-cluster.cluster-ctqmxtymvucy.us-east-1.rds.amazonaws.com:5432/carsaver_staging";
                GlobalTestData.DB_URL_TUNNEL = "carsaver-beta-cluster.cluster-ctqmxtymvucy.us-east-1.rds.amazonaws.com";
                GlobalTestData.DB_PORT = 5432;
                break;
            case "qa":
                GlobalTestData.DB_DRIVER = "";
                GlobalTestData.DB_USER = "";
                GlobalTestData.DB_PWD = "";
                GlobalTestData.DB_URL = "";
                GlobalTestData.DB_URL_TUNNEL = "";
                GlobalTestData.DB_PORT = 0;
                break;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) testContext.getPageObjectManager().getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            testContext.getPageObjectManager().getDriver().quit();
            //GenericFunctions.zip("target/cucumber-report-html");
        }
    }
}