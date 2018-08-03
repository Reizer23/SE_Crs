package keypress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo2 {
    WebDriver driver;
    String baseUrl;

    @FindBy(css="#openwindow")
    WebElement openWindow;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeySelectAll() throws InterruptedException {
        driver.get(baseUrl);
        //Way #1
        //openWindow.sendKeys(Keys.COMMAND + "a");
        //Way #2
        //openWindow.sendKeys(Keys.chord(Keys.COMMAND + "a"));
        //Way #3
        String selectAll = Keys.chord(Keys.COMMAND, "a");
        openWindow.sendKeys(selectAll);
        Thread.sleep(4000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
