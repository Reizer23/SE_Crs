package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUP() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://www.letskodeit.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSelenium() throws Exception
    {
        driver.get(baseUrl + "/");
        //driver.findElement(By.id("i90scv3glabel")).click();
        driver.findElement(By.linkText("Practice")).click();
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
