package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage(){

        driver.findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(this.driver);

    }
}
