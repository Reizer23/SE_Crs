package selenium;
//20-120
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSelection {
    WebDriver driver;
    String baseUrl;
    WebDriverWait wait;

    @FindBy(css="button#tab-flight-tab-hp")
    WebElement tabFlight;

    @FindBy(css="#flight-departing-hp-flight")
    WebElement departingField;

    @FindBy(xpath="//button[@data-month='6'][@data-day='31']")
    WebElement dateToSelect;

    @FindBy(css = "td>button")
    List<WebElement> allValidDates;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 7);
        baseUrl = "http://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void selectingFlightDay1() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tabFlight.click();
        departingField.click();
        dateToSelect.click();
        System.out.println("Test 1");
    }

    //20-121
    @Test(enabled = true)
    public void selectingFlightDay2() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tabFlight.click();
        departingField.click();

        for(WebElement date : allValidDates) {
            if(date.getText().trim().equals("31")){
                wait.until(ExpectedConditions.elementToBeClickable(date));
                date.click();
                break;
            }
        }
        System.out.println("Test 2");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
