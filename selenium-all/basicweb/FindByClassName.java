package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassName {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://demostore.x-cart.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.findElement(By.className("title")).click();
    }
}
