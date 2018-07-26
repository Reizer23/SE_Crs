package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;
import utilities.WaitTypes;

public class SearchPage {
    public static WebElement element = null;
    static Logger log = Logger.getLogger(SearchPage.class);
    private WebDriver driver;

    @FindBy(css = "#flight-returning-hp-flight")
    public static WebElement flightReturn;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    /**Click on Advanced Options link*/
    public static void clickOnAdvancedLink(WebDriver driver){
        element = driver.findElement(By.cssSelector("#flight-advanced-options-hp-flight"));
        element.click();
        log.info("Clicked on Advanced Options link");
    }

    /**Click on Non-stop check box*/
    public static void clickNonStopCheckBox(WebDriver driver){
        element = driver.findElement(By.cssSelector("#advanced-flight-nonstop-hp-flight"));
        element.click();
        log.info("Clicked non-stop check box");
    }

    /**Select Flight Class*/
    public static void selectFlightClass(WebDriver driver, String flightClass){
        Select options = new Select(driver.findElement(By.cssSelector("#flight-advanced-preferred-class-hp-flight")));
        options.selectByValue(flightClass);
        log.info("Select flight class as " + flightClass);
    }

    /**Select Flight Class*/
    public static void clickMorningFlight(WebDriver driver){
        WebElement element = WaitTypes.getWhenVisible(driver,By.xpath("//section[@id='columnAFilter']//input[@id='leg0-morning-departure']"), 30);
        element.click();
        log.info("Clicked on Morning Time to filter the results");
    }
}
