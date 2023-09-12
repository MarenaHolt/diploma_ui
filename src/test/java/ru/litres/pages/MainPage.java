package ru.litres.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private SelenideElement
            inputTypeSearch = $("[data-test-id='header__search-input--desktop']"),
            searchResultList = $("[data-test-id='popover__content']"),
            cookieAcceptPopup = $("[data-test-id='cookieAcceptPopup']"),
            loginButton = $("[data-test-id='header__login-button--desktop']"),
            authorizationPopup = $("[data-test-id='authorization-popup']"),
            promoCodeButton = $("[data-id='promoCodes']");

    private static ElementsCollection resultElementsHeaders = $$(("[data-test-id='lower-menu--desktop']"));

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
        open("");
        return this;
    }

    @Step("Получаем и проверяем элементы в хедере")
    public MainPage checkHeaderMainPage() {
        resultElementsHeaders.shouldHave(
                CollectionCondition.texts("Каталог\n" + "Подписка за 0 ₽\n" +
                        "Новинки\n" + "Популярное\n" + "Аудиокниги\n" + "Что почитать?\n" + "Самиздат\n" + "Промокод\n" + "Ещё\n"));
        return this;
    }

    @Step("Ввод текста в строку поиска")
    public MainPage putTextInInput(String text) {
        inputTypeSearch.click();
        inputTypeSearch.setValue(text);
        return this;
    }

    @Step("Отображение подсказок в поиске")
    public MainPage checkSearchResultListIsVisible() {
        searchResultList.shouldHave(Condition.visible);
        return this;
    }

    @Step("Поиск книги: ввести в строку название и кликнуть для перехода на другую страницу")
    public MainPage putTextInInputSearchAndSubmit(String text) {
        inputTypeSearch.click();
        inputTypeSearch.setValue(text).submit();
        return this;
    }

    @Step("Отображение на главной странице плейсхолдера с подсказками в поле поиска")
    public MainPage checkInputTypeSearchPlaceholder() {
        inputTypeSearch.shouldHave(Condition.visible);
        assertThat(inputTypeSearch.shouldHave(Condition.visible).getAttribute("placeholder"))
                .isEqualTo("Книга, серия, автор, жанр, издательство");
        return this;
    }

    @Step("Отображение на главной странице всплывающего окно с согласием на обработку файлов cookie")
    public MainPage checkCookieAcceptPopup() {
        assertThat(cookieAcceptPopup.shouldHave(Condition.visible).getText())
                .isEqualTo("Продолжая использовать этот сайт, вы даете согласие ООО \"ЛитРес\", город Москва, " +
                        "на обработку файлов cookie и соответствующих пользовательских данных... далее\n" +
                        "ПРИНЯТЬ");
        return this;
    }

    @Step("Клик по кнопке Войти на главной странице")
    public MainPage clickButtonLogin() {
        loginButton.shouldHave(Condition.visible).click();
        return this;
    }

    @Step("Отображение на главной странице всплывающего окна авторизации")
    public MainPage checkAuthorizationPopupExists() {
        assertThat(authorizationPopup.shouldHave(Condition.visible).getText()).isEqualTo("Вход или регистрация\n" +
                "VK ID\n" +
                "OK\n" +
                "Яндекс\n" +
                "Google\n" +
                "Mail.ru\n" +
                "ЭЛЕКТРОННАЯ ПОЧТА\n" +
                "НОМЕР ТЕЛЕФОНА\n" +
                "Используя ЛитРес, вы соглашаетесь с условиями обслуживания\n" +
                "Вход через приложение ЛитРес\n" +
                "Вход по читательскому билету");
        return this;
    }

    @Step("Клик по кнопке Промокод на главной странице")
    public MainPage clickPromoCodeButton() {
        promoCodeButton.shouldHave(Condition.visible).click();
        return this;
    }

}
