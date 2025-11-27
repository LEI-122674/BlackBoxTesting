package test_adicionarProduto.test;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_adicionarProduto.page.VaadinBookstoreExampleDemPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class VaadinBookstoreExampleDemTest {

    private VaadinBookstoreExampleDemPage page = new VaadinBookstoreExampleDemPage();


    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1280x800";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 8000;
    }

    @Test
    public void testAddProduct() throws InterruptedException {
        page.open();
        page.user_input.setValue("admin");
        page.pass_input.sendKeys("admin");
        page.login_submit.click();
        Thread.sleep(1000);
        assertTrue(page.labelBookstore.isDisplayed()); //Para ver se mudou de página
        page.buttonNewProduct.click();
        Thread.sleep(1000);
        assertTrue(page.formNewProduct.isDisplayed()); //Para confirmar se apareceu o forms

        page.getName_input().setValue("Livro Teste");
        assertEquals("Livro Teste",page.getName_input().getValue());

        page.getPrice_input().clear();
        page.getPrice_input().setValue("14.99");
        assertEquals("14.99",page.getPrice_input().getValue());

        page.checkBox_Romance.click();
        Thread.sleep(1000);
        assertTrue(page.getCheckBoxRomanceInput().isSelected());


        page.save_button.click();
        Thread.sleep(1000);

        assertEquals("Livro Teste created",page.notificacao.getText());

    }

}
