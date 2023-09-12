package ru.litres.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SearchPage {
    @Step("Проверка url страницы с данными поиска")
    public SearchPage checkUrlOfPageWithSearchResult(String text) {
        webdriver().shouldHave(url("https://www.litres.ru/search/?q=" + text));
        return this;
    }
}
