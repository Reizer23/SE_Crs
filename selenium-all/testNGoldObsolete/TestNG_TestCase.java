package testNGoldObsolete;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

public class TestNG_TestCase {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(UsingLog4j.class);
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

    @Test
    public void fillBasicInfo() throws InterruptedException {
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureDateTextBox(driver,"12/25/2018");
        SearchPage.flightReturn.clear();
        SearchPage.fillReturnDateTextBox(driver, "12/31/2018");
        Thread.sleep(3000);
    }

    @Test
    public void fillAdvancedInfo(){
        SearchPage.clickOnAdvancedLink(driver);
        SearchPage.clickNonStopCheckBox(driver);
        SearchPage.selectFlightClass(driver, "first");
    }

    @AfterClass
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
