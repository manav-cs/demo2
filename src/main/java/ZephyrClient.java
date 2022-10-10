import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZephyrClient {

    private String jwtToken;
    private HttpResponse<String> task;
    private String jobId;
    PropertiesReader propertiesReader = new PropertiesReader();

    public void generateJWT() throws UnirestException, IOException {
        HttpResponse<String> getToken = Unirest.post("https://prod-vortexapi.zephyr4jiracloud.com/api/v1/jwt/generate")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"accessKey\":\"" + propertiesReader.getJIRAProperty("access_key") + "\",\r\n  \"secretKey\":\"" + propertiesReader.getJIRAProperty("secret") + "\",\r\n  \"accountId\":\"" + propertiesReader.getJIRAProperty("account_id") + "\"\r\n}")
                .asString();
        Assert.assertTrue(getToken.isSuccess());
        jwtToken = getToken.getBody();
    }

    public void postResultsToJIRA() throws UnirestException, InterruptedException, IOException {
        System.out.println("pushing results to jira !!!".toUpperCase());
        // First step- generate the token
        generateJWT();
        Thread.sleep(2000);
        // second step: Create Task
        createTask();
        Thread.sleep(5000);
//        // Third step: Run/execute Task
        executeTask();
    }

    public void createTask() throws UnirestException, IOException {
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String jobName = "Automation Job-" + dateFormat.format(dt);
        System.out.println("Creating Automation Job with name: " + jobName);

        task = Unirest.post("https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/create")
                .header("accessKey", propertiesReader.getJIRAProperty("access_key"))
                .header("jwt", jwtToken)
                .field("jobName", jobName)
                .field("automationFramework", "Cucumber")
                .field("cycleName", propertiesReader.getJIRAProperty("cycleName"))
                .field("appendDateTimeInCycleName", "false")
                .field("appendDateTimeInFolderName", "false")
                .field("versionName", propertiesReader.getJIRAProperty("versionName"))
                .field("projectKey", "QA")
                .field("cycleStartingDate", "")
                .field("cycleEndingDate", "")
                .field("createNewCycle", "false")
                .field("createNewFolder", "false")
                .field("file", new File(System.getProperty("user.dir") + "/target/cucumber.json"))
                .field("assigneeUser", propertiesReader.getJIRAProperty("account_id"))
                .field("jobDescription", "Descriptions")
                .asString();
        Assert.assertTrue(task.isSuccess());
        jobId = task.getBody().split(":")[2].replaceAll("\"}", "");
    }

    public void executeTask() throws UnirestException, IOException {

        HttpResponse<String> response = Unirest.post("https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/execute")
                .header("accessKey", propertiesReader.getJIRAProperty("access_key"))
                .header("jwt", jwtToken)
                .multiPartContent()
                .field("jobId", jobId.trim())
                .asString();

        Assert.assertTrue(response.isSuccess());
        System.out.println("--- " + response.getBody() + "---");
        if (response.getBody().contains("Job executed successfully")) {
            System.out.println("Results Posted to JIRA !!!".toUpperCase());
        }
    }
}
