package TheInternetTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.DropDownPage;
import pages.TheInternet.MainPage;

import static org.testng.Assert.assertEquals;

public class DropDownTest {

    WebDriver driver;
    MainPage mainPage;
    DropDownPage dropDownPage;

    @BeforeClass
    public static void afterClass(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
        dropDownPage = mainPage.goToDropDownPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
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
