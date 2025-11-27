package test_adicionarProduto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://vaadin-bookstore-example.demo.vaadin.com/
public class VaadinBookstoreExampleDemPage {
    public SelenideElement user_input = $("input[aria-labelledby^='vaadin-text-field-label-0']");
    public SelenideElement pass_input = $("input[aria-labelledby^='vaadin-password-field-label-1']");
    public SelenideElement login_submit = $("vaadin-button[tabindex='0']");

    public SelenideElement labelBookstore = $("label");
    public SelenideElement buttonNewProduct = $x("//vaadin-button[.//iron-icon[@icon='vaadin:plus-circle']]");
    public SelenideElement formNewProduct = $x("//vaadin-vertical-layout[@class='product-form-content']");

    public SelenideElement checkBox_Romance = $x("/html/body/vaadin-app-layout/vaadin-horizontal-layout[2]/div/vaadin-vertical-layout/vaadin-checkbox-group/vaadin-checkbox[3]");

    public SelenideElement save_button = $x("//vaadin-button[@theme='primary' and contains(., 'Save')]");



    public SelenideElement notificacao = $("vaadin-notification-card[aria-label$='created']");


    public void open() {
        Selenide.open("https://vaadin-bookstore-example.demo.vaadin.com/");
    }

    public SelenideElement getName_input() {
        SelenideElement vaadintextfieldName = $x("//vaadin-text-field[@style='width: 100%;']");
        WebElement inputName = Selenide.executeJavaScript(
                "return arguments[0].shadowRoot.querySelector('input')",
                vaadintextfieldName
        );
        SelenideElement name_input = $(inputName);
        return name_input;
    }


    public SelenideElement getPrice_input() {
        SelenideElement vaadintextfieldPrice = $x("//vaadin-text-field[.//span[@slot='suffix']]");
        WebElement input = Selenide.executeJavaScript(
                "return arguments[0].shadowRoot.querySelector('input')",
                vaadintextfieldPrice
        );
       SelenideElement price_input = $(input);
       return price_input;
    }

    public SelenideElement getCheckBoxRomanceInput() {
        WebElement inputReal = Selenide.executeJavaScript(
                "return arguments[0].shadowRoot.querySelector('input[type=\"checkbox\"]')", // <- Garante que é um checkbox
                checkBox_Romance
        );
        return $(inputReal);
    }

    public SelenideElement getSaveButton() {
        SelenideElement vaadinButtonSave = $x("//vaadin-button[@theme='primary' and contains(., 'Save')]");
        WebElement buttonLabel = executeJavaScript(
                "return arguments[0].shadowRoot.querySelector('[part=\"label\"]')",
                vaadinButtonSave
        );

        SelenideElement saveButtonLabel = $(buttonLabel);
        return saveButtonLabel;
    }




}