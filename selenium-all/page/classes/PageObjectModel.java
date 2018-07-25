package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageObjectModel {
    WebDriver driver;
    String baseUrl;
    SearchPageFactory searchPage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://expedia.com";

        searchPage = new SearchPageFactory(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get(baseUrl);
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.originTextBox(driver).sendKeys("New York");
        SearchPage.destinationTextBox(driver).sendKeys("Chicago");
        SearchPage.departureDateTextBox(driver).sendKeys("12/25/2018");
        SearchPage.returnDateTextBox(driver).sendKeys("12/31/2018");
        SearchPage.clickOnSearchButton(driver);
    }

    @Test(enabled = false)
    public void test2BetterWay() throws InterruptedException {
        driver.get(baseUrl);
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver,"Chicago");
        SearchPage.fillDepartureDateTextBox(driver, "12/25/2018");
        SearchPage.fillReturnDateTextBox(driver,"12/31/2018");
        SearchPage.clickOnSearchButton(driver);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get(baseUrl);
        SearchPageFactory.clickFlightTab();
        Thread.sleep(2000);
        SearchPageFactory.clickRoundTrip();
        Thread.sleep(2000);
        SearchPageFactory.clickMultipleDestination();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
