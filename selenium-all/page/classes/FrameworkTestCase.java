package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameworkTestCase {
    private WebDriver driver;
    private String baseUrl;
    SearchPageFactory searchPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "http://expedia.com";
        searchPage = new SearchPageFactory(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchPageFactory(){
        driver.get(baseUrl);
        searchPage.clickFlightTab();
        searchPage.setOriginCity("New York");
        searchPage.setDestinationCity("Chicago");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

