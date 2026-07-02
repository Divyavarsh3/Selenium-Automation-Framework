package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome Browser
        driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Wait after opening browser
        Thread.sleep(10000);

        // Open Luma Store Website
        driver.get("https://luma.enablementadobe.com/");

        // Wait for website to load completely
        Thread.sleep(20000);

    }

    @AfterMethod
    public void tearDown() throws Exception {

        // Wait before closing browser
        Thread.sleep(10000);

        // Close Browser
        driver.quit();

    }
}