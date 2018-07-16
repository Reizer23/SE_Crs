package usefulmethods;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetAttributeDemo {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testGetText() throws InterruptedException {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.cssSelector("#name"));
        String attributeValue = element.getAttribute("class");
        String attributeTypeValue = element.getAttribute("type");

        System.out.println("Value of attribute is: " + attributeValue);
        System.out.println("Value of attribute is: " + attributeTypeValue);
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
