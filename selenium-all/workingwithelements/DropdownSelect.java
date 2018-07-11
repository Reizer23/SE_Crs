package workingwithelements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownSelect {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        WebElement e1ement = driver.findElement(By.cssSelector("#carselect"));
        Select sel = new Select(e1ement);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.selectByValue("benz");

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.deselectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select Benz by value");
        sel.deselectByVisibleText("BMW");

        Thread.sleep(2000);
        System.out.println("Print the list of all options");

        //Print Car list
        List<WebElement> options = sel.getOptions();
        int size = options.size();

        for(int i=0; i<size; i++){
            String optionName = options.get(i).getText();
            System.out.println(optionName);
        }
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
