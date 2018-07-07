package seleniumtuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagName {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://demostore.x-cart.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.findElement(By.tagName("a")).click();
    }

}
