package TestCases;

import Executor.BaseTest;
import Executor.TestDataReader;
import PageActions.MS_HomePage.MS_HomePageActions;
import PageActions.MS_HomePage.MS_OfficePageActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {


    @Test
    public void Validate_Application_is_getting_Launched(){

//        ExtentReports reports = new ExtentReports();
//        ExtentTest test= reports.createTest("Hello");
        String category=TestDataReader.getTestData("Validate_Application_is_getting_Launched", "Category");
        MS_HomePageActions.getInstance(driver).OpenCategory(category);
        MS_OfficePageActions.getInstance(driver).vaidateLinkIsDisplayed();

//        test.log(Status.PASS ,"Execution Compleed ");
    }



}
