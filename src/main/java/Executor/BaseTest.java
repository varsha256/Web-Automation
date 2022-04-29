package Executor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {
   protected WebDriver driver;
@BeforeClass
    public void launchApplication() throws IOException {
        GlobalProperties.loadGlobalProperties();
        String browser= GlobalProperties.globalProp.getProperty("BrowserName");
        String applicationUrl= GlobalProperties.globalProp.getProperty("micorsoftUrl");
        this.driver=DriverFactory.getDriver(browser);
        driver.get(applicationUrl);
        TestDataReader.readTestdataSheet();

}

@AfterClass

    public void tearDrown(){
    driver.quit();
    driver=null;

}
}
