package testBase;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class BrowserFactory {

    //create webdriver object for given browser


    public WebDriver createBrowserInstance(Browsers browser) throws MalformedURLException {

        WebDriver driver = null;

        switch (browser){
            case Chrome:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                //options.addArguments("--start-fullscreen");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions foptions = new FirefoxOptions();
                foptions.addArguments("-private");
                driver = new FirefoxDriver(foptions);
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions iOptions = new InternetExplorerOptions();
                iOptions.addCommandSwitches("-private");
                driver = new InternetExplorerDriver(iOptions);
                break;
        }
        return driver;
    }
}
