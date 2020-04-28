package TheInternetTests;

import Tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TheInternet.DynamicControlPage;
import pages.TheInternet.MainPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlTest extends BaseTest {

    MainPage mainPage;
    DynamicControlPage dynamicControlPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();

        driver.get("https://the-internet.herokuapp.com/");

        mainPage = new MainPage(driver);
        dynamicControlPage = mainPage.goToDynamicControlPage();
    }

    @Test
    public void alPulsarRemove_DesapareceCheckBox() throws InterruptedException {
        dynamicControlPage.clickButton();

        String mensaje = dynamicControlPage.getMensaje();

        assertFalse(dynamicControlPage.isCheckBoxPresent(), "El botón no ha desaparecido");
    }


}
