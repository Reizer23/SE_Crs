package switchto;
//21-132
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {
    WebDriver driver;
    String baseUrl;

    @FindBy(css = "#name")
    WebElement nameInput;

    @FindBy(css = "#alertbtn")
    WebElement alertBtn;

    @FindBy(css = "#confirmbtn")
    WebElement confirmBtn;

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
    public void test1(){
       nameInput.sendKeys("Ulises");
       alertBtn.click();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /** Not every pop-up is a java script Alert, but if it is, you must use this kind of Alert */
       Alert alert = driver.switchTo().alert();
       alert.accept();
    }

    @Test
    public void test2(){
        nameInput.sendKeys("Ulises");
        confirmBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
