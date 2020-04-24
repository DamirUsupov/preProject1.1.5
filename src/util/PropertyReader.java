package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getValueByKey(String key) throws IOException {
//использовать classloader вместо file input stream
        ClassLoader classLoader;



        FileInputStream fis;
        Properties properties = new Properties();
        fis = new FileInputStream("app.properties");
        properties.load(fis);
        return properties.getProperty(key);
    }
}
