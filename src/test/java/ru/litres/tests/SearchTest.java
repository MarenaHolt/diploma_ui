package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.MainPage;
import ru.litres.pages.SearchPage;
import ru.litres.utils.FakerUtils;

public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    FakerUtils fakerUtils = new FakerUtils();

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения поля поиска с плейсхолдером на главной странице")
    void checkSearchInput() {
        mainPage.openMainPage()
                .checkInputTypeSearchPlaceholder();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения подсказок при вводе текста в строку поиска на главной странице")
    void checkResultList() {
        mainPage.openMainPage()
                .putTextInInput(fakerUtils.getFakeBook())
                .checkSearchResultListIsVisible();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка Перехода на страницу поиска после ввода данных в строку поиска")
    void checkResultListWithPreviousSearchesAndModuleClear() {
        String book = fakerUtils.getFakeBook();
        mainPage.openMainPage()
                .putTextInInputSearchAndSubmit(book);
        searchPage.checkUrlOfPageWithSearchResult(book);
    }

}
