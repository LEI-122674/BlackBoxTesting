package test_adicionarCategoria.pages;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


// page_url = https://vaadin-bookstore-example.demo.vaadin.com/
public class VaadinBookstoreExampleDemPage {

    public SelenideElement usernameInput = $("input[aria-labelledby^='vaadin-text-field-label-0']");
    public SelenideElement passwordInput = $("input[aria-labelledby^='vaadin-password-field-label-1']");
    public SelenideElement loginButton = $("vaadin-button[tabindex='0']");
    public SelenideElement linkToAdmin = $("html > body > vaadin-app-layout > a:nth-of-type(3)");
    public SelenideElement addNewCategoryButton = $("vaadin-button[disableonclick='true']");
    public SelenideElement savedNotification = $("vaadin-notification-card[aria-label='Category Saved.']");



    public void setUp() {
        Configuration.browserSize = "1280x800";
        open("https://vaadin-bookstore-example.demo.vaadin.com/");
    }

    public void loginAsAdmin(){
        usernameInput.setValue("admin");
        passwordInput.setValue("admin");
        loginButton.click();
    }

    public void openAdminPage(){
        linkToAdmin.click();
    }

    public void addNewCategory(String category) {
        sleep(1000);
        addNewCategoryButton.click();
        sleep(1000);
        SelenideElement vaadinField = $$("vaadin-text-field").last();
        vaadinField.shouldBe(visible);

        executeJavaScript(
                "const field = arguments[0];" +
                        "const input = field.shadowRoot.querySelector('input[part=\"value\"]');" +
                        "input.focus();" +
                        "input.value = arguments[1];" +
                        "input.dispatchEvent(new Event('input', { bubbles: true }));",
                vaadinField, category
        );
        executeJavaScript(
                "const input = arguments[0].shadowRoot.querySelector('input[part=\"value\"]');" +
                        "input.dispatchEvent(new Event('change', { bubbles: true }));" +
                        "input.dispatchEvent(new KeyboardEvent('keydown', { key: 'Enter', bubbles: true }));" +
                        "input.dispatchEvent(new KeyboardEvent('keyup', { key: 'Enter', bubbles: true }));",
                vaadinField
        );
        sleep(1000);
    }

}