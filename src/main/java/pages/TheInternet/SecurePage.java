package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {

    public WebDriver driver;

    private By texto = By.id("flash");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTexto(){
       return driver.findElement(texto).getText();
    }
}
