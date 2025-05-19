package ru.yandex.praktikum.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.pages.Driver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        Driver browser = new Driver();
        browser.startUp(getBrowserName());
        this.driver = browser.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String getBrowserName() {
        return "chrome";
    }
}
