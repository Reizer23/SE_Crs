package extenreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
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

public class SeleniumLoginTestAventstack {
    WebDriver driver;
    String baseUrl;
    ExtentHtmlReporter htmlReports;
    ExtentReports report;
    ExtentTest test;
    String fileName = System.getProperty("user.dir") + "/test-output/logintest.html";

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
        baseUrl = "http://www.letskodeit.com/";
        ExtentReportConfig();
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
        test.log(Status.INFO, "Browser Started...");
        driver.manage().window().maximize();
        test.log(Status.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(Status.INFO, "Web application opened");
    }

    public void ExtentReportConfig(){
        htmlReports = new ExtentHtmlReporter(fileName);
        report = new ExtentReports();
        report.attachReporter(htmlReports);
        htmlReports.config().setReportName("Regression Testing");
        htmlReports.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReports.config().setDocumentTitle("HtmlReportsTestResults");
        htmlReports.config().getChartVisibilityOnOpen();
        report.setSystemInfo("Environment", "Stark");
        report.setSystemInfo("PARAM", "VALUE");
        report.setSystemInfo("OS", "Windows 10");
        report.setSystemInfo("User Name", "Reizer");
        report.setSystemInfo("Java Version", "1.8.0_171");
        report.setSystemInfo("Host Name", "Ulises.Cerecer");
        test = report.createTest("Verify Welcome Text");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        login.click();
        test.log(Status.INFO, "Clicked on Login Link");
        email.clear();
        email.sendKeys("test@email.com");
        test.log(Status.INFO, "Enter email");
        pass.clear();
        pass.sendKeys("abcabc");
        test.log(Status.INFO, "Enter password");
        loginBtn.click();
        test.log(Status.INFO, "Clicked Login Button");

        Thread.sleep(3000);
        Assert.assertTrue(myCoursesLabel != null);
        test.log(Status.PASS, "Verified Welcome Text");

        System.out.println("Login Successful");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        report.flush();
    }
}
