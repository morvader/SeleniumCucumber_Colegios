package TodoMVCTest;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TodoMVC.TodoMVCPage;

import static org.testng.Assert.*;

public class MyStepdefs {

    WebDriver driver;
    TodoMVCPage todoMVCPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        todoMVCPage = new TodoMVCPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^accedo a la web$")
    public void accedoALaWeb() {
        System.out.println("GIVEN");
        todoMVCPage.navigateTo();
    }

    @When("^añado el elemento \"([^\"]*)\" a lista$")
    public void añadoElElementoALista(String nuevoElemento) throws Throwable {
        System.out.println("WHEN");
        todoMVCPage.addNewTodo(nuevoElemento);

    }

    @And("^la lista contiene el elemento \"([^\"]*)\"$")
    public void laListaContieneElElemento(String nombreElemento) throws Throwable {
        System.out.println("AND");
        assertTrue(todoMVCPage.getElementNames().contains(nombreElemento), "La lista no contiene el elemento");
    }

    @Then("^la lista tiene (\\d+) elemento$")
    public void laListaTieneElemento(int nElementosEsperados) {
        System.out.println("THEN");
        int nElementosLista = todoMVCPage.getNumberOfElements();
        assertEquals(nElementosLista, nElementosEsperados, "El numero de elementos no coincide");

    }

    @Then("^la lista esta vacia$")
    public void laListaEstaVacia() {
        int nElementosLista = todoMVCPage.getNumberOfElements();
        assertEquals(nElementosLista, 0, "La lista no está vacía");
    }

    @When("^marco el elemento (\\d+) de la lista como completado$")
    public void marcoElElementoDeLaListaComoCompletado(int nElemento) {
        todoMVCPage.completeElement(nElemento);
    }

    @Then("^el elemento (\\d+) de la lista queda marcado como completado$")
    public void elElementoDeLaListaQuedaMarcadoComoCompletado(int nElemento) {
        assertTrue(todoMVCPage.isElementCompleted(nElemento), "El elemento no se ha marcado como completado");
    }

    @And("^en la lista de completados aparece el elemento \"([^\"]*)\"$")
    public void enLaListaDeCompletadosApareceElElemento(String nombreElemento) throws Throwable {
        todoMVCPage.clickCompletedBtn();

        assertTrue(todoMVCPage.getElementNames().contains(nombreElemento), "La lista de completados no tiene el elemento");
    }
}
