package org.example.blackboxtesting;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
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
        if ($("button.ch2-allow-all-btn").isDisplayed()) {
            $("button.ch2-allow-all-btn").click();
            System.out.println("Cookies aceites");
        }
    }

    @Test
    public void search() {

        mainPage.searchButton.shouldBe(Condition.visible).click();
        SelenideElement searchInputBox =$("[data-test-id='search-input']");
        searchInputBox.shouldBe(visible).setValue("Selenium");
        $("[data-test='full-search-button']").click();

    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();
        $("[data-test-marker=\"Developer Tools\"]").shouldBe(Condition.visible);
      }

    @Test
    public void navigationToAllTools() {
        mainPage.toolsMenu.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
}
