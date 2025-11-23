package org.example.blackboxtesting;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class NotificationMessagesTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");
        if ($("button.ch2-allow-all-btn").isDisplayed()) {
            $("button.ch2-allow-all-btn").click();
            System.out.println("Cookies aceites");
        }
    }

    @Test
    public void testNotificationMessages() throws InterruptedException {
        SelenideElement testInput = $("[id='request_anonymous_requester_email']");
        testInput.click();
        testInput.pressEnter();
        Thread.sleep(3000);
        if ($("button.ch2-allow-all-btn").isDisplayed()) {
            $("button.ch2-allow-all-btn").click();
            System.out.println("Cookies aceites");
        }
        $("[id='request_anonymous_requester_email_error']").shouldBe(Condition.visible);
    }
}
