package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public String getValueByKey(String key) throws IOException {

        InputStream inputStream;
        Properties properties = new Properties();
        inputStream = this.getClass().getClassLoader().getResourceAsStream("app.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }

}

