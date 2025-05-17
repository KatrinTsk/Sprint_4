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

    // Локатор кнопки cookie "Да все привыкли"
    private By buttonCookie = By.xpath("//button[contains(text(), 'да все привыкли')]");

    // Локатор верней кнопки "Заказать"
    private By orderButton1 = By.className("Button_Button__ra12g");

    // Локатор нижней кнопки "Заказать"
    private By orderButton2 = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // локатор поля "Имя"
    private By namOrder = By.xpath("//input[@placeholder='* Имя']");

    // локатор поля "Фамилия"
    private By lastNameOrder = By.xpath("//input[@placeholder='* Фамилия']");

    // локатор поля "Адрес"
    private By addressOrder = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля "Станция метро"
    private By metroDropDownOrder = By.xpath("//input[@placeholder='* Станция метро']");

    // локатор для поля "Телефон"
    private By phoneOrder = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор кнопки "Далее"
    private By buttonFurther = By.xpath(".//button[text()='Далее']");

    // локатор поля "Когда привезти самокат"
    private By dateOrder = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // локатор
    private By heading = By.className("Order_Header__BZXOb");

    // локатор поля "Срок аренды"
    private By rentalPeriodOrder = By.xpath("//div[text()='* Срок аренды']");

    // локатор поля "Цвет самоката"
    private By colorBlackScooterOrder = By.id("black"); // локатор чекбокса "Черный жемчуг"
    private By colorGreyScooterOrder = By.id("grey"); // локатор чекбокса "Серая безысходность"

    // локатор поля "Комментарий для курьера"
    private By commentOrder = By.xpath("//input[contains(@class, 'Input_Input__1iN_Z') and contains(@class, 'Input_Responsible__1jDKN')]");

    // локатор кнопки "Заказать"
    private By buttonOrder3 = By.xpath("(//button[contains(@class, 'Button_Button__ra12g') and text()='Заказать'])[2]");

    // локатор заголовка подтверждения заказа
    private By consentHeader = By.className("Order_ModalHeader__3FDaJ");

    // локатор кнопки "Да"
    private By yesButton = By.xpath(".//button[text()='Да']");

    // проверка оформленности заказа
    private By modalHeader = By.className("Order_ModalHeader__3FDaJ");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Клик по кнопке cookie "Да все привыкли"
    public void clickCookie() {
        driver.findElement(buttonCookie).click();
    }

    // Клик по верхней кнопке "Заказать"
    public void clickOrderButton1() {
        driver.findElement(orderButton1).click();
    }

    // скролл и клик по нижней кнопке "Заказать"
    public void clickOrderButton2() {
        WebElement button = driver.findElement(orderButton2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", button);
    }

    // ввод имени
    public void setName(String name) {
        driver.findElement(namOrder).sendKeys(name);
    }

    // ввод фамилии
    public void setLastName(String lastName) {
        driver.findElement(lastNameOrder).sendKeys(lastName);
    }

    // ввод адреса
    public void setAddress(String Address) {
        driver.findElement(addressOrder).sendKeys(Address);
    }

    // выбор станции

    public void selectMetroStation(String stationName) {
        // Кликаем на поле выбора станции
        driver.findElement(metroDropDownOrder).click();

        // 2. Ищем станцию по тексту (универсальный локатор)
        By stationLocator = By.xpath(String.format("//div[text()='%s']", stationName));

        // 3. Кликаем с ожиданием
        driverWait.until(ExpectedConditions.elementToBeClickable(stationLocator)).click();
    }


    // ввод номера телефона
    public void setPhone(String phone) {
        driver.findElement(phoneOrder).sendKeys(phone);
    }

    // клик по кнопке "Далее"
    public void clickButtonFurther() {
        driver.findElement(buttonFurther).click();
    }

    public void waitAfterNextButton() {
        // Ожидаем появления заголовка "Про аренду" (вторая страница формы)
        By rentHeader = By.xpath("//div[contains(text(), 'Про аренду')]");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(rentHeader));
    }

    // ввод даты заказа
    public void setDeliveryDate(String date) {
        driver.findElement(dateOrder).sendKeys(date);
        driverWait.until(ExpectedConditions.elementToBeClickable(heading)).click();
    }

    // Метод для выбора срока аренды
    public void setRentalPeriod(String period) {
        driver.findElement(rentalPeriodOrder).click(); // Клик на поле "Срок аренды"
        By periodOption = By.xpath(String.format("//div[@class='Dropdown-option' and text()='%s']", period));
        driverWait.until(ExpectedConditions.elementToBeClickable(periodOption)).click();
    }

    // Метод для выбора цвета самоката
    public void setScooterColor(String color) {
        if (color.equals("black")) {
            driver.findElement(colorBlackScooterOrder).click();
        } else if (color.equals("grey")) {
            driver.findElement(colorGreyScooterOrder).click();
        }
    }

    // Метод для заполнения комментария
    public void setComment(String comment) {
        driver.findElement(commentOrder).sendKeys(comment);
    }

    // Метод для клика по кнопке "Заказать" (на второй странице формы)
    public void clickOrderButton3() {
        driver.findElement(buttonOrder3).click();
    }

    // ожидание открытия формы для подтверждения
    public void clickYesButton() {
        driverWait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    // появилось окно "Заказ оформлен"
    public boolean orderModalHeader() {
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(modalHeader)).isDisplayed();
    }


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
