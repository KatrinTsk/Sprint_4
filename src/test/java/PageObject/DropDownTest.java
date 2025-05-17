package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DropDown;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class DropDownTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Test // 1
    public void checkTextDropDown1() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown1();
        objDropDown.checkTextAnswerDropDown1();
    }

    @Test // 2
    public void checkTextDropDown2() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown2();
        objDropDown.checkTextAnswerDropDown2();
    }

    @Test // 3
    public void checkTextDropDown3() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown3();
        objDropDown.checkTextAnswerDropDown3();
    }

    @Test // 4
    public void checkTextDropDown4() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown4();
        objDropDown.checkTextAnswerDropDown4();
    }

    @Test // 5
    public void checkTextDropDown5() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown5();
        objDropDown.checkTextAnswerDropDown5();
    }

    @Test // 6
    public void checkTextDropDown6() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown6();
        objDropDown.checkTextAnswerDropDown6();
    }

    @Test // 7
    public void checkTextDropDown7() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown7();
        objDropDown.checkTextAnswerDropDown7();
    }

    @Test // 8
    public void checkTextDropDown8() {
        DropDown objDropDown = new DropDown(driver);
        objDropDown.scrollDown();
        objDropDown.clickButtonQuestionDropDown8();
        objDropDown.checkTextAnswerDropDown8();
    }



    @After
    public void teardown() {
        // закрыть браузер
        driver.quit();
    }
}

