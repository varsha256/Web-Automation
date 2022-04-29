package PageActions.MS_HomePage;

import CommonUtils.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ResourceBundle;

public class MS_OfficePageActions {


    WebDriver driver ;
    ResourceBundle resourceBundle;
    public MS_OfficePageActions(WebDriver driver){
        this.driver=driver;
        String packageName= getClass().getPackage().getName().replace("Actions","_OR");;
        String resourceName= getClass().getSimpleName().replace("Actions","_OR");
        resourceBundle= ResourceBundle.getBundle(packageName+"."+resourceName);

    }

    public static MS_OfficePageActions getInstance(WebDriver driver) {
        return new MS_OfficePageActions(driver);
    }

    public void vaidateLinkIsDisplayed(){
        String linkLocator= resourceBundle.getString("qAndA");
        boolean isDisplayed = CommonFunctions.getInstance(driver).isPresent(linkLocator);
        Assert.assertTrue(isDisplayed,"Link is not displayed ");
    }

}
