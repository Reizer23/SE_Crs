package extenreports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Screenshots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumLoginTest {
    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @FindBy(linkText = "Login")
    WebElement login;

    @FindBy(css = "#user_email")
    WebElement email;

    @FindBy(css = "#user_password")
    WebElement pass;

    @FindBy(name = "commit")
    WebElement loginBtn;

    //Siempre encuentra este objeto =/
    @FindBy(linkText = "Category")
    WebElement categoryLabel;

    @BeforeClass
    public void beforeClass(){
        baseUrl = "http://www.letskodeit.com/";
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/logintest.html");
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        test.log(LogStatus.INFO, "Browser Started...");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        login.click();
        test.log(LogStatus.INFO, "Clicked on Login Link");
        email.clear();
        email.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "Enter email");
        pass.clear();
        pass.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");
        loginBtn.click();
        test.log(LogStatus.INFO, "Clicked Login Button");

        Thread.sleep(3000);
        WebElement categoryText = null;
        try {
            categoryText = driver.findElement(By.linkText("Category"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        Assert.assertTrue(categoryText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");
        System.out.println("Login Successful");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
