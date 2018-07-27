package testNGoldObsolete;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
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
        PropertyConfigurator.configure("log4jdemo.properties");
        driver.get(baseUrl);
    }

    @DataProvider(name = "fieldsInputs") //can have any name
    public static Object[][] searchData(){
        return new Object[][] {{"New York", "Chicago", "10/28/2018", "10/31/2018"},
                                {"New York", "Boston", "12/28/2018", "12/31/2018"}};
    }

    @Test
    @Parameters({"origin", "dest", "depDate", "retDate"})
    public void searchFlights(String origin, String dest, String depDate,
                              String retDate) throws InterruptedException {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, origin);
        SearchPage.fillDestinationTextBox(driver, dest);
        SearchPage.fillDepartureDateTextBox(driver,depDate);
        SearchPage.flightReturn.clear();
        SearchPage.fillReturnDateTextBox(driver, retDate);
    }

    @Test(dataProvider = "fieldsInputs")
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
    }

    @AfterClass
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
