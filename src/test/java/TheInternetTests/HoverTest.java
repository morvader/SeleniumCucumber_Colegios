package TheInternetTests;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.DropDownPage;
import pages.TheInternet.HoverPage;
import pages.TheInternet.MainPage;

import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTest {

    MainPage mainPage;
    HoverPage hoverPage;

    @BeforeMethod
    public void setUp(){

        super.setUp();
        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
        hoverPage = mainPage.goToHoverPagePage();
    }

    @Test
    public void muevoRatonUsuario1_SeMuestraInfoUsuario1() {

        hoverPage.moverRatonAFoto(1);

        assertTrue(hoverPage.esVisible(1), "El user2 no es visible");
    }
}
