package usefulmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindLinks {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        baseUrl = "http://expedia.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get(baseUrl);
        navigateToFlightsTab(driver);
        List<WebElement> linksList = clickableLinks(driver);
        for(WebElement link : linksList){
            String href = link.getAttribute("href");
            try {
                System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void navigateToFlightsTab(WebDriver driver){
        WebElement element;
        element = driver.findElement(By.cssSelector("#tab-flight-tab-hp"));
        element.click();
    }

    public static List<WebElement> clickableLinks(WebDriver driver){
        List<WebElement> linksToClick = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements){
            if (e.getAttribute("href") != null){
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }

    public static String linkStatus(URL url){
        try{
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}

