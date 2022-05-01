package Executor;

import CustomeReports.CustomeReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
   protected WebDriver driver;

    @BeforeClass
    public void launchApplication() throws IOException {
        GlobalProperties.loadGlobalProperties();
        String browser= GlobalProperties.globalProp.getProperty("BrowserName");
        String applicationUrl= GlobalProperties.globalProp.getProperty("appUrl");
        this.driver=DriverFactory.getDriver(browser);
        driver.get(applicationUrl);
        TestDataReader.readTestdataSheet();
        CustomeReporter.getInstance();


    }
@BeforeMethod
public void setReporter(Method method){
    ExtentTest test=  CustomeReporter.getInstance().createTest(method.getName());
    CustomeReporter.setTest(test);
}
@AfterClass

    public void tearDrown(){
    driver.quit();
    driver=null;
    CustomeReporter.getInstance().flush();

}
}
