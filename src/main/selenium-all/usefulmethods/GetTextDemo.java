package usefulmethods;
//18-107
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class GetTextDemo {
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
        WebElement buttonElement = driver.findElement(By.cssSelector("#opentab"));
        String elementText = buttonElement.getText();

        System.out.println("Text on the element is: " + elementText);
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
