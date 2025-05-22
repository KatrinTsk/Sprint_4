package ru.practicum.pages.tests;

import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.OrderPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {

    @RegisterExtension
    public DriverFactory driverFactory = new DriverFactory();

    @ParameterizedTest
    @MethodSource("orderFormFirst")
    public void orderTest(
            Boolean isTopButton,
            String name,
            String lastName,
            String address,
            String stationName,
            String phone,
            String orderData,
            String period,
            String color,
            String comment
    ) {
        WebDriver driver = driverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openAndAcceptCookies();
        mainPage.clickOrderButton(isTopButton);
        orderPage.sendOrderFormFirstPage(name, lastName, address, stationName, phone);
        orderPage.sendOrderFormSecondPage(orderData, period, color, comment);
        assertTrue(orderPage.orderModalHeader(),
                "Окно подтверждения заказа не отображается");
    }

    static Stream<Arguments> orderFormFirst() {
        return Stream.of(
                Arguments.of(true, "Анна", "Ахматова", "ул. Ленина, 1", "Сокольники", "89991234567", "17.05.2025", "сутки", "black", "Тест 1"),
                Arguments.of(false, "Александр", "Пушкин", "пер. Вернадского, 21", "Румянцево", "79137654321", "17.05.2025", "сутки", "grey", "Тест 2"),
                Arguments.of(false, "Сергей", "Есенин", "ул. Студенческая, 23", "Царицыно", "89231112233", "17.05.2025", "сутки", "black", "Тест 3"),
                Arguments.of(true, "Марина", "Цветаева", "пер. Столешников, 7", "Лубянка", "79523332211", "17.05.2025", "сутки", "grey", "Тест 4")
        );
    }
}

