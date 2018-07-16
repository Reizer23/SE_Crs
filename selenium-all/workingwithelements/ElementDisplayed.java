package workingwithelements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementDisplayed {

    WebDriver driver;
    String baseUrl1;
    String baseUrl2;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl1 = "http://letskodeit.teachable.com/p/practice";
        baseUrl2 = "http://expedia.com";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLetsKodeIt() throws InterruptedException
    {
        driver.get(baseUrl1);

        WebElement textBox = driver.findElement(By.cssSelector("#displayed-text"));
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        Thread.sleep(2000);

        WebElement hideButton = driver.findElement(By.cssSelector("#hide-textbox"));
        hideButton.click();
        System.out.println("Clicked on hide button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());

        WebElement showButton = driver.findElement(By.cssSelector("#show-textbox"));
        showButton.click();
        System.out.println("Clicked on show button");
        System.out.println("Text Box Displayed: " + textBox.isDisplayed());
    }

    @Test
    public void testExpedia() throws InterruptedException
    {
        driver.get(baseUrl2);

        WebElement childDropdown = driver.findElement(By.cssSelector("#package-1-age-select-1"));
        System.out.println("Child Dropdown Displayed: " + childDropdown.isDisplayed());
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }

}
