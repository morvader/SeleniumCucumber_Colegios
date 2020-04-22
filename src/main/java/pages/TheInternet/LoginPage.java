package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    private By userInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"login\"]/button");

    private By texto = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage loginIncorrecto(String user, String pass){

        loginAs(user, pass);

        return this;
    }

    public SecurePage loginCorrecto(String user, String pass){
        loginAs(user, pass);

        return new SecurePage(driver);
    }

    private void loginAs(String user, String pass) {
        driver.findElement(userInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public String getTexto(){
        return driver.findElement(texto).getText();
    }
}
