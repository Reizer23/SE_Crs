package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
    WebDriver driver;

    @FindBy(css = "#tab-flight-tab-hp")
    WebElement flightab;

    @FindBy(css = "#flight-type-roundtrip-label-hp-flight")
    WebElement rounTrip;

    @FindBy(css = "#flight-type-multi-dest-label-hp-flight")
    WebElement multipleDestination;

    @FindBy(css = "#flight-origin-hp-flight")
    WebElement originCity;

    @FindBy(css = "#flight-destination-hp-flight")
    WebElement destinationCity;

    @FindBy(css = "#flight-departing-hp-flight")
    WebElement departureDate;

    @FindBy(css = "#flight-returning-hp-flight")
    WebElement returnDate;

    public SearchPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRoundTrip(){
        rounTrip.click();
    }

    public void clickMultipleDestination(){
        multipleDestination.click();
    }

    public void clickFlightTab(){
        flightab.click();
    }

    public void setOriginCity(String origin){
        originCity.sendKeys(origin);
    }

    public void setDestinationCity(String destination){
        destinationCity.sendKeys(destination);
    }

}
