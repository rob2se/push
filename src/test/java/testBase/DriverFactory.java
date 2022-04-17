package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    //Singleton design pattern.  Only one instance of DriverFactory, global access is provided via getInstance.
    private DriverFactory(){
    }

    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    //Factory Design Pattern -- defines a separate factory method for creating objects
    ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driverParam){
        driver.set(driverParam);
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    public void closeDriver(){
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
}
