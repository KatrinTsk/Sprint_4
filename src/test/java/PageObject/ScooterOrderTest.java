package PageObject;

import org.example.OrderPage;
import org.openqa.selenium.WebDriver;

public class ScooterOrderTest {

    public void orderTestButton1(WebDriver driver) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookie();
        orderPage.sendOrderFormClickOrderButton1("Иван", "Иванов", "ул. Ленина, 1", "Сокольники", "89991234567");
        orderPage.sendOrderPageSecond("17.05.2025", "сутки", "black", "Позвонить за час");
    }

    public void orderTestButton2(WebDriver driver) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickCookie();
        orderPage.sendOrderFormClickOrderButton2("Екатерина", "Петрова", "ул. Пушкина, 1", "Арбатская", "89131234567");
        orderPage.sendOrderPageSecond("21.05.2025", "семеро суток", "grey", "Позвонить за полчаса");
    }
}