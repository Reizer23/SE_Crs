package usefulmethods;
//18-109
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GenericMethodsDemo {
    WebDriver driver;
    String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/p/practice";
        gm = new GenericMethods(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod() throws Exception {
        driver.get(baseUrl);
        WebElement element = gm.getElement("name", "id");
        element.sendKeys("test");
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
