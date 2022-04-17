package dataProvider;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "configs//Configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getEyesToken(){
        String eyes_token = properties.getProperty("eyes_token");
        if(eyes_token != null) return eyes_token;
        else throw new RuntimeException("eyes_token not specified in the Configuration.properties file.");
    }

    public String getBtnPath(){
        String btnPath = properties.getProperty("btnAbsPath");
        if(btnPath != null) return btnPath;
        else throw new RuntimeException("btnPath not specified in the Configuration.properties file.");
    }

}
