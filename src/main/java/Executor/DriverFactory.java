package Executor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Locale;

public class DriverFactory {
static WebDriver driver;
public static  WebDriver getDriver(String browser){

    switch (browser.toLowerCase()){
        case "chrome": {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\New\\chromedriver.exe");
            return new  ChromeDriver();
        }

        case "edge":  {
            System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Downloads\\New\\msedgedriver.exe");

            return new EdgeDriver();}


    }
    return driver;
}
}
