package PageActions.MS_HomePage;

import CommonUtils.CommonFunctions;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

public class MS_HomePageActions {


    WebDriver driver ;
    ResourceBundle resourceBundle;
    public MS_HomePageActions(WebDriver driver){
        this.driver=driver;
        String packageName= getClass().getPackage().getName().replace("Actions","_OR");;
        String resourceName= getClass().getSimpleName().replace("Actions","_OR");
        resourceBundle= ResourceBundle.getBundle(packageName+"."+resourceName);

    }

    public static MS_HomePageActions getInstance(WebDriver driver){
      return new MS_HomePageActions(driver);
    }
    public void OpenCategory(String categoryName){
        String categoryLocator= resourceBundle.getString("category");
        categoryLocator=categoryLocator.replace("+categoryName+",categoryName);
        CommonFunctions.getInstance(driver).click(categoryLocator);
    }

}
