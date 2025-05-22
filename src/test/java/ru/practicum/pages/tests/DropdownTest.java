package ru.practicum.pages.tests;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

    @RegisterExtension
    public DriverFactory driverFactory = new DriverFactory();

    @ParameterizedTest(name = "Проверка вопроса #{0}: {1}")
    @MethodSource("questionData")
    void testQuestionAnswer(int questionIndex, String expectedAnswer, String question) {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openAndAcceptCookies();
        mainPage.scrollToFAQSection();

        String actualAnswer = mainPage.getDropdownAnswer(questionIndex);
        assertEquals(expectedAnswer,
                actualAnswer,
                String.format("Ошибка в ответете на вопорс '%s'", question));
    }

    static Stream<Arguments> questionData() {
        return Stream.of(
                Arguments.of(0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Сколько это стоит? И как оплатить?"),
                Arguments.of(1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Хочу сразу несколько самокатов! Так можно?"),
                Arguments.of(2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",  "Как рассчитывается время аренды?"),
                Arguments.of(3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Можно ли заказать самокат прямо на сегодня?"),
                Arguments.of(4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Можно ли продлить заказ или вернуть самокат раньше?"),
                Arguments.of(5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Вы привозите зарядку вместе с самокатом?"),
                Arguments.of(6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Можно ли отменить заказ?"),
                Arguments.of(7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", "Я жизу за МКАДом, привезёте?")
        );
    }
}
