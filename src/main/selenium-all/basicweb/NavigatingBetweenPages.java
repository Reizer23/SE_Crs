package basicweb;
//17-97
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatingBetweenPages {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        //Getting Tittle page
        String tittle = driver.getTitle();
        System.out.println("Title of the page is: " + tittle);
        //Getting Current Url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);
        //Navigate to other Url
        String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?reset_purchase_session=1";
        driver.navigate().to(urlToNavigate);
        System.out.println("Navigate to Login page");
        //Getting Current Url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);

        Thread.sleep(2000);
        //Going back to the page
        driver.navigate().back();
        System.out.println("Navigate Back");
        //Getting Current Url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);

        Thread.sleep(2000);
        //Going back to the page
        driver.navigate().forward();
        System.out.println("Navigate Forward");
        //Getting Current Url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);

        Thread.sleep(2000);
        //Going back to the page
        driver.navigate().back();
        System.out.println("Navigate Back");
        //Getting Current Url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);

        Thread.sleep(2000);
        //Going back to the page
        driver.navigate().refresh();
        System.out.println("Navigate refresh");
        //Getting Current Url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url is: " + currentUrl);

        //Getting page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

    }

    @After
    public void tearDown() throws Exception
    {
        //driver.quit();
    }

}
