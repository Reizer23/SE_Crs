package testNG;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

public class TestNG_ParametersAndDataProviders {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(TestNG_ParametersAndDataProviders.class);
    SearchPage searchPage;

    @BeforeClass
    public void beforeMethod(){
        driver = new ChromeDriver();
        baseUrl = "https://expedia.com/";
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyConfigurator.configure("log4j.properties");
        driver.get(baseUrl);
    }

    @Parameters( { "origin", "dest", "depDate", "retDate" } )
    @Test
    public void searchFlights(String origin, String dest, String depDate,
                              String retDate) throws InterruptedException {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, origin);
        SearchPage.fillDestinationTextBox(driver, dest);
        SearchPage.fillDepartureDateTextBox(driver,depDate);
        SearchPage.flightReturn.clear();
        SearchPage.fillReturnDateTextBox(driver, retDate);
    }

    /*@Test
    public void searchFlightsWithMultiData(String origin, String dest, String depDate,
                                           String retDate) throws Exception{
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.clearAllFields(driver);
        Thread.sleep(3000);
        SearchPage.fillOriginTextBox(driver, origin);
        SearchPage.fillDestinationTextBox(driver, dest);
        SearchPage.fillDepartureDateTextBox(driver,depDate);
        SearchPage.flightReturn.clear();
        SearchPage.fillReturnDateTextBox(driver, retDate);
    }*/

    @AfterClass
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
