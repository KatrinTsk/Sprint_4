package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    //  ЛОКАТОРЫ
    private By buttonCookie = By.xpath("//button[contains(text(), 'да все привыкли')]"); // Кнопка cookie "Да все привыкли"
    private By orderButtonTop = By.className("Button_Button__ra12g"); // Верхняя кнопка "Заказать"
    private By orderButtonBottom = By.xpath("(//button[text()='Заказать'])[2]"); // Нижняя кнопка "Заказать"
    private By namOrder = By.xpath("//input[@placeholder='* Имя']"); // Поле "Имя"
    private By lastNameOrder = By.xpath("//input[@placeholder='* Фамилия']"); // Поле "Фамилия"
    private By addressOrder = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // Поле "Адрес"
    private By metroDropDownOrder = By.xpath("//input[@placeholder='* Станция метро']"); // Поле "Станция метро"
    private By phoneOrder = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле "Телефон"
    private By buttonFurther = By.xpath(".//button[text()='Далее']"); // Кнопка "Далее"
    private By dateOrder = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // Поле "Когда привезти самокат"
    private By heading = By.className("Order_Header__BZXOb"); // Заголовок "Про аренду"
    private By rentalPeriodOrder = By.xpath("//div[text()='* Срок аренды']"); // Поле "Срок аренды"
    private By colorBlackScooterOrder = By.id("black"); // Чекбокс цвета самоката "Черный жемчуг"
    private By colorGreyScooterOrder = By.id("grey"); // Чекбокс цвета самоката "Серая безысходность"
    private By commentOrder = By.xpath("//input[contains(@class, 'Input_Input__1iN_Z') and contains(@class, 'Input_Responsible__1jDKN')]"); // Поле "Комментарий для курьера"
    private By buttonOrder3 = By.xpath("(//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать'])[2]"); // Кнопка "Заказать"
    private By consentHeader = By.className("Order_ModalHeader__3FDaJ"); // Заголовок подтверждения заказа
    private By yesButton = By.xpath(".//button[text()='Да']"); // Кнопка "Да"
    private By modalHeader = By.xpath("//div[text()='Заказ оформлен']"); // Заголовок "Заказ оформлен"


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // МЕТОДЫ

    public void clickCookie() { // Клик по кнопке cookie "Да все привыкли"
        driver.findElement(buttonCookie).click();
    }

    public void clickOrderButton1() { // Клик по верхней кнопке "Заказать"
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButton2() { // Скролл и клик по нижней кнопке "Заказать"
        WebElement button = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", button);
    }

    public void setName(String name) { // Ввод имени
        driver.findElement(namOrder).sendKeys(name);
    }

    public void setLastName(String lastName) { // Ввод фамилии
        driver.findElement(lastNameOrder).sendKeys(lastName);
    }

    public void setAddress(String Address) { // Ввод адреса
        driver.findElement(addressOrder).sendKeys(Address);
    }

    public void selectMetroStation(String stationName) { // Выбор станции
        driver.findElement(metroDropDownOrder).click(); // Клик на поле выбора станции
        By stationLocator = By.xpath(String.format("//div[text()='%s']", stationName)); // Поиск станции по тексту (универсальный локатор)
        driverWait.until(ExpectedConditions.elementToBeClickable(stationLocator)).click(); // Клик с ожиданием
    }

    public void setPhone(String phone) { // Ввод номера телефона
        driver.findElement(phoneOrder).sendKeys(phone);
    }

    public void clickButtonFurther() { // Клик по кнопке "Далее"
        driver.findElement(buttonFurther).click();
    }

    public void waitAfterNextButton() { // Ожидание после нажатия кнопки "Далее"
        By rentHeader = By.xpath("//div[contains(text(), 'Про аренду')]"); // Ожидание появления заголовка "Про аренду" (вторая страница формы)
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(rentHeader));
    }

    public void setDeliveryDate(String date) { // Ввод даты заказа
        driver.findElement(dateOrder).sendKeys(date);
        driverWait.until(ExpectedConditions.elementToBeClickable(heading)).click();
    }

    public void setRentalPeriod(String period) { // Выбора срока аренды
        driver.findElement(rentalPeriodOrder).click(); // Клик на поле "Срок аренды"
        By periodOption = By.xpath(String.format("//div[@class='Dropdown-option' and text()='%s']", period));
        driverWait.until(ExpectedConditions.elementToBeClickable(periodOption)).click();
    }

    public void setScooterColor(String color) { // Выбора цвета самоката
        if (color.equals("black")) { // "Черный жемчуг"
            driver.findElement(colorBlackScooterOrder).click();
        } else if (color.equals("grey")) { // "Серая безысходность"
            driver.findElement(colorGreyScooterOrder).click();
        }
    }

    public void setComment(String comment) { // Заполнение комментария
        driver.findElement(commentOrder).sendKeys(comment);
    }

    public void clickOrderButton3() { // Клика по кнопке "Заказать"
        driver.findElement(buttonOrder3).click();
    }

    public void clickYesButton() { // Ожидание открытия формы для подтверждения
        driverWait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public boolean orderModalHeader() { // Проверка появиления окна "Заказ оформлен"
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(modalHeader)).isDisplayed();
    }


    // ШАГИ
    public void sendOrderFormClickOrderButton1(String name, String lastName, String adress, String stationName, String phone) {
        clickOrderButton1();
        setName(name);
        setLastName(lastName);
        setAddress(adress);
        selectMetroStation(stationName);
        setPhone(phone);
        clickButtonFurther();
    }

    public void sendOrderFormClickOrderButton2(String name, String lastName, String adress, String stationName, String phone) {
        clickOrderButton2();
        setName(name);
        setLastName(lastName);
        setAddress(adress);
        selectMetroStation(stationName);
        setPhone(phone);
        clickButtonFurther();
    }

    public void sendOrderPageSecond(String date, String period, String color, String comment) {
        waitAfterNextButton();
        setDeliveryDate(date);
        setRentalPeriod(period);
        setScooterColor(color);
        setComment(comment);
        clickOrderButton3();
        clickYesButton();
        orderModalHeader();
    }
}
