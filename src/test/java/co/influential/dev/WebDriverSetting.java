package co.influential.dev;

import driver.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSetting {

    public ChromeDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUo(){
        System.setProperty("webdriver.chrome.driver", "/Users/anduser/Desktop/UI/chromeDriver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @After
    public void close(){
        driver.quit();
    }
}

