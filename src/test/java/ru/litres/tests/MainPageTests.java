package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.MainPage;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения хедера c названиями разделов на главной странице")
    void checkHeader() {
        mainPage.openMainPage()
                .checkHeaderMainPage();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения cookieAcceptPopup")
    void checkSearchOnSite() {
        mainPage.openMainPage()
                .checkCookieAcceptPopup();
    }

}
