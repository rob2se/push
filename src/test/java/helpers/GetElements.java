package helpers;

import enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DriverFactory;


/**
 * GetElements class - customs locator class that waits for element visibility and click-ability of the element
 */
public class GetElements {

    WebDriver driver = DriverFactory.getInstance().getDriver();

    public WebElement getElement(Locators locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By byElement = null;
        switch (locator) {
            case ClassName:
                byElement = By.className(value);
                break;
            case CssSelector:
                byElement = By.cssSelector(value);
                break;
            case Id:
                byElement = By.id(value);
                break;
            case LinkText:
                byElement = By.linkText(value);
                break;
            case Name:
                byElement = By.name(value);
                break;
            case PartialLink:
                byElement = By.partialLinkText(value);
                break;
            case TagName:
                byElement = By.tagName(value);
                break;
            case Xpath:
                byElement = By.xpath(value);
                break;
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        wait.until(ExpectedConditions.elementToBeClickable(byElement));
        return driver.findElement(byElement);
    }
}
