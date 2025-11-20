package org.example.blackboxtesting;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
    public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-link']");
    public SelenideElement toolsMenu = $("[aria-label='Developer Tools: Open submenu']");
    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    public SelenideElement searchInput = $("[data-test-id='search-input']");


}
