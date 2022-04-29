package CustomeReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomeReporter extends ExtentReports {

    ExtentReports reporter ;
    ExtentTest Logger;


    public CustomeReporter(){
        SimpleDateFormat sf= new SimpleDateFormat("DD/MM/YYYY");


        Date date = new Date();
        String curr_date = sf.format(date);
        String  reportName= "Exceution_Result_"+curr_date+"_"+System.currentTimeMillis();
        String reportFilePath=System.getProperty("user.dir")+"src/main/java/ExecutionResults/"+reportName+".html";
//        ExtentSparkReporter extentSparkReporter= new E
        reporter= new ExtentReports();

    }

}
