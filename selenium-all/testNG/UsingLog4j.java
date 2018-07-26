package testNG;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.classes.SearchPage;

import java.util.concurrent.TimeUnit;

public class UsingLog4j {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(UsingLog4j.class);
    SearchPage searchpage;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        baseUrl = "https://expedia.com/";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyConfigurator.configure("log4j.properties");
    }

    @Test
    public void testMethod() throws InterruptedException {
        driver.get(baseUrl);
        searchpage.navigateToFlightsTab(driver);
        searchpage.fillOriginTextBox(driver, "New York");
        searchpage.fillDestinationTextBox(driver, "Chicago");
        searchpage.fillDepartureDateTextBox(driver,"12/25/2018");
        searchpage.fillReturnDateTextBox(driver, "12/31/2018");
    }

    @AfterMethod
    public void tearDown() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }
}
