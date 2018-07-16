package usefulmethods;
//18-112
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    WebDriver driver;

    public GenericMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    public List<WebElement> getElement(String locator, String type)
    {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if(type.equals("id"))
        {
            elementList = this.driver.findElements(By.id(locator));
        }
        else if(type.equals("xpath"))
        {
            elementList = this.driver.findElements(By.xpath(locator));
        }
        else if(type.equals("css"))
        {
            elementList = this.driver.findElements(By.cssSelector(locator));
        }
        else if(type.equals("linktext"))
        {
            elementList = this.driver.findElements(By.linkText(locator));
        }
        else if(type.equals("partiallinktext"))
        {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        }
        if(elementList.isEmpty())
        {
            System.out.println("Element not found with " + type + ": " + locator);
        }
        else
        {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public List<WebElement> getElementList(String locator, String type)
    {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if(type.equals("id"))
        {
            elementList = this.driver.findElements(By.id(locator));
        }
        else if(type.equals("xpath"))
        {
            elementList = this.driver.findElements(By.xpath(locator));
        }
        else if(type.equals("css"))
        {
            elementList = this.driver.findElements(By.cssSelector(locator));
        }
        else if(type.equals("linktext"))
        {
            elementList = this.driver.findElements(By.linkText(locator));
        }
        else if(type.equals("partiallinktext"))
        {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        }
        else
        {
            System.out.println("Locator type not supported");
            return null;
        }
        if(elementList.isEmpty())
        {
            System.out.println("Element not found with " + type + ": " + locator);
        }
        else
        {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public boolean isElementPresent(String locator, String type)
    {
        List<WebElement> elementList = getElementList(locator, type);
        int size = elementList.size();

        if(size > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void clickWhenReady(By locator, int timeout)
    {
        try
        {
            WebElement element = null;
            System.out.println("Waiting for max: " + timeout + " seconds for element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Element appeared on the web page.");
        }
        catch (Exception e)
        {
            System.out.println("Element not appeared on the web page");
        }
    }
}