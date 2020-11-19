package functional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Validation validation;
    protected Helper helper;

    public void setDriverSelenium() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        validation = new Validation(driver);
        helper = new Helper();
    }


    @BeforeClass
    public void setUp() {
        setDriverSelenium();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
