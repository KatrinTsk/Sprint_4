package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    //  ЛОКАТОРЫ
    private By namOrder = By.xpath("//input[@placeholder='* Имя']"); // Поле "Имя"
    private By lastNameOrder = By.xpath("//input[@placeholder='* Фамилия']"); // Поле "Фамилия"
    private By addressOrder = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле "Адрес"
    private By metroDropDownOrder = By.xpath("//input[@placeholder='* Станция метро']"); // Поле "Станция метро"
    private By phoneOrder = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле "Телефон"
    private By buttonFurther = By.xpath(".//button[text()='Далее']"); // Кнопка "Далее"
    private By dateOrder = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Поле "Когда привезти самокат"
    private By heading = By.className("Order_Header__BZXOb"); // Заголовок "Про аренду"
    private By rentalPeriodOrder = By.xpath("//div[text()='* Срок аренды']"); // Поле "Срок аренды"
    private final String RENTAL_PERIOD_OPTION_PATTERN = "//div[@class='Dropdown-option' and text()='%s']"; // Паттерн для выбора срока аренды
    private By colorBlackScooterOrder = By.id("black"); // Чекбокс цвета самоката "Черный жемчуг"
    private By colorGreyScooterOrder = By.id("grey"); // Чекбокс цвета самоката "Серая безысходность"
    private By commentOrder = By.xpath("//input[contains(@class, 'Input_Input__1iN_Z') and contains(@class, 'Input_Responsible__1jDKN')]"); // Поле "Комментарий для курьера"
    private By buttonOrderFinal = By.xpath("(//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать'])[2]"); // Кнопка "Заказать"
    private By yesButton = By.xpath(".//button[text()='Да']"); // Кнопка "Да"
    private By modalHeader = By.xpath("//div[text()='Заказ оформлен']"); // Заголовок "Заказ оформлен"

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // МЕТОДЫ
    public void sendOrderFormFirstPage(String name, String lastName, String adress, String stationName, String phone) {
        setName(name);
        setLastName(lastName);
        setAddress(adress);
        selectMetroStation(stationName);
        setPhone(phone);
        clickButtonFurther();
    }

    public void sendOrderFormSecondPage(String date, String period, String color, String comment) {
        waitAfterNextButton();
        setDeliveryDate(date);
        setRentalPeriod(period);
        setScooterColor(color);
        setComment(comment);
        clickOrderButtonFinal();
        clickYesButton();
    }

    public boolean orderModalHeader() { // Проверка появиления окна "Заказ оформлен"
        try {
            return driverWait.until(ExpectedConditions.visibilityOfElementLocated(modalHeader)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void setName(String name) { // Ввод имени
        driver.findElement(namOrder).sendKeys(name);
    }

    private void setLastName(String lastName) { // Ввод фамилии
        driver.findElement(lastNameOrder).sendKeys(lastName);
    }

    private void setAddress(String Address) { // Ввод адреса
        driver.findElement(addressOrder).sendKeys(Address);
    }

    private void selectMetroStation(String stationName) { // Выбор станции
        driver.findElement(metroDropDownOrder).click(); // Клик на поле выбора станции
        By stationLocator = By.xpath(String.format("//div[text()='%s']", stationName)); // Поиск станции по тексту (универсальный локатор)
        driverWait.until(ExpectedConditions.elementToBeClickable(stationLocator)).click(); // Клик с ожиданием
    }

    private void setPhone(String phone) { // Ввод номера телефона
        driver.findElement(phoneOrder).sendKeys(phone);
    }

    private void clickButtonFurther() { // Клик по кнопке "Далее"
        driver.findElement(buttonFurther).click();
    }

    private void waitAfterNextButton() { // Ожидание после нажатия кнопки "Далее"
        By rentHeader = By.xpath("//div[contains(text(), 'Про аренду')]"); // Ожидание появления заголовка "Про аренду" (вторая страница формы)
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(rentHeader));
    }

    private void setDeliveryDate(String date) { // Ввод даты заказа
        driver.findElement(dateOrder).sendKeys(date);
        driverWait.until(ExpectedConditions.elementToBeClickable(heading)).click();
    }

    private void setRentalPeriod(String period) { // Выбора срока аренды
        driver.findElement(rentalPeriodOrder).click(); // Клик на поле "Срок аренды"
        By periodOption = By.xpath(String.format(RENTAL_PERIOD_OPTION_PATTERN, period));
        driverWait.until(ExpectedConditions.elementToBeClickable(periodOption)).click();
    }


    private void setScooterColor(String color) { // Выбора цвета самоката
        if (color.equals("black")) { // "Черный жемчуг"
            driver.findElement(colorBlackScooterOrder).click();
        } else if (color.equals("grey")) { // "Серая безысходность"
            driver.findElement(colorGreyScooterOrder).click();
        }
    }

    private void setComment(String comment) { // Заполнение комментария
        driver.findElement(commentOrder).sendKeys(comment);
    }

    private void clickOrderButtonFinal() { // Клика по кнопке "Заказать"
        driver.findElement(buttonOrderFinal).click();
    }

    private void clickYesButton() { // Ожидание открытия формы для подтверждения
        driverWait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }
}
