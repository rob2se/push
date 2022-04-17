package actions;

import org.openqa.selenium.WebDriver;

import testBase.DriverFactory;

public class CommonActions {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    public String getPageTitle(){
        return driver.getTitle();
    }

}
