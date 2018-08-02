package extenreports;

/**
 * Login
 * HomePage
 * ExtentFactory
 * testng-extent.xml
 */

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver = null;
    ExtentTest test;

    @FindBy(linkText = "Login")
    WebElement login;

    @FindBy(css = "#user_email")
    WebElement mail;

    @FindBy(css = "#user_password")
    WebElement pass;

    @FindBy(name = "commit")
    WebElement loginBtn;

    //constructor
    public HomePage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver,this);
    }

    public void clickLoginLink(){
        login.click();
        test.log(LogStatus.INFO, "Clicked on Login Link");
    }

    public void enterEmail(String email){
        mail.clear();
        mail.sendKeys(email);
        test.log(LogStatus.INFO, "Enter email");
    }

    public void enterPassword(String password){
        pass.clear();
        pass.sendKeys(password);
        test.log(LogStatus.INFO, "Enter password");
    }

    public void clickLoginBtn(){
        loginBtn.click();
        test.log(LogStatus.INFO, "Clicked Login Button");
    }

    public boolean isCategoryTextPresent(){
        WebElement categoryText = null;
        try {
            categoryText = driver.findElement(By.xpath("//div[contains(text(),'Category')]"));
            if(categoryText != null){
                return true;
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public void login(String email, String password){
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

}
