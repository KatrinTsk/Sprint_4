package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

// Класс раскрывающегося списка.
// Здесь проверяем что cписки раскрываются и что открывшийся текст соответствует ожидаемому

public class DropdownPage {

    // ЛОКАТОРЫ

    private WebDriver driver;


    // 1 локатор
    private By buttonQuestionDropDown1 = By.xpath("//div[text()='Сколько это стоит? И как оплатить?']"); // Вопрос №1
    private By textAnswerDropDown1 = By.id("accordion__panel-0"); // Ответ №1

    // 2 локатор
    private By buttonQuestionDropDown2 = By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']"); // Вопрос №2
    private By textAnswerDropDown2 = By.id("accordion__panel-1"); // Ответ №2

    // 3 локатор
    private By buttonQuestionDropDown3 = By.xpath("//div[text()='Как рассчитывается время аренды?']"); // Вопрос №3
    private By textAnswerDropDown3 = By.id("accordion__panel-2"); // Ответ №3

    // 4 локатор
    private By buttonQuestionDropDown4 = By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']"); // Вопрос №4
    private By textAnswerDropDown4 = By.id("accordion__panel-3"); // Ответ №4

    // 5 локатор
    private By buttonQuestionDropDown5 = By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']"); // Вопрос №5
    private By textAnswerDropDown5 = By.id("accordion__panel-4"); // Ответ №5

    // 6 локатор
    private By buttonQuestionDropDown6 = By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']"); // Вопрос №6
    private By textAnswerDropDown6 = By.id("accordion__panel-5"); // Ответ № 6

    // 7 локатор
    private By buttonQuestionDropDown7 = By.xpath("//div[text()='Можно ли отменить заказ?']"); // Вопрос №7
    private By textAnswerDropDown7 = By.id("accordion__panel-6"); // Ответ №7

    // 8 локатор
    private By buttonQuestionDropDown8 = By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']"); // Вопрос №8
    private By textAnswerDropDown8 = By.id("accordion__panel-7"); // Ответ №9


    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // МЕТОДЫ

    // scroll
    public void scrollDown() {
        WebElement faqSection = driver.findElement(buttonQuestionDropDown8);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqSection);
    }

    // КЛИК И СВЕРКА

    // 1
    public void clickButtonQuestionDropDown1() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown1).click();
    }

    public void checkTextAnswerDropDown1() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown1); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                answer.getText()
        );
    }

    // 2
    public void clickButtonQuestionDropDown2() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown2).click();
    }

    public void checkTextAnswerDropDown2() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown2); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                answer.getText()
        );
    }

    // 3
    public void clickButtonQuestionDropDown3() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown3).click();
    }

    public void checkTextAnswerDropDown3() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown3); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                answer.getText()
        );
    }

    // 4
    public void clickButtonQuestionDropDown4() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown4).click();
    }

    public void checkTextAnswerDropDown4() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown4); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                answer.getText()
        );
    }

    // 5
    public void clickButtonQuestionDropDown5() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown5).click();
    }

    public void checkTextAnswerDropDown5() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown5); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                answer.getText()
        );
    }

    // 6
    public void clickButtonQuestionDropDown6() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown6).click();
    }

    public void checkTextAnswerDropDown6() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown6); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                answer.getText()
        );
    }

    // 7
    public void clickButtonQuestionDropDown7() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown7).click();
    }

    public void checkTextAnswerDropDown7() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown7); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                answer.getText()
        );
    }

    // 8
    public void clickButtonQuestionDropDown8() { // Кликаем по выпадающему списку
        driver.findElement(buttonQuestionDropDown8).click();
    }

    public void checkTextAnswerDropDown8() { // Сравнение текста раскрывшегося списка с ожидаемым текстом
        WebElement answer = driver.findElement(textAnswerDropDown8); // Поиск элемента с ответом
        assertEquals(
                "Открывающийся текст не соответствует ожидаемому",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                answer.getText()
        );
    }
}