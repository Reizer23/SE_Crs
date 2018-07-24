package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static page.classes.PageObjectModel.*;

public class SearchPage {
    public static WebElement element = null;

    /** Navigate to flights tab*/
    public static void navigateToFlightsTab(WebDriver driver){
        element = driver.findElement(By.cssSelector("#tab-flight-tab-hp"));
        element.click();
    }

    /** Returns the flight origin text box element*/
    public static WebElement originTextBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("#flight-origin-hp-flight"));
        return element;
    }

    public static void fillOriginTextBox(WebDriver driver, String origin){
        element = originTextBox(driver);
        element.sendKeys(origin);
    }

   /** Returns the flight destination text box element*/
    public static WebElement destinationTextBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("#flight-destination-hp-flight"));
        return element;
    }

    public static void fillDestinationTextBox(WebDriver driver, String origin){
        element = destinationTextBox(driver);
        element.sendKeys(origin);
    }

    /** Returns the departure date text box element*/
    public static WebElement departureDateTextBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("#flight-departing-hp-flight"));
        return element;
    }

    public static void fillDepartureDateTextBox(WebDriver driver, String origin){
        element = departureDateTextBox(driver);
        element.sendKeys(origin);
    }

    /** Returns the date text box element*/
    public static WebElement returnDateTextBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("#flight-returning-hp-flight"));
        return element;
    }

    public static void fillReturnDateTextBox(WebDriver driver, String origin){
        element = returnDateTextBox(driver);
        element.sendKeys(origin);
    }

    /** Returns the search button box element*/
    public static WebElement searchButton(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id='flight-add-hotel-checkbox-hp-flight']/../../..//span[text()='Search']/.."));
        return element;
    }

    /**Click on search Button*/
    public static void clickOnSearchButton(WebDriver driver){
        element = searchButton(driver);
        element.click();
    }
}
