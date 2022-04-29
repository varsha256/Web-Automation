package Executor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GlobalProperties {

    public static Properties globalProp;

    public static void loadGlobalProperties() throws IOException {
        globalProp= new Properties();
        globalProp.load(new FileReader(System.getProperty("user.dir")+"\\src\\test\\Config.properties"));
    }

}
