package ru.litres.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.litres.utils.FakerUtils;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CouponPage {

    private SelenideElement
            authorizationPopup = $("[data-test-id='authorization-popup']"),
            couponeForm = $("#activate_coupone_form"),
            couponeCode = $("#code1"),
            activateCouponButton = $("#activate_coupon");

    FakerUtils fakerUtils = new FakerUtils();

    @Step("Открылась страница с полем для ввода промокода")
    public CouponPage checkCouponPage() {
        couponeForm.shouldHave(Condition.visible).shouldHave(Condition.text("Активация промокода Литрес"));
        return this;
    }

    @Step("Ввод промокода")
    public CouponPage setValueInPromoCodeInput() {
        couponeCode.setValue(fakerUtils.getFakePromoCode());
        activateCouponButton.click();
        return this;
    }

    @Step("Появление попапа авторизации при активации Промокода")
    public CouponPage checkAuthorizationPopapWithPromoCode() {
        assertThat(authorizationPopup.shouldHave(Condition.visible)
                .getText()).isEqualTo("Чтобы активировать промокод, зарегистрируйтесь или войдите\n" +
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

}
