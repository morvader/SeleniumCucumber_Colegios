package pages.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    WebDriver driver;

    By selectElement = By.id("dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropDownPage seleccionarOpcion(int posicion){
        Select desplegable=  new Select(driver.findElement(selectElement));
        desplegable.selectByIndex(posicion);

        return this;
    }

    public String getElementoSeleccionado(){
        Select desplegable =  new Select(driver.findElement(selectElement));
        return desplegable.getFirstSelectedOption().getText();
    }
}
