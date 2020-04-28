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

    public DropDownPage goToDropDownPage(){

        driver.findElement(By.linkText("Dropdown")).click();
        return new DropDownPage(this.driver);
    }

    public DynamicControlPage goToDynamicControlPage() {
        driver.findElement(By.linkText("Dynamic Controls")).click();
        return new DynamicControlPage(driver);
    }

    public HoverPage goToHoverPagePage(){

        driver.findElement(By.linkText("Hovers")).click();
        return new HoverPage(this.driver);
    }
}
