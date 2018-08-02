package extenreports;

/**
 * Login
 * HomePage
 * ExtentFactory
 * testng-extent.xml
 */

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Screenshots;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest test;
    HomePage hp;

    @BeforeClass
    public void beforeClass(){
        baseUrl = "http://www.letskodeit.com/";
        report = ExtentFactory.getInstance();
        test = report.startTest("Verify Category Text");
        driver = new ChromeDriver();
        hp = new HomePage(driver, test);

        test.log(LogStatus.INFO, "Browser Started...");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        /*hp.clickLoginLink();
        hp.enterEmail("test@email.com");
        hp.enterPassword("abcabc");
        hp.clickLoginBtn();*/

        hp.login("test@email.com","abcabc");

        Thread.sleep(2000);

        boolean result = hp.isCategoryTextPresent();

        Assert.assertTrue(result);
        test.log(LogStatus.PASS, "Verified Category Text");
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
