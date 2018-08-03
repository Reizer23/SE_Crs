package selenium;
//20-123
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Screenshots {
    WebDriver driver;
    String baseUrl;

    @FindBy(css="button#tab-flight-tab-hp")
    WebElement flightTab;

    @FindBy(css="label[for='flight-origin-hp-flight'] input")
    WebElement flight_origin;

    @FindBy(css="label[for='flight-destination-hp-flight'] input")
    WebElement flight_destination;

    @FindBy(css="#flight-departing-hp-flight")
    WebElement departure_date;

    @FindBy(css="label[for='flight-returning-hp-flight'] input")
    WebElement return_date;

    @FindBy(xpath="//div[@id='f-fh-msg-tooltip-hp-flight']/..//button")
    WebElement search;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://www.expedia.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void selectingFlightDay1() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        flightTab.click();

        //Send data to elements
        flight_origin.sendKeys("New York");
        departure_date.sendKeys("12/23/2018");
        return_date.clear();
        return_date.sendKeys("12/31/2018");
        flight_destination.sendKeys("New York");
        search.click();
    }

    public static String getRandomString(int length){
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i=0; i<length; i++){
            int index = (int) Math.random() * characters.length();
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    @AfterClass
    public void tearDown() throws Exception {
        //String fileName = getRandomString(10) + ".png";
        String fileName = "ScreenShot.png";
        Path currentRelativePath = Paths.get("");
        String pathToDriver = currentRelativePath.toAbsolutePath().toString() +
                File.separator + "ScreenShots" + File.separator;
        String directory = pathToDriver;
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        driver.quit();
    }
}
