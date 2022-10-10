import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public String getJIRAProperty(String key) throws IOException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/jira_reporting_values.properties");
        Properties p = new Properties();
        p.load(reader);
        return p.getProperty(key);
    }

}
