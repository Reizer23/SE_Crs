package eventlistener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

    public static void main(String[] args){
        String baseUrl = "https://www.expedia.com/";
        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        HandleEvents he = new HandleEvents();
        eDriver.register(he); //enables the actions to perform

        eDriver.get(baseUrl);
        eDriver.findElement(By.id("tab-flight-tab-hp")).click();
    }
}
