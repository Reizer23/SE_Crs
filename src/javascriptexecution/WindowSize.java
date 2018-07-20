package javascriptexecution;
//21-125
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowSize {
    WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution(){
        js.executeScript("window.location = 'http://letskodeit.teachable.com/pages/practice'");
        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerHeight;");

        System.out.println("Height is: " + height);
        System.out.println("Width is: " + width);
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
