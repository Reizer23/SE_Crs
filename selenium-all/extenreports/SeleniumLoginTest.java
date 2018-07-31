package extenreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumLoginTest {
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

    @FindBy(linkText = "My Courses")
    WebElement myCoursesLabel;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        baseUrl = "http://www.letskodeit.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        login.click();
        email.clear();
        email.sendKeys("test@email.com");
        pass.clear();
        pass.sendKeys("abcabc");
        loginBtn.click();

        Thread.sleep(3000);
        Assert.assertTrue(myCoursesLabel != null);

        System.out.println("Login Successful");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
