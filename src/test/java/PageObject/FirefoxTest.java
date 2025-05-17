package PageObject;

import org.example.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FirefoxTest extends ScooterOrderTest {
    private WebDriver firefoxDriver;

    @Before
    public void startBrowser() {
        Driver driver = new Driver();
        driver.startUp("firefox");
        this.firefoxDriver = driver.getDriver();
    }

    @Test
    public void orderTest1Firefox() {
        orderTestButton1(firefoxDriver);
    }

    @Test
    public void orderTest2Firefox() {
        orderTestButton2(firefoxDriver);
    }

    @After
    public void tearDown() {
        firefoxDriver.quit();
    }
}

