package PageActions.HomePage;

import CommonUtils.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ResourceBundle;

public class HomePageActions {


    WebDriver driver ;
    ResourceBundle resourceBundle;
    public HomePageActions(WebDriver driver){
        this.driver=driver;
        String packageName= getClass().getPackage().getName().replace("Actions","_OR");;
        String resourceName= getClass().getSimpleName().replace("Actions","_OR");
        resourceBundle= ResourceBundle.getBundle(packageName+"."+resourceName);

    }

    public static HomePageActions getInstance(WebDriver driver){
      return new HomePageActions(driver);
    }
    public void validateLinkIsVisible(String LinkName ){
        String linkLocator= resourceBundle.getString(LinkName);
        Assert.assertTrue(CommonFunctions.getInstance(driver).isPresent(linkLocator));
    }

}
