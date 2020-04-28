package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.TheInternet.MainPage;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public static void afterClass(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    }

    public void setUp(){
        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
