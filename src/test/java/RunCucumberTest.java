import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDef"},
        tags = ("not @Ignore"),
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "junit:target/cucumber/result.xml"
        }
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void sendEmailReport() throws InterruptedException, IOException {
        try {
            if (System.getProperty("PostResultsToJira").equals("true")) {
                ZephyrClient zephyrClient = new ZephyrClient();
                zephyrClient.postResultsToJIRA();
            }
        } catch (NullPointerException ignored) {
        }
    }


}
