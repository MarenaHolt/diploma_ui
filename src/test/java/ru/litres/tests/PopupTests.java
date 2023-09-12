package ru.litres.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.litres.pages.CouponPage;
import ru.litres.pages.MainPage;

public class PopupTests extends TestBase {

    MainPage mainPage = new MainPage();
    CouponPage couponPage = new CouponPage();

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения попапа авторизации")
    void checkAuthorizationPopup() {
        mainPage.openMainPage()
                .clickButtonLogin()
                .checkAuthorizationPopupExists();
    }

    @Test
    @Tag("all")
    @DisplayName("Проверка отображения попапа авторизации на странице ввода промокода")
    void checkAuthorizationPopupForCoupon() {
        mainPage.openMainPage()
                .clickPromoCodeButton();
        couponPage.checkCouponPage()
                .setValueInPromoCodeInput()
                .checkAuthorizationPopapWithPromoCode();
    }
}
