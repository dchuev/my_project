package co.influential.dev.SignUp;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(id = "header")
    private WebElement header;

    private By signUpButtonLocator = By.cssSelector("[href=\"/signup\"]");
    private By mainSignUp = By.id("main-signup");

    public void open(){
        driver.get("https://portal.dev.influential.co/");
    }

    public void getStarted(){
        header.findElement(signUpButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainSignUp));
    }

}
