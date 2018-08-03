package basicweb;
//12-65
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverDemo {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://www.google.com";

        driver.get(baseURL);
        driver.quit();
    }
}

//xml file "selenium_all" with TestNG
/*public class ChromeDriverDemo {

    @Test(description = "Chrome Browser")
    public void openChromeTest()
    {
        WebDriver driver = new ChromeDriver();
        String baseURL = "http://www.google.com";

        driver.get(baseURL);
        driver.quit();
    }
}*/
