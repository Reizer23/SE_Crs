package log4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestNG_TestCase {
    private WebDriver driver;

    private String baseUrl;
    private static Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testMethod() {
        log.info(" This message is from TestNG method");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
