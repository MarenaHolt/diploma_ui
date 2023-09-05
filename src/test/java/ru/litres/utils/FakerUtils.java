package ru.litres.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public static String getFakePromoCode() {
        return new Faker().code().asin();
    }

    public static String getFakeBook() {
        return new Faker().book().title().replaceAll(" ", "");
    }
}
