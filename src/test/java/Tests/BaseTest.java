package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.TheInternet.MainPage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
            takeScreenshot(driver, "./screenshots", result.getName());

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String destinationPath, String testName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(destinationPath, testName + ".png"));
    }

}
