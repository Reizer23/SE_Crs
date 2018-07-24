package actionsclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseHoverActions {
    WebDriver driver;
    String baseUrl;
    JavascriptExecutor jse;

    @FindBy(css="#mousehover")
    WebElement mouseHoverMainElement;

    @FindBy(linkText="Top")
    WebElement subElement;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice/";
        jse = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        jse.executeScript("window.scrollBy(0,850)");
        Actions action = new Actions(driver);
        action.moveToElement(mouseHoverMainElement).perform();

        Thread.sleep(3000);
        action.moveToElement(subElement).click().perform();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
