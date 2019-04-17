package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<DriverManager>();

    protected synchronized static DriverManager getInstance(){
        if (driverManager.get() == null){
            driverManager.set(new DriverManager());
        }
        return driverManager.get();
    }

    protected WebDriver driver;

    public static WebDriver currentDriver(){
        return getInstance().getDriver();
    }

    protected synchronized WebDriver getDriver(){
        if (driver == null){
            DriverFactory driverFactory = new DriverFactory();
            driver = driverFactory.createDriver(DriverName.Chrome);
        }
        return driver;
    }
}
