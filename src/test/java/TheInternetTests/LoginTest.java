package TheInternetTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    @Test
    public void loginIncorrecto_MensajeError(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String fakeUser = "fran";
        String fakePass = "fakePass";

        String mensajeEsperado = "Your username is invalid!";

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Form Authentication")).click();

        driver.findElement(By.id("username")).sendKeys(fakeUser);

        driver.findElement(By.name("password")).sendKeys(fakePass);

        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();


        final String texto = driver.findElement(By.id("flash")).getText();

        assertTrue(texto.startsWith(mensajeEsperado),"El mensaje mostrado no es correcto");

        assertTrue(driver.getCurrentUrl().endsWith("error"),"La url no es correcta");

        driver.quit();

    }
}
