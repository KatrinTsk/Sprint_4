package ru.yandex.praktikum.tests;

import org.junit.Test;
import ru.yandex.praktikum.pages.OrderPage;

public class ScooterOrderTest extends BaseTest {

    //  КОНСТАНТЫ
    public static final String ИМЯ = "Иван";
    public static final String ФАМИЛИЯ = "Иванов";
    public static final String АДРЕС = "ул. Ленина, 1";
    public static final String МЕТРО = "Сокольники";
    public static final String ТЕЛЕФОН = "89991234567";
    public static final String ДАТА_ЗАКАЗА = "17.05.2025";
    public static final String СРОК_АРЕНДЫ = "сутки";
    public static final String ЦВЕТ_САМОКАТА = "black";
    public static final String КОММЕНТАРИЙ_КУРЬЕРУ = "Позвонить за час";

    @Test
    public void orderTestButton1() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookie();
        orderPage.sendOrderFormClickOrderButton1(ИМЯ, ФАМИЛИЯ, АДРЕС, МЕТРО, ТЕЛЕФОН);
        orderPage.sendOrderPageSecond(ДАТА_ЗАКАЗА, СРОК_АРЕНДЫ, ЦВЕТ_САМОКАТА, КОММЕНТАРИЙ_КУРЬЕРУ);
    }

    @Test
    public void orderTestButton2() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookie();
        orderPage.sendOrderFormClickOrderButton2(ИМЯ, ФАМИЛИЯ, АДРЕС, МЕТРО, ТЕЛЕФОН);
        orderPage.sendOrderPageSecond(ДАТА_ЗАКАЗА, СРОК_АРЕНДЫ, ЦВЕТ_САМОКАТА, КОММЕНТАРИЙ_КУРЬЕРУ);
    }
}