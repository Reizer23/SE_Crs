package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByLinkTextAndCSS {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://letskodeit.teachable.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);

        //linkText = El texto del tag <div>Login<div>
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);
        //partialLinkText = Es una parte del texto del tag <div>Practice<div>
        driver.findElement(By.partialLinkText("Pract")).click();
        //With CSS
        driver.findElement(By.cssSelector("#displayed-text")).sendKeys("Hello");

    }
}
