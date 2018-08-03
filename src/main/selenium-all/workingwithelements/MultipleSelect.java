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

public class MultipleSelect {

    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        baseUrl = "http://letskodeit.teachable.com/p/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        WebElement e1ement = driver.findElement(By.cssSelector("#multiple-select-example"));
        Select sel = new Select(e1ement);

        Thread.sleep(2000);
        System.out.println("Select orange by value");
        sel.selectByValue("orange");

        Thread.sleep(2000);
        System.out.println("De-Seect orange by value");
        sel.deselectByValue("orange");

        Thread.sleep(2000);
        System.out.println("Select peach by index");
        sel.selectByIndex(2);

        Thread.sleep(2000);
        System.out.println("Select Apple by visible text");
        sel.selectByVisibleText("Apple");

        Thread.sleep(2000);
        System.out.println("Print all selected options");

        //Print Fruits List
        List<WebElement> selectedOptions = sel.getAllSelectedOptions();
        for(WebElement option : selectedOptions){
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        System.out.println("De-Select all selected options");
        sel.deselectAll();
    }

    @After
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }

}
