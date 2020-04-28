package TheInternetTests;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.DropDownPage;
import pages.TheInternet.MainPage;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTest {

    MainPage mainPage;
    DropDownPage dropDownPage;


    @BeforeMethod
    public void setUp(){

        super.setUp();

        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
        dropDownPage = mainPage.goToDropDownPage();
    }


    @Test
    public void selecionoPrimeraOpcion_Option1() {
        int posionSelecionada = 1;
        String elementEsperado = "Option 1";

        dropDownPage.seleccionarOpcion(posionSelecionada);

        final String elementoSeleccionado = dropDownPage.getElementoSeleccionado();

        assertEquals(elementoSeleccionado, elementEsperado, "El elemento seleccionado no es correcto");

    }
}
