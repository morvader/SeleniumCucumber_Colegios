import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInit {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("Naranja");

        driver.findElement(By.id("search_button_homepage")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
