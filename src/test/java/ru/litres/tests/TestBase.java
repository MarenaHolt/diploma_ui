package ru.litres.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.litres.config.TestsConfigForTestBase;
import ru.litres.helpers.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

        @BeforeAll
        static void beforeAll() {
            TestsConfigForTestBase.configForTestBase();
        }

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        }

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();

            closeWebDriver();
        }
}
