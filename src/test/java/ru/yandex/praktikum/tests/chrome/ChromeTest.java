package ru.yandex.praktikum.tests.chrome;

import ru.yandex.praktikum.tests.ScooterOrderTest;

public class ChromeTest extends ScooterOrderTest {
    @Override
    protected String getBrowserName() {
        return "chrome";
    }
}
