package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdNameDemo {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://www.google.com";
        driver.manage().window().maximize();
        driver.get(baseURL);

        driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
        driver.findElement(By.id("searchform")).click();
        driver.findElement(By.name("btnK")).click();
    }

}
