package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageObjectModel {
    private WebDriver driver;
    private String baseUrl;
    SearchPage searchPage;
    SearchPageFactory searchFactory;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://expedia.com";
        searchFactory = new SearchPageFactory(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get(baseUrl);
        searchPage.navigateToFlightsTab(driver);
        searchPage.originTextBox(driver).sendKeys("New York");
        searchPage.destinationTextBox(driver).sendKeys("Chicago");
        searchPage.departureDateTextBox(driver).sendKeys("12/25/2018");
        searchPage.returnDateTextBox(driver).sendKeys("12/31/2018");
        searchPage.clickOnSearchButton(driver);
    }

    @Test(enabled = false)
    public void test2BetterWay() throws InterruptedException {
        driver.get(baseUrl);
        searchPage.navigateToFlightsTab(driver);
        searchPage.fillOriginTextBox(driver, "New York");
        searchPage.fillDestinationTextBox(driver,"Chicago");
        searchPage.fillDepartureDateTextBox(driver, "12/25/2018");
        searchPage.fillReturnDateTextBox(driver,"12/31/2018");
        searchPage.clickOnSearchButton(driver);
    }

    @Test
    public void test3PageFactory() throws InterruptedException {
        driver.get(baseUrl);
        searchFactory.clickFlightTab();
        Thread.sleep(2000);
        searchFactory.clickRoundTrip();
        Thread.sleep(2000);
        searchFactory.clickMultipleDestination();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
