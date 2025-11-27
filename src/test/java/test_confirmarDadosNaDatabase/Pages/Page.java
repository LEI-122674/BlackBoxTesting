package test_confirmarDadosNaDatabase.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://vaadin-database-example.demo.vaadin.com/
public class Page {

    public ElementsCollection movieGrid = $$("vaadin-grid-cell-content");

    public ElementsCollection getCollection(){
        return movieGrid;
    }

    public void open(){
        Selenide.open("https://vaadin-database-example.demo.vaadin.com/");
    }


}