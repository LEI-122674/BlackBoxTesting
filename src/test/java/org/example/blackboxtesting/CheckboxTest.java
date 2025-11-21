package org.example.blackboxtesting;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class CheckboxTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");
        $("button.ch2-allow-all-btn")
                .shouldBe(visible)
                .click();
    }

    @Test
    public void testCheckbox() throws InterruptedException {
        //Teste da Checkbox "Accept Privacy Policy"
        SelenideElement privacyCheckbox = $("[id='request_custom_fields_360000004124']");

        privacyCheckbox.scrollIntoView(true);
        privacyCheckbox.shouldBe(not(checked));
        Thread.sleep(1000);

        privacyCheckbox.click();
        privacyCheckbox.shouldBe(checked);
        Thread.sleep(1000);

        privacyCheckbox.click();
        privacyCheckbox.shouldBe(not(checked));
        Thread.sleep(1000);
    }
}
