package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
    private DriverManager driverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() throws InterruptedException {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getWebDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
