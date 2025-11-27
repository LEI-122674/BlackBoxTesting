package org.example.blackboxtesting;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DropdownTest {


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
    public void testDropdownSelections() throws InterruptedException{
        //Teste da dropdown "Operating system"
        SelenideElement dropdown = $("#request_custom_fields_28151042_label ~ a.nesty-input");

        dropdown.shouldBe(visible).click();
        Thread.sleep(1000);
        $$(".nesty-panel li").get(1).click();   //segunda opcao
        Thread.sleep(1500);

        dropdown.click();
        Thread.sleep(1000);
        $$(".nesty-panel li").get(4).click();   //quinta opcao
        Thread.sleep(1500);

        dropdown.click();
        Thread.sleep(1000);
        $$(".nesty-panel li").get(6).click();   //sétima opcao
        Thread.sleep(1500);
    }

}
