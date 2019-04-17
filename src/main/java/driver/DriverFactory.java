package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public static WebDriver createDriver(String nameofDriver){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");

        if(nameofDriver.matches(DriverName.Chrome)){
            return new ChromeDriver();
        }

        if(nameofDriver.matches(DriverName.FireFox)){
            return new FirefoxDriver();
        }
        return null;
    }

}
