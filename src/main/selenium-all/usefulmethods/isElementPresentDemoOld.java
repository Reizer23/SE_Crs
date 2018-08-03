package usefulmethods;
//18-110
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class isElementPresentDemoOld {
    WebDriver driver;
    String baseUrl;
    private GenericMethodsOld gm;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/p/practice";
        gm = new GenericMethodsOld(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);

        boolean result1 = gm.isElementPresent("name", "id");
        System.out.println("Is Element present: " + result1);

        boolean result2 = gm.isElementPresent("name-not-present", "id");
        System.out.println("Is Element present: " + result2);
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
