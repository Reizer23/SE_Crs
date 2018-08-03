package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Parallel_Exercise {
    WebDriver driver;
    String baseUrl;

    @FindBy(linkText = "Login")
    WebElement login;

    @FindBy(css = "#user_email")
    WebElement email;

    @FindBy(css = "#user_password")
    WebElement pass;

    @FindBy(name = "commit")
    WebElement loginBtn;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser){
        baseUrl = "https://letskodeit.teachable.com/";
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\automation-workspace\\Selenium_Info\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void parallelBrowsers() throws InterruptedException {
       Thread.sleep(2000);
        login.click();
        email.clear();
        driver.findElement(By.cssSelector("#user_email")).clear();
        email.sendKeys("testng@blabla.com");
        pass.clear();
        pass.sendKeys("password");
        loginBtn.click();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
