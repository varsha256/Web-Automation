
package  CustomeReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CustomeReporter{
private static ExtentReports extent= null;
private static ExtentTest test= null;

private CustomeReporter(){

        }
public  static ExtentTest getTest(){
        return test;
        }
public  static void setTest(ExtentTest testPrd){
        test=testPrd;
        }

public static ExtentReports getInstance(){
        if(extent==null){
        extent= createIntance();
        }
        return extent;
        }

private static ExtentReports createIntance() {
        String  reportPath = System.getProperty("user.dir")+"\\ExecutionResults\\ExecutionResults.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Automation-Execution-Report");
        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        return extent;
        }


        public static void report_Status_Pass(String message){
        CustomeReporter.getTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
        }

        public static void report_Status_Fail(String message){
                CustomeReporter.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));        }
}