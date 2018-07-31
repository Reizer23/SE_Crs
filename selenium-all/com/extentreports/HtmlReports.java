package com.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HtmlReports {

    WebDriver driver;
    ExtentHtmlReporter htmlReports;
    ExtentReports extent;
    ExtentTest test;
    String fileName = System.getProperty("user.dir")+"/test-output/HtmlTestResults.html";

    @BeforeTest
    public void setUp(){
        htmlReports = new ExtentHtmlReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReports);
        htmlReports.config().setReportName("Regression Testing");
        htmlReports.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReports.config().setDocumentTitle("HtmlReportsTestResults");
        extent.setSystemInfo("Environment", "QA-AUT");
    }

    @Test(priority = 0)
    public void openBrowser(){
        test=extent.createTest("TC_1=Open Firefox Browser using ChromeDriver");
        test.log(Status.INFO, "Test Case execution is started");
        driver = new ChromeDriver();
        test.log(Status.INFO, "Chrome Browser is Open");
    }

    @Test(priority = 1)
    public void openAutUrl(){
        test = extent.createTest("TC_2 = Open AUT url");
        driver.navigate().to("https://learn-selenium-automation-testing.blogspot.in");
        test.log(Status.PASS, "Application Under Test url is open");
    }

    @Test(priority = 2)
    public void verifyPageTitle() throws Exception {
        test = extent.createTest("TC_3 = Verify proper url is open or not");
        String actualPageTitle = driver.getTitle();
        assertTrue(actualPageTitle.equals("googles"));
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @AfterMethod //It will run after each test method is executes
    public void checkResults(ITestResult testResults){
        if(testResults.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL, "Test Case is Failed because of below problem");
            test.log(Status.FAIL, testResults.getThrowable());
        }else if(testResults.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS, "Test case is Passed");
        }else if(testResults.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP, testResults.getThrowable());
        }extent.flush();
    }
}
