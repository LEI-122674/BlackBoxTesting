package org.example.blackboxtesting;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
        if($("button.ch2-allow-all-btn").isDisplayed())
            $("button.ch2-allow-all-btn").click();
    }

    @Test
    public void search() {

        mainPage.searchButton.click();

        mainPage.searchInput.setValue("Selenium");
        mainPage.searchInput.shouldBe(Condition.visible).shouldHave(attribute("value", "Selenium"));
        $("button[data-test='full-search-button']").click();
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();
        $("[data-test-marker=\"Developer Tools\"]").shouldBe(Condition.visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }

}
