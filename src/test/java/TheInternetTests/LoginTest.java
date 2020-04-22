package TheInternetTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.TheInternet.LoginPage;
import pages.TheInternet.MainPage;
import pages.TheInternet.SecurePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    MainPage mainPage;
    LoginPage loginPage;
    WebDriver driver;

    @BeforeClass
    public static void afterClass(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        //driver.manage().window().setSize(new Dimension(300,600));

        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
        loginPage = mainPage.goToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginIncorrecto_MensajeError(){
        //Arrange
        String fakeUser = "fran";
        String fakePass = "fakePass";
        String mensajeEsperado = "Your username is invalid!";

        //Act
        loginPage.loginIncorrecto(fakeUser,fakePass);

        //Assert
        final String texto = loginPage.getTexto();

        assertTrue(texto.startsWith(mensajeEsperado),"El mensaje mostrado no es correcto");

        assertTrue(loginPage.driver.getCurrentUrl().endsWith("login"),"La url no es correcta");

    }

    @Test
    public void loginCorrecto_AccedoAreaSegura(){
        //Arrange
        String fakeUser = "tomsmith";
        String fakePass = "SuperSecretPassword!";
        String mensajeEsperado = "You logged into a secure area!";

        //Act
        final SecurePage securePage = loginPage.loginCorrecto(fakeUser, fakePass);

        //Assert
        final String texto = securePage.getTexto();

        assertTrue(texto.startsWith(mensajeEsperado),"El mensaje mostrado no es correcto");

        assertTrue(loginPage.driver.getCurrentUrl().endsWith("secure"),"La url no es correcta");
    }
}
