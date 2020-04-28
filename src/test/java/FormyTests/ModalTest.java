package FormyTests;

import Tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormyPages.ModalPage;

import static org.testng.Assert.assertEquals;

public class ModalTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testModal() {
        ModalPage page = new ModalPage(driver);

        page.navigateTo();

        page.openModal();

        final String modalTittle = page.getModalTittle();

        assertEquals(modalTittle, "Modal title", "El titulo no coincide");
    }
}
