package javascriptexecution;
//21-125
import org.openqa.selenium.By;
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

public class JavaScriptClick {
    WebDriver driver;
    String baseUrl;
    private JavascriptExecutor js;

    @FindBy(css = "#bmwcheck")
    WebElement checkBoxElement;

    @FindBy(css = "#subscribe")
    WebElement subscribe;

    @FindBy(xpath = "//div[text()='Log In / Sign up']")
    WebElement logIn;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void testJavaScriptExecution(){
        js.executeScript("window.location = 'http://letskodeit.teachable.com/pages/practice'");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", checkBoxElement);
    }

    @Test(enabled = true)
    public void testJSClick2() {
        driver.get("https://www.retailmenot.com/");
        logIn.click();
        System.out.println("Displayed: " + subscribe.isDisplayed());
        System.out.println("Selected: " + subscribe.isSelected());

        //with java script force to do click on the element
        js.executeScript("arguments[0].click();", subscribe);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
