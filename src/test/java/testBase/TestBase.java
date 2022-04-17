package testBase;

import dataProvider.ConfigFileReader;
import enums.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * <h>TestBase Class</h>
 * <br></br>
 * This TestBase Class specifies what happens before and after each Scenario using the @Before and @After Tags
 * <p></p>
 * "@Before" - launch Application gets an instance of the WebDriver and navigates to specified URL.
 * <br></br>
 * "@After"  - tearDown closes the instance of the WebDriver after Scenario has finished executing.
 * <p></p>

 */

public class TestBase {

    BrowserFactory bf = new BrowserFactory();
    ConfigFileReader configFileReader= new ConfigFileReader();

    @Before
    public void launchApplication(Scenario scenario) throws MalformedURLException {

        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browsers.valueOf(getParameter())));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        //VisualFactory.getInstance().setPercy(driver);
        ScenarioFactory.getInstance().setScenarioName(scenario.getName());
        System.out.println(configFileReader.getApplicationUrl());
        driver.get(configFileReader.getApplicationUrl());
    }

    //gets the browser type from command line parameter -Dbrowser=
    private String getParameter() {
        String value = System.getProperty("browser");
        String valueCapitalised = value.substring(0, 1).toUpperCase() + value.substring(1);
        if (valueCapitalised.isEmpty())
            throw new RuntimeException("browser" + " is empty!");

        return valueCapitalised;
    }

    @After
    public void tearDown(){
        DriverFactory.getInstance().closeDriver();
    }
}
