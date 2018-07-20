package switchto;
//21-132
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchFrame {
    WebDriver driver;
    String baseUrl;

    @FindBy(css = "#search-courses")
    WebElement searchBox;

    @FindBy(css = "#name")
    WebElement nameBox;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void testJavaScriptExecution() throws InterruptedException {
        //Switch to frame by Id
        //driver.switchTo().frame("courses-iframe");
        //Switch to frame by name
        //driver.switchTo().frame("iframe-name");
        //Switch to frame by numbers
        driver.switchTo().frame(0);
        searchBox.sendKeys("python");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        nameBox.sendKeys("Test Successful");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
