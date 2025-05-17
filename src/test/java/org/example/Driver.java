package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    private WebDriver driver;

    public void startUp(String browser) {

        if ("firefox".equals(browser)) {
            // Настройка Firefox
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(
                    "--no-sandbox",
                    "--headless",
                    "--disable-dev-shm-usage",
                    "--window-size=1920,1080",
                    "--disable-gpu",
                    "--disable-extensions"
            );
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://qa-scooter.praktikum-services.ru/");
        } else if ("chrome".equals(browser)) {
            // Настройка Chrome (по умолчанию)
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(
                    "--no-sandbox",
                    "--headless",
                    "--disable-dev-shm-usage",
                    "--window-size=1920,1080",
                    "--disable-gpu",
                    "--disable-extensions"
            );
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://qa-scooter.praktikum-services.ru/");
        } else {
            throw new RuntimeException("неправильный браузер");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}


