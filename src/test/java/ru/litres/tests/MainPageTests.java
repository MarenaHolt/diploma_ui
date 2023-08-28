package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.MainPage;

import static ru.litres.utils.FakerUtils.getFakeBook;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения хедера c названиями разделов на главной странице")
    void checkHeader() {
        mainPage.openMainPage().checkHeaderMainPage();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения поля поиска с плейсхолдером")
    void checkSearchInput() {
        mainPage.openMainPage().checkInputTypeSearchPlaceholder();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения подсказок при вводе текста в строку поиска")
    void checkResultList() {
        mainPage.openMainPage().checkSearchResultListIsVisible(getFakeBook());
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка Перехода на страницу поиска после ввода данных в строку поиска")
    void checkResultListWithPreviousSearchesAndModuleClear() {
        mainPage.openMainPage().checkUrlOfPageWithSearchResult(getFakeBook());
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения cookieAcceptPopup")
    void checkSearchOnSite() {
        mainPage.openMainPage()
                .checkСookieAcceptPopup();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения попапа авторизации")
    void checkAuthorizationPopup() {
        mainPage.openMainPage()
                .checkAuthorizationPopupExists();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения попапа авторизации")
    void checkAuthorizationPopupForCoupon() {
        mainPage.openMainPage()
                .checkPromoCode();
    }

}
