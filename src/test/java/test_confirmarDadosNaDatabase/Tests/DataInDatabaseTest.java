package test_confirmarDadosNaDatabase.Tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test_confirmarDadosNaDatabase.Pages.Page;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class DataInDatabaseTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1280x800";
        Configuration.pageLoadTimeout= 10000;
        Configuration.timeout = 10000;
    }

    Page page = new Page();

    @BeforeEach
    public void openPage() {
        page.open();
    }

    @Test
    public void testFirstMovie() throws InterruptedException {

        String name = page.movieGrid.get(0).getText();
        String year = page.movieGrid.get(1).getText();
        String director = page.movieGrid.get(2).getText();
        String linkText = page.movieGrid.get(3).getText();

        Thread.sleep(2000);

        Assertions.assertEquals("Law Abiding Citizen", name);
        Assertions.assertEquals("2009", year);
        Assertions.assertEquals("F. Gardy Gray", director);
        Assertions.assertEquals("Click to IMBD site", linkText);
    }

}
