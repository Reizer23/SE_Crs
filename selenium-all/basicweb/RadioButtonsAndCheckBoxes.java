package basicweb;
//17-99
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonsAndCheckBoxes {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/pages/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        WebElement bmwRadio = driver.findElement(By.cssSelector("#bmwradio"));
        bmwRadio.click();

        Thread.sleep(2000);
        WebElement benzRadio = driver.findElement(By.cssSelector("#benzradio"));
        benzRadio.click();

        WebElement bmwCheckBox = driver.findElement(By.cssSelector("#bmwcheck"));
        bmwCheckBox.click();

        Thread.sleep(2000);
        WebElement benzCheckBox = driver.findElement(By.cssSelector("#benzcheck"));
        benzCheckBox.click();

        System.out.println("BMW Radio is selected? " + bmwRadio.isSelected());
        System.out.println("Benz Radio is selected? " + benzRadio.isSelected());
        System.out.println("BMW CheckBox is selected? " + bmwCheckBox.isSelected());
        System.out.println("Benz CheckBox is selected? " + benzCheckBox.isSelected());
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
