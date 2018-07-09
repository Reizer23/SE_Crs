package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActions {
    WebDriver driver;
    String baseUrl;

    //inicializar Driver, the browser, etc.
    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test()
    {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Login")).click();
        System.out.println("Clicked on login");
        driver.findElement(By.cssSelector("input[type='email']")).clear();
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("test@email.com");
        System.out.println("Sending Keys to username field");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("test");
        System.out.println("Sending Keys tu password field");
        driver.findElement(By.cssSelector("input[type='email']")).clear();
        System.out.println("Clearing the username field");
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
