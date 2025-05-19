package ru.yandex.praktikum.tests.firefox;

import ru.yandex.praktikum.tests.ScooterOrderTest;

public class FirefoxTest extends ScooterOrderTest {

    @Override
    protected String getBrowserName() {
        return "firefox";
    }
}

