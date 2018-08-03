package javascriptexecution;

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

public class JavaScriptExecution {
    WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @FindBy(css = "#name")
    WebElement textBox;

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
    public void testJavaScriptExecution(){
        //driver.get(baseUrl);
        //JS will open the url
        //textBox.sendKeys("test");

        js.executeScript("window.location = 'http://letskodeit.teachable.com/pages/practice'");
        textBox = (WebElement) js.executeScript("return document.getElementById('name');");
        textBox.sendKeys("test");
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
