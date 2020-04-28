package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlPage {
    private WebDriver driver;

    By btn = By.cssSelector("#checkbox-example button");
    By checkbox = By.cssSelector("#checkbox");
    By mensaje = By.cssSelector("#message");

    public DynamicControlPage(WebDriver driver) {
        this.driver = driver;
    }


}
