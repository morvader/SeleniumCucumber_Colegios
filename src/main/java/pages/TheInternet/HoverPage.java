package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage {
    public WebDriver driver;

    By imagenes = By.cssSelector("#content img");
    By nombreUsuario = By.cssSelector(".figcaption h5");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public HoverPage moverRatonAFoto(int posicion){

        final List<WebElement> elements = driver.findElements(imagenes);
        final WebElement imagenUsuario = elements.get(posicion);

        Actions action = new Actions(driver);
        action.moveToElement(imagenUsuario).perform();

        return this;
    }

    public boolean esVisible(int posicion){
        final List<WebElement> nombres = driver.findElements(nombreUsuario);
        final WebElement nombreUsuario = nombres.get(posicion);

        return nombreUsuario.isDisplayed();
    }


}
