package org.example.blackboxtesting;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageChangeTest {

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
    public void testLanguageChange() {
        SelenideElement languageSwitcherButton = $("[data-test='language-picker']");

        SelenideElement koreanLanguageOption = $x("//span[text()='한국어']/parent::span[@data-test='list-item']");

        SelenideElement mainHeading = $("h1");

        languageSwitcherButton.shouldBe(visible).click();
        koreanLanguageOption.shouldBe(visible).click();
        webdriver().shouldHave(urlContaining("/ko-kr/"));
    }
}
