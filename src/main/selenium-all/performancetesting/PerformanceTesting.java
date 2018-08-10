package performancetesting;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.classes.SearchPage;
import utilities.Constants;
import utilities.ExcelUtility;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class PerformanceTesting {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(PerformanceTesting.class);

    long startTime;
    long endTime;
    long duration;
    double seconds;

    @BeforeClass
    public void beforeClass() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //PropertyConfigurator.configure("log4j.properties");
        driver.get(baseUrl);

        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
    }

    @Test
    public void searchFlight(Method name) throws Exception {
        startTime = System.nanoTime();
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureDateTextBox(driver, "12/25/2015");
        SearchPage.fillReturnDateTextBox(driver, "12/31/2015");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        seconds = (double)duration / 1000000000.0;
        log.info("******************************");
        log.info("Time taken to execute this method: " + seconds + " seconds");
        System.out.println("Time taken to execute this method: " + seconds + " seconds");
        ExcelUtility.setCellData(name.getName(), 1, 0);
        ExcelUtility.setCellData(seconds, 1, 1);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
