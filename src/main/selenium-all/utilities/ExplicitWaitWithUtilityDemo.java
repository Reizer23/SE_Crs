package utilities;
//19-116
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWaitWithUtilityDemo {
    WebDriver driver;
    String baseUrl;
    WaitTypes wt;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        wt = new WaitTypes(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void test()
    {
        driver.get(baseUrl);
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        WebElement emailField = wt.waitForelement(By.cssSelector("#user_email"), 3);
        emailField.sendKeys("test");

        wt.clickWhenReady(By.name("commit"), 3);
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(4000);
        driver.quit();
    }
}
//section[@class='cal-month'][position()=1]//a[text()='31']
