package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindByLinkText_CSS_FindByAnnotation {

    WebDriver driver;
    String baseUrl;

    /**
     * To use @FindBy we need To instantiate the elements, we call the initElements method of the PageFactory class
     * PageFactory.initElements(driver, this);
     * (driver, class)
     */

    @FindBy(css="#displayed-text")
    WebElement textDisplayed1;

    @FindBy(how = How.CSS, using = "#displayed-text")
    WebElement textDisplayed2;

     /** Two ways to write @FindBy Annotations
     *
     * these two annotations point to the same element:
     * @FindBy(id = "foobar") WebElement foobar;
     * @FindBy(how = How.ID, using = "foobar") WebElement foobar;
     *
     * these two annotations point to the same list of elements:
     * @FindBy(tagName = "a")
     * List<WebElement> links;
     * @FindBy(how = How.TAG_NAME, using = "a") List<WebElement> links;
     *
     */

    @BeforeMethod
    public void setUp() throws Exception
    {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this); //(driver, "class")
        baseUrl = "http://letskodeit.teachable.com/";
        driver.manage().window().maximize();
    }


    @Test
    public void findByLinkTextAndCss() throws InterruptedException
    {
        driver.get(baseUrl);
        //linkText = El texto del tag <div>Login<div>
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);
        //partialLinkText = Es una parte del texto del tag <div>Practice<div>
        driver.findElement(By.partialLinkText("Pract")).click();
        //With CSS
        driver.findElement(By.cssSelector("#displayed-text")).sendKeys("Welcome Back");
        textDisplayed1.sendKeys(" Reizer");
        Thread.sleep(1200);
        textDisplayed2.clear();
    }

    @AfterClass
    public void tearDown() throws Exception
    {
        Thread.sleep(2000);
        driver.quit();
    }
}
