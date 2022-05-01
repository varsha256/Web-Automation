package TestCases;

import CustomeReports.CustomeReporter;
import Executor.BaseTest;
import Executor.TestDataReader;
import PageActions.HomePage.HomePageActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {


    @Test
    public void validate_broken_links_on_Home_Page(){

//        String usr=TestDataReader.getTestData("validate_broken_links_on_Home_Page", "userName");
        HomePageActions.getInstance(driver).validateLinkIsVisible("Home");
        CustomeReporter.report_Status_Pass("Home Links is  Validated Sucessfully");

        HomePageActions.getInstance(driver).validateLinkIsVisible("SignIn");
        CustomeReporter.report_Status_Pass("Sign in Links is  Validated Sucessfully");

        HomePageActions.getInstance(driver).validateLinkIsVisible("SignUp");

        CustomeReporter.report_Status_Pass("Sign up Links is  Validated Sucessfully");

    }



}
