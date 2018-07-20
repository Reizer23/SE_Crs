package switchto;
//21-129
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @FindBy(css = "#openwindow")
    WebElement openWindow;

    @FindBy(css = "#search-courses")
    WebElement searchBox;

    @FindBy(css = "#name")
    WebElement nameInput;

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

        //Get the gandle window
        String parentHandle = driver.getWindowHandle();
        openWindow.click();

        //Get all handles
        Set<String> handles = driver.getWindowHandles();

        //Switching between handles
        for(String handle : handles){
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                searchBox.sendKeys("python");
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentHandle);
        nameInput.sendKeys("Test Successful");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
