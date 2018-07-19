package selenium;
//20-120
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Autocomplete {
    WebDriver driver;
    String baseUrl;

    @FindBy(css = "#air-city-departure")
    WebElement departInput;

    @FindBy(css = "ul#air-city-departure-menu")
    WebElement citys;

    @FindBy(tagName = "li")
    List<WebElement> results;

    @BeforeMethod
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        baseUrl = "http://www.southwest.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testAutocomplete() throws InterruptedException
    {
        driver.get(baseUrl);
        String searchingText = "New York/Newark, NJ - EWR";
        String partialText = "New York";

        departInput.sendKeys(partialText);

        //results = citys;

        int size = results.size();

        for(int i=0; i<size; i++)
        {
            System.out.println(results.get(i).getText());
        }

        for(WebElement result : results)
        {
            if(result.getText().equals(searchingText))
            {
                result.click();
            }
        }
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
