package PageObject;

import org.example.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ChromeTest extends ScooterOrderTest {
    private WebDriver chromeDriver;

    @Before
    public void startBrowser() {
        Driver driver = new Driver();
        driver.startUp("chrome");
        this.chromeDriver = driver.getDriver();
    }

    @Test
    public void orderTestButton1Chrome() {
        orderTestButton1(chromeDriver);
    }

    @Test
    public void orderTestButton2Chrome() {
        orderTestButton2(chromeDriver);
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
    }
}
