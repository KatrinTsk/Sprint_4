package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final static String BASE_URL = "https://qa-scooter.praktikum-services.ru"; // Константа ссылки на сайт
    private final static String DROPDOWN_QUESTION_PATTERN = "accordion__heading-%d"; // Паттерн вопросов выпадающего списка
    private final static String DROPDOWN_ANSWER_PATTERN = "accordion__panel-%d"; // Паттерн ответов выпадающего списка

    private WebDriver driver;
    private WebDriverWait driverWait;

    // Локаторы
    private By cookieButton = By.id("rcc-confirm-button"); // Кнопка принятия cookie
    private By faqSection = By.xpath("//div[@data-accordion-component='Accordion']"); // Раздел вопросов
    private By topOrderButton = By.className("Button_Button__ra12g"); // Верхняя кнопка "Заказать"
    private By bottomOrderButton = By.xpath("(//button[text()='Заказать'])[2]"); // Нижняя кнопка "Заказать"


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openAndAcceptCookies() {
        driver.get(BASE_URL); // Открытие сайта
        driver.findElement(cookieButton).click(); // Клик по кнопке cookie
    }

    public void clickOrderButton(Boolean isTopButton) {
        if (isTopButton) {
            driver.findElement(topOrderButton).click(); // Клик по верхней кнопке "Заказать"
        } else {
            WebElement button = driver.findElement(bottomOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", button); // Скролл и клик по нижней кнопке "Заказать"
        }
    }

        public void scrollToFAQSection() {
        WebElement element = driver.findElement(faqSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); // Скролл до раздела с вопросами
    }

    public String getDropdownAnswer(int questionIndex) { // Формирование локаторов под конкретный вопрос
        By question = By.id(String.format(DROPDOWN_QUESTION_PATTERN, questionIndex));
        By answer = By.id(String.format(DROPDOWN_ANSWER_PATTERN, questionIndex));

        driverWait.until(ExpectedConditions.elementToBeClickable(question)).click(); // Клик по вопросу
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(answer)).getText(); // Получение текста ответа
    }
}