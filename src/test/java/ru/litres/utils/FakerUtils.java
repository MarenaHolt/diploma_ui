package ru.litres.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public String getFakePromoCode() {
        return new Faker().code().asin();
    }

    public String getFakeBook() {
        return new Faker().book().title().replaceAll(" ", "");
    }
}
