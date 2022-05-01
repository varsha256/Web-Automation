package CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFunctions {
   static CommonFunctions commonFunctions;
    WebDriver driver ;
    public CommonFunctions(WebDriver driver){
        this.driver=driver;
    }
public static CommonFunctions getInstance(WebDriver driver){
       if(commonFunctions==null)

        return new CommonFunctions(driver);
       return commonFunctions;
}


    public WebElement getElement(String locator){
        
        String locatorMethod= locator.split("::")[0];
        String locatorstring= locator.split("::")[1];
        WebElement ele = null;
        switch (locatorMethod.toLowerCase()){
            
            case "xpath" : ele=driver.findElement(By.xpath(locatorstring));break;
            case "linktext" :ele= driver.findElement(By.linkText(locatorstring));break;
            case "classname" : ele=driver.findElement(By.className(locatorstring));break;
            case "id" : ele=driver.findElement(By.id(locatorstring));break;
        }
        
       return ele;
    }

    public List<WebElement> getElements(String locator){

        String locatorMethod= locator.split("::")[0];
        String locatorstring= locator.split("::")[1];
        List<WebElement> ele = null;
        switch (locatorMethod.toLowerCase()){
            case "xpath" : ele=driver.findElements(By.xpath(locatorstring));break;
            case "linktext" :ele= driver.findElements(By.linkText(locatorstring));break;
            case "classname" : ele=driver.findElements(By.className(locatorstring));break;
            case "id" : ele=driver.findElements(By.id(locatorstring));break;
        }

        return ele;
    }
    public void click(String locator){
     WebElement element=   getElement(locator);
     element.click();
    }
    public void sendKeys(String locator,String inputText){
        WebElement element=   getElement(locator);
        element.sendKeys(inputText);
    }

    public boolean isPresent(String locator){
        if(getElements(locator).size()==0)
       return false;
        return true;
    }
}
