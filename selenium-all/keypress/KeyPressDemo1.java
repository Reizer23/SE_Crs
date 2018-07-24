package keypress;

import org.openqa.selenium.Keys;
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

public class KeyPressDemo1 {
    WebDriver driver;
    String baseUrl;

    @FindBy(xpath="//a[contains(@href,'sign_in')]")
    WebElement signIn;

    @FindBy(css="#user_email")
    WebElement email;

    @FindBy(css="#user_password")
    WebElement password;

    @FindBy(name="commit")
    WebElement commit;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void testKeyPressEnter() throws InterruptedException {
        driver.get(baseUrl);
        signIn.click();
        email.sendKeys("test@email.com");
        Thread.sleep(2000);
        password.sendKeys("123123");
        Thread.sleep(2000);
        commit.sendKeys(Keys.ENTER);
    }

    @Test(enabled = true)
    public void testKeyPressTab() throws InterruptedException {
        driver.get(baseUrl);
        signIn.click();
        email.sendKeys("test@email.com");
        Thread.sleep(2000);
        email.sendKeys(Keys.TAB);
        password.sendKeys("123123");
        Thread.sleep(2000);
        commit.sendKeys(Keys.ENTER);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
