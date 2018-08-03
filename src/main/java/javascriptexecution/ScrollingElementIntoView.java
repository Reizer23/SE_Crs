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

public class ScrollingElementIntoView {
    WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @FindBy(css = "#mousehover")
    WebElement element;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution() throws InterruptedException {
        js.executeScript("window.location = 'http://letskodeit.teachable.com/pages/practice'");

        //Scroll Down
        js.executeScript("window.scrollBy(0, 1900);");
        Thread.sleep(2000);
        //Scroll Up
        js.executeScript("window.scrollBy(0, -1900);");
        Thread.sleep(2000);
        //Scroll Element Into View
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -190);");
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
