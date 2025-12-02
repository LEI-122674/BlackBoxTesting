package test_adicionarCategoria.tests;

import test_adicionarCategoria.pages.VaadinBookstoreExampleDemPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class VaadinBookstoreExampleDemTest {

    VaadinBookstoreExampleDemPage page = new VaadinBookstoreExampleDemPage();

    @BeforeEach
    public void setUp() {
        page.setUp();
    }

    @Test
    public void testAddNewCategory() throws InterruptedException {
        page.loginAsAdmin();
        page.openAdminPage();
        String category = "Horror"; // (min. 2 chars)
        page.addNewCategory(category);
        assertEquals("Category Saved.",page.savedNotification.getText());
    }
}
