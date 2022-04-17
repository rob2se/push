package pageObjects;


import com.applitools.eyes.selenium.Eyes;
import dataProvider.ConfigFileReader;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import testBase.DriverFactory;

public class InteractionTestPage {

    ConfigFileReader configFileReader= new ConfigFileReader();

    public void clickButton() throws FindFailed {
        Screen s = new Screen();
        Pattern clickHereButton = new Pattern(configFileReader.getBtnPath());
        s.click(clickHereButton);

    }

    public void checkBackground() {
        Eyes eyes = new Eyes();
        eyes.setApiKey(configFileReader.getEyesToken());
        eyes.open(DriverFactory.getInstance().getDriver(), "Applitools", "Test Web Page");
        eyes.checkWindow("Main Page");
        eyes.close();
    }
}
