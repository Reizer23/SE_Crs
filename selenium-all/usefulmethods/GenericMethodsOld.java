package usefulmethods;
//18-109
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericMethodsOld {
    WebDriver driver;

    public GenericMethodsOld(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type)
    {
        type = type.toLowerCase();
        if(type.equals("id"))
        {
            //System.out.println("Element found with id: " + type);
            System.out.println("Element found with id: " + type);
            return this.driver.findElement(By.id(locator));
        }
        else if(type.equals("xpath"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        }
        else if(type.equals("css"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        }
        else if(type.equals("linktext"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.linkText(locator));
        }
        else if(type.equals("partiallinktext"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        }
        else
        {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    //18-110
    public List<WebElement> getElementList(String locator, String type)
    {
        type = type.toLowerCase();
        if(type.equals("id"))
        {
            //System.out.println("Element found with id: " + type);
            System.out.println("Element found with id: " + type);
            return this.driver.findElements(By.id(locator));
        }
        else if(type.equals("xpath"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElements(By.xpath(locator));
        }
        else if(type.equals("css"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElements(By.cssSelector(locator));
        }
        else if(type.equals("linktext"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElements(By.linkText(locator));
        }
        else if(type.equals("partiallinktext"))
        {
            //System.out.println("Element found with xpath: " + type);
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElements(By.partialLinkText(locator));
        }
        else
        {
            System.out.println("Locator type not supported");
            return null;
        }
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
}