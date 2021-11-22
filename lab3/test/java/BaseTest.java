import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final long DEFAULT_TIMEOUT = 10;
    protected enum Driver { Chrome, FireFox }
    protected Driver current_driver = Driver.Chrome;
    protected WebDriver driver;

    @BeforeEach
    public void createDriver() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("52.251.88.102:80");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);
        FirefoxOptions ff_options = new FirefoxOptions();
        ff_options.setCapability("proxy", proxy);

        ClassLoader classLoader = BaseTest.class.getClassLoader();
        URL chromeExecutable = classLoader.getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeExecutable.getPath());
        URL firefoxExecutable = classLoader.getResource("geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", firefoxExecutable.getPath());

        switch (current_driver) {
            case Chrome -> {
                ChromeDriver ch_driver = new ChromeDriver();
                ch_driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                driver = ch_driver;
            }
            case FireFox -> {
                FirefoxDriver ff_driver = new FirefoxDriver();
                ff_driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                driver = ff_driver;
            }
        }
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
