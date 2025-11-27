package org.example.blackboxtesting;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class FileUploadTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://intellij-support.jetbrains.com/hc/en-us/requests/new?ticket_form_id=66731");
        try {
            $("button.ch2-allow-all-btn").shouldBe(visible).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Banner de cookies não apareceu, seguindo...");
        }
    }



    @Test
    public void testFileInput() throws InterruptedException {
         SelenideElement testFileInput = $("[id='request-attachments']");
         testFileInput.scrollIntoView(true);
         testFileInput.uploadFile(new File("ficheiroTesteUpload.txt"));
        Thread.sleep(3000);
        $("a.upload-link").shouldHave(text("ficheiroTesteUpload.txt"));
    }
}
